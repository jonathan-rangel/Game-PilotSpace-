import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BackgroundType here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BackgroundType extends World
{
    private String key;
    private int space;
    public BackgroundType()
    {    
        super(1280, 720, 1, false); 
        showText("Type your name or ID", getWidth()/2, getHeight()/2);
    }
    
    public void act()
    {
    }
}
