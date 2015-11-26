import greenfoot.*;

/**
 * Write a description of class Oneup here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Oneup extends Powerup
{
    /**
     * Act - do whatever the Oneup wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        setpower();
        boost();// Add your action code here.
    }    
    
    public void boost()
    {
         if(getWorld() instanceof MyWorld && counter% 4 ==0)
            {
                setImage(lifepower);
                counter++;
            }   
    }
}
