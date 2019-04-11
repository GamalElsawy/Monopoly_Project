package Monopoly_Game;
import Monopoly_Game.Field;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class RailRoad extends Field{
    int[] Rent;
    int Mort, Price;
    public RailRoad(String n,int x,int y,String PathImage, int[] rent, int mort, int price) {
        super(n,x,y,PathImage);
        Rent = new int[5];
        System.arraycopy(rent, 1, Rent, 1, 4);
        Mort = mort;
        Price = price;
    }
    int payRent(int noRailroads){
        return Rent[noRailroads];
    }
}