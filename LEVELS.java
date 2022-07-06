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
        setObstacles(0, new DEFAULTFLOOR(), 0, 9, 50, 5);
        setObstacles(0, new DEFAULTFLOOR(), 0, 60, 50, 5);
    }

    public static int giveBoxesYDirection() {
        return 100;
    }

    public static int giveSizeBox() {
        return 10;
    }

    public void setObstacles(int level, OBSTACLE obstacleType, int xpos, int ypos, int width, int height)
    {
        for (int h = 0; h < height; h++) {
            for (int w = 0; w < width; w++) {
                obstaclesColumnsLevels[level][xpos + w][ypos + h] = obstacleType;
            }
        }
    }

    public OBSTACLE[][] giveLevel(int level)
    {
        return obstaclesColumnsLevels[level];
    }

    // the pos in the level not the frame
    // pos is for the bottom left corner
    public static int[] giveStartPosPlayer() {
        int xStartBox = 10;
        int yStartBox = 20;
        int[] startPosPlayer = {xStartBox * giveSizeBox(), yStartBox * giveSizeBox()};
        return startPosPlayer;
    }
}
