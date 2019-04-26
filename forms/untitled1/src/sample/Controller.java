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

import java.io.IOException;

public class Controller {
    public Label closeButton;
    public Label backButton;
    public Label BackToNewGame;
    public Label two;
    public Label three;
    public Label four;
    public Label backToNumbers;
    public Stage twoPlayers;
    public Stage threePlayers;
    public Stage fourPlayers;
    public Stage noOfPlayers;
    public TextField oneName;
    public TextField twoName;
    public TextField threeName;
    public TextField fourName;
    public void handleCloseButtonAction() {
        //Main.primaryStage = (Stage) closeButton.getScene().getWindow();
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
            System.out.println("gasdga");
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
    public void Player1(){
        String s = oneName.getText();
        boolean allSpaces = true;
        for(int i = 0; i < s.length(); i++){
            if (s.charAt(i) != ' '){
                allSpaces = false;
                break;
            }
        }
        if (s.length() > 0 && !allSpaces){
            twoName.setDisable(false);
        }
        else
            twoName.setDisable(true);
    }
    public void Player2(){
        String s = twoName.getText();
        boolean allSpaces = true;
        for(int i = 0; i < s.length(); i++){
            if (s.charAt(i) != ' '){
                allSpaces = false;
                break;
            }
        }
        if (s.length() > 0 && !allSpaces){
            threeName.setDisable(false);
        }
        else
            threeName.setDisable(true);
    }
    public void Player3(){
        String s = threeName.getText();
        boolean allSpaces = true;
        for(int i = 0; i < s.length(); i++){
            if (s.charAt(i) != ' '){
                allSpaces = false;
                break;
            }
        }
        if (s.length() > 0 && !allSpaces){
            fourName.setDisable(false);
        }
        else
            fourName.setDisable(true);
    }


}
