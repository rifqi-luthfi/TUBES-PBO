
package tubes2048;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/**
 *
 * @author naufa
 */
public class ScoreManager {
    
    //current score
    private int currentScore ;
    private int currentTopScore;
    private int[] board = new int[GameBoard.ROWS*GameBoard.COLS];
    
    //File
    private String filePath;
    private String temp ="Temp.tmp";
    private GameBoard gBoard;
    
    //boolean
    private boolean newGame;
    
    public ScoreManager(GameBoard gBoard){
        this.gBoard=gBoard;
        filePath = new File("").getAbsolutePath();      
    }
    
  
    public void reset(){
        File f= new File(filePath,temp);
        if(f.isFile()){
            f.delete();
        }
        newGame=true;
        currentScore=0;
        //currentTopScore=0;
    }
    
    private void createFile(){
        FileWriter output = null;
        newGame=true;
        
        try{
            File f= new File(filePath,temp);
            output= new FileWriter(f);
            BufferedWriter writer = new BufferedWriter(output);
            writer.write(""+0);
            writer.newLine();
            writer.write(""+0);
            writer.newLine();                    
            writer.write(""+0);
            writer.newLine();
            writer.write(""+0);
            writer.newLine();                    
            for(int row =0; row<GameBoard.ROWS;row++){
                for(int col =0; col<GameBoard.COLS;col++){
                    if(row==GameBoard.ROWS-1&&col==GameBoard.COLS-1){
                        writer.write(""+0);
                    }
                    else {
                        writer.write(0+"-");
                    }
                }
            }
            writer.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public void saveGame(){
        FileWriter output = null;
        if(newGame)newGame=false;
        
        try{
            File f = new File(filePath,temp);
            output= new FileWriter(f);
            BufferedWriter writer = new BufferedWriter(output);
            writer.write(""+currentScore);
            writer.newLine();
            writer.write(""+currentTopScore);
            writer.newLine();         
            
            for(int row =0; row<GameBoard.ROWS;row++){
                for(int col =0; col<GameBoard.COLS;col++){                    
                    int location = row*GameBoard.COLS+col; // merubah 2 koordinat menjadi 1
                    Tile tile = gBoard.getBoard()[row][col];
                    this.board[location]= tile != null ? tile.getValue():0;
                    //this.board[row * GameBoard.COLS + col] = gBoard.getBoard()[row][col] != null ? gBoard.getBoard()[row][col].getValue() : 0;
                    if(row==GameBoard.ROWS-1&&col==GameBoard.COLS-1){
                        //writer.write("" + board[row * GameBoard.COLS + col]);
                        writer.write(""+board[location]);
                    }
                    else {
                        //writer.write(board[row * GameBoard.COLS + col] + "-");
                        writer.write(board[location]+"-");
                    }
                }
            }
            writer.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public void loadGame(){       
        try{            
            File f = new File(filePath,temp);
            
            if(!f.isFile()){
                createFile();
            }
            
            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(f)));
            currentScore = Integer.parseInt(reader.readLine());
            currentTopScore = Integer.parseInt(reader.readLine());           
            String[] board = reader.readLine().split("-");
            for(int i =0; i<board.length;i++){
                this.board[i]=Integer.parseInt(board[i]);
            }
            reader.close();
        }catch(Exception e){            
            e.printStackTrace();
        }
    }

    public int getCurrentScore() {
        return currentScore;
    }

    public void setCurrentScore(int currentScore) {
        this.currentScore = currentScore;
    }

    public int getCurrentTopScore() {
        return currentTopScore;
    }

    public void setCurrentTopScore(int currentTopScore) {
        this.currentTopScore = currentTopScore;
    }

    public int[] getBoard() {
        return board;
    }

    public boolean NewGame() {
        return newGame;
    }
}
