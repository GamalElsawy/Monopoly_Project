package Stages;

import gameData.gameData;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import sample.*;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import gameData.gameData;

import java.io.IOException;

import javax.swing.*;

public class Stages {

    public static void buyStage(Field c, int price, int idx, String path) {
        AnchorPane buy = new AnchorPane();
        buy.setStyle("-fx-background-color: #385d70;-fx-border-style: solid;-fx-border-width: 5px;-fx-border-color: white");
        Label playerName = new Label(gameData.Names[idx]);
        playerName.setMaxWidth(Double.MAX_VALUE);
        AnchorPane.setLeftAnchor(playerName, 0.0);
        AnchorPane.setRightAnchor(playerName, 0.0);
        playerName.setAlignment(Pos.TOP_CENTER);
        playerName.setTranslateY(20);
        playerName.setFont(new Font("Serif", 35));
        playerName.setTextFill(Color.web("#b5f2e8"));
        playerName.setStyle("-fx-font-weight: bold");
        Stage st = new Stage();

        Image image = new Image(Stages.class.getResourceAsStream(path));
        Label label1 = new Label();
        ImageView n = new ImageView(image);
        label1.setGraphic(n);

        label1.setTranslateX(100);
        label1.setTranslateY(100);
        Button btn = new Button("Buy: " + price + "M");
        Button auc = new Button("Cancel");

        btn.setMinHeight(30);
        btn.setMinWidth(80);
        btn.setFont(new Font("Tahoma", 20));
        btn.setStyle("-fx-background-color: #44e2c8;-fx-border-style: none;-fx-background-radius: 50px;");
        btn.setTranslateX(100);
        btn.setTranslateY(550);
        auc.setMinHeight(30);
        auc.setMinWidth(80);
        auc.setFont(new Font("Tahoma", 20));
        auc.setStyle("-fx-background-color: #44e2c8;-fx-border-style: none;-fx-background-radius: 50px;");
        auc.setTranslateX(320);
        auc.setTranslateY(550);
        btn.setOnAction(event -> {
            st.close();
            gameData.Players[idx].Payment(price, c.getId());
            c.setPlayerID(idx);
            Main.Labels(gameData.playersNumber);

            Main.group.getChildren().add(c.getIVIcon());
            if (c.getClass() == gameData.cities[0].getClass()) {
                gameData.Players[idx].addCity(c);
            } else if (c.getClass() == gameData.railRoads[0].getClass()) {
                gameData.Players[idx].addRR(c);
            } else
                gameData.Players[idx].addUtil(c);
            Main.group.setDisable(false);
        });
        auc.setOnAction(event -> {
            st.close();
            Main.group.setDisable(false);
        });
        if (gameData.Players[idx].getBalance() < price) {
            btn.setDisable(true);
        }
        Main.group.setDisable(true);

        buy.getChildren().addAll(label1, btn, auc, playerName);
        Scene scene = new Scene(buy, 500, 600);
        st.setScene(scene);
        st.setResizable(false);
        st.initStyle(StageStyle.UNDECORATED);
        st.show();

    }

