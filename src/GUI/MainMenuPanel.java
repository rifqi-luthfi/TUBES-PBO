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

/**
 *
 * @author naufa
 */
public class MainMenuPanel extends GuiPanel{

    private Font titleFont = Game.main.deriveFont(70f);
    private String title = "GAME 2048";
    private int buttonWidth = 220;
    private int spacing = 90;
    private int buttonHeight = 60;
    
    
    public MainMenuPanel() {
        super();
        
        GuiButton playButton = new GuiButton(Game.WIDTH / 2 - buttonWidth / 2, 220, buttonWidth, buttonHeight );
        GuiButton scoresButton = new GuiButton(Game.WIDTH / 2 - buttonWidth / 2, playButton.getY()+spacing,buttonWidth, buttonHeight );
        GuiButton helpButton = new GuiButton(Game.WIDTH / 2 - buttonWidth / 2, scoresButton.getY()+spacing,buttonWidth, buttonHeight );
        GuiButton quitButton = new GuiButton(Game.WIDTH / 2 - buttonWidth / 2, helpButton.getY()+spacing, buttonWidth, buttonHeight);
        GuiButton aboutButton = new GuiButton(380, 610, 20, 20);
        GuiButton faqButton = new GuiButton(300, 610, 70, 20);
        
        playButton.setText("Main");
        scoresButton.setText("Peringkat");      
        helpButton.setText("Cara Bermain");
        quitButton.setText("Keluar");
        aboutButton.setText("?");
        faqButton.setText("F.A.Q");
       
        playButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                GuiScreen.getInstance().setCurrentPanel("Play");
            }
        });
        
        scoresButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GuiScreen.getInstance().setCurrentPanel("Leaderboard");
            }
        });
        
        helpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GuiScreen.getInstance().setCurrentPanel("HowtoPlay");
            }
        });
        
        quitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        
        aboutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Credit().setVisible(true);
              
            }
        });
        
        faqButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GuiScreen.getInstance().setCurrentPanel("faq");
            }
        });             
        add(playButton);
        add(scoresButton);
        add(quitButton);
        add(helpButton);
        add(aboutButton);
        add(faqButton);
    }
    @Override
    public void render(Graphics2D g){
        super.render(g);
        g.setFont(titleFont);
        g.setColor(Color.black);
        g.drawString(title, Game.WIDTH/2-DrawUtils.getMessageWidth(title, titleFont, g)/2, 150);        
    }
}
