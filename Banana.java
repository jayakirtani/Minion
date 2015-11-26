import greenfoot.*;

/**
 * Write a description of class Banana here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Banana extends Actor
{
    /**
     * Act - do whatever the Banana wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    MinionContext minion = MinionContext.getInstanceCurrentState(getWorld());
    
    public void act() 
    {
        checkHit();
    }    
    
    private void checkHit()
    {
        MinionGun g = (MinionGun) getOneIntersectingObject(MinionGun.class);
        Minion m  =  (Minion) getOneIntersectingObject(Minion.class);
        MinionS s = (MinionS) getOneIntersectingObject(MinionS.class);
        if(g != null)
        {
            getWorld().removeObject(this);
        }
        if(m != null)
        {
            System.out.println(" Second control in banana : minion becomes MinionGun" );
          //  minion.setState(new Minion());
            minion.grow(getWorld());
            getWorld().removeObject(this);
        }
        if(s != null)
        {
            System.out.println(" first control in banana : minionSmall becomes Minion");
            minion.grow(getWorld());
            getWorld().removeObject(this);
        }
     }
}
