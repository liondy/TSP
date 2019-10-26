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
        this.populations = new CityPopulation[cityPopulation.totalCity+1];
        this.fitness = new double[cityPopulation.totalCity+1];
        CityPopulation temp = cityPopulation;
        CityPopulation[] tmp = new CityPopulation[cityPopulation.totalCity+1];
        for (int i = 1; i <= cityPopulation.totalCity; i++) {
            CityPopulation newCityPopulation = new CityPopulation();
            newCityPopulation = temp;
            newCityPopulation.countTotalCity();
            newCityPopulation.shuffle();
            newCityPopulation.setDistanceMap(distanceMap);
            newCityPopulation.calcFitness();
            System.out.println(i);
            tmp[i] = newCityPopulation;
            this.populations[i] = tmp[i];
//            this.addNewSolution(i,newCityPopulation);
            temp.cities = newCityPopulation.cities;
//            this.printAllSolution();
//            System.out.print("Solution "+ i + ": " );
//            for (int j = 1; j <= this.populations[i].totalCity; j++) {
//                System.out.print(this.populations[i].getCities(j).getNumber()+" ");
//            }
//            System.out.println();
        }
    }
    
    public void addNewSolution(int idx, CityPopulation sol){
        System.out.println(idx);
        this.populations[idx] = sol;
    }
    
    public CityPopulation getSolution(int idx){
        return this.populations[idx-1];
    }
    
    public void printAllSolution(){
        System.out.println();
        for (int i = 1; i < this.populations.length; i++) {
            if(this.populations[i]!=null){
                System.out.print("Solution "+ i + ": " );
                for (int j = 1; j <= this.populations[i].totalCity; j++) {
                    System.out.print(this.populations[i].getCities(i).getNumber()+" ");
                }
            }
            System.out.println();
        }
    }
    
}
