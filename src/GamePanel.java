import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class GamePanel extends JPanel {
    private MainMenu mainMenu;


    public GamePanel() {
        mainMenu = new MainMenu();
        setFocusable(true);

        addKeyListener(new KeyAdapter(){
            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyText(e.getKeyCode()).equals("Up")){
                    mainMenu.moveSelectionUp();
                    repaint();
                }
                else if(e.getKeyText(e.getKeyCode()).equals("Down")){
                    mainMenu.moveSelectionDown();
                    repaint();
                }
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(Color.GREEN);
        g.fillRect(0,0,getWidth(),getHeight());
        mainMenu.draw(g, getWidth(), getHeight());
    }

}
