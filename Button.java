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
            soundOfButton();
            action.onClick(this);
        }
    }
    
    private void soundOfButton()
    {
        soundTrack.setVolume(25);
        soundTrack.play();
    }
}
