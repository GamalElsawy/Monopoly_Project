package Monopoly_Game;
import Monopoly_Game.Field;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Utility extends Field{
    int Rent;
    static int Price = 150, Mort = 75;
    public Utility(String n,int x,int y,String PathImage) {
        super(n,x,y,PathImage);
        
    }
    public int payRent(int diceRolledAmount, boolean isBothOwned){
        if (isBothOwned)
            Rent = 10 * diceRolledAmount;
        else
            Rent = 4 * diceRolledAmount;
        return Rent;
    }
}
