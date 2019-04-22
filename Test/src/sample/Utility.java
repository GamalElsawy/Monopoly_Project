package sample;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Utility extends Field{
    int Rent, Price;
    public Utility(String[] data) {
        super(data[0],Integer.parseInt(data[1]),Integer.parseInt(data[2]),data[3]);
        Price = Integer.parseInt(data[4]);
    }
}
