


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
        
        OBSTACLE[] obstacleLevel = levels.GiveLevel(0);
        //for (OBSTACLE obstacleColumns: obstacleColumnsLevel)
        //{
        //  environment.obstacles.add(obstacleColumns);
        //}
    }
}
