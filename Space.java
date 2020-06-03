import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import static java.lang.System.out;
import java.util.*;
import java.io.File;
import java.time.*;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.FileNotFoundException;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Space extends World
{
    private Background spaceBackground, spaceBackground1;
    private List<AlienShip> alienShips;
    private Instant start = Instant.now();
    private static int timeInGame;
    private static File records;
    private final static GreenfootSound soundTrack = new GreenfootSound("MusicInTheSpace.mp3");
    private static int levelNum = 1;

    public Space()
    {    
        super(1280,720, 1, false);
        spaceBackground = new Background();
        addObject(spaceBackground, getWidth()/2, getHeight()/2);
        spaceBackground1 = new Background();
        addObject(spaceBackground1, getWidth()/2, getHeight() - getHeight() -getHeight()/2);
        playMusic();
        showText("Level " + levelNum, 1200, 10);
        prepare();
    }

    public void act()
    {
        spaceBackground.scroll();
        spaceBackground1.scroll();
        
        if(AlienShip.getAliensNum() == 3 && BossShip.returnStateOfTheBossShip() == false)
        {
            levelNum ++;

            BossShip bossShip = new BossShip();
            addObject(bossShip,getWidth()/2,-100);
            
            alienShips = new ArrayList();
            AlienShip alienShip = new AlienShip();
            addObject(alienShip,Greenfoot.getRandomNumber(1000),Greenfoot.getRandomNumber(300) * -1);
            alienShips.add(alienShip);

            alienShip = new AlienShip();
            addObject(alienShip,Greenfoot.getRandomNumber(1000),Greenfoot.getRandomNumber(300) * -1);
            alienShips.add(alienShip);

            alienShip = new AlienShip();
            addObject(alienShip,Greenfoot.getRandomNumber(1000),Greenfoot.getRandomNumber(300) * -1);
            alienShips.add(alienShip);
            
            showText("Level " + levelNum, 1200, 10);
            AlienShip.resetAliensNum();
            
        }
        
        if(BossShip.returnStateOfTheBossShip())
        {
            alienShips = new ArrayList();
            AlienShip alienShip = new AlienShip();
            addObject(alienShip,Greenfoot.getRandomNumber(1000),Greenfoot.getRandomNumber(300) * -1);
            alienShips.add(alienShip);

            alienShip = new AlienShip();
            addObject(alienShip,Greenfoot.getRandomNumber(1000),Greenfoot.getRandomNumber(300) * -1);
            alienShips.add(alienShip);

            alienShip = new AlienShip();
            addObject(alienShip,Greenfoot.getRandomNumber(1000),Greenfoot.getRandomNumber(300) * -1);
            alienShips.add(alienShip);
            
            
            AlienShip.resetAliensNum();
            BossShip.setStateOfTheBossShip(false);
        }
        
        Instant finish = Instant.now();
        long timeElapsed = Duration.between(start, finish).toSeconds();
        showText("Time: " + timeElapsed, 40, 10);
        timeInGame = (int)timeElapsed;
    }

    public static int getTime()
    {
        return timeInGame;
    }

    public static void setLevel(int level)
    {
        levelNum = level;
    }

    private void prepare()
    {   
        Ship ship = new Ship();
        addObject(ship,getWidth()/2,680);

        alienShips = new ArrayList();
        AlienShip alienShip = new AlienShip();
        addObject(alienShip,Greenfoot.getRandomNumber(1000),Greenfoot.getRandomNumber(200) * -1);
        alienShips.add(alienShip);

        alienShip = new AlienShip();
        addObject(alienShip,Greenfoot.getRandomNumber(1000),Greenfoot.getRandomNumber(200) * -1);
        alienShips.add(alienShip);

        alienShip = new AlienShip();
        addObject(alienShip,Greenfoot.getRandomNumber(1000),Greenfoot.getRandomNumber(200) * -1);
        alienShips.add(alienShip);
    }

    public static void save(Ship shipPlayer)
    {
        File recordsFile = new File("records.txt");
        try(FileWriter writer=new FileWriter(recordsFile,true)){
            writer.append("" + shipPlayer.getTimeInGame()).append(",").append(""+shipPlayer.getNickName()).append(System.lineSeparator());
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }

   
    public static ArrayList openFile()
    {

        ArrayList<Ship> fileTexts = new ArrayList<Ship>();
        try{
            List<String> lines= Files.readAllLines(Paths.get("records.txt"));
            for(String line:lines){
                Ship shipPlayers = new Ship();
                String []values=line.split(",");
                shipPlayers.setTimeInSpace(Integer.parseInt(values[0]));
                shipPlayers.setNickName(values[1]);
                fileTexts.add(shipPlayers);
            }
        } catch (IOException e) {
            e.printStackTrace();
            
        }
        return fileTexts;
    }
    
    public static void playMusic()
    {
        soundTrack.play();
    }
    
    public static void stopMusic()
    {
        soundTrack.stop();
    }
}