    public static void buyStageh(City c, int price, int idx, String path, String color) {
        AnchorPane buy = new AnchorPane();
        buy.setStyle("-fx-background-color: #385d70;-fx-border-style: solid;-fx-border-width: 5px;-fx-border-color: white");
        Label playerName = new Label(gameData.Names[idx]);
        playerName.setMaxWidth(Double.MAX_VALUE);
        AnchorPane.setLeftAnchor(playerName, 0.0);
        AnchorPane.setRightAnchor(playerName, 0.0);
        playerName.setAlignment(Pos.TOP_CENTER);
        playerName.setTranslateY(20);
        playerName.setFont(new Font("Serif", 35));
        playerName.setTextFill(Color.web("#b5f2e8"));
        playerName.setStyle("-fx-font-weight: bold");
        Stage st = new Stage();

        Image image = new Image(Stages.class.getResourceAsStream(path));
        Label label1 = new Label();
        label1.setGraphic(new ImageView(image));
        label1.setTranslateX(100);
        label1.setTranslateY(100);
        Button btn = new Button("Buy: " + price + "M");
        Button auc = new Button("Cancel");

        btn.setMinHeight(30);
        btn.setMinWidth(80);
        btn.setFont(new Font("Tahoma", 20));
        btn.setStyle("-fx-background-color: #44e2c8;-fx-border-style: none;-fx-background-radius: 50px;");
        btn.setTranslateX(100);
        btn.setTranslateY(550);
        auc.setMinHeight(30);
        auc.setMinWidth(80);
        auc.setFont(new Font("Tahoma", 20));
        auc.setStyle("-fx-background-color: #44e2c8;-fx-border-style: none;-fx-background-radius: 50px;");
        auc.setTranslateX(320);
        auc.setTranslateY(550);
        btn.setOnAction(event -> {

            st.close();
            gameData.Players[idx].Payment(price, c.getId());
            c.setPlayerID(idx);
            Main.Labels(gameData.playersNumber);
            Main.group.getChildren().add(c.getIVIcon());
            gameData.Players[idx].addCity(c);
            if (gameData.Players[idx].isNewGroup(color) == true) {
                gameData.Players[idx].setHasGroup(true);
            }


            Main.group.setDisable(false);
            Main.grouping();
            gameData.Players[idx].isNewGroup(color);


        });
        auc.setOnAction(event -> {
            st.close();
            Main.group.setDisable(false);
        });
        if (gameData.Players[idx].getBalance() < price) {
            btn.setDisable(true);
        }

        buy.getChildren().addAll(label1, btn, auc, playerName);
        Scene scene = new Scene(buy, 500, 600);
        st.setScene(scene);
        st.setResizable(false);
        st.initStyle(StageStyle.UNDECORATED);
        Main.group.setDisable(true);
        st.show();

    }

    public static void rent(int idx1, int idx2, int rent) {
        String message = gameData.Names[idx1] + "  Paid  "
                + rent + "M to  " + gameData.Names[idx2];
        if ((gameData.Players[idx1].getBalance() - rent) < 0) return;
        AnchorPane payRent = new AnchorPane();
        payRent.setStyle("-fx-background-color: #385d70;-fx-border-style: solid;-fx-border-width: 5px;-fx-border-color: white");
        Label playerName = new Label(message);
        playerName.setMaxWidth(Double.MAX_VALUE);
        AnchorPane.setLeftAnchor(playerName, 0.0);
        AnchorPane.setRightAnchor(playerName, 0.0);
        playerName.setAlignment(Pos.CENTER);
        playerName.setTranslateY(110);
        playerName.setFont(new Font("Serif", 20));
        playerName.setTextFill(Color.web("#b5f2e8"));
        playerName.setStyle("-fx-font-weight: bold");
        Stage st = new Stage();
        Button btn = new Button("OK");
        btn.setTranslateX(210);
        btn.setTranslateY(250);
        btn.setMinHeight(30);
        btn.setMinWidth(80);
        btn.setFont(new Font("Tahoma", 20));
        btn.setStyle("-fx-background-color: #44e2c8;-fx-border-style: none;-fx-background-radius: 50px;");
        btn.setOnAction(event -> {
            st.close();
            Main.Labels(gameData.playersNumber);
            Main.group.setDisable(false);
        });
        Main.group.setDisable(true);
        payRent.getChildren().addAll(playerName, btn);
        Scene scene = new Scene(payRent, 500, 300);
        st.setScene(scene);
        st.setResizable(false);
        st.initStyle(StageStyle.UNDECORATED);
        st.show();
    }

    public static void payTax(Tax t, int idx) {
        String message = gameData.Names[idx] + " Paid " + t.getTaxValue() + "M For " + t.getName();
        AnchorPane payRent = new AnchorPane();
        payRent.setStyle("-fx-background-color: #385d70;-fx-border-style: solid;-fx-border-width: 5px;-fx-border-color: white");
        Label playerName = new Label(message);
        playerName.setMaxWidth(Double.MAX_VALUE);
        AnchorPane.setLeftAnchor(playerName, 0.0);
        AnchorPane.setRightAnchor(playerName, 0.0);
        playerName.setAlignment(Pos.CENTER);
        playerName.setTranslateY(110);
        playerName.setFont(new Font("Serif", 20));
        playerName.setTextFill(Color.web("#b5f2e8"));
        playerName.setStyle("-fx-font-weight: bold");
        Stage st = new Stage();
        Button btn = new Button("OK");
        btn.setTranslateX(210);
        btn.setTranslateY(250);
        btn.setMinHeight(30);
        btn.setMinWidth(80);
        btn.setFont(new Font("Tahoma", 20));
        btn.setStyle("-fx-background-color: #44e2c8;-fx-border-style: none;-fx-background-radius: 50px;");
        btn.setOnAction(event -> {
            st.close();
            Main.Labels(gameData.playersNumber);
            Main.group.setDisable(false);
        });
        Main.group.setDisable(true);
        payRent.getChildren().addAll(playerName, btn);
        Scene scene = new Scene(payRent, 500, 300);
        st.setScene(scene);
        st.setResizable(false);
        st.initStyle(StageStyle.UNDECORATED);
        st.show();
    }

