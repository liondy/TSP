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
        int j = -1;
        for (int i = 0; i < 25; i++) {
            j++;
            Route parent1 = selection(population);
            Route parent2 = selection(population);
            Route[] child = crossover(parent1,parent2);
            Random rand = new Random();
            int mut = rand.nextInt(2);
            mutation(child[mut]);
            nextGeneration.addNewRoute(j++, child[0]);
            nextGeneration.addNewRoute(j, child[1]);
        }
        return nextGeneration;
    }
    
    private static Route selection(RoutePopulation population){
        double selection = Math.random();
        int idx = binarySearch(population,0,population.getPopulationSize()-1,selection);
        if(idx!=-1){
            Route selected = population.getPopulation()[idx];
            return selected;
        }
        return null;
    }
    
    private static int binarySearch(RoutePopulation population, int left, int right, double selection){
        if(right>=left){
            int idx = (left+right)/2;
            if(idx==right-1)return idx;
            if(population.getPopulation()[idx].getCumulative()<=selection && selection<= population.getPopulation()[idx+1].getCumulative()){
                return idx;
            }
            if(population.getPopulation()[idx].getCumulative()>selection){
                return binarySearch(population,left,idx-1,selection);
            }
            return binarySearch(population,idx+1,right,selection);
        }
        return 0;
    }
    
    private static Route[] crossover(Route solution1, Route solution2){
        Route[] children = new Route[2];
        Random rand = new Random();
        int cut = rand.nextInt(solution1.getTotalCity());
        ArrayList<City> parent1 = (ArrayList<City>) solution1.getRoute().clone();
        ArrayList<City> parent2 = (ArrayList<City>) solution2.getRoute().clone();
        ArrayList<City> res1 = parent1;
        ArrayList<City> res2 = parent2;
        for (int i = 0; i < cut; i++) {
            if(parent1.get(i).getNumber()!=parent2.get(i).getNumber()){
                Collections.swap(res1,i,res1.indexOf(parent2.get(i)));
                Collections.swap(res2,i,res2.indexOf(parent1.get(i)));
            }
        }
        solution1.setRoute(res1);
        solution2.setRoute(res2);
        children[0] = solution1;
        children[1] = solution2;
        return children;
    }
    
    private static void mutation(Route solution){
        Random rand = new Random();
        int idx1 = rand.nextInt(solution.getTotalCity());
        int idx2 = rand.nextInt(solution.getTotalCity());
        ArrayList<City> sol = (ArrayList<City>) solution.getRoute().clone();
        Collections.swap(sol,idx1,idx2);
        solution.setRoute(sol);
    }
}
