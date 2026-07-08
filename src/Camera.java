public class Camera {
    private int xPos ;
    private int yPos ;
    private int viewportWidth;
    private int viewportHeight;


    public Camera(int viewWidth, int viewHeight){
        this.viewportWidth = viewWidth;
        this.viewportHeight = viewHeight;
    }

    public void follow(int playerX, int playerY){
        xPos = playerX-viewportWidth/2;
        if(xPos < 0){
            xPos = 0;
        }
        yPos = playerY-viewportHeight/2;
        if(yPos < 0){
            yPos = 0;
        }
    }

    public void setViewportSize(int width, int height){
        this.viewportWidth = width;
        this.viewportHeight = height;
    }


    public int getXPos(){
        return xPos;
    }

    public int getYPos(){
        return yPos;
    }
}
