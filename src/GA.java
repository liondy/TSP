/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author michael
 */
public class GA {
    
    public static RoutePopulation evolve(RoutePopulation population){
        RoutePopulation nextGeneration = new RoutePopulation(population.getPopulationSize());
        for (int i = 0; i < nextGeneration.getPopulationSize(); i++) {
            Route parent1 = selection(population);
            Route parent2 = selection(population);
            Route[] child = crossover(parent1,parent2);
        }
        return nextGeneration;
    }
    
    public static Route selection(RoutePopulation population){
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
            if(population.getPopulation()[idx].getCumulative()>=selection && selection<= population.getPopulation()[idx+1].getCumulative()){
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
        return children;
    }
    
    public void mutation(int[] solution){
        
    }
}
