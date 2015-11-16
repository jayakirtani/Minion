import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
import java.util.ArrayList;
/**
 * Write a description of class SWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SWorld extends World
{

    private int scrolledX, scrolledY; // initial scrolled amount
    private int scrollType; // indicates scrolling directions (0=none, 1=horizontal, 2=vertical, 3=both)
    private int scrollingWidth, scrollingHeight; // limits for main actor within universal coordinates
    Actor mainActor = null; // the actor that always stays visible
    private int actorMinX, actorMaxX, actorMinY, actorMaxY; // limits for main actor within world coordinates
    private GreenfootImage background = null;
    private List<Actor>genActors=new ArrayList(); // lists all generic scrolling actor objects
    
    /**
     * Constructor for objects of class SWorld.
     * 
     */
    public SWorld(int wide, int high, int cellSize, int scrollWide, int scrollHigh)
    {
        super(cellSize==1?wide:(wide/2)*2+1, cellSize==1?high:(high/2)*2+1, cellSize, false);
        scrollType=(scrollWide>wide?1:0)+(scrollHigh>high?2:0);
        scrollingWidth=scrollType%2==1?scrollWide:wide;
        scrollingHeight=scrollType/2==1?scrollHigh:high;
    }
    
    public SWorld(int wide, int high, int cellSize, int scrollWide)
    {
        this(wide, high, cellSize, scrollWide, high);
    }
    
    public void addMainActor(Actor main, int xLoc, int yLoc, int xRange, int yRange)
    {
                if(main == null)
                {
                    System.out.println("Not MAIN actor has been supplied.");
                    System.out.println("");
                    return;
                }
                super.addObject(main, xLoc-scrolledX, yLoc-scrolledY);
                mainActor = main;
                xRange=(int)Math.min(xRange, getWidth());
                yRange=(int)Math.min(yRange, getHeight());
                actorMinX=getWidth()/2-xRange/2;
                actorMaxX=getWidth()/2+xRange/2;
                actorMinY=getHeight()/2-yRange/2;
                actorMaxY=getHeight()/2+yRange/2;
                act();
    }
    
    public void setScrollingBackground(GreenfootImage scrollingBackground)
    {
        if(mainActor==null)
        {
            System.out.println("'setMainActor' MUST be called prior to calling 'setScrollingBackground'.");
            System.out.println("");
            return;
        }
        background = new GreenfootImage(scrollingBackground);
        background.scale(scrollingWidth*getCellSize(), scrollingHeight*getCellSize());
        scrollBackground();
    }
    
    /**
     * Fills the background of the scrolling area with the <i>fillImage</i>.<br><br>
     * NOTE: for this method to work, the main actor must have previously been set with <i>setMainActor</i>.  The image will then
     * be used to fill the background of the scrolling area and is centered in the scrollable world.
     * 
     * @param fillImage the image to fill the background of the scrolling area with
     */
    public void fillScrollingBackground(GreenfootImage fillImage)
    {
        if(mainActor==null)
        {
            System.out.println("setMainActor MUST be called prior to calling fillScrollingBackground");
            System.out.println("");
            return;
        }
        if(fillImage.getWidth()<getWidth() && fillImage.getHeight()<getHeight())
        {
            setBackground(new GreenfootImage(fillImage));
            fillImage = getBackground();
        }
        World world = new World(scrollingWidth*getCellSize(), scrollingHeight*getCellSize(), 1){};
        world.setBackground(fillImage);
        background = new GreenfootImage(world.getBackground());
        scrollBackground();
    }
    
    /**
     * Adds an object into the world, listing it in the Actor array if it is a scrollable object; 
     * the coordinates are of the scrolling area for scrolling objects and of the world if not.
     *
     * @param obj the object to add to the world
     * @param xLoc the x-coordinate to place the object
     * @param yLoc the y-coordinate to place the object
     * @param scroller a flag indicating whether this object is of scrollable type or not
     */
    public void addObject(Actor obj, int xLoc, int yLoc, boolean scroller)
    {
        if (!scroller)
        {
            super.addObject(obj, xLoc, yLoc);
            if (obj == mainActor) act();
            return;
        }
        super.addObject(obj, xLoc-scrolledX, yLoc-scrolledY);
        genActors.add(obj);
    }
    
    /**
     * Adds a scrollable object into the world, listing them in the Actor array.
     *
     * @param obj the scrollable object to add to the world
     * @param xLoc the x-coordinate of the scrolling area to place the object
     * @param yLoc the y-coordinate of the scrolling area to place the object
     */
    public void addObject(Actor obj, int xLoc, int yLoc)
    {
        addObject(obj, xLoc, yLoc, true);
    }
    
    /**
     * Removes an object from the world, re-defining fields as neccessary
     *
     * @param obj the object to be removed from the world
     */
    public void removeObject(Actor obj)
    {
        if(obj==null)return;
        if(obj.equals(mainActor))mainActor=null;
        else genActors.remove(obj);
        super.removeObject(obj);
    }
    
    public void removeObjects(List<Actor>objs)
    {
        for(Actor obj:objs)removeObject(obj);
    }
    
       
    /**
     * Runs the scrolling.
     */
    public void act()
    {
        scrollObjects();
        scrollBackground();
    }
    
    /**
     * Scrolls the background image.
     */
    private void scrollBackground()
    {
        if (background==null) return;
        int c = getCellSize();
        getBackground().drawImage(background, -scrolledX*c, -scrolledY*c);
    }
    
    /*
     * Scrolls all scrollable object.  Determines how far outside boundary limits the main actor is, and moves all neccessary
     * objects in the same direction, moving the main actor back within boundary limits.  A background can be
     * made up of scrollable actor object(s) to produce a scrolling background; however, determining intersectors with object
     * will have to include the background object as being one or more of them when using <i>null</i> for the class of intersector.
     */
    private void scrollObjects()
    {
        if (mainActor==null) return;
         // determine how far the main actor is outside its standard window limits
        int dx=0, dy=0;
        if(mainActor.getX()<actorMinX) dx=actorMinX-mainActor.getX();
        if(mainActor.getX()>actorMaxX) dx=actorMaxX-mainActor.getX();
        if(mainActor.getY()<actorMinY) dy=actorMinY-mainActor.getY();
        if(mainActor.getY()>actorMaxY) dy=actorMaxY-mainActor.getY();
        if(dx==0 && dy==0) return; // not outside window limits
        // ** outside standard window limits **
        int dxSum = dx, dySum = dy; // hold changes in scroll amount
        scrolledX-=dx; scrolledY-=dy;// track scroll amount
        // move main actor back within standard window limits
        mainActor.setLocation(mainActor.getX()+dx, mainActor.getY()+dy);
        // determine how far the background is inside the world limits
        dx=0; dy=0;
        if(scrolledX > scrollingWidth-getWidth()) dx=scrolledX-(scrollingWidth-getWidth());
        if(scrolledX < 0) dx=scrolledX;
        if(scrolledY > scrollingHeight-getHeight()) dy=scrolledY-(scrollingHeight-getHeight());
        if(scrolledY < 0) dy=scrolledY;
        // ** background does not completely cover world limits
        dxSum+=dx; dySum+=dy; // keep running sum of changes in scroll amount
        scrolledX-=dx; scrolledY-=dy; // adjust scroll amount
        // move all objects so background covers the world
        mainActor.setLocation(mainActor.getX()+dx, mainActor.getY()+dy);
        for(Object obj : genActors)
        {
            Actor actor=(Actor)obj;
            actor.setLocation(actor.getX()+dxSum, actor.getY()+dySum);
        }
        // determine how far main actor is outside universal limits
        dx=0; dy=0;
        if(mainActor.getX() < 0) dx=0-mainActor.getX();
        if(mainActor.getX() > getWidth()-1) dx=(getWidth()-1)-mainActor.getX();
        if(mainActor.getY() < 0) dy=0-mainActor.getY();
        if(mainActor.getY() > getHeight()-1) dy=(getHeight()-1)-mainActor.getY();
        if(dx==0 && dy==0) return;
        // ** outside universal limits
        // move main actor back within world limits
        mainActor.setLocation(mainActor.getX()+dx, mainActor.getY()+dy);
        
        
        
    }
     /**
     * Returns the horizonal offset from the top-left corner of the scrolling world of the 'x' value given,
     * where 'x' is the horizontal offset from the top-left corner of the view window.
     *
     * @param worldX a horizontal offset from the top-left corner of the visible world
     * @return the absolute horizontal offset from the top-left corner of the scrolling world
     */
    public int getUnivX(int worldX)
    {
        return (scrollingWidth-getWidth())/2+worldX+scrolledX;
    }
    
    /**
     * Returns the vertical offset from the top-left corner of the scrolling world of the 'y' value given,
     * where 'y' is the vertical offset from the top-left corner of the view window.
     *
     * @param worldX a vertical offset from the top-left corner of the visible world
     * @return the absolute vertical offset from the top-left corner of the scrolling world
     */
    public int getUnivY(int worldY)
    {
        return (scrollingHeight-getHeight())/2+worldY+scrolledY;
    }
    
    /**
     * Returns the width of the scrolling area of the universe
     *
     * @return the width of the visible scrolling area
     */
    public int getScrollingWidth()
    {
        return scrollingWidth;
    }
    
    /**
     * Returns the height of the scrolling area of the universe
     *
     * @return the height of the visible scrolling area
     */
    public int getScrollingHeight()
    {
        return scrollingHeight;
    }
    
    
}