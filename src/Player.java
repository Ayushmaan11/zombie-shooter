import java.awt.*;

public class Player {


    private int xPos = 500;
    private int yPos = 100;
    private int width = 20;
    private int height = 30;
    private int speed;
    private Color color = Color.black;

    public Player(int x, int y) {
        this.xPos = x;
        this.yPos = y;
    }
    public void drawPlayer(Graphics g){
        g.setColor(color);
        g.fillRect( xPos,yPos,width, height);
    }

}



