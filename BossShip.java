import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BossShip here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BossShip extends Actor implements FireShip
{
    private int moveY = 3;
    private int moveX = 3;
    private int dir = 0;
    private int lifeBoss = 50;
    private static boolean bossDestroyed = false;
    long lastAdded = System.currentTimeMillis();

    public void act() 
    {
        moveBossAlienShipAndPutInAnotherEdgeOfTheSpace();

        fireBossAlienShip();

        deleteBossShip();
    } 

    public void fireBossAlienShip()
    {
        long curTime  = System.currentTimeMillis();
        if (curTime >= lastAdded + 1000)
        {
            fire();
            lastAdded  = curTime;
        }
    }

    public void fire()
    {
        FireShipA fire = new FireShipA();
        getWorld().addObject(fire, getX(), getY());
        fire.setRotation(Ship.getRotations());
    }

    public void deleteBossShip()
    {

        Actor fireShipPilot = getOneIntersectingObject(FireShipPilot.class);

        if(fireShipPilot != null)
        {
            getWorld().removeObject(fireShipPilot);
            lifeBoss -= 10;
            if(lifeBoss == 0)
            {
                getWorld().removeObject(this);
                bossDestroyed = true;
            }

        }
    }

    public static boolean returnStateOfTheBossShip()
    {
        return bossDestroyed;
    }

    public static void setStateOfTheBossShip(boolean state)
    {
        bossDestroyed = state;
    }

    public void moveBossAlienShipAndPutInAnotherEdgeOfTheSpace()
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

}
