import java.awt.image.BufferedImage;




public class Animation {
    private BufferedImage[] frames;
    private int currentFrame ;
    private int frameDelay;
    private int frameCounter;

    public Animation(BufferedImage[] frames, int frameDelay) {
        this.frameDelay = frameDelay;
        this.frames = frames;
        this.currentFrame = 0;
        this.frameCounter = 0;
    }

    public void update() {
        frameCounter++;
        if (frameCounter >= frameDelay) {
            frameCounter = 0;
            currentFrame++;
            if(currentFrame >= frames.length) {   
                currentFrame = 0;
            }
        }
    }
    }

 