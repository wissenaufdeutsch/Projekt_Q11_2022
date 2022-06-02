


public class ENVIRONMENTHANDLER
{
    ENVIRONMENT environment;
    LEVELS levels;
    public ENVIRONMENTHANDLER() 
    {
        environment = new ENVIRONMENT();
        levels = new LEVELS();
    }

    public int chooseLevel()
    {
        return 0;
    }
    
    public void AddLevel()
    {

        int level = chooseLevel();
        
        OBSTACLE[] obstaclesLevel = levels.GiveLevel(0);
        for (OBSTACLE obstacle: obstaclesLevel)
        {
          environment.obstacles.add(obstacle);
        }
    }
}
