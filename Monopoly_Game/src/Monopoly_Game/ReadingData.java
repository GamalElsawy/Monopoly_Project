package Monopoly_Game;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class ReadingData {
   
    private Scanner x;
    public  void OpenFile(){
        try{
        x = new Scanner(new File("CitiesDetails.txt"));
            //System.out.println("ininin");
        }catch(Exception e){
            System.out.println("zcxc");
        }
    }
    public void Read(){
        while (x.hasNext()) {            
            String s1 = x.next();
            String s2 = x.next();
            String s3 = x.next();
            String s4 = x.next();
            String s5 = x.next();
            String s6 = x.next();
            String s7 = x.next();
            String s8 = x.next();
            String s9 = x.next();
            String s10 = x.next();
            String s11 = x.next();
            String s12 = x.next();
            String s13 = x.next();
            String s14 = x.next();
            String s15 = x.next();
            String s16 = x.next();
            System.out.println(s1 + " "+s2+" "+s3+" " + s4+" " +s5 + " "+s6 +
                    " "+s7+" "+ s8 + " " +s9+" "+ s10 +" "+s11+ " "+s12
                    +" "+s13 +" "+s14+" "  + s15 +" "+s16+ "\n");
        }
       
    }
    public void Close(){
        x.close();
    }
    
    
}
