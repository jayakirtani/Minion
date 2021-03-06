import greenfoot.*;

/**
 * Write a description of class GameControls here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameControls extends World
{
    GreenfootSound theme = new GreenfootSound("menutheme2.wav");
    ReturnMenu returnmenu = new ReturnMenu();
    /**
     * Constructor for objects of class GameControls.
     * 
     */
    public GameControls()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        GreenfootImage controlscreen = new GreenfootImage("ControlScreen.png");
        setBackground(controlscreen);
        prepare();
    }

    /**
     * Prepare the world for the start of the program. That is: create the initial
     * objects and add them to the world.
     */
    private void prepare()
    {
        
        addObject(returnmenu, 515, 380);
        returnmenu.setLocation(507, 372);
        returnmenu.setLocation(503, 371);
        returnmenu.setLocation(297, 374);
    }
    
    public void act ()
    {
        if(theme.isPlaying() == false)
         {
             theme.play();
             theme.setVolume(40);
         }
         
        if ( Greenfoot.mouseClicked(returnmenu) )
        {
            theme.stop();
        }
        
    }

        
    public void stopped()
    {
        theme.pause();
    }
}
