package sample;

import Stages.Stages;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.*;
import javafx.geometry.Insets;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.scene.control.*;
import javafx.scene.shape.Box;
import javafx.scene.shape.Shape;
import javafx.scene.text.Font;
import javafx.scene.transform.*;
import javafx.stage.*;
import gameData.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javax.swing.*;
import java.awt.*;
import java.lang.invoke.MethodHandles;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Main extends Application {

    public static Stage primaryStage;
    public static Scene sss;


    protected static Box Player = new Box(30, 30, 30);
    protected static Sphere Player2 = new Sphere(20);
    protected static Cylinder Player3 = new Cylinder(15, 30);
    protected static Box Player4 = new Box(25, 40, 40);
    public static Scene scene;
    public static int turn = 0;
    Player[] Players = new Player[4];
    public static Group group = new Group();
    public static Transform Playertransform = new Rotate(45, new Point3D(1, 0, 0));
    public static Button throwDice = new Button("Throw Dice");
    public static Button endTurn = new Button("End Turn");
    public static Button dec = new Button("Declare Bankruptcy");
    public static Shape3D[] box = {Player, Player2, Player3, Player4};
    public static int doublesCnt = 0;

    @Override
    public void start(Stage PrimaryStage) throws Exception {


        gameData.fillData();
        gameData.fillMap();

        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage = PrimaryStage;

        primaryStage.setTitle("Let's Play Monopoly!");
        sss = new Scene(root, 300, 275);
        primaryStage.setScene(sss);
        primaryStage.setMaximized(true);
        primaryStage.show();

        PhongMaterial Playermaterial = new PhongMaterial(Color.YELLOW);
        PhongMaterial Playermaterial2 = new PhongMaterial(Color.RED);
        PhongMaterial Playermaterial3 = new PhongMaterial(Color.GREEN);
        PhongMaterial Playermaterial4 = new PhongMaterial(Color.BLUE);


        Player.setMaterial(Playermaterial);
        Player.translateXProperty().set(914);
        Player.translateYProperty().set(783);

        Player2.setMaterial(Playermaterial2);
        Player2.translateXProperty().set(914);
        Player2.translateYProperty().set(846);

        Player3.setMaterial(Playermaterial3);
        Player3.translateXProperty().set(944);
        Player3.translateYProperty().set(829);

        Player4.setMaterial(Playermaterial4);
        Player4.translateXProperty().set(944);
        Player4.translateYProperty().set(765);
        Image img = new Image("sample/2red.png", 70, 70, false, false);
        ImageView iv = new ImageView(img);
        iv.setTranslateX(900);
        iv.setTranslateY(780);
        group.getChildren().add(iv);


        group.getChildren().add(new ImageView(new Image(getClass().getResourceAsStream("/sample/xyz.png"))));

        Image image = new Image("sample/title1.jpeg");
        scene = new Scene(group, 1400, 980);


        group.getChildren().add(throwDice);
        throwDice.translateXProperty().set(300);
        throwDice.translateYProperty().set(900);
        throwDice.setStyle("-fx-background-color: #1b133a;-fx-border-style: none;-fx-background-radius: 15px");
        throwDice.setTextFill(Color.web("#fff"));
        throwDice.setFont(new Font("Impact", 20));
        throwDice.setMinWidth(30);

        endTurn.setTranslateX(700);
        endTurn.setTranslateY(900);
        endTurn.setDisable(true);
        endTurn.setStyle("-fx-background-color: #1b133a;-fx-border-style: none;-fx-background-radius: 15px");
        endTurn.setTextFill(Color.web("#fff"));
        endTurn.setFont(new Font("Impact", 20));
        endTurn.setMinWidth(30);
        group.getChildren().add(endTurn);

        dec.setTranslateX(475);
        dec.setTranslateY(920);
        dec.setVisible(false);
        dec.setDisable(true);
        dec.setStyle("-fx-background-color: #1b133a;-fx-border-style: none;-fx-background-radius: 15px");
        dec.setTextFill(Color.web("#fff"));
        dec.setFont(new Font("Impact", 20));
        dec.setMinWidth(30);
        dec.setOnAction(event -> {
            int ID_city;
            if (turn == 0) ID_city = gameData.mp1.get(gameData.Path1.get(gameData.cur1)).getId();
            else if (turn == 1) ID_city = gameData.mp2.get(gameData.Path2.get(gameData.cur2)).getId();
            else if (turn == 2) ID_city = gameData.mp3.get(gameData.Path3.get(gameData.cur3)).getId();
            else ID_city = gameData.mp4.get(gameData.Path4.get(gameData.cur4)).getId();

            if (ID_city == 4 || ID_city == 38 || ID_city == 2 || ID_city == 17 || ID_city == 33 || ID_city == 7 || ID_city == 22 || ID_city == 36 || ID_city == 10) {
                Property.setAvailableHouse(Property.getAvailableHouse() + gameData.Players[turn].getNOfHouses());
                Property.setAvailableHotel(Property.getAvailableHotel() + gameData.Players[turn].getNOfHotels());
                for (int i = 0; i < gameData.Players[turn].PlayerCities.size(); ++i) {

                    gameData.Players[turn].PlayerCities.get(i).Is_Mortaged = false;
                    gameData.Players[turn].PlayerCities.get(i).setNumberOfHouses(0);
                    gameData.Players[turn].PlayerCities.get(i).setNumberOfHotel(0);
                    gameData.Players[turn].PlayerCities.get(i).setIs_Grouped(false);


                    Main.group.getChildren().remove(gameData.Players[turn].PlayerCities.get(i).getIVIcon());
                    Main.group.getChildren().remove(gameData.Players[turn].PlayerCities.get(i).getIv());
                    Main.group.getChildren().remove(gameData.Players[turn].PlayerCities.get(i).getIvBuy());
                    gameData.Players[turn].PlayerCities.get(i).Clear();
                }
                for (int i = 0; i < gameData.Players[turn].PlayerRailRoad.size(); ++i) {
                    gameData.Players[turn].PlayerRailRoad.get(i).Is_Mortaged = false;
                    gameData.Players[turn].PlayerRailRoad.get(i).setIs_Grouped(false);


                    Main.group.getChildren().remove(gameData.Players[turn].PlayerRailRoad.get(i).getIVIcon());
                    Main.group.getChildren().remove(gameData.Players[turn].PlayerRailRoad.get(i).getIv());

                    gameData.Players[turn].PlayerRailRoad.get(i).Clear();
                }
                for (int i = 0; i < gameData.Players[turn].PlayerUtilities.size(); ++i) {
                    Players[turn].PlayerUtilities.get(i).Is_Mortaged = false;

                    Players[turn].PlayerUtilities.get(i).setIs_Grouped(false);


                    Main.group.getChildren().remove(Players[turn].PlayerUtilities.get(i).getIVIcon());
                    Main.group.getChildren().remove(Players[turn].PlayerUtilities.get(i).getIv());
                    Players[turn].PlayerUtilities.get(i).Clear();
                }
            } else {
                Field cc = gameData.mp1.get(gameData.Path1.get(ID_city));
                Property.setAvailableHouse(Property.getAvailableHouse() + gameData.Players[turn].NOfHouses);
                Property.setAvailableHotel(Property.getAvailableHotel() + gameData.Players[turn].NOfHotels);
                for (int i = 0; i < gameData.Players[turn].PlayerCities.size(); ++i) {

                    int hh = cc.getPlayerID();
                    Image Ic = new Image(gameData.playersIcons[hh], 70, 70, false, false);
                    gameData.Players[turn].PlayerCities.get(i).setIVIcon(Ic);

                }

                for (int i = 0; i < gameData.Players[turn].PlayerRailRoad.size(); ++i) {

                    int hh = cc.getPlayerID();
                    Image Ic = new Image(gameData.playersIcons[hh], 70, 70, false, false);
                    gameData.Players[turn].PlayerRailRoad.get(i).setIVIcon(Ic);

                }

                for (int i = 0; i < gameData.Players[turn].PlayerUtilities.size(); ++i) {

                    int hh = cc.getPlayerID();
                    Image Ic = new Image(gameData.playersIcons[hh], 70, 70, false, false);
                    gameData.Players[turn].PlayerUtilities.get(i).setIVIcon(Ic);

                }
            }
            gameData.Players[turn].setLoser(true);
            gameData.Losers++;
            gameData.playersShapes[turn].setVisible(false);
            gameData.playersShapes[turn].setDisable(true);
            end();


        });
        group.getChildren().add(dec);

        gameData.playersShapes[0] = Player;
        gameData.playersShapes[1] = Player2;
        gameData.playersShapes[2] = Player3;
        gameData.playersShapes[3] = Player4;


        throwDice.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
            if (!gameData.Players[turn].isLoser() && gameData.Players[turn].getBalance() < 0) {
                Stages.losing(turn);
                return;
            }
            int Dice1 = roll();
            int Dice2 = roll();
            int d = Dice1 + Dice2;
            if (Dice1 != Dice2) {
                throwDice.setDisable(true);
                endTurn.setDisable(false);
            } else {
                doublesCnt++;

            }
            moveFirst(d, turn, Dice1, Dice2);


        });
        endTurn.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
            end();
        });

        primaryStage.getIcons().add(image);

    }


    public static int roll() {
        ArrayList<Integer> b = new ArrayList<Integer>();
        for (int i = 1; i <= 6; i++)
            b.add(i);
        Collections.shuffle(b);
        Random r = new Random();
        int idx = r.nextInt(6);

        return (b.get(idx));
    }


    public static void moveFirst(int DiceRoll, int turn, int d1, int d2) {

        if (doublesCnt == 3) {
            gameData.gotojail.OnVisiting(turn, DiceRoll);
            Stages.Dice(d1, d2);
            return;
        }
        if (turn == 0) {
            int pass = gameData.cur1 + DiceRoll;
            gameData.cur1 = (gameData.cur1 + DiceRoll) % 40;
            box[turn].translateXProperty().set(gameData.Path1.get(gameData.cur1).x);
            box[turn].translateYProperty().set(gameData.Path1.get(gameData.cur1).y);
            gameData.mp1.get(gameData.Path1.get(gameData.cur1)).OnVisiting(turn, DiceRoll);
            if (pass > 40)
                gameData.go.OnVisiting(turn, DiceRoll);
        }
        if (turn == 1) {
            int pass = gameData.cur2 + DiceRoll;
            gameData.cur2 = (gameData.cur2 + DiceRoll) % 40;
            box[turn].translateXProperty().set(gameData.Path2.get(gameData.cur2).x);
            box[turn].translateYProperty().set(gameData.Path2.get(gameData.cur2).y);
            gameData.mp2.get(gameData.Path2.get(gameData.cur2)).OnVisiting(turn, DiceRoll);
            if (pass > 40)
                gameData.go.OnVisiting(turn, DiceRoll);
        }
        if (turn == 2) {
            int pass = gameData.cur3 + DiceRoll;
            gameData.cur3 = (gameData.cur3 + DiceRoll) % 40;
            box[turn].translateXProperty().set(gameData.Path3.get(gameData.cur3).x);
            box[turn].translateYProperty().set(gameData.Path3.get(gameData.cur3).y);
            gameData.mp3.get(gameData.Path3.get(gameData.cur3)).OnVisiting(turn, DiceRoll);
            if (pass > 40)
                gameData.go.OnVisiting(turn, DiceRoll);
        }
        if (turn == 3) {
            int pass = gameData.cur4 + DiceRoll;
            gameData.cur4 = (gameData.cur4 + DiceRoll) % 40;
            box[turn].translateXProperty().set(gameData.Path4.get(gameData.cur4).x);
            box[turn].translateYProperty().set(gameData.Path4.get(gameData.cur4).y);
            gameData.mp4.get(gameData.Path4.get(gameData.cur4)).OnVisiting(turn, DiceRoll);
            if (pass > 40) {
                gameData.go.OnVisiting(turn, DiceRoll);

            }
        }

        Stages.Dice(d1, d2);

    }


    public static void Labels(int playernum) {
        HBox[] panel;
        panel = new HBox[playernum];
        Label playername;
        int h = 20;
        for (int i = 0; i < playernum; i++) {
            playername = new Label("\t" + gameData.Players[i].Name + " : " + "\n" + "\t\t" + gameData.Players[i].getBalance() + "M");
            playername.setTextFill(Color.web("#DDD"));
            playername.setFont(new Font("broadway", 30));
            playername.setStyle("-fx-color:White;");
            panel[i] = new HBox();
            panel[i].getChildren().add(playername);
            panel[i].setBackground(new Background(new BackgroundFill(Color.web("#1b133a"), CornerRadii.EMPTY, Insets.EMPTY)));
            panel[i].translateXProperty().set(1020);
            panel[i].setStyle("-fx-background-color: #1b133a;-fx-border-style: none;-fx-background-radius: 15px");
            h += 150;
            panel[i].translateYProperty().set(h);
            panel[i].setPrefSize(500, 80);
            group.getChildren().add(panel[i]);
        }
    }

    public static void grouping() {
        boolean valid = true;
        for (int i = 0; i < 8; i++) {
            int id = gameData.cities[gameData.groups[i].GroupedCity[0]].getPlayerID();
            for (int j = 0; j < gameData.groups[i].NumberOfCities; j++) {
                if (gameData.cities[gameData.groups[i].GroupedCity[j]].getPlayerID() == -1 || gameData.cities[gameData.groups[i].GroupedCity[j]].getPlayerID() != id) {
                    valid = false;
                    break;
                }
            }
        }
    }


    public void end() {
        if (!gameData.Players[turn].isLoser() && gameData.Players[turn].getBalance() < 0) {
            Stages.losing(turn);
            return;
        }
        if (gameData.Losers == gameData.playersNumber - 1) {
            for (int i = 0; i < gameData.playersNumber; ++i) {
                if (gameData.Players[i].isLoser == false) {
                    Stages.Winner(gameData.Players[i].getName());
                    return;
                }
            }
        }
        dec.setVisible(false);
        dec.setDisable(true);
        turn = (turn + 1) % gameData.playersNumber;
        while (gameData.Players[turn].isLoser()) {
            turn = (turn + 1) % gameData.playersNumber;
        }
        if (gameData.Players[turn].isInJail) {
            Stages.punishment(turn);
        } else {
            throwDice.setDisable(false);
            endTurn.setDisable(true);
        }

    }

    public static void main(String[] args) {

        launch(args);

    }
}
