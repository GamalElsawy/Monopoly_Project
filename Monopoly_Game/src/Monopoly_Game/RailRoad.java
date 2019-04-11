package Monopoly_Game;
import Monopoly_Game.Field;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class RailRoad extends Field{
    static int[] Rent = {0, 25, 50, 100, 200};
    static int Mort = 100, Price = 200;
    public RailRoad(String n,int x,int y,String PathImage) {
        super(n,x,y,PathImage);
    }
    int payRent(int noRailroads){
        return Rent[noRailroads];
    }
}