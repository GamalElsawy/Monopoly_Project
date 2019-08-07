package sample;

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

public class Controller {
    public Label closeButton;
    public Label backButton;
    public Label two;
    public Label three;
    public Label four;
    public Label backToNumbers;
    public TextField oneName;
    public TextField twoName;
    public TextField threeName;
    public TextField fourName;
    public Label Start;

    public void handleCloseButtonAction() {
        Main.primaryStage.close();
    }

    public void twoPlayers(){

        try {
            Parent root = FXMLLoader.load(getClass().getResource("TwoPlayers.fxml"));
            Main.sss.setRoot(root);
            Main.primaryStage.setTitle("Two Players");

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void threePlayers(){

        try {
            Parent root = FXMLLoader.load(getClass().getResource("ThreePlayers.fxml"));
            Main.sss.setRoot(root);
            Main.primaryStage.setTitle("Three Players");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void fourPlayers(){

        try {
            Parent root = FXMLLoader.load(getClass().getResource("FourPlayers.fxml"));
            Main.sss.setRoot(root);
            Main.primaryStage.setTitle("Four Players");

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void newGame() {

        try {
            Parent root = FXMLLoader.load(getClass().getResource("NewGame.fxml"));
            Main.sss.setRoot(root);
            Main.primaryStage.setTitle("New Game");


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void backAction() {

        try {

            Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
            Main.sss.setRoot(root);
            Main.primaryStage.setTitle("Let's Play Monopoly!");
        } catch (IOException e) {
            System.out.println("Error!!");
        }
    }


    public void BackToNumbers(){

        try {
            Parent root = FXMLLoader.load(getClass().getResource("NewGame.fxml"));
            Main.sss.setRoot(root);
            Main.primaryStage.setTitle("New Game");
        }
        catch (IOException e){
            e.printStackTrace();
        }

    }

    public boolean isValid(String s){
        boolean allSpaces = true;
        for(int i = 0; i < s.length(); i++){
            if (s.charAt(i) != ' '){
                allSpaces = false;
                break;
            }
        }
        return s.length() > 0 && !allSpaces;
    }
    public void Player1_2(){
        if (isValid(oneName.getText())){
            twoName.setDisable(false);
            if (isValid(twoName.getText())){
                Start.setDisable(false);
            }
        }
        else {
            twoName.setDisable(true);
            Start.setDisable(true);
        }

    }
    public void Player1_3(){
        if (isValid(oneName.getText())){
            twoName.setDisable(false);
            if (isValid(twoName.getText())) {
                threeName.setDisable(false);
                if (isValid(threeName.getText()))
                    Start.setDisable(false);
            }
        }
        else {
            twoName.setDisable(true);
            threeName.setDisable(true);
            Start.setDisable(true);
        }


    }
    public void Player1_4(){
        if (isValid(oneName.getText())){
            twoName.setDisable(false);
            if (isValid(twoName.getText())) {
                threeName.setDisable(false);
                if (isValid(threeName.getText()))
                    fourName.setDisable(false);
                if(isValid(fourName.getText()))
                    Start.setDisable(false);
            }
        }
        else {
            twoName.setDisable(true);
            threeName.setDisable(true);
            fourName.setDisable(true);
            Start.setDisable(true);
        }

    }
    public void Player2_2(){
        if (isValid(twoName.getText())){
            Start.setDisable(false);
        }
        else {
            Start.setDisable(true);
        }


    }
    public void Player2_3(){
        if (isValid(twoName.getText())){
            threeName.setDisable(false);
            if(isValid(threeName.getText()))
                Start.setDisable(false);
        }
        else {
            threeName.setDisable(true);
            Start.setDisable(true);
        }
    }
    public void Player2_4(){
        if (isValid(twoName.getText())){
            threeName.setDisable(false);
            if(isValid(threeName.getText())){
                fourName.setDisable(false);
                if (isValid(fourName.getText()))
                    Start.setDisable(false);
            }
        }
        else {
            threeName.setDisable(true);
            fourName.setDisable(true);
            Start.setDisable(true);
        }
    }
    public void Player3_3(){
        if (isValid(threeName.getText())){

            Start.setDisable(false);
        }
        else {

            Start.setDisable(true);
        }
    }
    public void Player3_4(){

        if (isValid(threeName.getText())){
            fourName.setDisable(false);
            if (isValid(fourName.getText()))
                Start.setDisable(false);
        }
        else {
            fourName.setDisable(true);
            Start.setDisable(true);
        }


    }
    public void Player4(){

        if (isValid(fourName.getText())){

            Start.setDisable(false);
        }
        else {

            Start.setDisable(true);
        }

    }

    public void startGame2(){
        gameData.Names = new String[2];
        gameData.Players = new Player[2];
        gameData.Names[0] = oneName.getText();
        gameData.Names[1] = twoName.getText();

        gameData.Players[0] = new Player(0 ,gameData.Names[0]);
        gameData.Players[1] = new Player(1 ,gameData.Names[1]);

        gameData.playersNumber = 2;
        addPlayers();
        Main.primaryStage.setTitle("Monopoly");
        Main.primaryStage.setResizable(true);
        Main.Labels(2);
        Main.primaryStage.setScene(Main.scene);


    }
    public void startGame3(){
        gameData.Names = new String[3];
        gameData.Players = new Player[3];
        gameData.Names[0] = oneName.getText();
        gameData.Names[1] = twoName.getText();
        gameData.Names[2] = threeName.getText();

        gameData.Players[0] = new Player(0 ,gameData.Names[0]);
        gameData.Players[1] = new Player(1 ,gameData.Names[1]);
        gameData.Players[2] = new Player(2 ,gameData.Names[2]);

        gameData.playersNumber = 3;
        addPlayers();
        Main.primaryStage.setTitle("Monopoly");
        Main.primaryStage.setResizable(false);
        Main.Labels(3);
        Main.primaryStage.setScene(Main.scene);
        Main.primaryStage.setResizable(true);
    }
    public void startGame4(){
        gameData.Names = new String[4];
        gameData.Players = new Player[4];
        gameData.Names[0] = oneName.getText();
        gameData.Names[1] = twoName.getText();
        gameData.Names[2] = threeName.getText();
        gameData.Names[3] = fourName.getText();

        gameData.Players[0] = new Player(0 ,gameData.Names[0]);
        gameData.Players[1] = new Player(1 ,gameData.Names[1]);
        gameData.Players[2] = new Player(2 ,gameData.Names[2]);
        gameData.Players[3] = new Player(3 ,gameData.Names[3]);

        gameData.playersNumber = 4;
        addPlayers();
        Main.primaryStage.setTitle("Monopoly");
        Main.primaryStage.setResizable(false);
        Main.Labels(4);
        Main.primaryStage.setScene(Main.scene);
        Main.primaryStage.setResizable(true);
    }
    void addPlayers(){
        for (int i = 0; i < gameData.playersNumber; i++){
            gameData.playersShapes[i].getTransforms().add(Main.Playertransform);
            Main.group.getChildren().add(gameData.playersShapes[i]);
        }
    }


}
