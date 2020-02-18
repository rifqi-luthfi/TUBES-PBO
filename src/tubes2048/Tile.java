/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tubes2048;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

/**
 *
 * @author naufa
 */
public class Tile {
    public static final int WIDTH=80;
    public static final int HEIGHT=80;
    public static final int SLIDE_SPEED=20; 
    public static final int ARC_WIDTH=15;
    public static final int ARC_HEIGHT=15;
    
    private int value;
    private BufferedImage tileImage;
    private Color background;
    private Color text;
    private Font font;
    private Point slideTo;
    private int x;
    private int y;
    
    private boolean canCombine=true;
    
    public Tile(int value,int x,int y){
        this.value=value;
        this.x=x;
        this.y=y;
        slideTo=new Point(x,y);
        tileImage=new BufferedImage(WIDTH,HEIGHT,BufferedImage.TYPE_INT_ARGB);
        drawImage();
    }
    public void drawImage(){
        Graphics2D g=(Graphics2D)tileImage.getGraphics();
        if(value==2){
            background=new Color(238,228,218);
            text= new Color(119,110,101); 
        }
        else if(value==4){
            background=new Color(237,224,198);
            text= new Color(119,110,101); 
        }      
        else if(value==8){
            background=new Color(242,177,121);
            text= new Color(249,246,242); 
        }      
        else if(value==16){
            background=new Color(245,150,99);
            text= new Color(249,246,242); 
        }      
        else if(value==32){
            background=new Color(246,124,95);
            text= new Color(249,246,242); 
        }      
        else if(value==64){
            background=new Color(246,94,59);
            text= new Color(249,246,242); 
        }      
        else if(value==128){
            background=new Color(237,207,114);
            text= new Color(249,246,242); 
        }      
        else if(value==256){
            background=new Color(237,204,96);
            text= new Color(249,246,242); 
        }      
        else if(value==512){
            background=new Color(236,200,80);
            text= new Color(249,246,242); 
        }      
        else if(value==1024){
            background=new Color(237,197,65);
            text= new Color(119,110,101); 
        }      
        else if(value==2048){
            background=new Color(230,190,0);
            text= new Color(119,110,101); 
        }else{
            background=Color.black;
            text=Color.white;
        }   
        g.setColor(new Color(0,0,0,0));
        g.fillRect(0, 0, WIDTH, HEIGHT);
            
        g.setColor(background);
        g.fillRoundRect(0,0, WIDTH, HEIGHT, ARC_WIDTH, ARC_HEIGHT);
            
        g.setColor(text);
            
        if(value<=64){
            font = Game.main.deriveFont(36f);
        }
        else {
            font=Game.main;
        }
        g.setFont(font);      
            
        int drawX=WIDTH/2 - DrawUtils.getMessageWidth(""+value,font,g)/2;
        int drawY=HEIGHT/2 + DrawUtils.getMessageHeight(""+value,font,g)/2;
        g.drawString(""+value,drawX,drawY);
        g.dispose();
              
    }
    public void update(){
        
    }
    public void render(Graphics2D g){
        g.drawImage(tileImage, x, y, null);
    }
    
    public int getValue(){
        return value;
    }
    
    public void setValue(int value){
        this.value=value;
        drawImage();
    }
    
    public boolean canCombine() {
        return canCombine;
    }

    public void setCanCombine(boolean canCombine) {
        this.canCombine = canCombine;
    }

    public Point getSlideTo() {
        return slideTo;
    }

    public void setSlideTo(Point slideTo) {
        this.slideTo = slideTo;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
