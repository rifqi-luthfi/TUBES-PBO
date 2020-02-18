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
import tubes2048.DrawUtils;
import tubes2048.Game;
import tubes2048.GameBoard;

/**
 *
 * @author naufa
 */
public class faqpanel extends GuiPanel {
        
    private Font titleFont = Game.main.deriveFont(64f);
    private Font textFont = Game.main.deriveFont(18f);
    
    private String title1 = "F.A.Q";        
    private int buttonWidth = 220;
    private int spacing = 90;
    private int buttonHeight = 60;
    private String textline_1="1. Apakah itu game 2048? ";
    private String textline_1_2=" Game 2048 adalah game single player block ";
    private String textline_1_3=" puzzle. ";
    
    
    private String textline_2="2. Bagaimana cara menyelesaikan game 2048? ";
    private String textline_2_2=" Dengan mendapatkan nilai 2048 pada ubin.";
    
    private String textline_3="3. Apakah bisa lanjut setelah mendapat 2048?";
    private String textline_3_2=" Ya, kita bisa tetap lanjut atau kembali ke menu.";
      
    private String textline_4="4. Kapan game 2048 berakhir? ";
    private String textline_4_2=" Game akan berakhir jika ubin tidak bisa . ";
    private String textline_4_3=" digerakkan. ";
        
    private String textline_5="5. Bagaimana jika game telah berakhir?";
    private String textline_5_2=" Skor tersimpan dan bisa mengulang dari awal.";
    
 
    public faqpanel() {
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
        g.drawString(title1, Game.WIDTH/2-DrawUtils.getMessageWidth(title1, titleFont, g)/2, 115);
        g.drawString(textline_1, Game.WIDTH/2-DrawUtils.getMessageWidth(textline_2, textFont, g)/2, 250);
        g.drawString(textline_1_2, Game.WIDTH/2-DrawUtils.getMessageWidth(textline_2, textFont, g)/2, 280);
        g.drawString(textline_1_3, Game.WIDTH/2-DrawUtils.getMessageWidth(textline_2, textFont, g)/2, 310);
          
        g.drawString(textline_2, Game.WIDTH/2-DrawUtils.getMessageWidth(textline_2, textFont, g)/2, 350);
        g.drawString(textline_2_2, Game.WIDTH/2-DrawUtils.getMessageWidth(textline_2, textFont, g)/2, 380);
        
        g.drawString(textline_3, Game.WIDTH/2-DrawUtils.getMessageWidth(textline_2, textFont, g)/2, 420);
        g.drawString(textline_3_2, Game.WIDTH/2-DrawUtils.getMessageWidth(textline_2, textFont, g)/2, 450);
        
        g.drawString(textline_4, Game.WIDTH/2-DrawUtils.getMessageWidth(textline_2, textFont, g)/2, 490);
        g.drawString(textline_4_2, Game.WIDTH/2-DrawUtils.getMessageWidth(textline_2, textFont, g)/2, 520);
        g.drawString(textline_4_3, Game.WIDTH/2-DrawUtils.getMessageWidth(textline_2, textFont, g)/2, 550);
        
        g.drawString(textline_5, Game.WIDTH/2-DrawUtils.getMessageWidth(textline_2, textFont, g)/2, 590);
        g.drawString(textline_5_2, Game.WIDTH/2-DrawUtils.getMessageWidth(textline_2, textFont, g)/2, 620);       
    }
}
