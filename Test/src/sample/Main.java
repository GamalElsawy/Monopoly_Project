package sample;

import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.*;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Box;
import javafx.scene.control.*;
import javafx.scene.transform.*;
import javafx.stage.*;
import gameData.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sample.Frame;

import javax.swing.*;
import java.awt.*;
import java.time.Duration;
import java.util.Random;

public class Main extends Application {

    private static final float Width = 2000;
    private static final float Height = 1300;
    public static int x = 0;


    protected Box Player = new Box(40, 40, 40);
    protected Box Player2 = new Box(40, 40, 40);


    @Override
    public void start(Stage primaryStage) throws Exception {
        //NewGame ng = new NewGame();
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
        //ng.setVisible(true);
        gameData.fillData();
        gameData.fillMap();
        Box Ground = new Box(1000, 20, 1000);
        //Box Board = new Box(50 , 50,50);
        //Board.translateXProperty().set(1050);
        //Board.translateYProperty().set(800);
        PhongMaterial Playermaterial = new PhongMaterial(Color.ORANGE);
        PhongMaterial Playermaterial2 = new PhongMaterial(Color.RED);
        PhongMaterial Playermaterial3 = new PhongMaterial(Color.GREEN);
        PhongMaterial Playermaterial4 = new PhongMaterial(Color.BLUE);

        Player.setMaterial(Playermaterial);
        Player.translateXProperty().set(1159);
        Player.translateYProperty().set(727);

        Player2.setMaterial(Playermaterial2);
        Player2.translateXProperty().set(1159);
        Player2.translateYProperty().set(727);

        //Player.translateZProperty().set(300);
        Group group = new Group();
        group.getChildren().add(settingBackGroundImage());
        group.getChildren().add(Ground);
        Camera camera = new ParallelCamera();
        //Sphere s = new Sphere(50);

        PhongMaterial Boardmaterial = new PhongMaterial();
        Boardmaterial.setDiffuseMap(new Image(getClass().getResourceAsStream("/sample/Board.png")));
        //Boardmaterial.setSpecularColor(Color.SILVER);
        //Image img = new Image("sample/Wood.jpg");
        Image image = new Image("sample/title1.jpeg");
        Scene scene = new Scene(group, Width, Height);
        ColorAdjust coloradust = new ColorAdjust();
        coloradust.setBrightness(10);
        Transform transform = new Rotate(45, new Point3D(1.5, 0, 0));
        Transform Playertransform = new Rotate(45, new Point3D(1, 0, 0));
        Ground.setMaterial(Boardmaterial);
        Button throwDice = new Button("Throw Dice");
        group.getChildren().add(throwDice);
        throwDice.translateXProperty().set(1500);
        throwDice.translateYProperty().set(900);
        //text.setFont(Font.font("Italic" , 100));
        //Board.setFill(new ImagePattern(img));
        //Board.getTransforms().add(transform);
        //Board.translateXProperty().set((400));
        //Board.translateYProperty().set((400));
        Ground.getTransforms().add(transform);

        Player.getTransforms().add(Playertransform);
        scene.setFill(Color.SILVER);
        // scene.setCamera(camera);
        // scene.setFill(getClass().getResourceAsStream(new Image("sample/Back.jpg")));
        group.getChildren().add(CreatePlayers(Player));

        Player2.getTransforms().add(Playertransform);
        group.getChildren().add(CreatePlayers(Player2));


        //group.getChildren().add(Board);
        //group.getChildren().add(s);
        Ground.translateXProperty().set(Width / 2 - 250);
        Ground.translateYProperty().set(Height / 2 - 200);
        //Ground.translateZProperty().set(100);
        //Ground.translateZProperty().set(-1000);
        // Ground.setFill(new ImagePattern(img));
        // material.setDiffuseMap(new Image(getClass().getResourceAsStream("/1.jpg")));
        //Rectangle rectangle= new Rectangle(700 , 700);
        //Image img = new Image("/Assits/1.jpg");
        // ImageView view = new ImageView(img);
        //rectangle.setFill(new ImagePattern(img));
        //group.getChildren().add(view);
        throwDice.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {

            //int d = roll() + roll();


            for (int i = 0; i < 1; i++) {
                moveFirst(1);
            }
            System.out.println(Player.getTranslateX() + " " + Player.getTranslateY() + " " + Player.getTranslateZ());

        });

        primaryStage.addEventHandler(KeyEvent.KEY_PRESSED, event -> {
            switch (event.getCode()) {
                case A:

                    Player.translateXProperty().set(Player.getTranslateX() - 1);
                    // Player.translateYProperty().set(Player.getTranslateY()-0.5);
                    getpositionXY(Player);

                    break;
                case D:
                    Player.translateXProperty().set(Player.getTranslateX() + 1);
                    //Player.translateYProperty().set(Player.getTranslateY()+0.5);
                    getpositionXY(Player);
                    break;
                case W:
                    Player2.translateYProperty().set(Player2.getTranslateY() - 1);
                    //Player.translateXProperty().set(Player.getTranslateX()+1.8);
                    getpositionXY(Player2);
                    break;
                case S:
                    Player2.translateYProperty().set(Player2.getTranslateY() + 1);
                    //Player.translateXProperty().set(Player.getTranslateX()-1.8);
                    getpositionXY(Player2);
                    break;


            }


        });


        /*primaryStage.getIcons().add(image);
        primaryStage.fullScreenProperty();
        primaryStage.resizableProperty();
        primaryStage.setTitle("Monopoly");
        primaryStage.setScene(scene);
        //primaryStage.show();*/

    }

    double Xposition, YPosition;

    public static int roll() {
        int roll = 0;
        Random r = new Random();
        roll = r.nextInt(6) + 1;
        return roll;
    }

    int counter = 0;

    protected void moveFirst(int DiceRoll) {


        if (counter >= 0 && counter < 10) {
            Xposition = Player.translateXProperty().getValue() + (-82);
            Player.translateXProperty().set(Player.getTranslateX() - 82);

            counter++;

        } else if (counter >= 10 && counter < 20) {
            YPosition = Player.translateYProperty().getValue() + (-62);
            Player.translateYProperty().set(Player.getTranslateY() - 62);
            counter++;

        } else if (counter >= 20 && counter < 30) {
            Xposition = Player.translateXProperty().getValue() + (82);
            Player.translateXProperty().set(Player.getTranslateX() + 82);
            counter++;

        } else if (counter >= 30 && counter < 40) {
            YPosition = Player.translateYProperty().getValue() + (62);
            Player.translateYProperty().set(Player.getTranslateY() + 62);
            counter++;

        } else counter = 0;


    }


    private ImageView settingBackGroundImage() {
        Image BackPic = new Image(Main.class.getResourceAsStream("/sample/22.jpg"));
        ImageView Image_view = new ImageView(BackPic);
        Image_view.setFitHeight(Height);
        Image_view.setFitWidth(Width);
        Image_view.getTransforms().add(new Translate(-BackPic.getWidth() / 30, -BackPic.getHeight() / 30, 500));
        Image_view.setPreserveRatio(true);
        return Image_view;

    }

    public void getpositionXY(Box B) {
        System.out.println(B.translateXProperty());
        System.out.println(B.translateYProperty());

    }

    protected Box CreatePlayers(Box Player) {


        return Player;
    }

    public static void main(String[] args) {

        launch(args);

    }
}
