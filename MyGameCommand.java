import greenfoot.*;

/**
 * Interacts with receiver of the command MyGame.
 * 
 * @author Jaya
 * @version 1.0
 */
public class MyGameCommand implements ICommand
{

    public void execute()
    {
        Greenfoot.setWorld(new MyWorld());
    }
    
}
