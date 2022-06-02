


public class ENVIRONMENTHANDLER
{
    ENVIRONMENT environment;
    
    public ENVIRONMENTHANDLER(String mode) 
    {
        int level = chooseLevel();
        environment = new ENVIRONMENT();
    }

    public int chooseLevel()
    {
        return 0;
    }
    
    public void AddLevel()
    {
        LEVEL level = new LEVEL();
        
        OBSTACLE[] obstaclesLevel = level.GiveLevel(0);
        for (OBSTACLE obstacle: obstaclesLevel)
        {
          environment.obstacles.add(obstacle);
        }
    }
}
