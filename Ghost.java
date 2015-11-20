import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class EvilMinion here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Ghost extends Enemy
{
    public Ghost()
    {
        imageL = new GreenfootImage("ghostL.png");
        imageR = new GreenfootImage("ghostR.png");
        imageML = new GreenfootImage("ghostML.png");
        imageMR = new GreenfootImage("ghostMR.png");
        setImage(imageL);
        stability = 1;
        imageChangeTime = 5;
    }
    
    /**
     * Calls the necessary methods to move the ghoomba, animate it and decide whether or not it has been hit
     */
    public void act() 
    {
        moveEnemy();
        //switchImage();
    }  

    private void direction()
    {
        if(getImage()==imageR)
              setImage(imageMR);
        else if(getImage()==imageL)
              setImage(imageML); 
    }
    
    public void moveEnemy()
    {
        if((getWorld().getObjects(Minion.class).get(0).getX()-300<getX()&&getWorld().getObjects(Minion.class).get(0).getX()+300>getX()))
        {
            if (getOneObjectAtOffset (getImage().getWidth()/2+1, 0, Brick.class)!= null)
            {
                direction();
            }
            else if (getOneObjectAtOffset (-getImage().getWidth()/2-1, 0, Brick.class)!= null)
            {
                direction();
            }
            else if (getOneObjectAtOffset (getImage().getWidth()/2+1, 0, Block.class)!= null)
            {
                direction();
            }
            else if (getOneObjectAtOffset (-getImage().getWidth()/2-1, 0, Block.class)!= null)
            {
                direction();
            }
            else if (getOneObjectAtOffset (getImage().getWidth()/2+1, 0, Box.class)!= null)
            {
                direction();
            }
            else if (getOneObjectAtOffset (-getImage().getWidth()/2-1, 0, Box.class)!= null)
            {
                direction();
            }
            else if (getOneObjectAtOffset (getImage().getWidth()/2+1, 0, Minion.class)!= null)
            {
                direction();
            }
            else if (getOneObjectAtOffset (-getImage().getWidth()/2-1, 0, Minion.class)!= null)
            {
                direction();
            }
            else 
            {
                if(getImage()==imageML)
                    setImage(imageL); 
                else if(getImage()==imageML)
                    setImage(imageR); 
            }
              
            
            
            if(getWorld().getObjects(Minion.class).get(0).getX()>getX())
            {
                 move(+2);
                 if(getImage()==imageL)
                    setImage(imageL); 
                 else if(getImage()==imageML)
                    setImage(imageML); 
            }
            else
            {
                move(-2);
                if(getImage()==imageR)
                    setImage(imageR); 
                 else if(getImage()==imageMR)
                    setImage(imageMR); 
            }
            if(getWorld().getObjects(Minion.class).get(0).getY()>getY())
            {
                 setLocation(getX(), getY() + 2);
                 
            }
            else
            {
                setLocation(getX(), getY() - 2);
                
            }
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
}
