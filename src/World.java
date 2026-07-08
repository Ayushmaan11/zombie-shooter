import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

import java.awt.*;

public class World {
    private int worldWidth = 5000;
    private int worldHeight = 5000;
    private Color grassColor =  new Color(51, 102, 0);
    private int waterBorder = 300;
    private Color waterColor = new Color (0, 0, 51);
    private BufferedImage grassTexture;
    private final int TILE_SIZE = 32;

    public World() {
        try {
            grassTexture = ImageIO.read(new File("assets/grass.png"));
            System.out.println("Grass texture loaded");
        } catch (IOException e) {}
    }
    public void drawWorld(Graphics g, Camera camera){
        int grassWidth = worldWidth-2*waterBorder;
        int grassHeight = worldHeight-2*waterBorder;

        int rows = grassHeight/TILE_SIZE;
        int columns= grassWidth/TILE_SIZE;
        g.setColor(waterColor);
        g.fillRect(-camera.getXPos(), -camera.getYPos(), worldWidth, worldHeight);
        for(int row = 0; row <rows; row++){

            for(int column = 0; column<columns; column++){
                int titleWorldX = waterBorder + column*TILE_SIZE;
                int titleWorldY = waterBorder + row*TILE_SIZE;
                int screenX = titleWorldX - camera.getXPos();
                int screenY = titleWorldY - camera.getYPos();
                g.drawImage(grassTexture,screenX,screenY,TILE_SIZE,TILE_SIZE,null);
            }
        }
    }

    public int getWorldWidth() {
        return worldWidth;
    }

    public int getWorldHeight() {
        return worldHeight;
    }

    public int getWaterBorder() {
        return waterBorder;
    }
}