    public static void allownce(int idx) {
        String message = gameData.Names[idx] + " Took 200 For Standing-on/Passing-By Go ";
        AnchorPane payRent = new AnchorPane();
        payRent.setStyle("-fx-background-color: #385d70;-fx-border-style: solid;-fx-border-width: 5px;-fx-border-color: white");
        Label playerName = new Label(message);
        playerName.setMaxWidth(Double.MAX_VALUE);
        AnchorPane.setLeftAnchor(playerName, 0.0);
        AnchorPane.setRightAnchor(playerName, 0.0);
        playerName.setAlignment(Pos.CENTER);
        playerName.setTranslateY(110);
        playerName.setFont(new Font("Serif", 20));
        playerName.setTextFill(Color.web("#b5f2e8"));
        playerName.setStyle("-fx-font-weight: bold");
        Stage st = new Stage();
        Button btn = new Button("OK");
        btn.setTranslateX(210);
        btn.setTranslateY(250);
        btn.setMinHeight(30);
        btn.setMinWidth(80);
        btn.setFont(new Font("Tahoma", 20));
        btn.setStyle("-fx-background-color: #44e2c8;-fx-border-style: none;-fx-background-radius: 50px;");
        btn.setOnAction(event -> {
            st.close();
            Main.Labels(gameData.playersNumber);
            Main.group.setDisable(false);
        });
        Main.group.setDisable(true);
        payRent.getChildren().addAll(playerName, btn);
        Scene scene = new Scene(payRent, 500, 300);
        st.setScene(scene);
        st.setResizable(false);
        st.initStyle(StageStyle.UNDECORATED);
        st.show();
    }

    public static void ChanceAndChest(int idx, String path) {
        AnchorPane buy = new AnchorPane();
        buy.setStyle("-fx-background-color: #385d70;-fx-border-style: solid;-fx-border-width: 5px;-fx-border-color: white");
        Label playerName = new Label(gameData.Names[idx]);
        playerName.setMaxWidth(Double.MAX_VALUE);
        AnchorPane.setLeftAnchor(playerName, 0.0);
        AnchorPane.setRightAnchor(playerName, 0.0);
        playerName.setAlignment(Pos.TOP_CENTER);
        playerName.setTranslateY(20);
        playerName.setFont(new Font("Serif", 35));
        playerName.setTextFill(Color.web("#b5f2e8"));
        playerName.setStyle("-fx-font-weight: bold");
        Stage st = new Stage();
        Image image = new Image(Stages.class.getResourceAsStream(path));
        Label label1 = new Label();
        label1.setGraphic(new ImageView(image));
        label1.setTranslateX(160);
        label1.setTranslateY(100);
        Button btn = new Button("OK");

        btn.setMinHeight(30);
        btn.setMinWidth(80);
        btn.setFont(new Font("Tahoma", 20));
        btn.setStyle("-fx-background-color: #44e2c8;-fx-border-style: none;-fx-background-radius: 50px;");
        btn.setTranslateX(210);
        btn.setTranslateY(250);
        btn.setOnAction(event -> {
            st.close();
            Main.group.setDisable(false);
            Main.Labels(gameData.playersNumber);
        });
        buy.getChildren().addAll(label1, btn, playerName);
        Scene scene = new Scene(buy, 500, 300);
        st.setScene(scene);
        st.setResizable(false);
        st.initStyle(StageStyle.UNDECORATED);
        Main.group.setDisable(true);
        st.show();

    }


