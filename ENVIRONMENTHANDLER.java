public class ENVIRONMENTHANDLER
{

    ENVIRONMENT env;
    LEVELS levels;

    public ENVIRONMENTHANDLER(SUNRUNVIEW view)
    {
        levels = new LEVELS();
        int[] startPosPlayer = {50, 50};
        env = new ENVIRONMENT(startPosPlayer, view);
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
        env.drawObstacles();
        env.drawPlayer();
    }
}
