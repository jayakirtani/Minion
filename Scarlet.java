import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Scarlet here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Scarlet extends Enemy
{
    private static boolean playedonce=false;
    private static boolean attackonce=false;
    private boolean attackongoing=false;
    public Scarlet()
    {
        imageL = new GreenfootImage("scarletoverkillL.png");
        imageR = new GreenfootImage("scarletoverkillR.png");
        imageML = new GreenfootImage("scarletoverkillML.png");
        imageMR = new GreenfootImage("scarletoverkillMR.png");
        setImage(imageL);
        stability = 2;
        imageChangeTime = 5;
        birthsound = new GreenfootSound("scarletbirth.mp3");
        deathsound = new GreenfootSound("squish.wav");
        EnemySpeed = 2;
        hitEdge=false;
    }
    public void act() 
    {
        playsound();
        moveEnemy();
    }    
    
    public void moveEnemy()
    {
        Minion mget0 = (Minion) getWorld().getObjects(Minion.class).get(0);
        if (getOneObjectAtOffset (getImage().getWidth()/2+1, 0, Brick.class)!= null)
               hitEdge = true;
        else if (getOneObjectAtOffset (-getImage().getWidth()/2-1, 0, Brick.class)!= null)
               hitEdge = false;
        else if (getOneObjectAtOffset (getImage().getWidth()/2+1, 0, Block.class)!= null)
               hitEdge = true;
        else if (getOneObjectAtOffset (-getImage().getWidth()/2-1, 0, Block.class)!= null)
               hitEdge = false;
        else if (getOneObjectAtOffset (getImage().getWidth()/2+1, 0, Box.class)!= null)
               hitEdge = true;
        else if (getOneObjectAtOffset (-getImage().getWidth()/2-1, 0, Box.class)!= null)
               hitEdge = false;
        if (hitEdge && !attackongoing)
            {
                move(-EnemySpeed);
                setImage(imageL);
            }
        else if (!hitEdge && !attackongoing)
            {
               
                move(EnemySpeed);
                setImage(imageR);
            }
        if(this.getX()>(mget0.getX()-300) && this.getX()<(mget0.getX()+300))
        {
                attackongoing=true;
                attackminion();
        }
        else
            attackongoing=false;
    }
    public void playsound()
    {
        
        Minion mget0 = (Minion) getWorld().getObjects(Minion.class).get(0);
        if(this.getX()>(mget0.getX()-300) && this.getX()<(mget0.getX()+300))
        {
            if(!playedonce)
            {
                birthsound.play();
            }
            playedonce = true;
        }
        else
        {
            playedonce=false;
        }
    }
    
    private boolean intersectssomething()
    {
        if (getOneObjectAtOffset (getImage().getWidth()/2+1, 0, Brick.class)!= null)
               return true;
        else if (getOneObjectAtOffset (-getImage().getWidth()/2-1, 0, Brick.class)!= null)
               return true;
        else if (getOneObjectAtOffset (getImage().getWidth()/2+1, 0, Block.class)!= null)
               return true;
        else if (getOneObjectAtOffset (-getImage().getWidth()/2-1, 0, Block.class)!= null)
               return true;
        else if (getOneObjectAtOffset (getImage().getWidth()/2+1, 0, Box.class)!= null)
               return true;
        else if (getOneObjectAtOffset (-getImage().getWidth()/2-1, 0, Box.class)!= null)
               return true;
        else
            return false;
    }
    
    
    private void attackminion()
    {
        Minion mget0 = (Minion) getWorld().getObjects(Minion.class).get(0);
        if(!attackonce&&!intersectssomething())
        {
                        if(mget0.getX()>getX())
                        {
                            
                            move(EnemySpeed+3);
                            if(this.getX()>(mget0.getX()-50) && this.getX()<(mget0.getX()+50))
                            {
                                setImage(imageMR);
                            }
                            else
                            {
                                setImage(imageR); 
                            }
                        }
                        else if(mget0.getX()<getX())
                        {
                            move((-EnemySpeed-3));
                            if(this.getX()>(mget0.getX()-50) && this.getX()<(mget0.getX()+50))
                            {
                                setImage(imageML);
                            }
                            else
                            {
                                setImage(imageL); 
                            }      
                        }
                        else
                            setImage(imageML);
                            attackonce = true;
                        }
                    else
                        attackonce=false;
    }
}
