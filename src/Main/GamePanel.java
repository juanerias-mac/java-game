package Main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;


public class GamePanel extends JPanel implements Runnable{

    //screen settings
    final int originalTileSize = 16; // 16 x 16 tiles
    final int scale = 3;
     
    final int tileSize = originalTileSize * scale; //48x48 tile size
    final int maxScreenCol = 16;
    final int maxScreenRow = 12;
    final int screenWidth = tileSize * maxScreenCol; //768px
    final int screenHeight = tileSize * maxScreenRow; //576 pixels

    Thread gameThread;


    public GamePanel() {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
    }

    public void startGameThread() {
        gameThread = new Thread(this);
        gameThread.start();

    }

    @Override
    public void run(){
        
        while(gameThread != null) {




            //1 UPDATEL update information like character position
            update();


            //2 DRAW: draw the screen with the updated information

            repaint();


            //this loop is used to update information such as character position and drawing the screen with the updated information 
            //System.out.println("The game loop is running"); (this is a test of the gameloop)



        }



    }

    public void update() {

    }
    public void paintComponent(Graphics g) {
            super.paintComponent(g);

            Graphics2D g2 = (Graphics2D)g;

            g2.setColor(Color.white);

            g2.fillRect(100, 100, tileSize, tileSize);

            g2.dispose();
    }
}
