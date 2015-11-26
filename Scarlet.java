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
        imageDeath = new GreenfootImage("scarletoverkillDeath.png");
        setImage(imageL);
        stability = 20;
        imageChangeTime = 5;
        birthsound = new GreenfootSound("scarletbirth.mp3");
        deathsound = new GreenfootSound("squish.wav");
        EnemySpeed = 2;
        hitEdge=false;
    }
    public void act() 
    {
        if(!isDead)
        {
            playsound();
            moveEnemy();
        }  
        else
        {
            deathAnimation();
        }
    }    
    
    public void moveEnemy()
    {
        AllMinionState mget0 = (AllMinionState) getWorld().getObjects(AllMinionState.class).get(0);
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
        else if (getOneObjectAtOffset (getImage().getWidth()/2+1, 0, AllMinionState.class)!= null)
            {
                hitMinion = true;
            }
            else if (getOneObjectAtOffset (-getImage().getWidth()/2-1, 0, AllMinionState.class)!= null)
            {
                hitMinion = true;
            }
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
        if(this.getX()>(mget0.getX()-300) && this.getX()<(mget0.getX()+300)&& this.getY()<(mget0.getY()+80))
        {
                attackongoing=true;
                attackminion();
        }
        else
            attackongoing=false;
            
        if( hitMinion == true){
                minion.shrink(getWorld());
            }
    }
    public void playsound()
    {
        
        AllMinionState mget0 = (AllMinionState) getWorld().getObjects(AllMinionState.class).get(0);
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
        AllMinionState mget0 = (AllMinionState) getWorld().getObjects(AllMinionState.class).get(0);
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
