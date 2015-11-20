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
        imageL = new GreenfootImage("EvilMinion2L.png");
        imageR = new GreenfootImage("EvilMinion2R.png");
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

    
    public void moveEnemy()
    {
        if (getOneObjectAtOffset (getImage().getWidth()/2+1, 0, Brick.class)!= null)
               hitEdge = true;
        if (getOneObjectAtOffset (-getImage().getWidth()/2-1, 0, Brick.class)!= null)
               hitEdge = false;
        if (getOneObjectAtOffset (getImage().getWidth()/2+1, 0, Block.class)!= null)
               hitEdge = true;
        if (getOneObjectAtOffset (-getImage().getWidth()/2-1, 0, Block.class)!= null)
               hitEdge = false;
        if (getOneObjectAtOffset (getImage().getWidth()/2+1, 0, Box.class)!= null)
               hitEdge = true;
        if (getOneObjectAtOffset (-getImage().getWidth()/2-1, 0, Box.class)!= null)
               hitEdge = false;
        if (getOneObjectAtOffset (getImage().getWidth()/2+1, 0, Minion.class)!= null)
               hitEdge = true;
        if (getOneObjectAtOffset (-getImage().getWidth()/2-1, 0, Minion.class)!= null)
               hitEdge = false;
        if (hitEdge == false)
        {
            move(5);
            setImage(imageR);
        }
        else if (hitEdge == true)
        {
            move(-5);
            setImage(imageL);
        } 
    }
}
