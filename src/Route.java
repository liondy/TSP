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
public class Route {
    private ArrayList<City> arrayCity;
    private int totalCity;
    private double fitness;
    
    public Route(ArrayList<City> cities,double distance){
        this.arrayCity = cities;
        this.totalCity = cities.size();
        this.fitness = 1.0 / distance;
    }
    
    public ArrayList<City> getRoute(){
        return this.arrayCity;
    }
    
    public int getTotalCity(){
        return this.totalCity;
    }
    
    public double getFitness(){
        return this.fitness;
    }
    
    public City getCities(int i){
        return this.arrayCity.get(i-1);
    }
}
