package gameData;

import java.io.File;

import sample.*;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadingData {
    private Scanner x;
    private String Path;


    public void OpenFile(String path) {
        Path = path;
        try {
            x = new Scanner(new File(Path));

        } catch (Exception e) {
            System.out.println("Error!!!");
        }
    }

    public void Read(int noOfFields) {
        String[] data = new String[noOfFields];
        int idx = 0;
        while (x.hasNext()) {
            int id = Integer.parseInt(x.next());
            int dimX = 0, dimY = 0 , MorX = 0 , MorY = 0;
            if (Path == "CitiesDetails.txt" || Path == "Railroads.txt" || Path == "Utilities.txt"){
                dimX = Integer.parseInt(x.next());
                dimY = Integer.parseInt(x.next());
                MorX = Integer.parseInt(x.next());
                MorY = Integer.parseInt(x.next());
            }
            for (int i = 0; i < noOfFields; i++) {
                data[i] = x.next();
            }
            if (Path == "CitiesDetails.txt") {
                gameData.cities[idx] = new City(data);
                gameData.cities[idx].SetId(id);
                gameData.cities[idx].setSmall(dimX, dimY);
                gameData.cities[idx].setMor(MorX, MorY);

                idx++;
            } else if (Path == "Railroads.txt") {
                gameData.railRoads[idx] = new RailRoad(data);
                gameData.railRoads[idx].SetId(id);
                gameData.railRoads[idx].setSmall(dimX, dimY);
                gameData.railRoads[idx].setMor(MorX, MorY);

                idx++;
            } else if (Path == "Taxes.txt") {
                gameData.taxes[idx] = new Tax(data);
                gameData.taxes[idx].SetId(id);
                idx++;
            } else if (Path == "Utilities.txt") {
                gameData.utilities[idx] = new Utility(data);
                gameData.utilities[idx].SetId(id);
                gameData.utilities[idx].setSmall(dimX, dimY);
                gameData.utilities[idx].setMor(MorX, MorY);
                idx++;

            } else if (Path == "Community Chest.txt") {
                gameData.arrOfCommunity[idx] = new CommunityChest(data);
                gameData.arrOfCommunity[idx].SetId(id);
                idx++;
            } else if (Path == "Chance.txt") {
                gameData.arrOfChance[idx] = new Chance(data);
                gameData.arrOfChance[idx].SetId(id);
                idx++;
            }
            else if (Path == "ChanceCards.txt"){
                gameData.ChanceCards[id] = data[0];
            }
            else if (Path == "ChestCards.txt"){
                gameData.CommunityCards[id] = data[0];
            }
            else
                System.out.println("An defined Format !");

        }
        Close();
    }
    public void ReadGroups(){
        int idx = 0;
        while (x.hasNext()) {
            String color = x.next();
            int size = x.nextInt();
            int[] ids = new int[size];
            for (int i = 0; i < size; i++)
                ids[i] = x.nextInt();
            gameData.groups[idx] = new Groups(size, ids, color);
            gameData.groupMP.put(color, gameData.groups[idx]);
            idx++;
        }
    }

    public void Close() {
        x.close();
    }
}
