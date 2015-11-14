import greenfoot.*;

/**
 * Write a description of class MyGameMenu here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyGameMenu extends World
{
    
    /**
     * Constructor for objects of class MyGameMenu.
     * 
     */
    public MyGameMenu()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        prepare();
    }

    /**
     * Prepare the world for the start of the program. That is: create the initial
     * objects and add them to the world.
     */
    private void prepare()
    {
        StartGame startgame = new StartGame();
        addObject(startgame, 223, 159);
        Help help = new Help();
        addObject(help, 235, 245);
        help.setLocation(228, 238);
        help.setLocation(223, 236);
    }
}
