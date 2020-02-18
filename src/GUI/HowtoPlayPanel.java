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

import tubes2048.DrawUtils;
import tubes2048.Game;
import tubes2048.GameBoard;
import tubes2048.ScoreManager;

/**
 *
 * @author naufa
 */
public class HowtoPlayPanel extends GuiPanel{
    
    private Font titleFont = Game.main.deriveFont(64f);
    private Font textFont = Game.main.deriveFont(18f);
    
    private String title1 = "CARA";    
    private String title2 = "BERMAIN";    
    private int buttonWidth = 220;
    private int spacing = 90;
    private int buttonHeight = 60;
    private String textline_1="1. Gunakan arah panah untuk menggerakkan ";
    private String textline_1_2=" ubin di papan game.";
    
    private String textline_2="2. Ubin akan tergabung jika memiliki nilai ";
    private String textline_2_2=" yang sama saat digerakkan.";
    
    private String textline_3="3. Setiap jalan, akan muncul ubin baru ";
    private String textline_3_2=" bernilai 2 atau 4 secara acak.";
    
    
    private String textline_4="4. Lanjutkan memainkan game sampai ";
    private String textline_4_2=" mendapatkan skor 2048. ";
    
    
    private String textline_5="5. Game akan berakhir jika papan penuh dan ";
    private String textline_5_2=" tidak bisa digerakkan lagi.";
    
    private String textline_6="6. Teruslah berlatih. ";
 
    public HowtoPlayPanel() {
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
    
    @Override
    public void render(Graphics2D g){
        super.render(g);
        g.setFont(titleFont);
        g.setColor(Color.black);
        g.drawString(title1, Game.WIDTH/2-DrawUtils.getMessageWidth(title1, titleFont, g)/2, 80);
        g.drawString(title2, Game.WIDTH/2-DrawUtils.getMessageWidth(title2, titleFont, g)/2, 150);
        g.drawString(textline_1, Game.WIDTH/2-DrawUtils.getMessageWidth(textline_1, textFont, g)/2, 250);
        g.drawString(textline_1_2, Game.WIDTH/2-DrawUtils.getMessageWidth(textline_2, textFont, g)/2, 280);
        g.drawString(textline_2, Game.WIDTH/2-DrawUtils.getMessageWidth(textline_1, textFont, g)/2, 310);
        g.drawString(textline_2_2, Game.WIDTH/2-DrawUtils.getMessageWidth(textline_2, textFont, g)/2, 340);
        g.drawString(textline_3, Game.WIDTH/2-DrawUtils.getMessageWidth(textline_1, textFont, g)/2, 370);
        g.drawString(textline_3_2, Game.WIDTH/2-DrawUtils.getMessageWidth(textline_2, textFont, g)/2, 400);
        g.drawString(textline_4, Game.WIDTH/2-DrawUtils.getMessageWidth(textline_1, textFont, g)/2, 430);
        g.drawString(textline_4_2, Game.WIDTH/2-DrawUtils.getMessageWidth(textline_2, textFont, g)/2, 460);
        g.drawString(textline_5, Game.WIDTH/2-DrawUtils.getMessageWidth(textline_1, textFont, g)/2, 490);
        g.drawString(textline_5_2, Game.WIDTH/2-DrawUtils.getMessageWidth(textline_2, textFont, g)/2, 520);
        g.drawString(textline_6, Game.WIDTH/2-DrawUtils.getMessageWidth(textline_1, textFont, g)/2, 550);      
    }
}
