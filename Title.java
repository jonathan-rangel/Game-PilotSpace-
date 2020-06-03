import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Title here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Title extends World
{
    private Click click;

    /**
     * Constructor for objects of class Title.
     * 
     */
    public Title()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1280, 720, 1, false); 
        GreenfootImage drawedImage = new GreenfootImage("Title.png");
        getBackground().drawImage(drawedImage, 150, 100);
        GreenfootImage drawedImage1 = new GreenfootImage("Pilot.png");
        getBackground().drawImage(drawedImage1, 600, 350); 
    }

 
    public void act()
    {
        if(click == null) {
            Greenfoot.delay(50);
            click = new Click();
            addObject(click, 1074, 688);
        }
        if(Greenfoot.mouseClicked(this))
            Greenfoot.setWorld(new MainTitle());
    }
}
