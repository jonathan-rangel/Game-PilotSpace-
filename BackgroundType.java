import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import static java.lang.System.out;
import java.util.*;
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
    private boolean typeNickname = true;
    public BackgroundType()
    {      
        super(1280, 720, 1, false);  
    }

    
    public void act()
    {
        if(typeNickname)
        {
            key = Greenfoot.ask("Type your Nickname or ID");
            showText("Your nickname or ID is: ", getWidth()/2, getHeight()/2);
            showText(key, getWidth()/2, (getHeight()/2) + 50);
            showText("An your time is: " + Space.getTime(), getWidth()/2, (getHeight()/2) + 100);
            Space.setTime(0);
            Greenfoot.delay(1000);
            Greenfoot.setWorld(new MainTitle());
            typeNickname = false;
        }
    }
}
