import java.awt.image.BufferedImage;

public class SpriteSheet {

    private BufferedImage spriteSheet;

    private int frameWidth;
    private int frameHeight;

    private int startX;
    private int startY;

    // Space between frames (0 for most sprite sheets)
    private int paddingX;
    private int paddingY;

    public SpriteSheet(BufferedImage spriteSheet,
                       int frameWidth,
                       int frameHeight,
                       int startX,
                       int startY,
                       int paddingX,
                       int paddingY) {

        this.spriteSheet = spriteSheet;

        this.frameWidth = frameWidth;
        this.frameHeight = frameHeight;

        this.startX = startX;
        this.startY = startY;

        this.paddingX = paddingX;
        this.paddingY = paddingY;
    }

    public BufferedImage getFrame(int row, int col) {

        int x = startX + col * (frameWidth + paddingX);
        int y = startY + row * (frameHeight + paddingY);

        return spriteSheet.getSubimage(x, y, frameWidth, frameHeight);
    }
}