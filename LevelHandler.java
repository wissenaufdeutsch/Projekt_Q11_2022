public class LevelHandler
{

    Game game;
    Levels levels;

    public LevelHandler(Game game)
    {
        levels = new Levels();
        this.game = game;
    }

    public void addLevel()
    {
        int level = chooseLevel();

        Obstacle[][] obstacleColumnsLevel = levels.giveLevel(level);
        for (Obstacle[] obstacleColumns: obstacleColumnsLevel)
        {
          game.obstacleColumns.add(obstacleColumns);
        }
    }

    private int chooseLevel()
    {
        return 2;
    }
}
