import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MainActor here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

public class MainActor extends Actor
{
    final int jSpeed = 20; // the initial 'jump' speed
    int ySpeed = 0, xSpeed = 0; // the initial vertical and horizontal speeds
    boolean onGround; // the state of the actor being set on an object or not
    boolean aboutFace; // the direction (left or right) the actor is facing

    /**
     * Act - do whatever the MainActor wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
        //getDirection();
        move();
    }    
    
    private void move()
    {
        ySpeed++; //add gravity
        setLocation(getX()+xSpeed/10,getY()+ySpeed/2);
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
            //((Score) getWorld().getObjects(Score.class).get(0)).add(1); // increment jump counter
        }
    }
}
