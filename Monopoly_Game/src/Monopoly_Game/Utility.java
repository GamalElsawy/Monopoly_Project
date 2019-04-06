package Monopoly_Game;
import Monopoly_Game.Field;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Utility extends Field{
    int Rent, Price;
    public Utility(String n,double x,double y,String PathImage, int rent, int price) {
        super(n,x,y,PathImage);
        Rent = rent;
        Price = price;
    }
}
