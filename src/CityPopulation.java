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
public class CityPopulation {
    ArrayList<City> cities = new ArrayList<>();
    int totalCity;
    double fitness;
    double[][] distance;
    
    public void addToPopulation(City city){
        cities.add(city);
    }
    
    public void countTotalCity(){
        this.totalCity = this.cities.size();
        this.distance = new double[this.totalCity+1][this.totalCity+1];
    }
    
    public City getCities(int i){
        return this.cities.get(i-1);
    }
    
    public void setDistanceMap(double[][] distance){
        this.distance = distance;
    }
    
    public void setAllDistances(){
        for (int i = 1; i <= this.totalCity; i++) {
            for (int j = 1; j <= this.totalCity; j++) {
                if(this.getCities(i).getNumber()==this.getCities(j).getNumber()) this.distance[i][j] = 0;
                else if(this.distance[this.getCities(i).getNumber()][this.getCities(i).getNumber()]!=0)continue;
                else{
                    int deltaX = this.getCities(i).getX() - this.getCities(j).getX();
                    int deltaY = this.getCities(i).getY() - this.getCities(j).getY();
                    this.distance[this.getCities(i).getNumber()][this.getCities(j).getNumber()] = Math.sqrt((deltaX*deltaX) + (deltaY*deltaY));
                    this.distance[this.getCities(j).getNumber()][this.getCities(i).getNumber()] = Math.sqrt((deltaX*deltaX) + (deltaY*deltaY));
                }
            }
        }
    }
    
    public void getAllDistances(){
        for (int i = 1; i <= this.totalCity; i++) {
            for (int j = 1; j <= this.totalCity; j++) {
                System.out.print(this.distance[i][j]+" ");
            }
            System.out.println();
        }
    }
    
    public void calcFitness(){
        this.fitness = 0;
        for (int i = 0; i <= this.totalCity-2; i++) {
            this.fitness+=this.distance[this.cities.get(i).getNumber()][this.cities.get(i+1).getNumber()];
        }
    }
    
    public void shuffle(){
        Collections.shuffle(this.cities);
    }
}
