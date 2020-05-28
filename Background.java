import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import static java.lang.System.out;

public class Background extends Actor
{  
    public void scroll()
    {
        if(getY() == 1080)
        {
            setLocation(getWorld().getWidth()/2, getY() - 1440);
        }
        setLocation(getX(), getY() + 5);
    }
}
