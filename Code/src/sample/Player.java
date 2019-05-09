package sample;

import java.util.ArrayList;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Iterator;

import Stages.Stages;
import gameData.gameData;
import javafx.scene.image.Image;

public class Player {
    int ID;
    String Name;
    ArrayList<Field> PlayerCities;
    ArrayList<Field> PlayerRailRoad;
    ArrayList<Field> PlayerUtilities;
    boolean isInJail, HaveJailCardChest, HaveJailCardChance, hasGroup, isLoser;
    int ValueOfAssets;

    int jailtime;


    public int getValueOfAssets() {
        return ValueOfAssets;
    }
    int NOfHouses;
    int NOfHotels;
    int Balance;


    public Player(int id, String n) {
        ID = id;
        Name = n;
        jailtime = 0;
        HaveJailCardChance = false;
        HaveJailCardChest = false;
        hasGroup = false;
        NOfHouses = NOfHotels = ValueOfAssets = 0;
        Balance = 1500;
        isInJail = false;
        isLoser = false;
        PlayerCities = new ArrayList<>();
        PlayerRailRoad = new ArrayList<>();
        PlayerUtilities = new ArrayList<>();

    }
    public void setValueOfAssets(int valueOfAssets) {
        ValueOfAssets = valueOfAssets;
    }


    public String getName() {
        return Name;
    }

    public int getJailtime() {
        return jailtime;
    }

    public void setJailtime(int jailtime) {
        this.jailtime = jailtime;
    }

    public boolean isHaveJailCardChest() {
        return HaveJailCardChest;
    }

    public void setHaveJailCardChest(boolean haveJailCardChest) {
        HaveJailCardChest = haveJailCardChest;
    }

    public boolean isHaveJailCardChance() {
        return HaveJailCardChance;
    }

    public void setHaveJailCardChance(boolean haveJailCardChance) {
        HaveJailCardChance = haveJailCardChance;
    }

    public boolean isLoser() {
        return isLoser;
    }

    public void setLoser(boolean loser) {
        isLoser = loser;
        Main.dec.setDisable(false);
        Main.dec.setVisible(true);
    }

    public int getNOfHouses() {
        return NOfHouses;
    }

    public void setNOfHouses(int NOfHouses) {
        this.NOfHouses = NOfHouses;
    }

    public int getNOfHotels() {
        return NOfHotels;
    }

    public void setNOfHotels(int NOfHotels) {
        this.NOfHotels = NOfHotels;
    }


    public void Payment(int value, int ID_city) {

        if (Balance-value < 0) {
            Main.dec.setDisable(false);
            Main.dec.setVisible(true);
            Balance = -1;

        }
        else {
            gameData.Players[ID].setBalance(gameData.Players[ID].getBalance()-value);
        }
    }

    public int getBalance() {
        return Balance;
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

    public void addCity(Field c) {
        PlayerCities.add(c);
    }

    public void addRR(Field r) {
        PlayerRailRoad.add(r);
    }

    public void addUtil(Field u) {
        PlayerUtilities.add(u);
    }

    public boolean isNewGroup(String color) {
        Groups g = gameData.groupMP.get(color);
        for (int i = 0; i < g.NumberOfCities; i++) {
            System.out.println("City:" + g.GroupedCity[i] + "::::::" + gameData.cities[g.GroupedCity[i]].getPlayerID());
            if (gameData.cities[g.GroupedCity[i]].getPlayerID() == -1 || gameData.cities[g.GroupedCity[i]].getPlayerID() != ID)
                return false;
        }
        g.setGrouped(true);
        for (int i = 0; i < g.NumberOfCities; i++) {

            gameData.cities[g.GroupedCity[i]].setIs_Grouped(true);

        }
        return true;
    }

    public void setHasGroup(boolean hasGroup) {
        this.hasGroup = hasGroup;
    }
}