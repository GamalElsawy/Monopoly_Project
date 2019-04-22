package sample;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Groups {
    Color color;
    int NumberOfCities;
    //boolean isGrouped;
    int Sold;
    City[] GroupedCity;

    Groups(int noc,Color clr) {
        color = clr;
        NumberOfCities = noc;
        Sold = 0;
        GroupedCity = new City[noc];
    }
    public void setGroupedCity(City[] GroupedCity) {
        System.arraycopy(GroupedCity, 0, this.GroupedCity, 0, NumberOfCities);

    }

}
