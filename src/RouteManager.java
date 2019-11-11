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
    
    private final ArrayList<City> cityRoute;
    private final double[][] distanceMap;
    private double distance;
    
    public RouteManager(ArrayList<City> cities, double[][] distanceMap){
        this.cityRoute = cities;
        this.distanceMap = distanceMap;
        this.calcDistance();
    }
    
    public ArrayList<City> shuffle(){
        Collections.shuffle(this.cityRoute);
        this.calcDistance();
        return this.cityRoute;
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
    
    private int getTotalCities(){
        return this.cityRoute.size();
    }    
    
    private City getCity(int i){
        return this.cityRoute.get(i-1);
    }
}
