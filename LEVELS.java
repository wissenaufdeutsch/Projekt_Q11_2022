public class LEVELS
{

    private OBSTACLE [][][] obstaclesColumnsLevels;
    public int boxesYDirection;
    public int boxesXDirection;
    
    public LEVELS()
    {
        boxesXDirection = giveBoxesYDirection();
        boxesYDirection = 100;
        obstaclesColumnsLevels = new OBSTACLE[1000][boxesXDirection][boxesYDirection];
        setObstacles(0, new DEFAULTFLOOR(), 0, 20, 50, 5);
        setObstacles(0, new DEFAULTFLOOR(), 0, 70, 50, 5);
    }

    public static int giveBoxesYDirection() {
        return 100;
    }

    public OBSTACLE[][] giveLevel(int level)
    {
        return obstaclesColumnsLevels[level];
    }

    public void setObstacles(int level, OBSTACLE obstacleType, int xpos, int ypos, int width, int height)
    {
        for (int h = 0; h < height; h++) {
            for (int w = 0; w < width; w++) {
                obstaclesColumnsLevels[level][xpos + w][ypos + h] = obstacleType;
            }
        }
    }
}
