import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class GamePanel extends JPanel {
    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);

        g.setColor(Color.GREEN);
        g.fillRect(0,0,getWidth(),getHeight());
    }
}
