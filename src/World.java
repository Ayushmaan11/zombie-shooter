import java.awt.*;

public class World {
    private int worldWidth = 5000;
    private int worldHeight = 5000;
    private Color grassColor =  new Color(51, 102, 0);
    private Color waterColor;

    public void drawWorld(Graphics g){
        g.setColor(grassColor);
        g.fillRect(0, 0, worldWidth, worldHeight);
    }

    public int getWorldWidth() {
        return worldWidth;
    }

    public int getWorldHeight() {
        return worldHeight;
    }
}


