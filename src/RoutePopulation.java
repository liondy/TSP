/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author michael
 */
public class RoutePopulation {
    private Route[] population;
    
    public RoutePopulation(int populationSize){
        this.population = new Route[populationSize];
    }
    
    public void addNewRoute(int idx, Route route){
        this.population[idx] = route;
        this.printAllSolution();
    }
    
    public Route getRoute(int idx){
        return this.population[idx];
    }
    
    public void printAllSolution(){
        for (int i = 0; i < this.population.length; i++) {
            if(this.population[i]!=null){
                System.out.print("Solution "+ i + ": " );
                for (int j = 1; j <= this.population[i].getTotalCity(); j++) {
                    System.out.print(this.population[i].getRoute().get(j-1).getNumber()+" ");
                }
                System.out.println();
            }
        }
    }
    
}
