import greenfoot.Actor;
import greenfoot.GreenfootImage;


public class Click extends Actor {
    private static final int MAX_TRANSPARENCY = 255;
    private static final int OFFSET_TRANSPARENCY = 10;
    private long timeLastAdded = System.currentTimeMillis();
    private int currentTransparency = 255;
    private int direction = 1;
    
    
    public Click(){
    }

    public void act() {
        long curTime = System.currentTimeMillis();
        if (curTime >= timeLastAdded + 15) {
            flashingButton();
            timeLastAdded = curTime;
        }
    }

    public void flashingButton() {
        
        currentTransparency += OFFSET_TRANSPARENCY * direction;
        if (currentTransparency >= MAX_TRANSPARENCY || currentTransparency < 0) {
            direction *= -1;
            currentTransparency += OFFSET_TRANSPARENCY * direction;
        }
        GreenfootImage image = getImage();
        image.setTransparency(currentTransparency);
        setImage(image);
    }

}
