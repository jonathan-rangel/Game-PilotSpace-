import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Ship here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Ship extends Actor
{
    private int dirx;
    private int diry;
    private int rotaX;
    private int rotaY;
    private int i = 1;
    public void act() 
    {
        dirx = getX();
        diry = getY();
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
        if(isTouching(AlienShip.class))
        {
            setImage("Ship" + i + ".png");
            Greenfoot.delay(20);
            i++;
        }
        if(getY() == 0)
            setLocation(getX(), getWorld().getHeight());
        if(getY() == getWorld().getHeight()+2)
            setLocation(getX(), 2);
        if(getX() == 0)
            setLocation(getWorld().getWidth(), getY());
        if(getX() == getWorld().getWidth()+2)
            setLocation(2, getY());
    }
}
