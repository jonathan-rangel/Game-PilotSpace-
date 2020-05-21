import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
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
        PrintRecords();
    }
    
    public void PrintRecords()
    {
        ArrayList<String> fileOfRecords = new ArrayList<String>();
        fileOfRecords = Space.openFile();
        for(String fileOfRecord: fileOfRecords)
        {
            showText(fileOfRecord, getWidth()/2, getHeight()/2 + aumento);
            aumento += 50;
        }
    }
    
}
