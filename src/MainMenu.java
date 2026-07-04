import java.awt.*;
import java.util.Arrays;

public class MainMenu {

    private String title = "Zombie Shooter Game";
    private String[] options = new String[3];
    private int selectedOption;
    private Color backgroundColor = Color.BLACK;
    private Color titleColor = Color.RED;
    private Color textColor =  Color.WHITE;
    private Color selectedColor =  Color.green;
    private Font titleFont = new  Font("Arial", Font.BOLD, 60);
    private Font menuFont = new  Font("Arial", Font.BOLD, 30);
    // position properties; these will be calculated
    FontMetrics fontMetrics;
    MainMenu(){
        title = "Zombie Shooter Game";
        options[0] = "New Game";
        options[1] = "Options";
        options[2] = "Exit";

    }

    public void draw(Graphics g, int width, int height){
        fontMetrics = g.getFontMetrics(titleFont);
        int textWidth = fontMetrics.stringWidth(title);
        g.setColor(backgroundColor);
        g.fillRect(0,0,width,height);
        g.setFont(titleFont);
        g.setColor(titleColor);
        g.drawString(title,(width-textWidth)/2,200);
        g.setColor(textColor);
        g.setFont(menuFont);
        g.drawString(options[0],100,320);
        g.drawString(options[1],100,420);
        g.drawString(options[2],100,520);

    }

    public void update(){

    }
    public void mouseClicked(){
        
    }
}