    public static void Mortage(int idx, int icity) {
        Field CC = gameData.mp1.get(gameData.Path1.get(icity));

        if (CC.isIs_Mortaged() == true) return;

        AnchorPane Mortage = new AnchorPane();
        Mortage.setStyle("-fx-background-color: #385d70;-fx-border-style: solid;-fx-border-width: 5px;-fx-border-color: white");
        String message = gameData.Names[idx] + " " + "Has Mortage City" + CC.getName();
        Label playerName = new Label(message);
        playerName.setMaxWidth(Double.MAX_VALUE);
        AnchorPane.setLeftAnchor(playerName, 0.0);
        AnchorPane.setRightAnchor(playerName, 0.0);
        playerName.setAlignment(Pos.CENTER);
        playerName.setTranslateY(110);
        playerName.setFont(new Font("Serif", 20));
        playerName.setTextFill(Color.web("#b5f2e8"));
        playerName.setStyle("-fx-font-weight: bold");

        Stage st = new Stage();
        Button btn = new Button("OK");
        btn.setTranslateX(350);
        btn.setTranslateY(250);
        btn.setMinHeight(30);
        btn.setMinWidth(80);
        btn.setFont(new Font("Tahoma", 20));
        btn.setStyle("-fx-background-color: #44e2c8;-fx-border-style: none;-fx-background-radius: 50px;");
        btn.setOnAction(event -> {

            st.close();
            Main.Labels(gameData.playersNumber);
            CC.setIs_Mortaged(true);
            gameData.Players[idx].setBalance(gameData.Players[idx].getBalance() + CC.getMortage());
            Main.Labels(gameData.playersNumber);
            Main.group.setDisable(false);
        });

        Mortage.getChildren().addAll(playerName, btn);
        Scene scene = new Scene(Mortage, 800, 300);
        st.setScene(scene);
        st.setResizable(false);
        st.initStyle(StageStyle.UNDECORATED);
        st.show();

    }

    public static void Dice(int D1, int D2) {
        Image ii = new Image("sample/dice" + D1 + ".png");
        ImageView iv = new ImageView(ii);
        Label lb = new Label();
        lb.setGraphic(iv);
        lb.setTranslateX(100);
        lb.setTranslateY(100);
        Image jj = new Image("sample/dice" + D2 + ".png");
        ImageView vi = new ImageView(jj);
        Label bl = new Label();
        bl.setGraphic(vi);
        bl.setTranslateX(300);
        bl.setTranslateY(100);

        AnchorPane payRent = new AnchorPane();
        payRent.setStyle("-fx-background-color: #385d70;-fx-border-style: solid;-fx-border-width: 5px;-fx-border-color: white");

        AnchorPane.setLeftAnchor(lb, 0.0);
        AnchorPane.setRightAnchor(lb, 0.0);
        Stage st = new Stage();
        Button btn = new Button("OK");
        btn.setTranslateX(210);
        btn.setTranslateY(550);
        btn.setMinHeight(30);
        btn.setMinWidth(80);
        btn.setFont(new Font("Tahoma", 20));
        btn.setStyle("-fx-background-color: #44e2c8;-fx-border-style: none;-fx-background-radius: 50px;");
        btn.setOnAction(event -> {

            st.close();
            Main.Labels(gameData.playersNumber);

        });

        payRent.getChildren().addAll(lb, btn, bl);
        Scene scene = new Scene(payRent, 500, 600);
        st.setScene(scene);
        st.setResizable(false);
        st.initStyle(StageStyle.UNDECORATED);
        //Main.Labels(gameData.playersNumber);
        st.show();
    }

