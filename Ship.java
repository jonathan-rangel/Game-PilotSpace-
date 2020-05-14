import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
import static java.lang.System.out;
/**
 * Write a description of class Ship here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Ship extends Actor implements FireShip
{
    private int dirx;
    private int diry;
    private int rotaX;
    private int rotaY;
    private int i = 1;
    private static int rot;

    public void fire()
    {
        FireShipPilot fire = new FireShipPilot();
        getWorld().addObject(fire, getX(), getY());
        fire.setRotation(getRotation() - 90);
        int i = getRotation();
        rot = i;
    }

    public static int getRotations()
    {
        return rot;
    }

    public void act() 
    {   
        dirx = getX();
        diry = getY();
        MouseInfo mi = Greenfoot.getMouseInfo();
        if (mi != null)
        {
            int buttonNumber = mi.getButton();
            if (buttonNumber == 1)
            {
                fire();
            }
        }

        if(Greenfoot.isKeyDown("d"))
        {
            dirx+=2;
            setLocation(dirx,diry);
        }
        if(Greenfoot.isKeyDown("a"))
        {
            dirx-=2;
            setLocation(dirx,diry);
        }
        if(Greenfoot.isKeyDown("w"))
        {
            diry-=2;
            setLocation(dirx,diry);
        }
        if(Greenfoot.isKeyDown("s"))
        {
            diry+=2;
            setLocation(dirx,diry);
        }
        if(Greenfoot.mouseMoved(null))
        {
            MouseInfo mouse = Greenfoot.getMouseInfo();
            rotaX = mouse.getX() - getX();
            rotaY = mouse.getY() - getY();
            double r = Math.toDegrees(Math.atan2(rotaX, rotaY));
            setRotation(-(int) r);
        }
        if(getY() == 0)
            setLocation(getX(), getWorld().getHeight());
        if(getY() == getWorld().getHeight()+2)
            setLocation(getX(), 2);
        if(getX() == 0)
            setLocation(getWorld().getWidth(), getY());
        if(getX() == getWorld().getWidth()+2)
            setLocation(2, getY());    
        if(isTouching(FireShipA.class))
        {
            getWorld().removeObject(this);
        }
        else
        {
            if(isTouching(AlienShip.class))
            {
                Greenfoot.setWorld(new BackgroundType());
                getWorld().removeObject(this);
            }
        }

    }
}
