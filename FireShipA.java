import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class FireShipA here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class FireShipA extends Fire
{
    /**
     * Act - do whatever the FireShipA wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        move(5);
        removeIfFireShipOutOfTheWorld();
    }    
}
