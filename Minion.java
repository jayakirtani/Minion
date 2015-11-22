import greenfoot.*;

/**
 * A user-controlled actor that walks and jumps, and is pulled down by gravity.
 * <l><li>Left arrow moves actor left (toward left scroll limit)</li>
 * <li>Right arrow moves actor right (toward right scroll limit)</li>
 * <li>Up arrow makes the actor jump</li><l>
 */
public class Minion extends Actor
{
    final int jSpeed = 20; // the initial 'jump' speed
    int ySpeed = 0, xSpeed = 0; // the initial vertical and horizontal speeds
    boolean aboutFace; // the direction (left or right) the actor is facing
    boolean onGround; // the state of the actor being set on an object or not
    boolean _600=true;
    
    /** 
     * Checks for changes in direction and moves the main actor.
     */
    public void act()
    {
        getDirection();
        move();
    }
    
    /**
     * Moves the actor with appropriate image.  Checks for obstacles and adjusts
     * the position of the actor accordingly.
     */
    private void move()
    {
        ySpeed++; // adds gravity
        EnemyFactory E = new EnemyFactory();
        if (xSpeed != 0 && onGround) xSpeed+=aboutFace?0.5:-2; // add friction
        setLocation(getX()+xSpeed/10, getY()+ySpeed/2);
        // check for change in horizontal direction
        if((xSpeed>0 && aboutFace) || (xSpeed<0 && !aboutFace)) 
        {
            getImage().mirrorHorizontally();
            aboutFace = !aboutFace;
        }
        
        // check for obstacles
        onGround=false; // initialize value
        // check below the actor
        while(getOneObjectAtOffset(0, getImage().getHeight()/2+1, null)!=null)
        {
            setLocation(getX(), getY()-1); 
            onGround=true; 
            ySpeed=0;
        }
        // check above the actor
        while(getOneObjectAtOffset(0, -getImage().getHeight()/2-1, null)!=null) 
        {
            setLocation(getX(), getY()+1);
            ySpeed = 0;
        }
        // check to right of actor
        while(getOneObjectAtOffset(getImage().getWidth()/2+1, 0, null)!=null)
        {
            setLocation(getX()-1, getY());
            xSpeed = 0;
        }
        // check to left of actor
        while(getOneObjectAtOffset(-getImage().getWidth()/2-1, 0, null)!=null)
        {
            setLocation(getX()+1, getY());
            xSpeed = 0;
        }
        
        if(getX()>400 && _600)
        {
            _600=false;
            getWorld().addObject(E.makeEnemy("EM"), 600, 335);
            getWorld().addObject(E.makeEnemy("GM"), 600, 335);
            getWorld().addObject(E.makeEnemy("GH"), 600, 280);
        }
    }
    
    /**
     * Determines any changes in horizontal and vertical speeds for the actor.
     */
    private void getDirection()
    {
//         if (!onGround) return; // if not mid-air changes allowed
        // sets requested direction of move, or continues in current direction
        if (Greenfoot.isKeyDown("left") && xSpeed>-50) xSpeed-=2; // check left
        if (Greenfoot.isKeyDown("right") && xSpeed<50) xSpeed+=2; // check right
        if (Greenfoot.isKeyDown("up") && onGround) // check jump
        {
            ySpeed -= jSpeed; // add jump speed
            ((Score) getWorld().getObjects(Score.class).get(0)).add(1); // increment jump counter
        }
    }
}
