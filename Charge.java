import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Charge here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Charge extends Actor
{
    private int rotation = 0;
    
    public void setRotations()
    {
        while(rotation < 360)
            {
                setRotation(rotation += 45);
                Greenfoot.delay(10);
            }
    }
}
