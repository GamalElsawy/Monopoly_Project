package sample;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Tax extends Field{
    int taxValue;
    public Tax(String[] data) {
        super(data[0],Integer.parseInt(data[1]),Integer.parseInt(data[2]),data[3]);
        taxValue = Integer.parseInt(data[4]);
    }
}
