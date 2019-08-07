package sample;

import gameData.gameData;

public class ChanceJudges {

    public static void ChanceJudge(int num, int idx) {
        if (num == 6) {
            //goto jail
            if (idx == 0) {
                gameData.playersShapes[idx].setTranslateX(209 * Main.x);
                gameData.playersShapes[idx].setTranslateY(776 * Main.y);
                gameData.cur1 = 10;
            } else if (idx == 1) {
                gameData.playersShapes[idx].setTranslateX(212 * Main.x);
                gameData.playersShapes[idx].setTranslateY(816 * Main.y);
                gameData.cur2 = 10;
            }
            if (idx == 2) {
                gameData.playersShapes[idx].setTranslateX(250 * Main.x);
                gameData.playersShapes[idx].setTranslateY(769 * Main.y);
                gameData.cur3 = 10;
            }
            if (idx == 3) {
                gameData.playersShapes[idx].setTranslateX(250 * Main.x);
                gameData.playersShapes[idx].setTranslateY(806 * Main.y);
                gameData.cur4 = 10;
            }
            gameData.Players[idx].setIsInJail(true);
        }
        if (num == 2) {
//        free from jail
                gameData.Players[idx].HaveJailCardChance = true;
            }

        if (num == 3) {
//    Advance to go
            if (idx == 0) {
                gameData.playersShapes[idx].setTranslateX(914 * Main.x);
                gameData.playersShapes[idx].setTranslateY(783 * Main.y);
                gameData.cur1 = 0;
            } else if (idx == 1) {
                gameData.playersShapes[idx].setTranslateX(914 * Main.x);
                gameData.playersShapes[idx].setTranslateY(846 * Main.y);
                gameData.cur2 = 0;
            }
            if (idx == 2) {
                gameData.playersShapes[idx].setTranslateX(944 * Main.x);
                gameData.playersShapes[idx].setTranslateY(829 * Main.y);
                gameData.cur3 = 0;
            }
            if (idx == 3) {
                gameData.playersShapes[idx].setTranslateX(944 * Main.x);
                gameData.playersShapes[idx].setTranslateY(765 * Main.y);
                gameData.cur4 = 0;
            }
            gameData.go.OnVisiting(idx,0);

        }
        if (num == 4) {
       // pay 25 for each house and 100 for each Hotel...
            gameData.Players[idx].Payment(gameData.Players[idx].NOfHouses*25+gameData.Players[idx].NOfHotels*100,10);
        }
        if (num == 5) {
//    Advance to illnois Avenu
            if (idx == 0) {
                gameData.playersShapes[idx].setTranslateX(526 * Main.x);
                gameData.playersShapes[idx].setTranslateY(110 * Main.y);
                if(gameData.cur1>24)gameData.go.OnVisiting(idx,0);
                gameData.cur1 = 24;
                gameData.mp1.get(gameData.Path1.get(gameData.cur1)).OnVisiting(idx, 0);
            } else if (idx == 1) {
                gameData.playersShapes[idx].setTranslateX(526 * Main.x);
                gameData.playersShapes[idx].setTranslateY(55 * Main.y);
                if(gameData.cur2>24)gameData.go.OnVisiting(idx,0);
                gameData.cur2 = 24;
                gameData.mp2.get(gameData.Path2.get(gameData.cur2)).OnVisiting(idx, 0);
            }
            if (idx == 2) {
                gameData.playersShapes[idx].setTranslateX(492 * Main.x);
                gameData.playersShapes[idx].setTranslateY(44 * Main.y);
                if(gameData.cur3>24)gameData.go.OnVisiting(idx,0);
                gameData.cur3 = 24;
                gameData.mp3.get(gameData.Path3.get(gameData.cur3)).OnVisiting(idx, 0);
            }
            if (idx == 3) {
                gameData.playersShapes[idx].setTranslateX(492 * Main.x);
                gameData.playersShapes[idx].setTranslateY(93 * Main.y);
                if(gameData.cur4>24)gameData.go.OnVisiting(idx,0);
                gameData.cur4 = 24;
                gameData.mp4.get(gameData.Path4.get(gameData.cur4)).OnVisiting(idx, 0);
            }

        }
        if (num == 1) {
//    back three spaces



            if (idx == 0) {
                gameData.cur1-=3;
                gameData.playersShapes[idx].setTranslateX(gameData.Path1.get(gameData.cur1).x * Main.x);
                gameData.playersShapes[idx].setTranslateY(gameData.Path1.get(gameData.cur1).y * Main.y);
                gameData.mp1.get(gameData.Path1.get(gameData.cur1)).OnVisiting(idx, 0);
            } else if (idx == 1) {
                gameData.cur2 -= 3;
                gameData.playersShapes[idx].setTranslateX(gameData.Path2.get(gameData.cur2).x * Main.x);
                gameData.playersShapes[idx].setTranslateY(gameData.Path2.get(gameData.cur2).y * Main.y);
                gameData.mp2.get(gameData.Path2.get(gameData.cur2)).OnVisiting(idx, 0);
            }
            if (idx == 2) {
                gameData.cur3 -= 3;
                gameData.playersShapes[idx].setTranslateX(gameData.Path3.get(gameData.cur3).x * Main.x);
                gameData.playersShapes[idx].setTranslateY(gameData.Path3.get(gameData.cur3).y * Main.y);
                gameData.mp3.get(gameData.Path3.get(gameData.cur3)).OnVisiting(idx, 0);
            }
            if (idx == 3) {
                gameData.cur4 -= 3;
                gameData.playersShapes[idx].setTranslateX(gameData.Path4.get(gameData.cur4).x * Main.x);
                gameData.playersShapes[idx].setTranslateY(gameData.Path4.get(gameData.cur4).y * Main.y);
                gameData.mp4.get(gameData.Path4.get(gameData.cur4)).OnVisiting(idx, 0);
            }
        }
        if (num == 7) {
//  Pay 50 to each player


            gameData.Players[idx].Payment((gameData.playersNumber-1)*50,10);
            for (int i = 0; i < gameData.playersNumber; i++){
                if (i == idx)
                    continue;
           if( gameData.Players[i].isLoser==false)
                gameData.Players[i].setBalance(gameData.Players[i].getBalance() + 50);
            }
        }
        if (num == 8) {
//  Pay 15$ as poor Tax
            gameData.Players[idx].Payment(15,10);

        }
        if (num == 9) {
//  Bank give you 50$
            gameData.Players[idx].setBalance(gameData.Players[idx].getBalance()+50);
        }
        if (num == 10) {
//   go to charles palace...
            if (idx == 0) {
                gameData.playersShapes[idx].setTranslateX(228 * Main.x);
                gameData.playersShapes[idx].setTranslateY(700 * Main.y);
                if(gameData.cur1>11)gameData.go.OnVisiting(idx,0);
                gameData.cur1 = 11;
                gameData.mp1.get(gameData.Path1.get(gameData.cur1)).OnVisiting(idx, 0);
            } else if (idx == 1) {
                gameData.playersShapes[idx].setTranslateX(180 * Main.x);
                gameData.playersShapes[idx].setTranslateY(704 * Main.y);
                if(gameData.cur2>11)gameData.go.OnVisiting(idx,0);
                gameData.cur2 = 11;
                gameData.mp2.get(gameData.Path2.get(gameData.cur2)).OnVisiting(idx, 0);
            }
            if (idx == 2) {
                gameData.playersShapes[idx].setTranslateX(195 * Main.x);
                gameData.playersShapes[idx].setTranslateY(737 * Main.y);
                if(gameData.cur3>11)gameData.go.OnVisiting(idx,0);
                gameData.cur3 = 11;
                gameData.mp3.get(gameData.Path3.get(gameData.cur3)).OnVisiting(idx, 0);
            }
            if (idx == 3) {
                gameData.playersShapes[idx].setTranslateX(243 * Main.x);
                gameData.playersShapes[idx].setTranslateY(729 * Main.y);
                if(gameData.cur4>11)gameData.go.OnVisiting(idx,0);
                gameData.cur4 = 11;
                gameData.mp4.get(gameData.Path4.get(gameData.cur4)).OnVisiting(idx, 0);
            }
        }

    }


}
