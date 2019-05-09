package sample;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class FreeParking extends Field{
    public FreeParking(String n, String PathImage) {
        super(n,PathImage);
        String[] s = {"246", "109", "244", "54", "195", "52", "195", "101"};
        setPostion(s);
    }

    @Override
    public void OnVisiting(int idx, int dice) {
        return;
    }
}