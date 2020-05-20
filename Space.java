import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import static java.lang.System.out;
import java.util.*;
import java.io.File;
import java.time.*;

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
    private Instant start = Instant.now();
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
        Instant finish = Instant.now();
        long timeElapsed = Duration.between(start, finish).toSeconds();
        showText("Time: " + timeElapsed, 40, 10);
    }
        
    public static int getTime()
    {
        return 0;
    }
    
    public static void setTime(int time)
    {
    }
    
    private void prepare()
    {
        File recordsFile = new File("records.txt");
        
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
