package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
public static Stage primaryStage;
public static Scene sss;
    @Override
    public void start(Stage PrimaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage = PrimaryStage;
        primaryStage.setTitle("Let's Play Monopoly!");
        sss = new Scene(root, 300, 275);
        primaryStage.setScene(sss);
        primaryStage.setMaximized(true);
        primaryStage.show();

        //primaryStage.close();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
