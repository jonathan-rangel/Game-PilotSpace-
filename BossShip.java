import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BossShip here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BossShip extends Actor implements FireShip
{
    private static final int MOVE_Y = 3;
    private static final int MOVE_X = 3;
    private static final int SECONDS_TO_FIRE = 1000;
    public static final int LIFE_BOSS_DECREASE = 10;
    public static final int NO_LIFE = 0;
    private int dir = 0;
    private int lifeBoss = 50;
    private static boolean bossDestroyed = false;
    private long lastAdded = System.currentTimeMillis();

    public void act() 
    {
        moveBossAlienShipAndPutInAnotherEdgeOfTheSpace();

        fireBossAlienShip();

        deleteBossShip();
    } 

    public void fireBossAlienShip()
    {
        long curTime  = System.currentTimeMillis();
        if (curTime >= lastAdded + SECONDS_TO_FIRE)
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
            lifeBoss -= LIFE_BOSS_DECREASE;
            if(lifeBoss == NO_LIFE)
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
        setLocation(getX(),getY() + MOVE_Y);
        if(dir == 0)
        {
            setLocation(getX() - MOVE_X, getY());
            if(getX() <= 0)
                dir = 1;
        }
        else
        {
            setLocation(getX() + MOVE_X, getY());
            if(getX() >= getWorld().getWidth())
                dir = 0;
        }

        if(getY() >= getWorld().getHeight())
            setLocation(getX(), -100);
    }

}
