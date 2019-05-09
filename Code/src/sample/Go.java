package sample;

import Stages.Stages;
import gameData.gameData;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Go extends Field{
    public Go(String n, String []Pos,String PathImage) {
        super(n,PathImage);
        setPostion(Pos);
    }

    @Override
    public void OnVisiting(int idx, int dice) {
        Stages.allownce(idx);
        gameData.Players[idx].setBalance(gameData.Players[idx].getBalance() + 200);
        Main.Labels(gameData.playersNumber);
    }
}
