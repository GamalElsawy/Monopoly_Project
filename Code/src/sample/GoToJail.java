package sample;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import gameData.gameData;

public class GoToJail extends Field{
    public GoToJail(String n,String[] Pos,String PathImage) {
        super(n,PathImage);
        setPostion(Pos);

    }

    @Override
    public void OnVisiting(int idx, int dice) {
        if (idx == 0){
            gameData.playersShapes[idx].setTranslateX(209);
            gameData.playersShapes[idx].setTranslateY(776);
            gameData.cur1 = 10;
        }
        else if (idx == 1){
            gameData.playersShapes[idx].setTranslateX(212);
            gameData.playersShapes[idx].setTranslateY(816);
            gameData.cur2 = 10;
        }
        if (idx == 2){
            gameData.playersShapes[idx].setTranslateX(250);
            gameData.playersShapes[idx].setTranslateY(769);
            gameData.cur3 = 10;
        }
        if (idx == 3){
            gameData.playersShapes[idx].setTranslateX(250);
            gameData.playersShapes[idx].setTranslateY(806);
            gameData.cur4 = 10;
        }
        Main.doublesCnt = 0;
        gameData.Players[idx].setIsInJail(true);
        Main.throwDice.setDisable(true);
        Main.endTurn.setDisable(false);
    }
}
