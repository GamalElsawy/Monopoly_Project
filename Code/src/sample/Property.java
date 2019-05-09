package sample;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public abstract class Property {
    public static int getAvailableHouse() {
        return AvailableHouse;
    }

    public static int getAvailableHotel() {
        return AvailableHotel;
    }

    public static void setAvailableHouse(int availableHouse) {
        AvailableHouse = availableHouse;
    }

    public static void setAvailableHotel(int availableHotel) {
        AvailableHotel = availableHotel;
    }

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
