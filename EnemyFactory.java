/**
 * Write a description of class EnemyFactory here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EnemyFactory  
{
    public Enemy makeEnemy(String E)
    {
        if(E.equals("EM"))
        {
            return new EvilMinion();
        }
        else
        {
            return null;
        }
    }
}
