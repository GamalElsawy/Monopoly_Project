package Monopoly_Game;
import Monopoly_Game.Field;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class RailRoad extends Field{
    int[] Rent;
    public RailRoad(String n,double x,double y,String PathImage) {
        super(n,x,y,PathImage);
        Rent = new int[5];
    }
    int payRent(int noRailroads){
        return Rent[noRailroads];
    }
}