    public static void Choice2(int idx, int icity) {
        Field CC = gameData.mp1.get(gameData.Path1.get(icity));
        AnchorPane payRent = new AnchorPane();
        payRent.setStyle("-fx-background-color: #385d70;-fx-border-style: solid;-fx-border-width: 5px;-fx-border-color: white");
        String message = "Choose an action.";
        Label playerName = new Label(message);
        playerName.setMaxWidth(Double.MAX_VALUE);
        AnchorPane.setLeftAnchor(playerName, 0.0);
        AnchorPane.setRightAnchor(playerName, 0.0);
        playerName.setAlignment(Pos.CENTER);
        playerName.setTranslateY(110);
        playerName.setFont(new Font("Serif", 20));
        playerName.setTextFill(Color.web("#b5f2e8"));
        playerName.setStyle("-fx-font-weight: bold");
        Stage st = new Stage();
        Button btn = new Button("Mortage");
        btn.setTranslateX(5);
        btn.setTranslateY(250);
        btn.setMinHeight(30);
        btn.setMinWidth(80);
        btn.setFont(new Font("Tahoma", 20));
        btn.setStyle("-fx-background-color: #44e2c8;-fx-border-style: none;-fx-background-radius: 50px;");
        btn.setOnAction(event -> {
            st.close();
            Stages.Mortage(idx, icity);
            Main.group.setDisable(false);
        });
        Button btnx = new Button("UnMortage");
        btnx.setTranslateX(200);
        btnx.setTranslateY(250);
        btnx.setMinHeight(30);
        btnx.setMinWidth(80);
        btnx.setDisable(true);
        if (CC.isIs_Mortaged() == true) {
            btnx.setDisable(false);
            btn.setDisable(true);
        }
        btnx.setFont(new Font("Tahoma", 20));
        btnx.setStyle("-fx-background-color: #44e2c8;-fx-border-style: none;-fx-background-radius: 50px;");
        btnx.setOnAction(event -> {
            st.close();
            if (CC.isIs_Mortaged() != false) {
                gameData.Players[idx].Payment(CC.getMortage() + CC.getMortage() / 10, CC.getId());
                Main.Labels(gameData.playersNumber);
                CC.setIs_Mortaged(false);
            }
            Main.group.setDisable(false);
        });
        Button btn3 = new Button("Cancel");
        btn3.setTranslateX(405);
        btn3.setTranslateY(250);
        btn3.setMinHeight(30);
        btn3.setMinWidth(80);
        btn3.setFont(new Font("Tahoma", 20));
        btn3.setStyle("-fx-background-color: #44e2c8;-fx-border-style: none;-fx-background-radius: 50px;");

        btn3.setOnAction(event -> {

            st.close();
            Main.group.setDisable(false);
        });
        Main.group.setDisable(true);
        payRent.getChildren().addAll(playerName, btn, btn3, btnx);

        Scene scene = new Scene(payRent, 500, 300);
        st.setScene(scene);
        st.setResizable(false);
        st.initStyle(StageStyle.UNDECORATED);
        st.show();
    }


