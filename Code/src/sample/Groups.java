package sample;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Groups {
    String color;
    int NumberOfCities;

    boolean isGrouped;
    int[] GroupedCity;

    public Groups(int noc,int[] cities,String clr) {
        color = clr;
        NumberOfCities = noc;
        isGrouped = false;
        GroupedCity = new int[noc];
        setGroupedCity(cities);
    }

    public boolean isGrouped() {
        return isGrouped;
    }

    public void setGrouped(boolean grouped) {
        isGrouped = grouped;
    }

    public void setGroupedCity(int[] GroupedCity) {
        System.arraycopy(GroupedCity, 0, this.GroupedCity, 0, NumberOfCities);

    }

}
