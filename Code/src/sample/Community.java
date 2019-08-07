package sample;

import gameData.gameData;

public class Community {

    public static void CommunityJudge(int num, int idx) {
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
        // Doctor Fees 50$
            gameData.Players[idx].Payment(50,10);
        }
        if (num == 3) {
            //bank error give you 75
            gameData.Players[idx].setBalance(gameData.Players[idx].getBalance()+75);

        }
        if (num == 4) {
//  pay to hospital
            gameData.Players[idx].Payment(100,10);

        }
        if (num == 5) {
   //pay school tax
            gameData.Players[idx].Payment(50,10);

        }
        if (num == 1) {
      //Advance to go
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
        if (num == 7) {
     //   free jail card
            gameData.Players[idx].HaveJailCardChest=true;
        }
        if (num == 8) {
        //life insurence
            gameData.Players[idx].setBalance(gameData.Players[idx].getBalance()+100);
        }
        if (num == 9) {
       //income tax refund fund
            gameData.Players[idx].setBalance(gameData.Players[idx].getBalance()+20);
        }
        if (num == 10) {
   // take 50 from each player
            gameData.Players[idx].setBalance(gameData.Players[idx].getBalance() + gameData.playersNumber * 50);
            for (int i = 0; i < gameData.playersNumber; i++){
                if (i == idx)
                    continue;
                gameData.Players[i].Payment(50,10);
            }
        }
    }
}
