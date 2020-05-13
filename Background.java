import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import static java.lang.System.out;

/**
 * Write a description of class Background here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
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
