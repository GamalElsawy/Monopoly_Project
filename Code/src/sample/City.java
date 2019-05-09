package sample;

import Stages.Stages;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

import gameData.gameData;

public class City extends Field {
    String CityColor;
    int Price;

    int HotelCost;
    int MonopolyRent;
    int[] Rent;

    public City(String[] data) {
        super(data[0], data[9]);

        NumberOfHouses = 0;
        String[] s = new String[8];
        System.arraycopy(data, 1, s, 0, 8);
        setPostion(s);
        int idx = 10;


        HouseCost = Integer.parseInt(data[idx++]);
        HotelCost = Integer.parseInt(data[idx++]);
        MonopolyRent = Integer.parseInt(data[idx++]);
        Rent = new int[6];
        for (int i = 0; i < 6; i++) {
            Rent[i] = Integer.parseInt(data[idx++]);
        }
        Mortage = Integer.parseInt(data[idx++]);
        CityColor = data[idx++];
        Price = Integer.parseInt(data[idx++]);


    }
    void PayRent(int idx, int id_city) {
        int paid;
        if (is_Grouped && NumberOfHouses == 0) {
            paid = MonopolyRent;
        }
        else {
            paid = Rent[NumberOfHouses];
        }
        gameData.Players[idx].Payment(paid, id_city);
        gameData.Players[PlayerID].setBalance(gameData.Players[PlayerID].getBalance() + paid);
        Stages.rent(idx, PlayerID, paid);
    }
    public String getCityColor() {
        return CityColor;
    }

    public boolean isIs_Grouped() {
        return is_Grouped;
    }

    public void setIs_Grouped(boolean is_Grouped) {
        this.is_Grouped = is_Grouped;
    }

    @Override
    public void OnVisiting(int idx, int dice) {
        if (Is_Mortaged) {
            return;
        }

        if (PlayerID == -1) {

            Stages.buyStageh(this, Price, idx, image, CityColor);
            if (idx == 0) {
                Icon1 = new Image(gameData.playersIcons[idx], 70, 70, false, false);
                IVIcon = new ImageView(Icon1);
                IVIcon.setTranslateX(smallX);
                IVIcon.setTranslateY(smallY);
                IVIcon.setVisible(true);
                IVIcon.setDisable(false);
                IVIcon.setOnMouseClicked(event1 -> {
                    if (Main.turn == idx) {

                        Stages.choice(idx, getId(), getCityColor());

                    } else {
                        return;
                    }

                });
            }
            if (idx == 1) {
                Icon1 = new Image(gameData.playersIcons[idx], 70, 70, false, false);
                IVIcon = new ImageView(Icon1);
                IVIcon.setTranslateX(smallX);
                IVIcon.setTranslateY(smallY);
                IVIcon.setVisible(true);
                IVIcon.setDisable(false);

                IVIcon.setOnMouseClicked(event1 -> {
                    if (Main.turn == idx) {

                        Stages.choice(idx, getId(), getCityColor());

                    } else {
                        return;
                    }

                });
            }
            if (idx == 2) {
                Icon1 = new Image(gameData.playersIcons[idx], 70, 70, false, false);
                IVIcon = new ImageView(Icon1);
                IVIcon.setTranslateX(smallX);
                IVIcon.setTranslateY(smallY);
                IVIcon.setVisible(true);
                IVIcon.setDisable(false);

                IVIcon.setOnMouseClicked(event1 -> {
                    if (Main.turn == idx) {

                        Stages.choice(idx, getId(), getCityColor());

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

                        Stages.choice(idx, getId(), getCityColor());


                    } else {
                        return;
                    }

                });
            }
        } else if (PlayerID != idx) {
            PayRent(idx, id);
        }

    }
}
