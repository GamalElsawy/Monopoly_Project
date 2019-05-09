package sample;


import Stages.Stages;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import gameData.gameData;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Utility extends Field {
    int Rent, Price;


    public Utility(String[] data) {
        super(data[0], data[9]);
        Mortage=75;
        String[] s = new String[8];
        System.arraycopy(data, 1, s, 0, 8);
        setPostion(s);
        int idx = 10;
        Price = Integer.parseInt(data[idx]);
    }


    @Override
    public void OnVisiting(int idx, int dice) {
        if (Is_Mortaged) {
            return;
        }
        if (PlayerID == -1) {
            Stages.buyStage(this, Price, idx, image);

            if (idx == 0) {
                Icon1 = new javafx.scene.image.Image(gameData.playersIcons[idx], 70, 70, false, false);
                IVIcon = new ImageView(Icon1);
                IVIcon.setTranslateX(smallX);
                IVIcon.setTranslateY(smallY);
                IVIcon.setVisible(true);
                IVIcon.setDisable(false);
                IVIcon.setOnMouseClicked(event1 -> {
                    if (Main.turn == idx) {

                        Stages.Choice2(idx, getId());


                    } else {
                        return;
                    }

                });
            }
            if (idx == 1) {
                Icon1 = new javafx.scene.image.Image(gameData.playersIcons[idx], 70, 70, false, false);
                IVIcon = new ImageView(Icon1);
                IVIcon.setTranslateX(smallX);
                IVIcon.setTranslateY(smallY);
                IVIcon.setVisible(true);
                IVIcon.setDisable(false);

                IVIcon.setOnMouseClicked(event1 -> {
                    if (Main.turn == idx) {

                        Stages.Choice2(idx, getId());


                    } else {
                        return;
                    }

                });
            }
            if (idx == 2) {
                Icon1 = new javafx.scene.image.Image(gameData.playersIcons[idx], 70, 70, false, false);
                IVIcon = new ImageView(Icon1);
                IVIcon.setTranslateX(smallX);
                IVIcon.setTranslateY(smallY);
                IVIcon.setVisible(true);
                IVIcon.setDisable(false);

                IVIcon.setOnMouseClicked(event1 -> {
                    if (Main.turn == idx) {

                        Stages.Choice2(idx, getId());


                    } else {
                        return;
                    }

                });
            }
            if (idx == 3) {
                Icon1 = new Image(gameData.playersIcons[idx], 70, 70, false, false);
                IVIcon = new ImageView(Icon1);
                IVIcon.setTranslateX(smallX);
                IVIcon.setTranslateY(smallY);
                IVIcon.setVisible(true);
                IVIcon.setDisable(false);

                IVIcon.setOnMouseClicked(event1 -> {
                    if (Main.turn == idx) {

                        Stages.Choice2(idx, getId());

                    } else {
                        return;
                    }

                });
            }

        } else if (PlayerID != idx) {
            if (gameData.Players[PlayerID].PlayerUtilities.size() == 2)
                Rent = 10 * dice;
            else
                Rent = 4 * dice;
            Stages.rent(idx, PlayerID, Rent);
        }
    }

}
