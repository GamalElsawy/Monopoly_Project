package gameData;

import com.sun.javafx.collections.MappingChange;
import javafx.scene.shape.Shape3D;
import sample.*;

import java.awt.*;
import java.util.HashMap;

public class gameData {
    public static City[] cities = new City[22];
    public static RailRoad[] railRoads = new RailRoad[4];
    public static Tax[] taxes = new Tax[2];
    public static Utility[] utilities = new Utility[2];
    public static HashMap<Point, Field> mp1 = new HashMap<Point, Field>();
    public static HashMap<Point, Field> mp2 = new HashMap<Point, Field>();
    public static HashMap<Point, Field> mp3 = new HashMap<Point, Field>();
    public static HashMap<Point, Field> mp4 = new HashMap<Point, Field>();
    public static FreeParking freeparking = new FreeParking("FreeParking", "");
    public static Chance[] arrOfChance = new Chance[3];
    public static CommunityChest[] arrOfCommunity = new CommunityChest[3];
    public static HashMap<Integer, Point> Path1 = new HashMap<Integer, Point>();
    public static HashMap<Integer, Point> Path2 = new HashMap<Integer, Point>();
    public static HashMap<Integer, Point> Path3 = new HashMap<Integer, Point>();
    public static HashMap<Integer, Point> Path4 = new HashMap<Integer, Point>();
    public static int Losers = 0;

    public static Groups[] groups = new Groups[8];
    public static HashMap<String, Groups> groupMP = new HashMap<>();
    public static String[] ChanceCards = new String[10];
    public static String[] CommunityCards = new String[10];
    public static String[] goPos = {"914", "783", "914", "846", "944", "829", "944", "765"};
    public static String[] jailPos = {"175", "788", "178", "846", "220", "847", "252", "836"};
    public static String[] goJail = {"948", "110", "948", "55", "912", "44", "912", "93"};
    public static GoToJail gotojail = new GoToJail("GoToJail", goJail, "");
    public static Jail jail = new Jail("Jail", jailPos, "");
    public static Go go = new Go("Go", goPos, "");
    public static String[] Names ;
    public static int playersNumber;
    public static Player[] Players;
    public static String[] playersIcons = {"sample/1yellow.png", "sample/2red.png", "sample/3green.png", "sample/4blue.png"};
    public static Shape3D[] playersShapes = new Shape3D[4];
    public static int cur1 = 0, cur2 = 0, cur3 = 0, cur4 = 0, curChance = 0, curChest = 0;


    public static void fillData() {
        ReadingData rd = new ReadingData();
        rd.OpenFile("CitiesDetails.txt");
        rd.Read(22);
        rd.OpenFile("Railroads.txt");
        rd.Read(15);
        rd.OpenFile("Taxes.txt");
        rd.Read(11);
        rd.OpenFile("Utilities.txt");
        rd.Read(11);
        rd.OpenFile("Community Chest.txt");
        rd.Read(8);
        rd.OpenFile("Chance.txt");
        rd.Read(8);
        rd.OpenFile("ChanceCards.txt");
        rd.Read(1);
        rd.OpenFile("ChestCards.txt");
        rd.Read(1);
        rd.OpenFile("Groups.txt");
        rd.ReadGroups();
        go.SetId(0);
        jail.SetId(10);
        freeparking.SetId(20);
        gotojail.SetId(30);
    }

