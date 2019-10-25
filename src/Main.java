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
        ArrayList<City> cities = new ArrayList<>();
        while(sc.hasNext()){
            int n = sc.nextInt();
            int x = sc.nextInt();
            int y = sc.nextInt();
            City city = new City(n,x,y);
            cities.add(city);
        }
    }
}
