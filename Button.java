import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Button here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Button extends Actor 
{
    private ButtonAction action;
    
    public Button(String image, ButtonAction action)
    {
        setImage(image);
        this.action = action;
    }
    
    public void act() 
    {
        if(Greenfoot.mouseClicked(this))
        {    
            action.onClick(this);
        }
    }    
}
