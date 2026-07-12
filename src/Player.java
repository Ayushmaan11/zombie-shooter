import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Player {

    //-----------------------------
    // Position
    //-----------------------------
    private int xPos;
    private int yPos;

    private final int speed = 7;

    //-----------------------------
    // Drawing Size
    //-----------------------------
    private final int drawWidth = 64;
    private final int drawHeight = 64;

    //-----------------------------
    // Collision
    //-----------------------------
    private final int collisionWidth = 22;
    private final int collisionHeight = 30;

    //-----------------------------
    // Direction
    //-----------------------------
    private Direction direction = Direction.DOWN;

    //-----------------------------
    // Animation State
    //-----------------------------
    private boolean moving = false;

    //-----------------------------
    // Sprite Sheet
    //-----------------------------
    private BufferedImage sheetImage;

    //-----------------------------
    // Idle Frames
    //-----------------------------
    private BufferedImage[] idleDownFrames = new BufferedImage[3];
    private BufferedImage[] idleUpFrames = new BufferedImage[2];
    private BufferedImage[] idleSideFrames = new BufferedImage[2];

    //-----------------------------
    // Walk Frames
    //-----------------------------
    private BufferedImage[] walkDownFrames = new BufferedImage[6];
    private BufferedImage[] walkSideFrames = new BufferedImage[6];

    //-----------------------------
    // Animations
    //-----------------------------
    private Animation idleDown;
    private Animation idleUp;
    private Animation idleSide;

    private Animation walkDown;
    private Animation walkSide;

    private Animation currentAnimation;

    //-----------------------------
    // Constructor
    //-----------------------------
    public Player(int x, int y) {

        xPos = x;
        yPos = y;

        try {

            sheetImage = ImageIO.read(new File("assets/player.png"));

        } catch (IOException e) {

            e.printStackTrace();
        }

        SpriteSheet sheet = new SpriteSheet(
                sheetImage,
                192,
                192,
                0,
                0,
                0,
                0
        );

        //----------------------------------
        // Idle Down
        //----------------------------------

        idleDownFrames[0] = sheet.getFrame(0,1);
        idleDownFrames[1] = sheet.getFrame(0,2);
        idleDownFrames[2] = sheet.getFrame(0,3);

        //----------------------------------
        // Idle Up
        //----------------------------------

        idleUpFrames[0] = sheet.getFrame(0,0);
        idleUpFrames[1] = sheet.getFrame(0,6);

        //----------------------------------
        // Idle Side
        //----------------------------------

        idleSideFrames[0] = sheet.getFrame(0,4);
        idleSideFrames[1] = sheet.getFrame(0,5);

        //----------------------------------
        // Walk Down
        //----------------------------------

        for(int i=0;i<6;i++){

            walkDownFrames[i]=sheet.getFrame(1,i+1);

        }

        //----------------------------------
        // Walk Side
        //----------------------------------

        for(int i=0;i<6;i++){

            walkSideFrames[i]=sheet.getFrame(2,i+1);

        }

        //----------------------------------
        // Create Animations
        //----------------------------------

        idleDown = new Animation(idleDownFrames,15,true);
        idleUp = new Animation(idleUpFrames,20,true);
        idleSide = new Animation(idleSideFrames,18,true);

        walkDown = new Animation(walkDownFrames,8,true);
        walkSide = new Animation(walkSideFrames,8,true);

        currentAnimation = idleDown;
    }
