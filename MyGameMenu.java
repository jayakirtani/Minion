import greenfoot.*;

/**
 * Write a description of class MyGameMenu here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyGameMenu extends World
{
<<<<<<< HEAD
//     static GreenfootSound theme = new GreenfootSound("menutheme2.mp3");
=======
    static GreenfootSound theme = new GreenfootSound("menutheme2.wav");
    StartGame startgame = new StartGame();
    Controls controls = new Controls();
    
>>>>>>> f12712c8997e3a80cf76e0f5662b68fb75989cf3
    /**
     * Constructor for objects of class MyGameMenu.
     * 
     */
    
    public MyGameMenu()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        GreenfootImage gamemenu = new GreenfootImage("GameMenu.png");
        setBackground(gamemenu);
        prepare();
    }

    
    /**
     * Prepare the world for the start of the program. That is: create the initial
     * objects and add them to the world.
     */
    private void prepare()
    {       
        addObject(startgame, 223, 159);   
        addObject(controls, 235, 245);
        controls.setLocation(228, 238);
        controls.setLocation(223, 236);
        startgame.setLocation(301, 143);
        controls.setLocation(302, 215);
        startgame.setLocation(300, 117);
        controls.setLocation(300, 186);
        startgame.setLocation(282, 295);
        controls.setLocation(300, 337);
<<<<<<< HEAD
=======
    }
    
    public void act ()
    {
        if(theme.isPlaying() == false)
         {
             theme.play();
             theme.setVolume(40);
         }
         
        if ( Greenfoot.mouseClicked(startgame) || Greenfoot.mouseClicked(controls) )
        {
            theme.stop();
        }
        
    }

        
    public void stopped()
    {
        theme.pause();
>>>>>>> f12712c8997e3a80cf76e0f5662b68fb75989cf3
    }
//     
//     public void act ()
//     {
//         if(theme.isPlaying() == false)
//          {
//              theme.playLoop();
//          }
//          
//         if ( Greenfoot.mouseClicked(null))
//         {
//             theme.stop();
//         }
//         
//     }
// 
//     
//     public void started()
//     {
//          if(theme.isPlaying() == false)
//          {
//              theme.play();
//          }
//     }
//     
//     public void stopped()
//     {
//         theme.pause();
//     }
}
