package Main;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JPanel;

public class GamePanel extends JPanel{

    //screen settings
    final int originalTileSize = 16; // 16 x 16 tiles
    final int scale = 3;
     
    final int tileSize = originalTileSize * scale; //48x48 tile size
    final int maxScreenCol = 16;
    final int maxScreenRow = 12;
    final int screenWidth = tileSize * maxScreenCol; //768px
    final int screenHeight = tileSize * maxScreenRow; //576 pixels


    public GamePanel() {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
    }
}
