package sample;

import gameData.gameData;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Pair;

import java.awt.*;
import javax.swing.ImageIcon;

public abstract class Field {
    String image;

    public int getNumberOfHouses() {
        return NumberOfHouses;
    }

    public boolean isIs_Grouped() {
        return is_Grouped;
    }

    public void setIs_Grouped(boolean is_Grouped) {
        this.is_Grouped = is_Grouped;
    }

    public void setNumberOfHouses(int numberOfHouses) {
        NumberOfHouses = numberOfHouses;
    }

    public int getNumberOfHotel() {
        return NumberOfHotel;
    }

    public void setNumberOfHotel(int numberOfHotel) {
        NumberOfHotel = numberOfHotel;
    }

    public int getHouseCost() {
        return HouseCost;
    }

    public void setHouseCost(int houseCost) {
        HouseCost = houseCost;
    }

    String Name;

    public ImageView getIvBuy() {
        return ivBuy;
    }


    double smallX, smallY, morX, morY;
    int Mortage;
    int NumberOfHouses;
    int NumberOfHotel;
    int HouseCost;
    int id;
    int PlayerID;
    boolean Is_Mortaged;
    Point[] pos = new Point[4];
    String IconMore = "sample/Mortage.png";

    public void setIVIcon(Image IVIco) {
        Main.group.getChildren().remove(this.IVIcon);
        this.IVIcon = new ImageView(IVIco);
        IVIcon.setFitWidth(Main.x(50));
        IVIcon.setFitHeight(Main.y(50));
        IVIcon.setTranslateX(smallX);
        IVIcon.setTranslateY(smallY);
        IVIcon.setVisible(true);
        IVIcon.setDisable(false);
        Main.group.getChildren().add(IVIcon);

    }

    Image img, ImgBuy, Icon1;
    ImageView IVIcon;

    public void setImgBuy(Image imgBuy) {
        ImgBuy = imgBuy;
    }

    boolean is_Grouped;

    public void DELETE() {
        Main.group.getChildren().remove(ivBuy);
    }

    ImageView iv, ivBuy;
    String down1 = "sample/Properities/house1.png";
    String left1 = "sample/Properities/house1FlippedRight.png";
    String right1 = "sample/Properities/house1FlippedLeft.png";
    String up1 = "sample/Properities/house1UpsideDown.png";

    String down2 = "sample/Properities/house2.png";
    String left2 = "sample/Properities/house2FlippedRight.png";
    String right2 = "sample/Properities/house2FlippedLeft.png";
    String up2 = "sample/Properities/house2UpsideDown.png";

    String down3 = "sample/Properities/house3.png";
    String left3 = "sample/Properities/house3FlippedRight.png";
    String right3 = "sample/Properities/house3FlippedLeft.png";
    String up3 = "sample/Properities/house3UpsideDown.png";

    String down4 = "sample/Properities/house4.png";
    String left4 = "sample/Properities/house4FlippedRight.png";
    String right4 = "sample/Properities/house4FlippedLeft.png";
    String up4 = "sample/Properities/house4UpsideDown.png";

    String hoteldown = "sample/Properities/hotel.png";
    String hotelleft = "sample/Properities/hotelFlippedLeft.png";
    String hotelright = "sample/Properities/hotelFlippedRight.png";
    String hotelup = "sample/Properities/hotelUpsideDown.png";


    public int getMortage() {
        return Mortage;
    }

    Field(String n, String PathImage) {
        img = new Image(IconMore, 70, 70, false, false);
        iv = new ImageView(img);
        Name = n;
        Is_Mortaged = false;
        PlayerID = -1;
        image = PathImage;
        is_Grouped = false;
    }

    public void Clear() {
        NumberOfHouses = 0;
        NumberOfHotel = 0;
        Is_Mortaged = false;
        PlayerID = -1;
        is_Grouped = false;
    }

    public ImageView getIv() {
        return iv;
    }

