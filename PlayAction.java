import greenfoot.Actor;
import greenfoot.Greenfoot;

/**
 * Write a description of class Start here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class PlayAction implements ButtonAction {

    public void onClick(Actor actor) {
        Charge charge = new Charge();
        actor.getWorld().addObject(charge, 1244, 678);
        Greenfoot.delay(2000);
        MainTitle.stopMusic();
        Greenfoot.setWorld(new Space());
    }
}
