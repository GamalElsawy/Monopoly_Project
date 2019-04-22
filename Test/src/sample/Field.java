package sample;

import javafx.util.Pair;

import java.awt.*;
import javax.swing.ImageIcon;

public abstract class Field {
    Image image;
    String Name;
    Point pos;
    Field(String n,int x,int y,String PathImage){
        Name = n;
        pos = new Point(x, y);
        ImageIcon ii = new ImageIcon(PathImage);
        image  = ii.getImage();

    }

    public Point getPos() {
        return pos;
    }
}
