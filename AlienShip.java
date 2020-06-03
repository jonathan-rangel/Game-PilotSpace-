import greenfoot.Actor;

public class AlienShip extends Actor implements FireShip {

    private int moveY = 2;
    private int moveX = 2;
    private int direction = 0;
    private static final int LEFT = 0;
    private static final int RIGHT = 1;
    private static int aliensNum = 0;
    private long timeLastAdded = System.currentTimeMillis();

    public void fire() {
        FireShipA fire = new FireShipA();
        getWorld().addObject(fire, getX(), getY());
        fire.setRotation(Ship.getRotations());
    }

    public void act() {
        moveAlienShipAndPutInAnotherEdgeOfTheSpace();

        fireAlienShip();

        deleteAlienShip();

    }

    public void deleteAlienShip() {
        Actor fireShipPilot = getOneIntersectingObject(FireShipPilot.class);

        if (fireShipPilot != null) {
            getWorld().removeObject(fireShipPilot);
            getWorld().removeObject(this);
            aliensNum++;
        }

    }

    public void fireAlienShip() {
        long curTime = System.currentTimeMillis();
        if (curTime >= timeLastAdded + 1000) {
            fire();
            timeLastAdded = curTime;
        }
    }

    public void moveAlienShipAndPutInAnotherEdgeOfTheSpace() {
        setLocation(getX(), getY() + moveY);
        if (direction == LEFT) {
            setLocation(getX() - moveX, getY());
            if (getX() <= 0)
                direction = RIGHT;
        } else {
            setLocation(getX() + moveX, getY());
            if (getX() >= getWorld().getWidth())
                direction = LEFT;
        }

        if (getY() >= getWorld().getHeight())
            setLocation(getX(), -100);
    }

    public static int getAliensNum() {
        return aliensNum;
    }

    public static void resetAliensNum() {
        aliensNum = 0;
    }
}   
