import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Start here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PlayAction implements ButtonAction
{

    public void onClick(Actor actor) 
    {
            Button.soundOfbotton();
            Charge charge = new Charge();
            actor.getWorld().addObject(charge,1244,678);
            charge.setRotations();
            MainTitle.stopMusic();
            Greenfoot.setWorld(new Space());
    }
}
