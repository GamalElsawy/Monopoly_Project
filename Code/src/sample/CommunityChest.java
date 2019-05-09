package sample;

import Stages.Stages;
import gameData.gameData;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CommunityChest extends Field{
    public CommunityChest(String[] s) {
        super("CommunityChest", "");
        setPostion(s);

    }

    @Override
    public void OnVisiting(int idx, int dice) {
        Stages.ChanceAndChest(idx, gameData.CommunityCards[gameData.curChest]);
        Community.CommunityJudge(gameData.curChest + 1, idx);
        gameData.curChest = (gameData.curChest + 1) % 10;
    }
}
