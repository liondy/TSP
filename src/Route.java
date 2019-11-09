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
    private double distance;
    private double fitness;
    private double peluang;
    private double cumulative;
    
    public Route(ArrayList<City> cities,double distance){
        this.arrayCity = cities;
        this.totalCity = cities.size();
        this.distance = distance;
        this.fitness = 1.0 / distance;
    }
    
    public void setSomeCity(City city, int i){
        this.arrayCity.add(i, city);
    }
    
    public void setRoute(ArrayList<City> cities){
        this.arrayCity = cities;
    }
    
    public void setPeluang(double peluang){
        this.peluang = peluang;
    }
    
    public void setCumulative(double cumulative){
        this.cumulative = cumulative;
    }
    
    public double getPeluang(){
        return this.peluang;
    }
    
    public double getCumulative(){
        return this.cumulative;
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
    
    public double getDistance(){
        return this.distance;
    }
    
    public City getCities(int i){
        return this.arrayCity.get(i-1);
    }
}
