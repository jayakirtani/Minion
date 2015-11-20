import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class EvilMinion here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GreenEvilMinion extends Enemy
{
    public GreenEvilMinion()
    {
        imageL = new GreenfootImage("evilminion2L.png");
        imageR = new GreenfootImage("evilminion2R.png");
        setImage(imageL);
        stability = 1;
        imageChangeTime = 5;
    }
    
    /**
     * Calls the necessary methods to move the ghoomba, animate it and decide whether or not it has been hit
     */
    public void act() 
    {
        moveEvilMinion();
        switchImage();
    }  

    
    public void moveEvilMinion()
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
    
   /* public void switchImage()
        {
        if(imageChangeDelayCount >= imageChangeTime)
        {
            if(getImage() == imageL)
            {
                setImage(imageML);
                imageChangeDelayCount = 0;
            }
            else if(getImage() == imageML)
            {
                setImage(imageL);
                imageChangeDelayCount = 0;
            }
            else if(getImage() == imageR)
            {
                setImage(imageMR);
                imageChangeDelayCount = 0;
            }
            else
            {
                setImage(imageR);
                imageChangeDelayCount = 0;
            }
        }
        else
        {
            imageChangeDelayCount++;
        }
    }
    */
   
    public void hit(int damage) 
    {
        stability = stability - damage;
        if(stability <= 0) 
        {
            getWorld().removeObject(this);
        }
    }
    
    
    
    
    
}
