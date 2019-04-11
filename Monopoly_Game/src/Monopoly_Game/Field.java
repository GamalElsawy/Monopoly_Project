
package Monopoly_Game;

import java.awt.Image;
import javax.swing.ImageIcon;

public abstract class Field {
    Image image;
    String Name;
    int Rows,Cols;
    Field(String n,int x,int y,String PathImage){
        Name = n;
        Rows=x;
        Cols=y;
        ImageIcon ii = new ImageIcon(PathImage);
        image  = ii.getImage();
                
    }
}
