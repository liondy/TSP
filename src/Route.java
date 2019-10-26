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
    private ArrayList<City> cities;
    private int totalCity;
    private double fitness;
    
    public Route(ArrayList<City> cities,double distance){
        this.cities = cities;
        this.totalCity = cities.size();
        this.fitness = 1.0 / distance;
    }
    
    public ArrayList<City> getRoute(){
        return this.cities;
    }
    
    public int getTotalCity(){
        return this.totalCity;
    }
    
    public double getFitness(){
        return this.fitness;
    }
    
    public City getCities(int i){
        return this.cities.get(i-1);
    }
}