    public void SetBuildImage(int num) {

        if (num <= 4) {
            if (id >= 0 && id <= 10) {
                if (num == 1) {

                    ImgBuy = new Image(down1, 70, 70, false, false);
                    ivBuy = new ImageView(ImgBuy);
                    ivBuy.setVisible(true);
                    ivBuy.setDisable(false);
                    ivBuy.setTranslateX(smallX);
                    ivBuy.setTranslateY(morY + 45);

                    ivBuy.setFitHeight(30);
                    Main.group.getChildren().add(ivBuy);
                }
                if (num == 2) {
                    Main.group.getChildren().remove(ivBuy);
                    ImgBuy = new Image(down2, 70, 70, false, false);
                    ivBuy = new ImageView(ImgBuy);
                    ivBuy.setVisible(true);
                    ivBuy.setDisable(false);
                    ivBuy.setTranslateX(smallX);
                    ivBuy.setTranslateY(morY + 45);

                    ivBuy.setFitHeight(30);
                    Main.group.getChildren().add(ivBuy);
                }
                if (num == 3) {
                    Main.group.getChildren().remove(ivBuy);
                    ImgBuy = new Image(down3, 70, 70, false, false);
                    ivBuy = new ImageView(ImgBuy);
                    ivBuy.setVisible(true);
                    ivBuy.setDisable(false);
                    ivBuy.setTranslateX(smallX);
                    ivBuy.setTranslateY(morY + 45);

                    ivBuy.setFitHeight(30);
                    Main.group.getChildren().add(ivBuy);
                }
                if (num == 4) {
                    Main.group.getChildren().remove(ivBuy);
                    ImgBuy = new Image(down4, 70, 70, false, false);
                    ivBuy = new ImageView(ImgBuy);
                    ivBuy.setVisible(true);
                    ivBuy.setDisable(false);
                    ivBuy.setTranslateX(smallX);
                    ivBuy.setTranslateY(morY + 45);

                    ivBuy.setFitHeight(30);
                    Main.group.getChildren().add(ivBuy);
                }
            }
            if (id > 10 && id <= 20) {
                if (num == 1) {

                    ImgBuy = new Image(left1, 70, 70, false, false);
                    ivBuy = new ImageView(ImgBuy);
                    ivBuy.setVisible(true);
                    ivBuy.setDisable(false);
                    ivBuy.setTranslateX(getSmallX() - 35);
                    ivBuy.setTranslateY(getSmallY() + 20);
                    ivBuy.setFitHeight(40);
                    Main.group.getChildren().add(ivBuy);
                }
                if (num == 2) {
                    Main.group.getChildren().remove(ivBuy);
                    ImgBuy = new Image(left2, 70, 70, false, false);
                    ivBuy = new ImageView(ImgBuy);
                    ivBuy.setVisible(true);
                    ivBuy.setDisable(false);
                    ivBuy.setTranslateX(getSmallX() - 35);
                    ivBuy.setTranslateY(getSmallY() + 20);
                    ivBuy.setFitHeight(40);
                    Main.group.getChildren().add(ivBuy);
                }
                if (num == 3) {
                    Main.group.getChildren().remove(ivBuy);
                    ImgBuy = new Image(left3, 70, 70, false, false);
                    ivBuy = new ImageView(ImgBuy);
                    ivBuy.setVisible(true);
                    ivBuy.setDisable(false);
                    ivBuy.setTranslateX(getSmallX() - 35);
                    ivBuy.setTranslateY(getSmallY() + 20);
                    ivBuy.setFitHeight(40);
                    Main.group.getChildren().add(ivBuy);


                }
                if (num == 4) {
                    Main.group.getChildren().remove(ivBuy);
                    ImgBuy = new Image(left4, 70, 70, false, false);
                    ivBuy = new ImageView(ImgBuy);
                    ivBuy.setVisible(true);
                    ivBuy.setDisable(false);
                    ivBuy.setTranslateX(getSmallX() - 35);
                    ivBuy.setTranslateY(getSmallY() + 20);
                    ivBuy.setFitHeight(40);
                    Main.group.getChildren().add(ivBuy);
                }
            }
            if (id > 20 && id <= 30) {
                if (num == 1) {

                    ImgBuy = new Image(up1, 70, 70, false, false);
                    ivBuy = new ImageView(ImgBuy);
                    ivBuy.setVisible(true);
                    ivBuy.setDisable(false);
                    ivBuy.setTranslateX(getSmallX());
                    ivBuy.setTranslateY(getSmallY());
                    ivBuy.setFitHeight(30);
                    Main.group.getChildren().add(ivBuy);
                }
                if (num == 2) {
                    Main.group.getChildren().remove(ivBuy);
                    ImgBuy = new Image(up2, 70, 70, false, false);
                    ivBuy = new ImageView(ImgBuy);
                    ivBuy.setVisible(true);
                    ivBuy.setDisable(false);
                    ivBuy.setTranslateX(getSmallX());
                    ivBuy.setTranslateY(getSmallY());
                    ivBuy.setFitHeight(30);
                    Main.group.getChildren().add(ivBuy);
                }
                if (num == 3) {
                    Main.group.getChildren().remove(ivBuy);
                    ImgBuy = new Image(up3, 70, 70, false, false);
                    ivBuy = new ImageView(ImgBuy);
                    ivBuy.setVisible(true);
                    ivBuy.setDisable(false);
                    ivBuy.setTranslateX(getSmallX());
                    ivBuy.setTranslateY(smallY);
                    ivBuy.setFitHeight(30);
                    Main.group.getChildren().add(ivBuy);
                }
                if (num == 4) {
                    Main.group.getChildren().remove(ivBuy);
                    ImgBuy = new Image(up4, 70, 70, false, false);
                    ivBuy = new ImageView(ImgBuy);
                    ivBuy.setVisible(true);
                    ivBuy.setDisable(false);
                    ivBuy.setTranslateX(smallX);
                    ivBuy.setTranslateY(smallY);
                    ivBuy.setFitHeight(30);
                    Main.group.getChildren().add(ivBuy);
                }
            }
            if (id > 30 && id <= 40) {
                if (num == 1) {

                    ImgBuy = new Image(right1, 70, 70, false, false);
                    ivBuy = new ImageView(ImgBuy);
                    ivBuy.setVisible(true);
                    ivBuy.setDisable(false);
                    ivBuy.setTranslateX(getSmallX() + 35);
                    ivBuy.setTranslateY(getSmallY());
                    ivBuy.setFitHeight(40);
                    Main.group.getChildren().add(ivBuy);

                }
                if (num == 2) {
                    Main.group.getChildren().remove(ivBuy);
                    ImgBuy = new Image(right2, 70, 70, false, false);
                    ivBuy = new ImageView(ImgBuy);
                    ivBuy.setVisible(true);
                    ivBuy.setDisable(false);
                    ivBuy.setTranslateX(getSmallX() + 35);
                    ivBuy.setTranslateY(getSmallY());
                    ivBuy.setFitHeight(40);
                    Main.group.getChildren().add(ivBuy);

                }
                if (num == 3) {
                    Main.group.getChildren().remove(ivBuy);
                    ImgBuy = new Image(right3, 70, 70, false, false);
                    ivBuy = new ImageView(ImgBuy);
                    ivBuy.setVisible(true);
                    ivBuy.setDisable(false);
                    ivBuy.setTranslateX(getSmallX() + 35);
                    ivBuy.setTranslateY(getSmallY());
                    ivBuy.setFitHeight(40);
                    Main.group.getChildren().add(ivBuy);

                }
                if (num == 4) {
                    Main.group.getChildren().remove(ivBuy);
                    ImgBuy = new Image(right4, 70, 70, false, false);
                    ivBuy = new ImageView(ImgBuy);
                    ivBuy.setVisible(true);
                    ivBuy.setDisable(false);
                    ivBuy.setTranslateX(getSmallX() + 35);
                    ivBuy.setTranslateY(getSmallY());
                    ivBuy.setFitHeight(40);
                    Main.group.getChildren().add(ivBuy);

                }
            }
        } else {
            if (id >= 0 && id <= 10) {
                Main.group.getChildren().remove(ivBuy);
                ImgBuy = new Image(hoteldown, 70, 70, false, false);
                ivBuy = new ImageView(ImgBuy);
                ivBuy.setVisible(true);
                ivBuy.setDisable(false);
                ivBuy.setTranslateX(smallX);
                ivBuy.setTranslateY(morY + 45);

                ivBuy.setFitHeight(30);
                Main.group.getChildren().add(ivBuy);

            }
            if (id > 10 && id <= 20) {
                Main.group.getChildren().remove(ivBuy);
                ImgBuy = new Image(hotelleft, 70, 70, false, false);
                ivBuy = new ImageView(ImgBuy);
                ivBuy.setVisible(true);
                ivBuy.setDisable(false);
                ivBuy.setTranslateX(getSmallX() - 35);
                ivBuy.setTranslateY(getSmallY() + 20);
                ivBuy.setFitHeight(30);
                Main.group.getChildren().add(ivBuy);

            }
            if (id > 20 && id <= 30) {
                Main.group.getChildren().remove(ivBuy);
                ImgBuy = new Image(hotelup, 70, 70, false, false);
                ivBuy = new ImageView(ImgBuy);
                ivBuy.setVisible(true);
                ivBuy.setDisable(false);
                ivBuy.setTranslateX(smallX);
                ivBuy.setTranslateY(smallY);
                ivBuy.setFitHeight(30);
                Main.group.getChildren().add(ivBuy);
            }
            if (id > 30 && id <= 40) {
                Main.group.getChildren().remove(ivBuy);
                ImgBuy = new Image(hotelright, 70, 70, false, false);
                ivBuy = new ImageView(ImgBuy);
                ivBuy.setVisible(true);
                ivBuy.setDisable(false);
                ivBuy.setTranslateX(getSmallX() + 35);
                ivBuy.setTranslateY(getSmallY());
                ivBuy.setFitHeight(40);
                Main.group.getChildren().add(ivBuy);

            }

        }
    }

