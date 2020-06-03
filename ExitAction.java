import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Exit here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ExitAction implements ButtonAction
{
    public void onClick(Actor actor) 
    {
        MainTitle.stopMusic();
        Greenfoot.stop();
    }

}
