package sample;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import Stages.Stages;
import gameData.gameData;
import javafx.scene.chart.StackedAreaChart;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class RailRoad extends Field {
    int[] Rent;
    int price;


    public RailRoad(String[] data) {
        super(data[0], data[9]);
        String[] s = new String[8];
        System.arraycopy(data, 1, s, 0, 8);
        setPostion(s);
        int idx = 10;
        Rent = new int[4];
        for (int i = 0; i < 4; i++) {
            Rent[i] = Integer.parseInt(data[idx++]);
        }
        price = Integer.parseInt(data[idx++]);
    }

    @Override
    public void OnVisiting(int idx, int dice) {
        if (Is_Mortaged) {
            return;
        }
        if (PlayerID == -1) {
            Stages.buyStage(this, price, idx, image);
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
        } else if (idx != PlayerID) {
            Stages.rent(idx, PlayerID, Rent[gameData.Players[PlayerID].PlayerRailRoad.size() - 1]);
        }
    }
}