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
        for (int i = 0; i < 10; i++) {
            System.out.println();
            Route parent1 = selection(population);
            Route parent2 = selection(population);
            System.out.println("parent1: ");
            for (int j = 0; j < parent1.getTotalCity(); j++) {
                System.out.print(parent1.getRoute().get(j).getNumber()+" ");
            }
            System.out.println();
            System.out.println("parent2: ");
            for (int j = 0; j < parent2.getTotalCity(); j++) {
                System.out.print(parent2.getRoute().get(j).getNumber()+" ");
            }
            Route[] child = crossover(parent1,parent2);
        }
        return nextGeneration;
    }
    
    public static Route selection(RoutePopulation population){
        double selection = Math.random();
        System.out.println("selection: "+selection);
        int idx = binarySearch(population,0,population.getPopulationSize()-1,selection);
        System.out.println("idx: "+idx);
        if(idx!=-1){
            Route selected = population.getPopulation()[idx];
            return selected;
        }
        return null;
    }
    
    private static int binarySearch(RoutePopulation population, int left, int right, double selection){
        if(right>=left){
            int idx = (left+right)/2;
            System.out.println("index= "+idx);
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
        return children;
    }
    
    public void mutation(int[] solution){
        
    }
}
