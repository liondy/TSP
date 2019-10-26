/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author michael
 */
public class Solution {
    CityPopulation[] populations;
    double[] fitness;
    
    public Solution(CityPopulation cityPopulation, double[][] distanceMap){
        this.populations = new CityPopulation[cityPopulation.totalCity];
        this.fitness = new double[cityPopulation.totalCity];
        for (int i = 0; i < cityPopulation.totalCity; i++) {
            CityPopulation newCityPopulation = cityPopulation;
            newCityPopulation.countTotalCity();
            newCityPopulation.shuffle();
            newCityPopulation.setDistanceMap(distanceMap);
            newCityPopulation.calcFitness();
            this.addNewSolution(i,newCityPopulation);
        }
    }
    
    public void addNewSolution(int idx, CityPopulation sol){
        this.populations[idx] = sol;
    }
    
    public CityPopulation getSolution(int idx){
        return this.populations[idx-1];
    }
    
    public void printAllSolution(){
        for (int i = 1; i <= this.populations.length; i++) {
            for (int j = 0; j < this.populations[i].totalCity; j++) {
                System.out.println(this.populations[i].cities.get(j)+" ");
            }
            System.out.println();
        }
    }
    
}
