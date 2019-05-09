package sample;

import Stages.Stages;
import gameData.gameData;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Tax extends Field {
    int taxValue;

    public int getTaxValue() {
        return taxValue;
    }

    public Tax(String[] data) {
        super(data[0], data[9]);
        String[] s = new String[8];
        System.arraycopy(data, 1, s, 0, 8);
        setPostion(s);
        int idx = 10;
        taxValue = Integer.parseInt(data[idx]);
    }

    @Override
    public void OnVisiting(int idx, int dice) {
        Stages.payTax(this,idx);
        gameData.Players[idx].Payment(taxValue,10);
        Main.Labels(gameData.playersNumber);

    }
}