    public static void choice(int idx, int icity, String color) {
        Field CC = gameData.mp1.get(gameData.Path1.get(icity));
        AnchorPane payRent = new AnchorPane();
        payRent.setStyle("-fx-background-color: #385d70;-fx-border-style: solid;-fx-border-width: 5px;-fx-border-color: white");
        String message = "Choose an action.";
        Label playerName = new Label(message);
        playerName.setMaxWidth(Double.MAX_VALUE);
        AnchorPane.setLeftAnchor(playerName, 0.0);
        AnchorPane.setRightAnchor(playerName, 0.0);
        playerName.setAlignment(Pos.CENTER);
        playerName.setTranslateY(110);
        playerName.setFont(new Font("Serif", 20));
        playerName.setTextFill(Color.web("#b5f2e8"));
        playerName.setStyle("-fx-font-weight: bold");
        Stage st = new Stage();
        Button btn = new Button("Mortage");
        btn.setTranslateX(5);
        btn.setTranslateY(250);
        btn.setMinHeight(30);
        btn.setMinWidth(80);
        btn.setFont(new Font("Tahoma", 20));
        btn.setStyle("-fx-background-color: #44e2c8;-fx-border-style: none;-fx-background-radius: 50px;");
        if (CC.isIs_Mortaged() == true) {
            btn.setDisable(true);
        }
        btn.setOnAction(event -> {
            st.close();
            Stages.Mortage(idx, icity);
            Main.group.setDisable(false);
        });
        Button btnx = new Button("UnMortage");
        btnx.setTranslateX(108);
        btnx.setTranslateY(250);
        btnx.setMinHeight(30);
        btnx.setMinWidth(80);
        btnx.setDisable(true);
        if (CC.isIs_Mortaged() == true) btnx.setDisable(false);
        btnx.setFont(new Font("Tahoma", 20));
        btnx.setStyle("-fx-background-color: #44e2c8;-fx-border-style: none;-fx-background-radius: 50px;");
        btnx.setOnAction(event -> {
            st.close();
            if (CC.isIs_Mortaged() != false) {
                gameData.Players[idx].Payment(CC.getMortage() + CC.getMortage() / 10, CC.getId());
                Main.Labels(gameData.playersNumber);
                CC.setIs_Mortaged(false);
            }
            Main.group.setDisable(false);
        });
        Button btn1 = new Button("Build");
        btn1.setTranslateX(235);
        btn1.setTranslateY(250);
        btn1.setMinHeight(30);
        btn1.setMinWidth(80);
        btn1.setFont(new Font("Tahoma", 20));
        btn1.setStyle("-fx-background-color: #44e2c8;-fx-border-style: none;-fx-background-radius: 50px;");
        if (CC.getNumberOfHotel() == 1 || CC.isIs_Mortaged() == true) {
            btn1.setDisable(true);
        }
        btn1.setOnAction(event -> {
            st.close();
            Main.Labels(gameData.playersNumber);
            Main.group.setDisable(false);
            if (gameData.Players[idx].getBalance() >= CC.getHouseCost()) {
                gameData.Players[idx].Payment(CC.getHouseCost(), CC.getId());
                if (CC.getNumberOfHouses() == 4) {
                    Property.setAvailableHouse(Property.getAvailableHouse() + 4);
                    Property.setAvailableHotel(Property.getAvailableHouse() - 1);
                    gameData.Players[idx].setNOfHouses(0);
                    CC.setNumberOfHouses(0);
                    CC.setNumberOfHotel(1);
                    gameData.Players[idx].setNOfHotels(1);
                    gameData.Players[idx].setValueOfAssets(gameData.Players[idx].getValueOfAssets() +
                            CC.getHouseCost());
                    CC.SetBuildImage(5);
                } else {
                    Property.setAvailableHouse(Property.getAvailableHouse() - 1);
                    gameData.Players[idx].setNOfHouses(gameData.Players[idx].getNOfHouses() + 1);
                    CC.setNumberOfHouses(CC.getNumberOfHouses() + 1);
                    gameData.Players[idx].setValueOfAssets(gameData.Players[idx].getValueOfAssets() +
                            CC.getHouseCost());
                    CC.SetBuildImage(CC.getNumberOfHouses());

                }
            }
        });
        Button btn2 = new Button("Sell");
        btn2.setTranslateX(320);
        btn2.setTranslateY(250);
        btn2.setMinHeight(30);
        btn2.setMinWidth(80);
        btn2.setFont(new Font("Tahoma", 20));
        btn2.setStyle("-fx-background-color: #44e2c8;-fx-border-style: none;-fx-background-radius: 50px;");

        btn2.setOnAction(event -> {
            st.close();
            Main.Labels(gameData.playersNumber);
            Main.group.setDisable(false);
            if (gameData.Players[idx].getNOfHotels() == 1) {
                CC.DELETE();
                Property.setAvailableHotel(Property.getAvailableHotel() + 1);
                Property.setAvailableHouse(Property.getAvailableHouse() - 4);
                gameData.Players[idx].setNOfHotels(0);
                gameData.Players[idx].setNOfHouses(4);
                CC.setNumberOfHouses(4);
                CC.setNumberOfHotel(0);
                CC.SetBuildImage(4);
                gameData.Players[idx].setBalance(gameData.Players[idx].getBalance() +
                        (CC.getHouseCost() - (CC.getHouseCost()) / 10));
            } else {
                CC.DELETE();
                Property.setAvailableHouse(Property.getAvailableHouse() + 1);
                gameData.Players[idx].setNOfHouses(gameData.Players[idx].getNOfHouses() - 1);
                gameData.Players[idx].setBalance(gameData.Players[idx].getBalance() +
                        (CC.getHouseCost() - (CC.getHouseCost()) / 10));
                CC.setNumberOfHouses(CC.getNumberOfHouses() - 1);
                CC.SetBuildImage(CC.getNumberOfHouses());
            }
        });
        Button btn3 = new Button("Cancel");
        btn3.setTranslateX(405);
        btn3.setTranslateY(250);
        btn3.setMinHeight(30);
        btn3.setMinWidth(80);
        btn3.setFont(new Font("Tahoma", 20));
        btn3.setStyle("-fx-background-color: #44e2c8;-fx-border-style: none;-fx-background-radius: 50px;");

        btn3.setOnAction(event -> {

            st.close();
            Main.group.setDisable(false);
        });
        Main.group.setDisable(true);
        payRent.getChildren().addAll(playerName, btn, btn1, btn2, btn3, btnx);
        if (!gameData.groupMP.get(color).isGrouped()) {
            btn1.setDisable(true);
        }
        if (gameData.Players[idx].getNOfHouses() == 0 && gameData.Players[idx].getNOfHotels() == 0) {
            btn2.setDisable(true);
        }
        Scene scene = new Scene(payRent, 500, 300);
        st.setScene(scene);
        st.setResizable(false);
        st.initStyle(StageStyle.UNDECORATED);
        st.show();
    }