    public void setMor(int x, int y) {
        morX = x* Main.x;
        morY = y* Main.y;
    }

    public boolean isIs_Mortaged() {
        return Is_Mortaged;
    }

    public void setIs_Mortaged(boolean is_Mortaged) {
        if (is_Mortaged == true) {

            iv.setTranslateX(morX);
            iv.setTranslateY(morY);
            iv.setVisible(true);
            iv.setDisable(false);
            Main.group.getChildren().add(iv);
        } else {
            Main.group.getChildren().remove(iv);
            iv.setVisible(false);
            iv.setDisable(true);
        }
        Is_Mortaged = is_Mortaged;
    }

    public void setPlayerID(int playerID) {
        PlayerID = playerID;
    }

    public void setSmall(int x, int y) {
        smallX = Main.x(x);
        smallY = Main.y(y);
    }

    public int getPlayerID() {
        return PlayerID;
    }

    public double getSmallX() {
        return smallX;
    }

    public double getSmallY() {
        return smallY;
    }

    public String getName() {
        return Name;
    }

    public abstract void OnVisiting(int idx, int dice);


    public int getId() {
        return id;
    }

    public void SetId(int ID) {
        id = ID;
    }

    public void setPostion(String[] s) {
        int i = 0, j = 0;
        while (i < 8) {
            pos[j++] = new Point(Integer.parseInt(s[i++]), Integer.parseInt(s[i++]));
        }
    }

    public Point getPos(int playerIndex) {
        return pos[playerIndex - 1];
    }

    public ImageView getIVIcon() {
        return IVIcon;
    }
}
