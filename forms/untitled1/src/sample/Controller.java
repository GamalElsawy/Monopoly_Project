package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class Controller {
    public Label closeButton;
    public Label backButton;

    public void handleCloseButtonAction() {
        //Main.primaryStage = (Stage) closeButton.getScene().getWindow();
        Main.primaryStage.close();


    }
    public void newGame(){
        handleCloseButtonAction();
        try {
            Parent root = FXMLLoader.load(getClass().getResource("NewGame.fxml"));
            Stage nstage = new Stage();
            nstage.setTitle("No of players");
            nstage.setScene(new Scene(root, 450, 450));
            nstage.setMaximized(true);

            nstage.show();
            // Hide this current window (if this is what you want)

        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void backAction(){
        Stage stage = (Stage) backButton.getScene().getWindow();
        stage.close();
        try {

            Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));

            Main.primaryStage.show();
        }
        catch (IOException e){
            System.out.println("gasdga");
        }
    }

}
