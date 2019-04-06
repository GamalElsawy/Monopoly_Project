package Monopoly_Game;
import Monopoly_Game.Field;
import java.util.ArrayList;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Player {
    int ID,NOfHouses,NOfHotels,
            Balance,ValueOfAssets;
    String Name;
    ArrayList<City> PlayerCities;
    ArrayList<RailRoad> PlayerRailRoad;
    ArrayList<Utility> PlayerUtilities;
    boolean isInJail;

    Player(int id,String n) {
        ID = id;
        Name = n;
        NOfHouses = NOfHotels = ValueOfAssets = 0;
        Balance = 1500;
        PlayerCities = new ArrayList<City>();
        PlayerRailRoad = new ArrayList<RailRoad>();
        PlayerUtilities = new ArrayList<Utility>();
        isInJail = false;
        
    }

    public int getID() {
        return ID;
    }

    public void setBalance(int Balance) {
        this.Balance = Balance;
    }

    public void setIsInJail(boolean isInJail) {
        this.isInJail = isInJail;
    }
    
}