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
    private int moveXShip;
    private int moveYShip;
    private int rotationXShip;
    private int rotationYShip;
    private int i = 1;
    private static int rotationShip;
    String lastKey;

    public void fire()
    {
        FireShipPilot fire = new FireShipPilot();
        getWorld().addObject(fire, getX(), getY());
        fire.setRotation(getRotation() - 90);
        int i = getRotation();
        rotationShip = i;
    }

    public static int getRotations()
    {
        return rotationShip;
    }

    public void act() 
    {   
        moveShip();

        rotationShip();
        
        fireShipDirection();
        
        moveShipAtAnotherEdgeOfTheSpace();
        
        deleteShip();   
    }

    public void moveShip()
    {
        moveXShip = getX();
        moveYShip = getY();
        if(Greenfoot.isKeyDown("a"))
            moveXShip-=2;
        if(Greenfoot.isKeyDown("w"))
            moveYShip-=2;
        if(Greenfoot.isKeyDown("s"))
            moveYShip+=2;
        if(Greenfoot.isKeyDown("d"))
            moveXShip+=2;

        setLocation(moveXShip,moveYShip);
    }
    
    public void rotationShip()
    {
        if(Greenfoot.mouseMoved(null))
        {
            MouseInfo mouse = Greenfoot.getMouseInfo();
            rotationXShip = mouse.getX() - getX();
            rotationYShip = mouse.getY() - getY();
            double r = Math.toDegrees(Math.atan2(rotationXShip, rotationYShip));
            setRotation(-(int) r);
        }
    }
    
    public void moveShipAtAnotherEdgeOfTheSpace()
    {
        if(getY() == 0)
            setLocation(getX(), getWorld().getHeight());
        if(getY() == getWorld().getHeight()+2)
            setLocation(getX(), 2);
        if(getX() == 0)
            setLocation(getWorld().getWidth(), getY());
        if(getX() == getWorld().getWidth()+2)
            setLocation(2, getY()); 
    }
    
    public void deleteShip()
    {
        if(isTouching(FireShipA.class) || isTouching(AlienShip.class) )
        {
            Greenfoot.setWorld(new BackgroundType());
            getWorld().removeObject(this);
        }
    }
    
    public void fireShipDirection()
    {
        MouseInfo mi = Greenfoot.getMouseInfo();
        if (mi != null)
        {
            int buttonNumber = mi.getButton();
            if (buttonNumber == 1)
            {
                fire();
            }
        }
    }
    
}
