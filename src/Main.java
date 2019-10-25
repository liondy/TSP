/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author michael
 */
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CityPopulation cityPopulation = new CityPopulation();
        while(sc.hasNextInt()){
            int n = sc.nextInt();
            int x = sc.nextInt();
            int y = sc.nextInt();
            City city = new City(n,x,y);
            cityPopulation.addToPopulation(city);
        }
        cityPopulation.countTotalCity();
        cityPopulation.setAllDistances();
        cityPopulation.getAllDistances();
    }
}
