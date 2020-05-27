import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import static java.lang.System.out; 

public class Click extends Actor
{
    public static int maxTransparency = 255;
    long TimelastAdded = System.currentTimeMillis();
    
    public void act() 
    { 
        long curTime  = System.currentTimeMillis();
        if (curTime >= TimelastAdded + 5000)
        {
            flashingButton(0);
            TimelastAdded  = curTime;
        }
        else
            flashingButton(maxTransparency);
    }    

    public void flashingButton(int adjust)
    {
        GreenfootImage image = getImage();
        image.setTransparency(adjust);
        setImage(image);
    }

}
