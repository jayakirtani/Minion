import greenfoot.*;

/**
 * Write a description of class Castlebricks here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Castlebricks extends Brick
{
      public Castlebricks()
    {
       
    }
    public void act()
    {
       act2();
       action();
    }
    public void action()
    {
        if(getWorld() instanceof MyWorld && counter% 6 ==0)
            {
                setImage(bricks);
                //System.out.println("here");
                counter++;
    }
    }
}
