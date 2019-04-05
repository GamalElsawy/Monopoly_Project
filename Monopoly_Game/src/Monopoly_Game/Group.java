package Monopoly_Game;
import Monopoly_Game.Field;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Group {
    Color color;
    int NumberOfCities;
    //boolean isGrouped;
    int Sold;
    City[] GroupedCity;

    Group(int noc,Color clr) {
        color = clr;
        NumberOfCities = noc;
        Sold = 0;
        GroupedCity = new City[noc];
    }
    public void setGroupedCity(City[] GroupedCity) {
        System.arraycopy(GroupedCity, 0, this.GroupedCity, 0, NumberOfCities);
        
    }
    
 }
