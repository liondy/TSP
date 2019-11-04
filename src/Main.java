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
import java.util.Collections;
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
        for (int i = 0; i < populationSize; i++) {
            RouteManager routeManager = new RouteManager(cities,cityDistanceMap);
            ArrayList<City> newCityRoute = (ArrayList) routeManager.shuffle().clone();
            double distance = routeManager.getDistance();
            Route route = new Route(newCityRoute,distance);
            routePopulation.addNewRoute(i, route);
            totalFitness += route.getFitness();
        }
        routePopulation.setTotalFitness(totalFitness);
        routePopulation.countPeluangKumulatif();
        routePopulation.printAllSolution();
        routePopulation = GA.evolve(routePopulation);
    }
}
