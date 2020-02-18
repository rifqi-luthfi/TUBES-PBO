/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tubes2048;
/**
 *
 * @author naufa
 */
import GUI.splashscreen;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import tubes2048.Leaderboards;

public class Mulai {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
            Game game = new Game(); // Buat objek game
            splashscreen ss = new splashscreen();
            ss.setVisible(true);
            try{
                for (int i = 0; i <= 100; i++){
                    Thread.sleep(20);
                    //ss.time.setText(Integer.toString(i)+"%");
                    if ( i == 100){
                        ss.setVisible(false);                       
                    }
                }
            }catch (Exception e){
                e.printStackTrace();
            }
            JFrame window = new JFrame("2048");
            window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            window.setResizable(false);
            window.add(game);
            window.pack();
            window.setLocationRelativeTo(null);
            window.setVisible(true);           
            game.start();
    }
}
            
    
