import java.awt.image.BufferedImage;

public class Animation {

    private BufferedImage[] frames;

    private int currentFrame;
    private int frameCounter;
    private int frameDelay;

    private boolean loop;
    private boolean finished;

    public Animation(BufferedImage[] frames, int frameDelay) {
        this(frames, frameDelay, true);
    }

    public Animation(BufferedImage[] frames, int frameDelay, boolean loop) {

        this.frames = frames;
        this.frameDelay = frameDelay;
        this.loop = loop;

        currentFrame = 0;
        frameCounter = 0;
        finished = false;
    }

    public void update() {

        if (frames == null || frames.length <= 1)
            return;

        if (finished)
            return;

        frameCounter++;

        if (frameCounter >= frameDelay) {

            frameCounter = 0;
            currentFrame++;

            if (currentFrame >= frames.length) {

                if (loop) {

                    currentFrame = 0;

                } else {

                    currentFrame = frames.length - 1;
                    finished = true;
                }
            }
        }
    }

    public BufferedImage getCurrentFrame() {
        return frames[currentFrame];
    }

    public void reset() {
        currentFrame = 0;
        frameCounter = 0;
        finished = false;
    }

    public void setFrameDelay(int frameDelay) {
        this.frameDelay = frameDelay;
    }

    public boolean isFinished() {
        return finished;
    }

    public int getCurrentFrameIndex() {
        return currentFrame;
    }
}