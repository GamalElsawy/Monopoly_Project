
package Monopoly_Game;
import Monopoly_Game.Field;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public abstract class Property {
    static int AvailableHouse;
    static int AvailableHotel;
    Image img;
    

    public Property(String path) {
        AvailableHouse = 32;
        AvailableHotel = 12;
        ImageIcon ii = new ImageIcon(path);
        img  = ii.getImage();
        
    }
    
}
