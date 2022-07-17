public class Levels
{
    private Obstacle[][] createObstacleColumns() {
        return new Obstacle[giveBoxesXDirection()][giveBoxesYDirection()];
    }

    private Obstacle[][] setRectangleObstacles(Obstacle[][] obstacleColumns, Obstacle obstacleType, int xpos, int ypos, int width, int height)
    {
        for (int h = 0; h < height; h++) {
            for (int w = 0; w < width; w++) {
                obstacleColumns[xpos + w][ypos + h] = obstacleType;
            }
        }
        return obstacleColumns;
    }

    public Obstacle[][] giveLevel(int level)
    {
        switch (level) {
            case 0:
                return giveLevel0();
            default:
                System.out.println("Level " + level + "not available.");
                return null;
        }
    }

    private Obstacle[][] giveLevel0() {
        Obstacle[][] obstacleColumns = createObstacleColumns();
        obstacleColumns = setRectangleObstacles(obstacleColumns, new DefaultFloor(), 0, 9, 50, 5);
        obstacleColumns = setRectangleObstacles(obstacleColumns, new DefaultFloor(), 0, 50, 50, 5);
        obstacleColumns = setRectangleObstacles(obstacleColumns, new DefaultFloor(), 40, 30, 100, 5);
        return obstacleColumns;
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
