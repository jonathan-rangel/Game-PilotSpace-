import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class FireShipPilot here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class FireShipPilot extends Actor
{
    private static GreenfootSound soundTrack = new GreenfootSound("SoundOfTheShooting.mp3"); 
    
    public void act() 
    {
        move(7);
        
    }    
      
    public FireShipPilot()
    {
        soundTrack.setVolume(25);
        playMusic();
    }
    
    public static void playMusic()
    {
        soundTrack.play();
    }
    
    public static void stopMusic()
    {
        soundTrack.stop();
    }
    
 
    
    
}
