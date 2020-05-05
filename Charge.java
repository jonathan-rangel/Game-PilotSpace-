import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Charge here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Charge extends Actor
{
    private int rot = 0;

    public void setRotations()
    {
        while(rot < 360)
            {
                setRotation(rot+=45);
                Greenfoot.delay(10);
            }
    }
}
