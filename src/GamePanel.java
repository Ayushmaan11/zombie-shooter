import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GamePanel extends JPanel implements ActionListener {

    private MainMenu mainMenu;
    private World world;
    private Player player;
    private Camera camera;

    private Timer timer;

    // Movement Keys
    private boolean up;
    private boolean down;
    private boolean left;
    private boolean right;

    private enum GameState {
        MENU,
        PLAYING,
        OPTIONS
    }

    private GameState gameState = GameState.MENU;

    public GamePanel() {

        mainMenu = new MainMenu();
        world = new World();
        player = new Player(world.getWorldWidth() / 2,
                world.getWorldHeight() / 2);

        camera = new Camera(1920,1080);

        setFocusable(true);

        addKeyListener(new KeyAdapter() {

            @Override
            public void keyPressed(KeyEvent e) {

                if(gameState == GameState.MENU){

                    switch(e.getKeyCode()){

                        case KeyEvent.VK_UP:
                            mainMenu.moveSelectionUp();
                            break;

                        case KeyEvent.VK_DOWN:
                            mainMenu.moveSelectionDown();
                            break;

                        case KeyEvent.VK_ENTER:

                            switch(mainMenu.getSelectedOption()){

                                case 0:
                                    gameState = GameState.PLAYING;
                                    break;

                                case 1:
                                    gameState = GameState.OPTIONS;
                                    break;

                                case 2:
                                    System.exit(0);
                            }

                            break;
                    }

                    return;
                }

                if(gameState != GameState.PLAYING)
                    return;

                switch(e.getKeyCode()){

                    case KeyEvent.VK_W:
                        up = true;
                        break;

                    case KeyEvent.VK_S:
                        down = true;
                        break;

                    case KeyEvent.VK_A:
                        left = true;
                        break;

                    case KeyEvent.VK_D:
                        right = true;
                        break;
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {

                switch(e.getKeyCode()){

                    case KeyEvent.VK_W:
                        up = false;
                        break;

                    case KeyEvent.VK_S:
                        down = false;
                        break;

                    case KeyEvent.VK_A:
                        left = false;
                        break;

                    case KeyEvent.VK_D:
                        right = false;
                        break;
                }
            }

        });

        timer = new Timer(16,this);
        timer.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(gameState == GameState.PLAYING){

            boolean moving = false;

            if(up &&
                    player.getYPos()-player.getSpeed() >= world.getWaterBorder()){

                player.moveUp();
                moving = true;
            }

            if(down &&
                    player.getYPos()+player.getHeight()+player.getSpeed()
                            <= world.getWorldHeight()-world.getWaterBorder()){

                player.moveDown();
                moving = true;
            }

            if(left &&
                    player.getXPos()-player.getSpeed() >= world.getWaterBorder()){

                player.moveLeft();
                moving = true;
            }

            if(right &&
                    player.getXPos()+player.getWidth()+player.getSpeed()
                            <= world.getWorldWidth()-world.getWaterBorder()){

                player.moveRight();
                moving = true;
            }

            if(moving){

                player.playWalkAnimation();

            }else{

                player.playIdleAnimation();
            }

            player.update();

            camera.follow(
                    player.getXPos(),
                    player.getYPos(),
                    world.getWorldWidth(),
                    world.getWorldHeight()
            );
        }

        repaint();
    }

    @Override
    protected void paintComponent(Graphics g){

        super.paintComponent(g);

        if(gameState == GameState.MENU){

            mainMenu.draw(g,getWidth(),getHeight());
        }

        else if(gameState == GameState.PLAYING){

            camera.setViewportSize(getWidth(),getHeight());

            world.drawWorld(g,camera);

            player.drawPlayer(g,camera);
        }
    }
}