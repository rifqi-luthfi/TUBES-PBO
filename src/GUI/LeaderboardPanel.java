/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import tubes2048.DrawUtils;
import tubes2048.Game;
import tubes2048.GameBoard;
import tubes2048.Leaderboards;
import tubes2048.ScoreManager;

/**
 *
 * @author naufa
 */
public class LeaderboardPanel extends GuiPanel{
    private Font titleFont = Game.main.deriveFont(50f);
    private Font scoreFont1 = Game.main.deriveFont(35f);
    private Font scoreFont2 = Game.main.deriveFont(32f);
        
    int rank;
    private String skor;  
    private String skor2;  
 
    private String title1 = "PERINGKAT";    
    private String title2 = "SKOR";    
    private int buttonWidth = 220;
    private int spacing = 90;
    private int buttonHeight = 60;
    private Leaderboards lBoard;  
    
    
    public LeaderboardPanel() {
        super();       
        GuiButton homeButton = new GuiButton(Game.WIDTH/2-GameBoard.BOARD_WIDTH/2, 170, 55 , 40);     

        homeButton.setText("Balik");      
       
        homeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {                                
                GuiScreen.getInstance().setCurrentPanel("Menu");                
            }
        }); 
        
        add(homeButton);
    }    
    
    public void drawLeaderboards(Graphics2D g){
      
        int skor_pos=200;
        for(rank=0;rank<10;rank++){
            int skor_temp;
            skor_temp = (Leaderboards.getInstance().getSkorTertinggi(rank));
            skor = Integer.toString(skor_temp);
            if(rank==9){
                g.drawString((rank+1)+".  "+skor,Game.WIDTH/2-DrawUtils.getMessageWidth((rank+1)+".  "+skor, scoreFont1, g)/2, skor_pos);
            } 
            else{
                g.drawString((rank+1)+".  "+skor,Game.WIDTH/2-DrawUtils.getMessageWidth((rank+1)+".  "+skor, scoreFont1, g)/2, skor_pos);
            }           
            skor_pos=skor_pos+45;       
        }   

/*
        g.drawString("1. 4764", Game.WIDTH/2-DrawUtils.getMessageWidth("1. 4764", scoreFont1, g)/2, 200);
        g.drawString("2. 4672", Game.WIDTH/2-DrawUtils.getMessageWidth("2. 4672", scoreFont1, g)/2, 245);
        g.drawString("3. 3688", Game.WIDTH/2-DrawUtils.getMessageWidth("3. 3688", scoreFont1, g)/2, 290);
        g.drawString("4. 2712", Game.WIDTH/2-DrawUtils.getMessageWidth("4. 2712", scoreFont1, g)/2, 335);
        g.drawString("5. 2708", Game.WIDTH/2-DrawUtils.getMessageWidth("5. 2708", scoreFont1, g)/2, 380);
        g.drawString("6. 2544", Game.WIDTH/2-DrawUtils.getMessageWidth("6. 2544", scoreFont1, g)/2, 425);
        g.drawString("7. 2404", Game.WIDTH/2-DrawUtils.getMessageWidth("7. 2404", scoreFont1, g)/2, 470);
        g.drawString("8. 1640", Game.WIDTH/2-DrawUtils.getMessageWidth("8. 1640", scoreFont1, g)/2, 515);
        g.drawString("9. 1268", Game.WIDTH/2-DrawUtils.getMessageWidth("9. 1268", scoreFont1, g)/2, 560);
        g.drawString("10. 824", Game.WIDTH/2-DrawUtils.getMessageWidth("10. 824", scoreFont1, g)/2, 605);
*/
    }
    
    @Override
    public void render(Graphics2D g){
        super.render(g);
        g.setFont(titleFont);
        g.setColor(Color.black);
        g.drawString(title1, Game.WIDTH/2-DrawUtils.getMessageWidth(title1, titleFont, g)/2, 80);
        g.setFont(titleFont);
        g.setColor(Color.black);
        g.drawString(title2, Game.WIDTH/2-DrawUtils.getMessageWidth(title2, titleFont, g)/2, 120);
        drawLeaderboards(g);
    }
}
