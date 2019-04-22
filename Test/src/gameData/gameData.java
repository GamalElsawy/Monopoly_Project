package gameData;
import com.sun.javafx.collections.MappingChange;
import sample.*;

import java.awt.*;
import java.util.HashMap;

public class gameData {
    public static City[] cities = new City[22];
    public static RailRoad[] railRoads = new RailRoad[4];
    public static Tax[] taxes = new Tax[2];
    public static Utility[] utilities = new Utility[2];
    public static HashMap <Point, Field> mp = new HashMap<Point, Field>();
    public static Jail jail = new Jail("Jail",339,727,"");
    public static GoToJail gotojail = new GoToJail("GoToJail",1159,107,"");
    public static FreeParking freeparking = new FreeParking("FreeParking",339,107,"");
    public static Chance[] arrOfChance = new Chance[3];
    public static CommunityChest[] arrOfCommunity = new CommunityChest[3];


    public static Go go = new Go("Go",1159,727,"");

    public static void fillData(){
        ReadingData rd = new ReadingData();
        rd.OpenFile("CitiesDetails.txt");
        rd.Read(16);
        rd.OpenFile("Railroads.txt");
        rd.Read(9);
        rd.OpenFile("Taxes.txt");
        rd.Read(5);
        rd.OpenFile("Utilities.txt");
        rd.Read(5);
        arrOfChance[0] = new Chance("Chance1",585,727,"");
        arrOfChance[1] = new Chance("Chance2",503,107,"");
        arrOfChance[2] = new Chance("Chance3",1159,479,"");

        arrOfCommunity[0] = new CommunityChest("Community1",995,727,"");
        arrOfCommunity[1] = new CommunityChest("Community2",339,293,"");
        arrOfCommunity[2] = new CommunityChest("Community3",1159,293,"");

    }
    public static void fillMap(){
        for (int i = 0; i < 22; i++){
            mp.put(cities[i].getPos(), cities[i]);
        }
        for (int i = 0; i < 4; i++){
            mp.put(railRoads[i].getPos(), railRoads[i]);
        }
        for (int i = 0; i < 2; i++){
            mp.put(taxes[i].getPos(), taxes[i]);
        }
        for (int i = 0; i < 2; i++){
            mp.put(utilities[i].getPos(), utilities[i]);
        }
        for(int i = 0;i < 3;i++)
            mp.put(arrOfChance[i].getPos(),arrOfChance[i]);
        for(int i = 0;i < 3;i++)
            mp.put(arrOfCommunity[i].getPos(),arrOfCommunity[i]);
        mp.put(jail.getPos(),jail);
        mp.put(gotojail.getPos(),gotojail);
        mp.put(freeparking.getPos(),freeparking);
        mp.put(go.getPos(),go);
    }
}
