import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

import java.io.File;

/**
 * Write a description of class ListOfRecords here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ListOfRecords extends World
{

    private static int aumento = 0;
    public ListOfRecords()
    {    
        super(1280, 720, 1, false);
        GreenfootImage drawedImage = new GreenfootImage("LastRecords.png");
        getBackground().drawImage(drawedImage,(getWidth()/4) - 50 , 100);
        putButtonBack();
        printRecords();
    }

    public void putButtonBack()
    {
        Button backButton = new Button("Back.png", new BackAction());
        addObject(backButton, 65 ,50);
    }

    public static void setAumento(int aumentoDado)
    {
        aumento = aumentoDado;
    }

    public void printRecords()
    {
        int i = 0;
        ArrayList<Ship> fileOfRecords = new ArrayList<Ship>();
        fileOfRecords = Space.openFile();
        Collections.sort(fileOfRecords, Ship.ShipTimeComparator);
        for(Ship fileOfRecord: fileOfRecords)
        {
            if(i < 7)
            {
                showText(fileOfRecord.getNickName(), (getWidth()/4) + 50, (getHeight()/2) + aumento);
                showText("" + fileOfRecord.getTimeInGame() + " seconds", (getWidth()/2) + 200 , (getHeight()/2) + aumento);
                aumento += 50;
            }
            i ++;
        }
    }

}
