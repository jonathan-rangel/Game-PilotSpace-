import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Controls here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Controls extends World
{

    /**
     * Constructor for objects of class Controls.
     * 
     */
    public Controls()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1280, 720, 1, false);
        GreenfootImage drawedImage = new GreenfootImage("Controls.png");
        getBackground().drawImage(drawedImage,(getWidth()/4) , 0);
        PutButtonBack();
    }
    
    public void PutButtonBack()
    {
        Button backButton = new Button("Back.png", new BackAction());
        addObject(backButton, 65 ,50);
    }
}
