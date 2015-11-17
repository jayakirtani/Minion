import greenfoot.*;

/**
 * Write a description of class StartGame here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class StartGame extends Actor
{
    GameMenuInvoker menuInvoker = new GameMenuInvoker();
    ICommand myGame = new MyGameCommand();
    
    /**
     * Act - do whatever the StartGame wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    public StartGame ()
    {
        GreenfootImage start = new GreenfootImage("Start.png");
        setImage (start);
    }
    
    public void act() 
    {
        // Add your action code here.
        if (Greenfoot.mouseClicked(this)){
            //Greenfoot.setWorld(new MyGame());
           menuInvoker.setCommand(myGame);
           menuInvoker.clickMenuOption();
        }
    }   
}
