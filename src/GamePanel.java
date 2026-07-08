import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class GamePanel extends JPanel {
    private MainMenu mainMenu;
    private World world;
    private Player player;
    private Camera camera;
    private enum GameState {
        MENU,
        PLAYING,
        OPTIONS
    }
    GameState gameState = GameState.MENU;

    public GamePanel() {
        mainMenu = new MainMenu();
        world = new World();
        player = new Player(world.getWorldWidth()/2, world.getWorldHeight()/2);
        camera = new Camera(1920,  1080);
        setFocusable(true);

        addKeyListener(new KeyAdapter(){
            @Override
            public void keyPressed(KeyEvent e) {
                if(gameState == GameState.MENU) {
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
                else if(gameState == GameState.PLAYING){
                    if(e.getKeyCode() == KeyEvent.VK_W && player.getYPos()-player.getSpeed() >= 0){
                        player.moveUp();
                        repaint();
                    }else if(e.getKeyCode() == KeyEvent.VK_S && player.getYPos()+player.getHeight()+player.getSpeed() <= world.getWorldHeight()){
                        player.moveDown();
                        repaint();
                    }else if(e.getKeyCode() == KeyEvent.VK_A && player.getXPos()-player.getSpeed()>= 0){
                        player.moveLeft();
                        repaint();
                    }else if(e.getKeyCode() == KeyEvent.VK_D && player.getXPos()+player.getWidth()+player.getSpeed() <= world.getWorldWidth()){
                        player.moveRight();
                        repaint();
                    }
                }
            }
        });
    }



    @Override
    protected void paintComponent(Graphics g){

        super.paintComponent(g);
        if(gameState == GameState.MENU){
            mainMenu.draw(g, getWidth(), getHeight());
        }else if(gameState == GameState.PLAYING){
            camera.setViewportSize(getWidth(), getHeight());
            camera.follow(player.getXPos(),player.getYPos());
            System.out.println("Player X:" +  player.getXPos());
            System.out.println("Player Y:" +  player.getYPos());
            System.out.println("Camera X:" +  camera.getXPos());
            System.out.println("Camera Y:" +  camera.getYPos());
            world.drawWorld(g,camera);
            player.drawPlayer(g, camera);
        }
    }
}
