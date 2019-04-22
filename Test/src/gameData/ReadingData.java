package gameData;
import java.io.File;
import sample.*;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadingData {
    private  Scanner x;
    private  String Path;
    public void OpenFile(String path){
        Path = path;
        try{
            x = new Scanner(new File(Path));
            //System.out.println("ininin");
        }catch(Exception e){
            System.out.println("zcxc");
        }
    }
    public void Read(int noOfFields){
        String [] data = new String[noOfFields];
        int idx = 0;
        while (x.hasNext()) {
            for (int i = 0; i < noOfFields; i++){
                data[i] = x.next();
            }
            if (Path == "CitiesDetails.txt")
                gameData.cities[idx++] = new City(data);
            else if (Path == "Railroads.txt")
                gameData.railRoads[idx++] = new RailRoad(data);
            else if (Path == "Taxes.txt")
                gameData.taxes[idx++] = new Tax(data);
            else if (Path == "Utilities.txt")
                gameData.utilities[idx++] = new Utility(data);

        }
        Close();
    }
    public void Close(){
        x.close();
    }
}
