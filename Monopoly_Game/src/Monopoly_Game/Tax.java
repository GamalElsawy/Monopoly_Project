package Monopoly_Game;
import Monopoly_Game.Field;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Tax extends Field{
    int taxValue;
    public Tax(String n,double x,double y,String PathImage, int taxValue) {
        super(n,x,y,PathImage);
        this.taxValue = taxValue;
    }
}
