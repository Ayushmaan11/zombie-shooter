import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class GamePanel extends JPanel {
    private MainMenu mainMenu;
    private World world;
    private enum GameState {
        MENU,
        PLAYING,
        OPTIONS
    }
    GameState gameState = GameState.MENU;


    public GamePanel() {
        mainMenu = new MainMenu();
        world = new World();
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
                }else if(e.getKeyText(e.getKeyCode()).equals("Enter")){
                    int option = mainMenu.getSelectedOption();
                    if(option == 0){
                        gameState = GameState.PLAYING;
                        repaint();
                    }else if(option == 1){
                        gameState = GameState.OPTIONS;
                    } else if (option == 2) {
                        System.exit(0);
                    }
                }
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(Color.GREEN);
        g.fillRect(0,0,getWidth(),getHeight());
        if(gameState == GameState.MENU){
            mainMenu.draw(g, getWidth(), getHeight());
        }else if(gameState == GameState.PLAYING){
            world.drawWorld(g);
        }
    }

}
