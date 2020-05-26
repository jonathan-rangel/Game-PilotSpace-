import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Controls here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Controls extends World
{
    public Controls()
    {    
        super(1280, 720, 1, false);
        GreenfootImage drawedImage = new GreenfootImage("Controls.png");
        getBackground().drawImage(drawedImage,(getWidth()/4) , 0);
        putButtonBack();
    }
    
    public void putButtonBack()
    {
        Button backButton = new Button("Back.png", new BackAction());
        addObject(backButton, 65 ,50);
    }
}
