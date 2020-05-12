import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import static java.lang.System.out;
import java.util.*;

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Space extends World
{
    private Background spaceBackground, spaceBackground1;
    private List<AlienShip> alienShips;
    public Space()
    {    
        super(1280,720, 1, false);
        spaceBackground = new Background();
        addObject(spaceBackground, getWidth()/2, getHeight()/2);
        spaceBackground1 = new Background();
        addObject(spaceBackground1, getWidth()/2, getHeight() - getHeight() -getHeight()/2);
        prepare();
    }

    public void act()
    {
        spaceBackground.scroll();
        spaceBackground1.scroll();

        if(AlienShip.getAliensNum() == 3)
        {
            alienShips = new ArrayList();
            AlienShip alienShip = new AlienShip();
            addObject(alienShip,Greenfoot.getRandomNumber(1000),-100);
            alienShips.add(alienShip);

            alienShip = new AlienShip();
            addObject(alienShip,Greenfoot.getRandomNumber(1000),-100);
            alienShips.add(alienShip);

            alienShip = new AlienShip();
            addObject(alienShip,Greenfoot.getRandomNumber(1000),-100);
            alienShips.add(alienShip);

            AlienShip.setAliensNum(0);

        }

    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        Ship ship = new Ship();
        addObject(ship,getWidth()/2,680);

        alienShips = new ArrayList();
        AlienShip alienShip = new AlienShip();
        addObject(alienShip,100,-100);
        alienShips.add(alienShip);

        alienShip = new AlienShip();
        addObject(alienShip,640,-100);
        alienShips.add(alienShip);

        alienShip = new AlienShip();
        addObject(alienShip,1180,-100);
        alienShips.add(alienShip);

    }
}
