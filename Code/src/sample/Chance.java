package sample;

import Stages.Stages;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import gameData.gameData;

public class Chance extends Field{
    public Chance(String[] s) {
        super("Chance", "");
        setPostion(s);
    }


    @Override
    public void OnVisiting(int idx, int dice) {
        Stages.ChanceAndChest(idx,gameData.ChanceCards[gameData.curChance]);
        ChanceJudges.ChanceJudge(gameData.curChance + 1, idx);
        gameData.curChance = (gameData.curChance + 1) % 10;
    }
}