    public static void losing(int idx) {
        String message = "You don't have enough money to make that payment. Sell some houses or hotels (if you have any) or mortgage some of your properties.";
        AnchorPane payRent = new AnchorPane();
        payRent.setStyle("-fx-background-color: #385d70;-fx-border-style: solid;-fx-border-width: 5px;-fx-border-color: white");
        Label playerName = new Label(message);
        playerName.setMaxWidth(Double.MAX_VALUE);
        AnchorPane.setLeftAnchor(playerName, 0.0);
        AnchorPane.setRightAnchor(playerName, 0.0);
        playerName.setAlignment(Pos.CENTER);
        playerName.setTranslateY(110);
        playerName.setFont(new Font("Serif", 20));
        playerName.setTextFill(Color.web("#b5f2e8"));
        playerName.setStyle("-fx-font-weight: bold");
        Stage st = new Stage();
        Button btn = new Button("OK");
        btn.setTranslateX(210);
        btn.setTranslateY(250);
        btn.setMinHeight(30);
        btn.setMinWidth(80);
        btn.setFont(new Font("Tahoma", 20));
        btn.setStyle("-fx-background-color: #44e2c8;-fx-border-style: none;-fx-background-radius: 50px;");
        btn.setOnAction(event -> {
            st.close();
            Main.Labels(gameData.playersNumber);
            Main.group.setDisable(false);
        });
        Main.group.setDisable(true);
        payRent.getChildren().addAll(playerName, btn);
        Scene scene = new Scene(payRent, 500, 300);
        st.setScene(scene);
        st.setResizable(false);
        st.initStyle(StageStyle.UNDECORATED);
        st.show();
    }

    public static void punishment(int idx) {
        String message = "YOU'RE IN JAIL!";
        AnchorPane payRent = new AnchorPane();
        payRent.setStyle("-fx-background-color: #385d70;-fx-border-style: solid;-fx-border-width: 5px;-fx-border-color: white");
        Label playerName = new Label(message);
        playerName.setMaxWidth(Double.MAX_VALUE);
        AnchorPane.setLeftAnchor(playerName, 0.0);
        AnchorPane.setRightAnchor(playerName, 0.0);
        playerName.setAlignment(Pos.CENTER);
        playerName.setTranslateY(110);
        playerName.setFont(new Font("Serif", 20));
        playerName.setTextFill(Color.web("#b5f2e8"));
        playerName.setStyle("-fx-font-weight: bold");
        Stage st = new Stage();
        Button btn = new Button("Roll for doubles");
        btn.setTranslateX(10);
        btn.setTranslateY(250);
        btn.setMinHeight(30);
        btn.setMinWidth(80);
        btn.setFont(new Font("Tahoma", 20));
        btn.setStyle("-fx-background-color: #44e2c8;-fx-border-style: none;-fx-background-radius: 50px;");
        btn.setOnAction(event -> {
            int roll1 = Main.roll();
            int roll2 = Main.roll();
            Stages.Dice(roll1, roll2);
            if (roll1 == roll2) {
                gameData.Players[idx].setIsInJail(false);
                Main.moveFirst(roll1 + roll2, idx, roll1, roll2);
            } else if (gameData.Players[idx].getJailtime() + 1 == 3) {
                gameData.Players[idx].setJailtime(0);
                timeUp();
                Main.Labels(gameData.playersNumber);
                gameData.Players[idx].Payment(50, 10);
            } else {
                gameData.Players[idx].setJailtime(gameData.Players[idx].getJailtime() + 1);
            }
            st.close();

            Main.Labels(gameData.playersNumber);
            Main.group.setDisable(false);

        });
        Button btn1 = new Button("Use free from jail card");
        btn1.setTranslateX(175);
        btn1.setTranslateY(200);
        btn1.setMinHeight(30);
        btn1.setMinWidth(80);
        btn1.setFont(new Font("Tahoma", 20));
        btn1.setStyle("-fx-background-color: #44e2c8;-fx-border-style: none;-fx-background-radius: 50px;");
        btn1.setOnAction(event -> {
            st.close();
            if (gameData.Players[idx].isHaveJailCardChance())
                gameData.Players[idx].setHaveJailCardChance(false);
            else
                gameData.Players[idx].setHaveJailCardChest(false);
            gameData.Players[idx].setIsInJail(false);
            Main.Labels(gameData.playersNumber);
            Main.throwDice.setDisable(false);
            Main.endTurn.setDisable(true);
            Main.group.setDisable(false);
        });
        Button btn2 = new Button("Pay 50M");
        btn2.setTranslateX(390);
        btn2.setTranslateY(250);
        btn2.setMinHeight(30);
        btn2.setMinWidth(80);
        btn2.setFont(new Font("Tahoma", 20));
        btn2.setStyle("-fx-background-color: #44e2c8;-fx-border-style: none;-fx-background-radius: 50px;");
        btn2.setOnAction(event -> {
            st.close();
            gameData.Players[idx].Payment(50, 10);
            gameData.Players[idx].setIsInJail(false);
            Main.Labels(gameData.playersNumber);
            Main.throwDice.setDisable(false);
            Main.endTurn.setDisable(true);
            Main.group.setDisable(false);
        });
        if (gameData.Players[idx].getBalance() < 50)
            btn2.setDisable(true);
        if (!gameData.Players[idx].isHaveJailCardChance() && !gameData.Players[idx].isHaveJailCardChest())
            btn1.setDisable(true);
        Main.group.setDisable(true);
        payRent.getChildren().addAll(playerName, btn, btn1, btn2);
        Scene scene = new Scene(payRent, 500, 300);
        st.setScene(scene);
        st.setResizable(false);
        st.initStyle(StageStyle.UNDECORATED);
        st.show();
    }

