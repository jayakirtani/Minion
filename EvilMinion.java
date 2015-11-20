import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class EvilMinion here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EvilMinion extends Enemy
{
    public EvilMinion()
    {
        imageL = new GreenfootImage("evilminionL.png");
        imageR = new GreenfootImage("evilminionR.png");
        setImage(imageL);
        stability = 1;
        imageChangeTime = 5;
    }
    
    /**
     * Calls the necessary methods to move the ghoomba, animate it and decide whether or not it has been hit
     */
    public void act() 
    {
        moveGhoomba();
        switchImage();
    }  

    
    public void moveGhoomba()
    {
        if (getOneObjectAtOffset (getImage().getWidth()/2+1, 0, Brick.class)!= null)
        {
            move(-2);
            hitEdge = true;
        }
        if (getOneObjectAtOffset (-getImage().getWidth()/2-1, 0, Brick.class)!= null)
        {
            move(2);
            hitEdge = false;
        }
        if (getOneObjectAtOffset (getImage().getWidth()/2+1, 0, Block.class)!= null)
        {
            move(-2);
            hitEdge = true;
        }
        if (getOneObjectAtOffset (-getImage().getWidth()/2-1, 0, Block.class)!= null)
        {
            move(2);
            hitEdge = false;
        }
        if (getOneObjectAtOffset (getImage().getWidth()/2+1, 0, Box.class)!= null)
        {
            move(-2);
            hitEdge = true;
        }
        if (getOneObjectAtOffset (-getImage().getWidth()/2-1, 0, Box.class)!= null)
        {
            move(2);
            hitEdge = false;
        }
        if (getOneObjectAtOffset (getImage().getWidth()/2+1, 0, Minion.class)!= null)
        {
            move(-2);
            hitEdge = true;
        }
        if (getOneObjectAtOffset (-getImage().getWidth()/2-1, 0, Minion.class)!= null)
        {
            move(2);
            hitEdge = false;
        }
        if (hitEdge == false)
        {
            move(1);
            setImage(imageR);
        }
        else if (hitEdge == true)
        {
            move(-1);
            setImage(imageL);
        }
    }
    
   
    public void hit(int damage) 
    {
        stability = stability - damage;
        if(stability <= 0) 
        {
            getWorld().removeObject(this);
        }
    }
    
}
