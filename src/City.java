/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author michael
 */
public class City {
    private final int number;
    private final int x;
    private final int y;
    
    public City(int number, int x, int y){
        this.number=number;
        this.x=x;
        this.y=y;
    }
    
    public int getNumber(){
        return this.number;
    }
    
    public int getX(){
        return this.x;
    }
    
    public int getY(){
        return this.y;
    }
}
