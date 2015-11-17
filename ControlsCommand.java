import greenfoot.*;

/**
 * Interacts with Receiver of the command.
 * 
 * @author Jaya 
 * @version 1.0
 */

public class ControlsCommand implements ICommand
{
//     GameControls control;
//     
//     public ControlsCommand(){
//         //this.control = control;
//     }
    public void execute ()
    {
        Greenfoot.setWorld(new GameControls());
    }
    
}
