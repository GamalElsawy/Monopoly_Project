package Monopoly_Game;
import java.io.File;
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
            Monopoly_Game.cities[idx++] = new City(data);
        }

    }
    public void Close(){
        x.close();
    }
    
    
}
