import greenfoot.*;

public class BackAction implements ButtonAction
{
    
    public void onClick(Actor actor) 
    {
        Greenfoot.setWorld(new MainTitle());
    }
}
