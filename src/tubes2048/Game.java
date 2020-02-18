/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tubes2048;

import GUI.GuiScreen;
import GUI.HowtoPlayPanel;
import GUI.MainMenuPanel;
import GUI.PlayPanel;
import GUI.LeaderboardPanel;
import GUI.HowtoPlayPanel;
import GUI.faqpanel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

/**
 *
 * @author naufa
 */
public class Game extends JPanel implements KeyListener,MouseListener, MouseMotionListener, Runnable {
     
    private static final long serialVersionUID=1L;
    public static final int WIDTH=400;
    public static final int HEIGHT=630;
    public static final Font main = new Font("Clear Sans Medium",Font.PLAIN,28);
    private Thread game;
    private boolean running;
    private BufferedImage image = new BufferedImage(WIDTH,HEIGHT,BufferedImage.TYPE_INT_RGB);
    private GuiScreen screen;
    
    private long startTime;
    private long elapsed;
    private boolean set;
    
    public Game(){
        setFocusable(true);
        setPreferredSize(new Dimension(WIDTH,HEIGHT));
        addKeyListener(this);
        addMouseListener(this);
        addMouseMotionListener(this);
        
        screen = GuiScreen.getInstance();
        screen.add("Menu",new MainMenuPanel());
        screen.add("Play",new PlayPanel());
        screen.add("Leaderboard",new LeaderboardPanel());
        screen.add("HowtoPlay",new HowtoPlayPanel());
        screen.add("faq", new faqpanel());
               
        screen.setCurrentPanel("Menu");
        
    }
    
    private void update(){
        screen.update();
        Keyboard.update();
    }
    
    private void render(){
        Graphics2D g = (Graphics2D)image.getGraphics(); // membuat image 
        Color bg = new Color(251,248,239);
        g.setColor(bg);                       // set warna image(Background) ClearScreen
        g.fillRect(0,0, WIDTH, HEIGHT);                // mengisi kotak 
        // render papan
        screen.render(g);
        g.dispose();
               
        Graphics2D g2d = (Graphics2D) getGraphics();
        g2d.drawImage(image,0,0,null);  // grafik Jpanel sebenarnya dengan mengambil get graphics dari g
        g2d.dispose();
    }

    @Override
    public void keyTyped(KeyEvent e) {    
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
       Keyboard.keyPressed(e);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        Keyboard.keyReleased(e);
    }

    @Override
    public void run() {
        int fps=0;
        int updates=0;
        long fpsTimer = System.currentTimeMillis();
        double nsPerUpdate = 1000000000.0/60;
       
        //last update nanodetik
        double then = System.nanoTime();
        double unprocessed=0;
        
        
        while(running){          
            boolean shouldRender = false;
            double now=System.nanoTime();
            unprocessed+=(now-then)/nsPerUpdate;
            then=now;                     
            
            // update queue
            while (unprocessed>=1){
                updates++;
                update();
                unprocessed--;
                shouldRender=true;
            }
       
            // rendering
            if(shouldRender){
                fps++;
                render();
                shouldRender=false;          
            }
            else{
                try{
                    Thread.sleep(1);              
                }
                catch(Exception e){
                    e.printStackTrace();
                }
            }
        }
        
        //FPS timer
        if(System.currentTimeMillis()-fpsTimer>1000){
            System.out.printf("%d fps %d updates",fps,updates);
            System.out.println();
            fps=0;
            updates=0;
            fpsTimer+=1000;
        }
    }
    
    public synchronized void start(){
        if(running)return;
        running=true;
        game= new Thread(this,"game");
        game.start();       
    }
    public synchronized void stop(){
        if(!running)return;
        running=false;
        System.exit(0);   
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        
    }

    @Override
    public void mousePressed(MouseEvent e) {
        screen.mousePressed(e);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        screen.mouseReleased(e);
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
       
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        screen.mouseDragged(e);
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        screen.mouseMoved(e);
    }
    
}
