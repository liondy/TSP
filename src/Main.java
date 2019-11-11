/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author michael
 */
import java.util.Scanner;
import java.util.ArrayList;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int populationSize = 50;
        ArrayList<City> cities = new ArrayList<>();
        while(sc.hasNextInt()){
            int n = sc.nextInt();
            int x = sc.nextInt();
            int y = sc.nextInt();
            City city = new City(n,x,y);
            cities.add(city);
        }
        double[][] cityDistanceMap = new double[cities.size()+1][cities.size()+1];
        for (int i = 0; i < cityDistanceMap.length-1; i++) {
            for (int j = 0; j < cityDistanceMap.length-1; j++) {
                if(cities.get(i).getNumber()==cities.get(j).getNumber()) cityDistanceMap[cities.get(i).getNumber()][cities.get(j).getNumber()] = 0;
                else if(cityDistanceMap[cities.get(i).getNumber()][cities.get(j).getNumber()]!=0)continue;
                else{
                    int deltaX = cities.get(i).getX() - cities.get(j).getX();
                    int deltaY = cities.get(i).getY() - cities.get(j).getY();
                    cityDistanceMap[cities.get(i).getNumber()][cities.get(j).getNumber()] = Math.sqrt((deltaX*deltaX) + (deltaY*deltaY));
                    cityDistanceMap[cities.get(j).getNumber()][cities.get(i).getNumber()] = cityDistanceMap[cities.get(i).getNumber()][cities.get(j).getNumber()];
                }
            }
        }
        RoutePopulation routePopulation = new RoutePopulation(populationSize);
        double totalFitness = 0;
        RouteManager routeManager = new RouteManager(cities,cityDistanceMap);
        Route firstRoute = new Route(cities,routeManager.getDistance());
        System.out.println("First Generation, the route is: ");
        for (int i = 0; i < cities.size(); i++) {
            System.out.print(cities.get(i).getNumber()+" ");
        }
        System.out.println();
        System.out.println("Fitness: "+ firstRoute.getFitness());
        System.out.println("Distance: "+firstRoute.getDistance());
        for (int i = 0; i < populationSize; i++) {
            ArrayList<City> newCityRoute = (ArrayList) routeManager.shuffle().clone();
            double distance = routeManager.getDistance();
            Route route = new Route(newCityRoute,distance);
            routePopulation.addNewRoute(i, route);
            totalFitness += route.getFitness();
        }
        routePopulation.setTotalFitness(totalFitness);
        routePopulation.countPeluangKumulatif();
//        routePopulation.printAllSolution();

        //get the (initial = best) route, best fitness (max fitness), and best distance (min distance), and before first generation (generation = 0)
        ArrayList<City> bestRoute = (ArrayList<City>) firstRoute.getRoute().clone();
        double bestFitness = firstRoute.getFitness();
        double bestDistance = firstRoute.getDistance();
        int generation = 0;
        
        //first evolution
        routePopulation = GA.evolve(routePopulation);
        
        //get the first best route, best fitness of first generation (max fitness of first generation), and best distance of first generation (min distance of first generation)
        Route firstBest = routePopulation.getFittest();
        ArrayList<City> firstGenerationBest = (ArrayList<City>) firstBest.getRoute().clone();
        double firstGenerationBestFitness = firstBest.getFitness();
        double firstGenerationBestDistance = firstBest.getDistance();
        System.out.println("Solution 1: "+firstGenerationBestFitness);
        
        //check if the first generation best fitness (max fitness of first generation) is better than our assumption on initial route fitness
        if(firstGenerationBestFitness>bestFitness){
            bestRoute = (ArrayList<City>) firstGenerationBest.clone();
            bestFitness = firstGenerationBestFitness;
            bestDistance = firstGenerationBestDistance;
            generation = 1;
        }
        
        //loop through 100 generation to find the best route for this TSP
        for (int i = 2; i <= 100; i++) {
            //first of all, evolve the population of current generation
            routePopulation = GA.evolve(routePopulation);
            
            //get the best route of each generation, best fitness of each generation (max fitness of each generation), and best distance of each generation (min distance of each generation)
            Route best = routePopulation.getFittest();
            ArrayList<City> bestGenerationNow = (ArrayList<City>) best.getRoute().clone();
            double bestFitnessNow = best.getFitness();
            double bestDistanceNow = best.getDistance();
            System.out.println("Solution "+i+": "+bestFitnessNow);
            
            //check if the current generation best fitness (max fitness of current generation) is better than our assumption of best route before
            if(bestFitnessNow>bestFitness){
                bestRoute = (ArrayList<City>) bestGenerationNow.clone();
                bestFitness = bestFitnessNow;
                bestDistance = bestDistanceNow;
                generation = i;
            }
        }
        
        //Output the best solution after that 100 generation
        System.out.println("After 100 generation, best route is on generation "+ generation+" with order: ");
        
        //Print the order of best route
        for (int i = 0; i < bestRoute.size(); i++) {
            System.out.print(bestRoute.get(i).getNumber()+" ");
        }
        System.out.println();
        
        //Print the fitness of that best route
        System.out.println("Fitness: "+bestFitness);
        
        //Print the distance of that best route
        System.out.println("Distance: "+bestDistance);
    }
}
