import greenfoot.Actor;

/**
 * Action performed by buttons
 */
public interface ButtonAction {
    /**
     * Action to be executed when a button is clicked
     *
     * @param actor Actual button being clicked
     */
    void onClick(Actor actor);
}
