package sample;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import gameData.gameData;

public class Jail extends Field{

    public Jail(String n,String []Pos,String PathImage) {
        super(n,PathImage);
        setPostion(Pos);
    }


    @Override
    public void OnVisiting(int idx, int dice) {
        return;
    }
}
