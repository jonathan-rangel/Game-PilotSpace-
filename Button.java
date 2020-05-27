import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Button extends Actor 
{
    private ButtonAction action;
    private static GreenfootSound soundTrack = new GreenfootSound("BotonSound.mp3");
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
    
    public static void soundOfbotton()
    {
        soundTrack.setVolume(25);
        soundTrack.play();
    }
}
