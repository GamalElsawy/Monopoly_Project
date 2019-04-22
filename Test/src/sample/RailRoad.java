package sample;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import gameData.gameData;

public class RailRoad extends Field{
    int[] Rent;
    int price;
    public RailRoad(String[] data) {
        super(data[0],Integer.parseInt(data[1]),Integer.parseInt(data[2]),data[3]);
        Rent = new int[4];
        int idx = 4;
        for (int i = 0; i < 4; i++){
            Rent[i] = Integer.parseInt(data[idx++]);
        }
        price = Integer.parseInt(data[idx++]);
    }
    int payRent(int noRailroads){
        return Rent[noRailroads];
    }
}