    public static void fillMap() {
        for (int i = 0; i < 22; i++) {
            Path1.put(cities[i].getId(),cities[i].getPos(1));
            Path2.put(cities[i].getId(),cities[i].getPos(2));
            Path3.put(cities[i].getId(),cities[i].getPos(3));
            Path4.put(cities[i].getId(),cities[i].getPos(4));

            mp1.put(cities[i].getPos(1), cities[i]);
            mp2.put(cities[i].getPos(2), cities[i]);
            mp3.put(cities[i].getPos(3), cities[i]);
            mp4.put(cities[i].getPos(4), cities[i]);
        }
        for (int i = 0; i < 4; i++) {
            Path1.put(railRoads[i].getId(),railRoads[i].getPos(1));
            Path2.put(railRoads[i].getId(),railRoads[i].getPos(2));
            Path3.put(railRoads[i].getId(),railRoads[i].getPos(3));
            Path4.put(railRoads[i].getId(),railRoads[i].getPos(4));

            mp1.put(railRoads[i].getPos(1), railRoads[i]);
            mp2.put(railRoads[i].getPos(2), railRoads[i]);
            mp3.put(railRoads[i].getPos(3), railRoads[i]);
            mp4.put(railRoads[i].getPos(4), railRoads[i]);

        }
        for (int i = 0; i < 2; i++) {
            Path1.put(taxes[i].getId(),taxes[i].getPos(1));
            Path2.put(taxes[i].getId(),taxes[i].getPos(2));
            Path3.put(taxes[i].getId(),taxes[i].getPos(3));
            Path4.put(taxes[i].getId(),taxes[i].getPos(4));

            mp1.put(taxes[i].getPos(1), taxes[i]);
            mp2.put(taxes[i].getPos(2), taxes[i]);
            mp3.put(taxes[i].getPos(3), taxes[i]);
            mp4.put(taxes[i].getPos(4), taxes[i]);
        }
        for (int i = 0; i < 2; i++) {
            Path1.put(utilities[i].getId(),utilities[i].getPos(1));
            Path2.put(utilities[i].getId(),utilities[i].getPos(2));
            Path3.put(utilities[i].getId(),utilities[i].getPos(3));
            Path4.put(utilities[i].getId(),utilities[i].getPos(4));

            mp1.put(utilities[i].getPos(1), utilities[i]);
            mp2.put(utilities[i].getPos(2), utilities[i]);
            mp3.put(utilities[i].getPos(3), utilities[i]);
            mp4.put(utilities[i].getPos(4), utilities[i]);
        }
        for (int i = 0; i < 3; i++) {
            Path1.put(arrOfChance[i].getId(),arrOfChance[i].getPos(1));
            Path2.put(arrOfChance[i].getId(),arrOfChance[i].getPos(2));
            Path3.put(arrOfChance[i].getId(),arrOfChance[i].getPos(3));
            Path4.put(arrOfChance[i].getId(),arrOfChance[i].getPos(4));

            mp1.put(arrOfChance[i].getPos(1), arrOfChance[i]);
            mp2.put(arrOfChance[i].getPos(2), arrOfChance[i]);
            mp3.put(arrOfChance[i].getPos(3), arrOfChance[i]);
            mp4.put(arrOfChance[i].getPos(4), arrOfChance[i]);
        }
        for (int i = 0; i < 3; i++) {
            Path1.put(arrOfCommunity[i].getId(),arrOfCommunity[i].getPos(1));
            Path2.put(arrOfCommunity[i].getId(),arrOfCommunity[i].getPos(2));
            Path3.put(arrOfCommunity[i].getId(),arrOfCommunity[i].getPos(3));
            Path4.put(arrOfCommunity[i].getId(),arrOfCommunity[i].getPos(4));

            mp1.put(arrOfCommunity[i].getPos(1), arrOfCommunity[i]);
            mp2.put(arrOfCommunity[i].getPos(2), arrOfCommunity[i]);
            mp3.put(arrOfCommunity[i].getPos(3), arrOfCommunity[i]);
            mp4.put(arrOfCommunity[i].getPos(4), arrOfCommunity[i]);
        }
        Path1.put(jail.getId(),jail.getPos(1));
        Path2.put(jail.getId(),jail.getPos(2));
        Path3.put(jail.getId(),jail.getPos(3));
        Path4.put(jail.getId(),jail.getPos(4));

        mp1.put(jail.getPos(1), jail);
        mp2.put(jail.getPos(2), jail);
        mp3.put(jail.getPos(3), jail);
        mp4.put(jail.getPos(4), jail);

        Path1.put(gotojail.getId(),gotojail.getPos(1));
        Path2.put(gotojail.getId(),gotojail.getPos(2));
        Path3.put(gotojail.getId(),gotojail.getPos(3));
        Path4.put(gotojail.getId(),gotojail.getPos(4));

        mp1.put(gotojail.getPos(1), gotojail);
        mp2.put(gotojail.getPos(2), gotojail);
        mp3.put(gotojail.getPos(3), gotojail);
        mp4.put(gotojail.getPos(4), gotojail);

        Path1.put(freeparking.getId(),freeparking.getPos(1));
        Path2.put(freeparking.getId(),freeparking.getPos(2));
        Path3.put(freeparking.getId(),freeparking.getPos(3));
        Path4.put(freeparking.getId(),freeparking.getPos(4));

        mp1.put(freeparking.getPos(1), freeparking);
        mp2.put(freeparking.getPos(2), freeparking);
        mp3.put(freeparking.getPos(3), freeparking);
        mp4.put(freeparking.getPos(4), freeparking);

        Path1.put(go.getId(),go.getPos(1));
        Path2.put(go.getId(),go.getPos(2));
        Path3.put(go.getId(),go.getPos(3));
        Path4.put(go.getId(),go.getPos(4));

        mp1.put(go.getPos(1), go);
        mp2.put(go.getPos(2), go);
        mp3.put(go.getPos(3), go);
        mp4.put(go.getPos(4), go);

    }
}
