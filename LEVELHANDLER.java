public class LEVELHANDLER
{

    GAME game;
    LEVELS levels;

    public LEVELHANDLER(GAME game)
    {
        levels = new LEVELS();
        this.game = game;
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
          game.obstacleColumns.add(obstacleColumns);
        }
    }
}
