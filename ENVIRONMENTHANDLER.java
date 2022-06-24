public class ENVIRONMENTHANDLER
{

    ENVIRONMENT env;
    LEVELS levels;

    public ENVIRONMENTHANDLER() 
    {
        levels = new LEVELS();
        env = new ENVIRONMENT(levels.boxesYDirection);
    }

    public int chooseLevel()
    {
        return 0;
    }
    
    public void addLevel()
    {
        int level = chooseLevel();
        
        OBSTACLE[][] obstacleColumnsLevel = levels.giveLevel(level);
        for (OBSTACLE[] obstacleColumns: obstacleColumnsLevel)
        {
          env.obstacleColumns.add(obstacleColumns);
        }
    }

    public void update() {
        env.draw();
    }
}
