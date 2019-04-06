
package Monopoly_Game;

import java.awt.Image;
import javax.swing.ImageIcon;

public abstract class Field {
    Image image;
    String Name;
    double X,Y; // double or int ?? 
    Field(String n,double x,double y,String PathImage){
        Name = n;
        X=x;
        Y=y;
        ImageIcon ii = new ImageIcon(PathImage);
        image  = ii.getImage();
                
    }
}
