import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import static java.lang.System.out;
import java.util.*;

public class AlienShip extends Actor implements FireShip
{

    private int moveY = 2;
    private int moveX = 2;
    private int direction = 0;
    private static final int LEFT = 0;
    private static final int RIGHT = 1;
    private static int aliensNum = 0;
    long TimelastAdded = System.currentTimeMillis();

    public void fire()
    {
        FireShipA fire = new FireShipA();
        getWorld().addObject(fire, getX(), getY());
        fire.setRotation(Ship.getRotations());
    }

    public void act() 
    {
        moveAlienShipAndPutInAnotherEdgeOfTheSpace();

        fireAlienShip();
        
        deleteAlienShip();

    }
    
    public void deleteAlienShip()
    {
        if(isTouching(FireShipPilot.class))
        {
            getWorld().removeObject(this);
            aliensNum ++;
        }
    }
    
    public void fireAlienShip()
    {
        long curTime  = System.currentTimeMillis();
        if (curTime >= TimelastAdded + 1000)
        {
            fire();
            TimelastAdded  = curTime;
        }
    }
    
    public void moveAlienShipAndPutInAnotherEdgeOfTheSpace()
    {
        setLocation(getX(),getY() + moveY);
        if(direction == LEFT)
        {
            setLocation(getX() - moveX, getY());
            if(getX() <= 0)
                direction = RIGHT;
        }
        else
        {
            setLocation(getX() + moveX, getY());
            if(getX() >= getWorld().getWidth())
                direction = LEFT;
        }
        
        if(getY() >= getWorld().getHeight())
            setLocation(getX(), -100);
    }
    
    public static int getAliensNum()
    {
        return aliensNum;
    }

    public static void setAliensNum(int aliensNumm)
    {
        aliensNum = aliensNumm;
    }
}   
