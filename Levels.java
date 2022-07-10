public class Levels
{

    Obstacle[][][] obstaclesColumnsLevels;

    public Levels()
    {
        obstaclesColumnsLevels = new Obstacle[1000][giveBoxesXDirection()][giveBoxesYDirection()];
        setObstacles(0, new DefaultFloor(), 0, 9, 50, 5);
        setObstacles(0, new DefaultFloor(), 0, 50, 50, 5);
        setObstacles(0, new DefaultFloor(), 40, 30, 100, 5);

    }

    private void setObstacles(int level, Obstacle obstacleType, int xpos, int ypos, int width, int height)
    {
        for (int h = 0; h < height; h++) {
            for (int w = 0; w < width; w++) {
                obstaclesColumnsLevels[level][xpos + w][ypos + h] = obstacleType;
            }
        }
    }

    public Obstacle[][] giveLevel(int level)
    {
        return obstaclesColumnsLevels[level];
    }

    public static int giveBoxesXDirection() {
        return 1000;
    }

    public static int giveBoxesYDirection() {
        return 100;
    }

    public static int giveSizeBox() {
        return 10;
    }

    // the pos in the level not the frame
    // pos is for the bottom left corner
    public static double[] giveStartPosPlayer() {
        double xStartBox = 10;
        double yStartBox = 20;
        double[] startPosPlayer = {xStartBox * giveSizeBox(), yStartBox * giveSizeBox()};
        return startPosPlayer;
    }
}
