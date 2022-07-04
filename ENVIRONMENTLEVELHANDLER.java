public class ENVIRONMENTLEVELHANDLER
{

    ENVIRONMENT env;
    LEVELS levels;

    public ENVIRONMENTLEVELHANDLER(ENVIRONMENT env)
    {
        levels = new LEVELS();
        this.env = env;
    }

    public int chooseLevel()
    {
        return 0;
    }
    
    public void addLevelEnv()
    {
        int level = chooseLevel();
        
        OBSTACLE[][] obstacleColumnsLevel = levels.giveLevel(level);
        for (OBSTACLE[] obstacleColumns: obstacleColumnsLevel)
        {
          env.obstacleColumns.add(obstacleColumns);
        }
    }
}
