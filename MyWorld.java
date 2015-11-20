import greenfoot.*;

/**
 * Class MyWorld: sample world to show how to make use of my world super-class SWorld
 */
public class MyWorld extends SWorld
{

    /**
     * Creates a scrolling world using a main actor, a background, some obstacles, and a non-scrolling score.
     */
    public MyWorld()
    {    
        super(1000, 400, 1, 2000); // scroll world constructor call; last parameter is scroll width
        // in the following statement, the main actor is placed at (400, 342) in scroll area coordinates
        addMainActor(new Minion(), 400, 342, 250, 300); // the last two int parameters are centered window x and y ranges
        GreenfootImage bg = new GreenfootImage("spooky.jpg");
        setScrollingBackground(bg); // set the scolling background image
        // add other scrollable objects using scroll area coordinates
        addObject(new Ground(), 500, 390);
        addObject(new Box(), 320, 300);
        // use of the following also adds scrollable objects using scroll area coordinates
        addObject(new Box(), 680, 450, true); // the boolean determines scrollable state
        // use the following for non-scrollable objects using window coordinates (not scroll area coordinates)
        addObject(new Box(), 920, 350);
        addObject(new Score(), 40, 390, false);
    }
}
