import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MainTitle here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MainTitle extends World
{

    private int pos;
    
    public MainTitle()
    {    
        super(1280,720, 1, false);    
        prepare();
    }

    private void prepare()
    {
        pos = 200;
        Button play = new Button("Start.png", new PlayAction());
        addObject(play,getWidth()/2 ,pos);
        Button howToPlay = new Button("HowToPlay.png", new HowToPlayAction());
        addObject(howToPlay,getWidth()/2,pos+=125);
        Button records = new Button("Records.png", new RecordsAction());
        addObject(records,getWidth()/2,pos+=125);
        Button exit = new Button("Exit.png", new ExitAction());
        addObject(exit,getWidth()/2,pos+=125);
        
    }

}
