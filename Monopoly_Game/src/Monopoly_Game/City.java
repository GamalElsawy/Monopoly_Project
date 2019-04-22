package Monopoly_Game;
import Monopoly_Game.Field;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class City extends Field{
   String CityColor;
   int Price,NumberOfHouses,Mortage,HouseCost,HotelCost,MonopolyRent,PlayerID;
   int[]Rent;
   boolean is_Grouped;
   public City(String[] data) {
        super(data[0], Integer.parseInt(data[1]), Integer.parseInt(data[2]), data[3]);
        int idx = 4;
        PlayerID = -1;
        HouseCost = Integer.parseInt(data[idx++]);
        HotelCost = Integer.parseInt(data[idx++]);
        MonopolyRent = Integer.parseInt(data[idx++]);
        Rent = new int[6];
        for (int i = 0; i < 6; i++) {
            Rent[i] = Integer.parseInt(data[idx++]);
        }
        Mortage = Integer.parseInt(data[idx++]);
        CityColor = data[idx++];
        Price = Integer.parseInt(data[idx++]);

    }
   void PayRent(int id){
   }
   void BuildHouse(){
   }
   void BuildHotel(){
   }
   void sell(){
   }
   void print(){
       System.out.print(Name + " " + Rows + " " + Cols + " " + HouseCost + " " + HotelCost + " " + MonopolyRent + " ");
       for (int i = 0; i < 6; i++)
           System.out.print(Rent[i] + " ");
       System.out.println(Mortage + " " + CityColor + " " + Price);
   }
   void ahmedHisham(){}
}
