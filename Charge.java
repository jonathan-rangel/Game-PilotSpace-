import greenfoot.Actor;
import greenfoot.Greenfoot;

/**
 * Write a description of class Charge here.
 */
public class Charge extends Actor {
    private int rotation = 0;
    private int counter = 0;

    private boolean done = false;

    public void act() {
        if(counter > 20) {
            setRotation(rotation += 45);
            counter = 0;
        }
        counter++;
    }

    public boolean isDone(){
        return done;
    }
}
