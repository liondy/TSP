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
public class RouteManager {
    
    private ArrayList<City> cities;
    private double[][] distanceMap;
    private double distance;
    
    public RouteManager(ArrayList<City> cities, double[][] distanceMap){
        this.cities = cities;
        this.distanceMap = distanceMap;
        this.calcDistance();
    }
    
    public City getCity(int i){
        return this.cities.get(i-1);
    }
    
    public int getTotalCities(){
        return this.cities.size();
    }
    
    public ArrayList<City> shuffle(){
        Collections.shuffle(this.cities);
        this.calcDistance();
        return this.cities;
    }
    
    public double getDistance(){
        return this.distance;
    }
    
    private void calcDistance(){
        this.distance = 0;
        for (int i = 1; i < this.getTotalCities(); i++) {
            this.distance+=this.distanceMap[this.getCity(i).getNumber()][this.getCity(i+1).getNumber()];
        }
    }
}
