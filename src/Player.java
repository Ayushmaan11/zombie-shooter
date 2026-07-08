import java.awt.*;

public class Player {

    private int xPos = 500;
    private int yPos = 300;
    private int width = 20;
    private int height = 30;
    private int speed = 7 ;
    private Color color = Color.black;

    public Player(int x, int y) {
        this.xPos = x;
        this.yPos = y;
    }
    public void drawPlayer(Graphics g,  Camera camera) {
        g.setColor(color);
        g.fillRect( xPos - camera.getXPos(),yPos - camera.getYPos(),width, height);
    }

    public int getXPos() {
        return xPos;
    }

    public int  getYPos() {
        return yPos;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getSpeed() {
        return speed;
    }

    public void moveUp() {
        yPos -= speed;
    }

    


    public void moveDown() {
        yPos += speed;
    }
    public void moveLeft() {
        xPos -= speed;
    }
    public void moveRight() {
        xPos += speed;
    }

}



