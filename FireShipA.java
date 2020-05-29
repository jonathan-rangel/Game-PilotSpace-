import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class FireShipA extends Fire
{
    public void act() 
    {
        move(5);
        removeIfFireShipOutOfTheWorld();
    }    
}
