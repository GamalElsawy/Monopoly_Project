package Monopoly_Game;
import Monopoly_Game.Field;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class City extends Field{
   Color CityColor;
   int Price,NumberOfHouses,Mortage,HouseCost,HotelCost,MonopolyRent,PlayerID;
   int[]Rent;
   boolean is_Grouped;
   City(String n,int x,int y,String PathImage,int hsc,int htc,int monoRent,int[] rent,int mort,Color clr,int prc){
       super(n,x,y,PathImage);
       PlayerID = -1;
       System.arraycopy(rent, 0, Rent, 0, 6);
       HouseCost = hsc;
       HotelCost = htc;
       MonopolyRent = monoRent;
       Mortage = mort;
       CityColor = clr;
       Price = prc;
       
   }
   void PayRent(int id){
   }
   void BuildHouse(){
   }
   void BuildHotel(){
   }
   void sell(){
   }
}
