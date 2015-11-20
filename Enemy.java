import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Enemy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class Enemy extends Actor
{
    protected int stability; //stores how much health the ghoomba has
    protected GreenfootImage imageL;
    protected GreenfootImage imageR;
    protected GreenfootImage imageML;
    protected GreenfootImage imageMR;
    protected int imageChangeTime; //defines how long to wait before the image changes
    protected int imageChangeDelayCount; //ticks up to change the image
    protected boolean imminentDeath; //determines if the ghoomba is about to die
    protected boolean hitEdge = false; //initialize value for hitEdge. Determines whether the ghoomba has hit the edge
    
     public void act() 
    {
        moveEnemy();
        switchImage();
    }  
    
    public void moveEnemy()
    {
    }
    
    /**
     * When this method is called, the stability of the ghoomba will be reduced by the damage that the bullet imflicts.
     * If the stability of the ghoomba is less than or equal to zero, the ghoomba wll be removed.
     */
    public void hit(int damage) 
    {
        stability = stability - damage;
        if(stability <= 0) 
        {
            getWorld().removeObject(this);
        }
    }
    
    /**
     * This will animate the ghoomba based on which image it has and whether or not the delay count has reached the change time.
     * If the delay count has not reached the change time, the delay count will tick up.
     */
    public void switchImage()
    {
    }
}
