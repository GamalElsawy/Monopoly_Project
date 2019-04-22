package Monopoly_Game;
import com.sun.corba.se.impl.protocol.giopmsgheaders.Message;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class gameData {
    
    
}
public class Monopoly_Game {
   public static City[] cities = new City[22];
    public static void main(String[] args) {
        ReadingData Read = new ReadingData();
        Read.OpenFile("CitiesDetails.txt");
        Read.Read(16);
        Read.Close();
        for (int i = 0; i < 22; i++){
            cities[i].print();
        }
       
        /*JFrame MainPage = new JFrame();
        MainPage.setLayout(new FlowLayout());
        MainPage.setExtendedState(JFrame.MAXIMIZED_BOTH); 
        MainPage.setUndecorated(true);
        JButton newGame = new JButton("NEW GAME");
        newGame.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                MainPage.setVisible(false);
                JFrame NOPlayers = new JFrame();
                NOPlayers.setLayout(new FlowLayout());
                NOPlayers.setExtendedState(JFrame.MAXIMIZED_BOTH); 
                NOPlayers.setUndecorated(true);
                JButton TwoPlayers = new JButton("2 PLAYERS");
                
                NOPlayers.add(TwoPlayers);
                
                JButton ThreePlayers = new JButton("3 PLAYERS");
                NOPlayers.add(ThreePlayers);
                
                JButton FourPlayers = new JButton("4 PLAYERS");
                NOPlayers.add(FourPlayers);
                
                JButton ReturnToMain = new JButton("RETURN TO MAIN MENU");
                ReturnToMain.addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        NOPlayers.setVisible(false);
                        MainPage.setVisible(true);
                    }
                });
                NOPlayers.add(ReturnToMain);
                
                NOPlayers.setVisible(true);
                MainPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            }
        });
        MainPage.add(newGame);
        
        JButton loadGame = new JButton("LOAD GAME");
        MainPage.add(loadGame);
        
        JButton Exit = new JButton("EXIT");
        Exit.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                int result = JOptionPane.showConfirmDialog(null,
                        "Are you sure you want to quit?",
                        "Confirm Quit", JOptionPane.YES_NO_CANCEL_OPTION);
                if (result == JOptionPane.YES_OPTION) System.exit(0);
            }
        });
        MainPage.add(Exit);
        
        MainPage.setVisible(true);
        MainPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);*/
     
    }
    
}
