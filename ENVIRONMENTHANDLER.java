public class ENVIRONMENTHANDLER
{
    ENVIRONMENT environment;
    LEVELS levels;
    OBSTACLE[][] obstacleColumnsLevel;
    JUMPNRUNVIEW view;
    
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
        
        obstacleColumnsLevel = levels.GiveLevel(0);
        for (OBSTACLE[] obstacleColumns: obstacleColumnsLevel)
        {
          environment.obstacleColumns.add(obstacleColumns);
        }
    }
    
    public void draw() {
        for (OBSTACLE[] obstacleColumn : obstacleColumnsLevel) {
            for (OBSTACLE obstacle : obstacleColumn) {
                view.drawImg(obstacleobstacle.image);
            }
        }
    }
}
