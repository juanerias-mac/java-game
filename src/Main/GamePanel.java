package Main;

import Entity.Player;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;


public class GamePanel extends JPanel implements Runnable{

    //screen settings
    final int originalTileSize = 16; // 16 x 16 tiles
    final int scale = 3;
     
    public final int tileSize = originalTileSize * scale; //48x48 tile size
    final int maxScreenCol = 16;
    final int maxScreenRow = 12;
    final int screenWidth = tileSize * maxScreenCol; //768px
    final int screenHeight = tileSize * maxScreenRow; //576 pixels


    //FPS
    int FPS = 60;

    KeyHandler keyH = new KeyHandler();
    Thread gameThread;
    Player player = new Player (this,keyH);

    //set players default position
    

    public GamePanel() {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true);
    }

    public void startGameThread() {
        gameThread = new Thread(this);
        gameThread.start();

    }

    @Override
    public void run(){

        double drawInterval = 1000000000/FPS; //0.01666 seconds, drawing the screen 60 times per second
        double nextDrawTime = System.nanoTime() + drawInterval;

        
        while(gameThread != null) {

            update();


            repaint();
          



            try {

                double remainingTime = nextDrawTime - System.nanoTime();
                remainingTime = remainingTime/1000000;
                if(remainingTime < 0 ){
                    remainingTime = 0;
                }

                Thread.sleep((long) remainingTime);
                
                nextDrawTime += drawInterval;
            } 
            catch (Exception e) {
                e.printStackTrace();
            }

            

        }



    }

    public void update() {
       player.update();

    }
    public void paintComponent(Graphics g) {
            super.paintComponent(g);

            Graphics2D g2 = (Graphics2D)g;

            player.draw(g2);

            g2.dispose();
    }
}
