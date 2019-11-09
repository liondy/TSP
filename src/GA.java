/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author michael
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
public class GA {
    
    public static RoutePopulation evolve(RoutePopulation population){
        RoutePopulation nextGeneration = new RoutePopulation(population.getPopulationSize());
        int j = 0;
        for (int i = 0; i < 10; i++) {
            Route parent1 = selection(population);
            Route parent2 = selection(population);
//            System.out.println("parent1: ");
//            for (int j = 0; j < parent1.getTotalCity(); j++) {
//                System.out.print(parent1.getRoute().get(j).getNumber()+" ");
//            }
//            System.out.println("parent2: ");
//            for (int j = 0; j < parent2.getTotalCity(); j++) {
//                System.out.print(parent2.getRoute().get(j).getNumber()+" ");
//            }
            Route[] child = crossover(parent1,parent2);
            nextGeneration.addNewRoute(j++, child[0]);
            nextGeneration.addNewRoute(j++, child[1]);
        }
        return nextGeneration;
    }
    
    public static Route selection(RoutePopulation population){
        double selection = Math.random();
//        System.out.println("selection: "+selection);
        int idx = binarySearch(population,0,population.getPopulationSize()-1,selection);
//        System.out.println("idx: "+idx);
        if(idx!=-1){
            Route selected = population.getPopulation()[idx];
            return selected;
        }
        return null;
    }
    
    private static int binarySearch(RoutePopulation population, int left, int right, double selection){
        if(right>=left){
            int idx = (left+right)/2;
            if(population.getPopulation()[idx].getCumulative()<=selection && selection<= population.getPopulation()[idx+1].getCumulative()){
                return idx;
            }
            if(population.getPopulation()[idx].getCumulative()>selection){
                return binarySearch(population,left,idx-1,selection);
            }
            return binarySearch(population,idx+1,right,selection);
        }
        return -1;
    }
    
    public void getFitnessFunction(){
        
    }
    
    private static Route[] crossover(Route solution1, Route solution2){
        Route[] children = new Route[2];
        Random rand = new Random();
        int cut = rand.nextInt(solution1.getTotalCity());
        ArrayList<City> temp1 = (ArrayList<City>) solution1.getRoute().clone();
        ArrayList<City> temp2 = (ArrayList<City>) solution2.getRoute().clone();
        ArrayList<City> res1 = new ArrayList<City>();
        ArrayList<City> res2 = new ArrayList<City>();
//        Route children1 = new Route(solution1.getRoute(),solution1.getDistance());
//        Route children2 = new Route(solution2.getRoute(),solution2.getDistance());
        for (int i = 0; i < cut; i++) {
            res1.add(i, temp2.get(i));
            res2.add(i, temp1.get(i));
        }
        for (int i = cut; i < solution1.getTotalCity(); i++) {
            res1.add(i, temp1.get(i));
            res2.add(i, temp2.get(i));
        }
        return children;
    }
    
    private static Route swap(Route swapRoute, int idx1, int idx2){
        ArrayList<City> route = (ArrayList<City>) swapRoute.getRoute().clone();
        Collections.swap(route,idx1,idx2);
        Route swapped = new Route(route,swapRoute.getDistance());
        return swapped;
    }
    
    public void mutation(int[] solution){
        
    }
}
