import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import static java.lang.System.out;
import java.util.*;

public class AlienShip extends Actor implements FireShip
{

    private int moveY = 2;
    private int moveX = 2;
    private int dir = 0;
    private static int aliensNum = 0;
    long lastAdded = System.currentTimeMillis();

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
        if (curTime >= lastAdded + 1000)
        {
            fire();
            lastAdded  = curTime;
        }
    }
    
    public void moveAlienShipAndPutInAnotherEdgeOfTheSpace()
    {
        setLocation(getX(),getY() + moveY);
        if(dir == 0)
        {
            setLocation(getX() - moveX, getY());
            if(getX() <= 0)
                dir = 1;
        }
        else
        {
            setLocation(getX() + moveX, getY());
            if(getX() >= getWorld().getWidth())
                dir = 0;
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
