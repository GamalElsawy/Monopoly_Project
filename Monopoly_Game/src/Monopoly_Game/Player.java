package Monopoly_Game;
import Monopoly_Game.Field;
import java.util.ArrayList;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Player {
    int ID,NOfHouses,NOfHotels,NORailWays,Balance,ValueOfAssets,NOUtilities;
    String Name;
    ArrayList<City> PlayerCities;
    ArrayList<RailRoad> PlayerRailRoad;
    ArrayList<Utility> PlayerUtilities;
    boolean isInJail;

    public Player(int id,String n) {
        ID = id;
        Name = n;
        NOfHouses = NOfHotels = NORailWays = ValueOfAssets = NOUtilities = 0;
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