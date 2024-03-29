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
    private final Route[] population;
    private final int populationSize;
    private double totalFitness;
    
    public RoutePopulation(int populationSize){
        this.populationSize = populationSize;
        this.population = new Route[populationSize];
    }
    
    public int getPopulationSize(){
        return this.populationSize;
    }
    
    public void addNewRoute(int idx, Route route){
        this.population[idx] = route;
    }
    
    public Route getRoute(int idx){
        return this.population[idx];
    }
    
    public void setTotalFitness(double totalFitness){
        this.totalFitness = totalFitness;
    }
    
    public void countPeluangKumulatif(){
        double cumulative = 0;
        for (int i = 0; i < this.populationSize; i++) {
            double peluang = this.population[i].getFitness()/this.totalFitness;
            this.population[i].setPeluang(peluang);
            cumulative+=peluang;
            this.population[i].setCumulative(cumulative);
        }
    }
    
    public Route[] getPopulation(){
        return this.population;
    }
    
    public Route getFittest() {
        Route fittest = this.population[0];
        for (int i = 1; i < this.population.length; i++) {
            if(this.population[i]!=null){
                if (fittest.getFitness() <= this.population[i].getFitness()) {
                    fittest = this.population[i];
                }
            }
        }
        return fittest;
    }
}
