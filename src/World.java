import java.awt.*;

public class World {
    private int worldWidth = 5000;
    private int worldHeight = 5000;
    private Color grassColor =  new Color(51, 102, 0);
    private int waterBorder = 300;
    private Color waterColor = new Color (0, 0, 51);

    public void drawWorld(Graphics g, Camera camera){
        g.setColor(waterColor);
        g.fillRect(-camera.getXPos(), -camera.getYPos(), worldWidth, worldHeight);
        g.setColor(grassColor);
        g.fillRect(300-camera.getXPos(), 300-camera.getYPos(), worldWidth - 2*waterBorder, worldHeight - 2*waterBorder);
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


