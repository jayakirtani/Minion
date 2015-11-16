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
        Controls controls = new Controls();
        addObject(controls, 235, 245);
        controls.setLocation(228, 238);
        controls.setLocation(223, 236);
        startgame.setLocation(301, 143);
        controls.setLocation(302, 215);
        startgame.setLocation(300, 117);
        controls.setLocation(300, 186);
    }
}
