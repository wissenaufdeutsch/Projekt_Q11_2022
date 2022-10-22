public class SRLevelHandler
{

    SRGame game;
    SRLevels levels;

    public SRLevelHandler(SRGame game)
    {
        levels = new SRLevels();
        this.game = game;
    }

    public void addLevel()
    {
        int level = chooseLevel();

        SRObstacle[][] obstacleColumnsLevel = levels.giveLevel(level);
        for (SRObstacle[] obstacleColumns: obstacleColumnsLevel)
        {
          game.obstacleColumns.add(obstacleColumns);
        }
    }

    private int chooseLevel()
    {
        return 3;
    }
}
