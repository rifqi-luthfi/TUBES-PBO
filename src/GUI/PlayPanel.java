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
import java.util.concurrent.TimeUnit;

import tubes2048.DrawUtils;
import tubes2048.Game;
import tubes2048.GameBoard;
import tubes2048.ScoreManager;

/**
 *
 * @author naufa
 */
public class PlayPanel extends GuiPanel {
    private GameBoard board;
    private BufferedImage info;
    private ScoreManager scores;
    private Font scoreFont;
       
    //game over
    private GuiButton TryAgain;
    private GuiButton MainMenu;
    private GuiButton Continue;
    private GuiButton Home;
    
    private int ButtonWidth=320;
    private int ButtonHeight=50;
    private boolean added;
    
    private int spacing =20;  
    private int alpha;
    private Font gameOverFont;
    private Font winFont;
    
    private int i=0;
    
    public PlayPanel(){
        scoreFont = Game.main.deriveFont(24f);
        gameOverFont = Game.main.deriveFont(70f);
        winFont = Game.main.deriveFont(70f);
        
        board = new GameBoard(Game.WIDTH/2-GameBoard.BOARD_WIDTH/2,Game.HEIGHT-GameBoard.BOARD_HEIGHT-20);
        scores=board.getScores();
        info = new BufferedImage(Game.WIDTH,200,BufferedImage.TYPE_INT_RGB);
        
        MainMenu = new GuiButton(Game.WIDTH/2-ButtonWidth/2,450,ButtonWidth,ButtonHeight);
        TryAgain = new GuiButton(MainMenu.getX(),MainMenu.getY()-spacing-ButtonHeight,ButtonWidth,ButtonHeight);
        Continue = new GuiButton(MainMenu.getX(),MainMenu.getY()-spacing-ButtonHeight,ButtonWidth,ButtonHeight);
        Home =  new GuiButton(Game.WIDTH/2-GameBoard.BOARD_WIDTH/2, 170, 55 , 40);
      
        TryAgain.setText("Coba Lagi");
        MainMenu.setText("Kembali ke Menu");
        Continue.setText("Lanjut Main");
        Home.setText("Balik");
        
        add(Home);
            
        TryAgain.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                board.getScores().reset();
                board.reset();
                alpha = 0;
                
                add(Home);
                remove(TryAgain);
                remove(MainMenu);
                
                added=false;          
            }
        });
        MainMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {              
                GuiScreen.getInstance().setCurrentPanel("Menu");         
            }
        });
        
        Continue.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {                 
                add(Home);
                remove(Continue);
                remove(MainMenu);                                   
                added=false;                 
            }
        });        
        Home.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {                                
                GuiScreen.getInstance().setCurrentPanel("Menu");                
            }
        });        
       
        
    }
    
    private void drawGui(Graphics2D g){
        Graphics2D g2d = (Graphics2D) info.getGraphics();
        Color bg = new Color(251,248,239);     
	g2d.setColor(bg);
	g2d.fillRect(0, 0, info.getWidth(), info.getHeight());
	g2d.setColor(Color.lightGray);
	g2d.setFont(scoreFont);
	g2d.drawString("" + scores.getCurrentScore(), 30, 40);
	g2d.setColor(Color.red);
	g2d.drawString("Terbaik: " + scores.getCurrentTopScore(), 
            Game.WIDTH - DrawUtils.getMessageWidth("Terbaik: " + scores.getCurrentTopScore(),
                    scoreFont, g2d) - 20, 40);	
	g2d.dispose();
	g.drawImage(info, 0, 0, null);    
    }
    
    public void drawGameOver(Graphics2D g){
        g.setColor(new Color(222,222,222,alpha));
        g.fillRect(0, 0, Game.WIDTH, Game.HEIGHT);
        g.setColor(Color.red);
        g.setFont(gameOverFont);
        g.drawString("Yah Kalah", Game.WIDTH / 2 - DrawUtils.getMessageWidth("Yah Kalah", gameOverFont, g) / 2, 150);       
    }
    
    public void drawWin(Graphics2D g){
        g.setColor(new Color(222,222,222,alpha));
        g.fillRect(0, 0, Game.WIDTH, Game.HEIGHT);
        g.setColor(Color.black);
        g.setFont(winFont);
        g.drawString("Yee Menang", Game.WIDTH / 2 - DrawUtils.getMessageWidth("Yee menang", winFont, g) / 2, 150);  
    }
         
    @Override
    public void update(){
        board.update();
        if(board.isLose()){
            alpha++;
            if (alpha > 170) alpha = 170;
        }
    }
    
    @Override
    public void render(Graphics2D g){
        drawGui(g);       
        board.render(g);   
        if(board.isLose()){
            if(!added){
                added = true;  
                remove(Home);
                add(MainMenu);
                add(TryAgain);                
            }
            drawGameOver(g);
        }
        // tambah animasi win di sini
        else if(board.isWin()){
            if(!added && i==0){
                added = true;  
                remove(Home);
                add(MainMenu);
                add(Continue);            
                boolean x=false;
                board.setWin(x);
                i=1;
            }
            drawWin(g);            
        }         
        super.render(g);
    } 
    
}
