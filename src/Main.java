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
import java.util.ArrayList;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int totalCity = 0;
        CityPopulation cityPopulation = new CityPopulation();
        ArrayList<City> dummy = new ArrayList<>();
        while(sc.hasNextInt()){
            totalCity++;
            int n = sc.nextInt();
            int x = sc.nextInt();
            int y = sc.nextInt();
            City city = new City(n,x,y);
            dummy.add(city);
            cityPopulation.addToPopulation(city);
        }
        cityPopulation.countTotalCity();
        double[][] cityDistanceMap = new double[totalCity+1][totalCity+1];
        for (int i = 0; i < totalCity; i++) {
            for (int j = 0; j < totalCity; j++) {
                if(dummy.get(i).getNumber()==dummy.get(j).getNumber()) cityDistanceMap[dummy.get(i).getNumber()][dummy.get(j).getNumber()] = 0;
                else if(cityDistanceMap[dummy.get(i).getNumber()][dummy.get(j).getNumber()]!=0)continue;
                else{
                    int deltaX = dummy.get(i).getX() - dummy.get(j).getX();
                    int deltaY = dummy.get(i).getY() - dummy.get(j).getY();
                    cityDistanceMap[dummy.get(i).getNumber()][dummy.get(j).getNumber()] = Math.sqrt((deltaX*deltaX) + (deltaY*deltaY));
                    cityDistanceMap[dummy.get(j).getNumber()][dummy.get(i).getNumber()] = cityDistanceMap[dummy.get(i).getNumber()][dummy.get(j).getNumber()];
                }
            }
        }
        cityPopulation.setDistanceMap(cityDistanceMap);
        Solution population = new Solution(cityPopulation,cityDistanceMap);
        population.printAllSolution();
    }
}
