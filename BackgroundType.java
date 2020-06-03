import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import static java.lang.System.out;
import java.util.*;
/**
 * Write a description of class BackgroundType here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BackgroundType extends World
{
    private static String nickName;
    private boolean typeNickname = true;
    private final Ship shipPlayer;

    public BackgroundType(Ship ship)
    {      
        super(1280, 720, 1, false);
        GreenfootImage drawedImage = new GreenfootImage("GameOver.png");//the image that is drawed;
        getBackground().drawImage(drawedImage,(getWidth()/4) - 25 , 100);
        shipPlayer = ship;
    }

    
    public void act()
    {
        if(typeNickname)
        {
            nickName = Greenfoot.ask("Type your Nickname or ID");
            showText("Your nickname or ID is: ", getWidth()/2, getHeight()/2 + 100);
            showText(nickName, getWidth()/2, (getHeight()/2) + 150);
            showText("And your time is: " + Space.getTime() + " seconds", getWidth()/2, (getHeight()/2) + 200);
            shipPlayer.setNickName(nickName);
            shipPlayer.setTimeInSpace(Space.getTime());
            Space.save(shipPlayer);
            Space.setLevel(1);
            Greenfoot.delay(500);
            Space.stopMusic();
            Greenfoot.setWorld(new MainTitle());
            typeNickname = false;
        }
    }
    
    public static String getNickname()
    {
        return nickName;
    }
}