    public static void timeUp() {
        String message = "You rolled for doubles unseccessfully for 3 times and you have to pay 50M";
        AnchorPane payRent = new AnchorPane();
        payRent.setStyle("-fx-background-color: #385d70;-fx-border-style: solid;-fx-border-width: 5px;-fx-border-color: white");
        Label playerName = new Label(message);
        playerName.setMaxWidth(Double.MAX_VALUE);
        AnchorPane.setLeftAnchor(playerName, 0.0);
        AnchorPane.setRightAnchor(playerName, 0.0);
        playerName.setAlignment(Pos.CENTER);
        playerName.setTranslateY(110);
        playerName.setFont(new Font("Serif", 20));
        playerName.setTextFill(Color.web("#b5f2e8"));
        playerName.setStyle("-fx-font-weight: bold");
        Stage st = new Stage();
        Button btn = new Button("OK");
        btn.setTranslateX(210);
        btn.setTranslateY(250);
        btn.setMinHeight(30);
        btn.setMinWidth(80);
        btn.setFont(new Font("Tahoma", 20));
        btn.setStyle("-fx-background-color: #44e2c8;-fx-border-style: none;-fx-background-radius: 50px;");
        btn.setOnAction(event -> {
            st.close();
            Main.Labels(gameData.playersNumber);
            Main.group.setDisable(false);
        });
        Main.group.setDisable(true);
        payRent.getChildren().addAll(playerName, btn);
        Scene scene = new Scene(payRent, 500, 300);
        st.setScene(scene);
        st.setResizable(false);
        st.initStyle(StageStyle.UNDECORATED);
        st.show();
    }

    public static void Winner(String name) {
        String message = name + " " + " is The Winner ";
        AnchorPane payRent = new AnchorPane();
        payRent.setStyle("-fx-background-color: #385d70;-fx-border-style: solid;-fx-border-width: 5px;-fx-border-color: white");
        Label playerName = new Label(message);
        playerName.setMaxWidth(Double.MAX_VALUE);
        AnchorPane.setLeftAnchor(playerName, 0.0);
        AnchorPane.setRightAnchor(playerName, 0.0);
        playerName.setAlignment(Pos.CENTER);
        playerName.setTranslateY(110);
        playerName.setFont(new Font("Serif", 20));
        playerName.setTextFill(Color.web("#b5f2e8"));
        playerName.setStyle("-fx-font-weight: bold");
        Stage st = new Stage();
        Button btn = new Button("OK");
        btn.setTranslateX(210);
        btn.setTranslateY(250);
        btn.setMinHeight(30);
        btn.setMinWidth(80);
        btn.setFont(new Font("Tahoma", 20));
        btn.setStyle("-fx-background-color: #44e2c8;-fx-border-style: none;-fx-background-radius: 50px;");
        btn.setOnAction(event -> {
            st.close();
            Main.Labels(gameData.playersNumber);
            Main.group.setDisable(false);
            Main.primaryStage.close();
        });
        Main.group.setDisable(true);
        payRent.getChildren().addAll(playerName, btn);
        Scene scene = new Scene(payRent, 500, 300);
        st.setScene(scene);
        st.setResizable(false);
        st.initStyle(StageStyle.UNDECORATED);
        st.show();
    }

}

