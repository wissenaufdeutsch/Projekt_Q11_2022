public class SRLevels
{
    private SRObstacle[][] createObstacleColumns() {
        return new SRObstacle[giveBoxesXDirection()][giveBoxesYDirection()];
    }

    private SRObstacle[][] setRectangleObstacles(SRObstacle[][] obstacleColumns, SRObstacle obstacleType, int xpos, int ypos, int width, int height)
    {
        for (int h = 0; h < height; h++) {
            for (int w = 0; w < width; w++) {
                obstacleColumns[xpos + w][ypos + h] = obstacleType;
            }
        }
        return obstacleColumns;
    }

    public SRObstacle[][] giveLevel(int level)
    {
        switch (level) {
            case 0:
                return giveLevel0();
                
            case 1:
                return giveLevel1();
                
            case 2:
                return giveLevel2();
                
            case 3: 
                return giveLevel3();
                
            default:
                System.out.println("Level " + level + "not available.");
                return null;
        }
    }

    private SRObstacle[][] giveLevel0() {
        SRObstacle[][] obstacleColumns = createObstacleColumns();
        obstacleColumns = setRectangleObstacles(obstacleColumns, new SRDefaultFloor(), 0, 9, 50, 5);
        obstacleColumns = setRectangleObstacles(obstacleColumns, new SRDefaultFloor(), 0, 50, 50, 5);
        obstacleColumns = setRectangleObstacles(obstacleColumns, new SRDefaultFloor(), 40, 30, 100, 5);
        obstacleColumns = setRectangleObstacles(obstacleColumns, new SRDefaultFloor(), 80, 10, 100, 5);

        return obstacleColumns;
    }
    
    private SRObstacle[][] giveLevel1()
    {
        SRObstacle[][] obstacleColumns = createObstacleColumns();
        obstacleColumns = setRectangleObstacles(obstacleColumns, new SRDefaultFloor(), 0, 9, 80, 5);
        obstacleColumns = setRectangleObstacles(obstacleColumns, new SRDefaultFloor(), 80, 9, 20, 12); //deadly
        obstacleColumns = setRectangleObstacles(obstacleColumns, new SRDefaultFloor(), 80, 23, 20, 3);
        obstacleColumns = setRectangleObstacles(obstacleColumns, new SRDefaultFloor(), 25, 9, 15, 10); //deadly
        obstacleColumns = setRectangleObstacles(obstacleColumns, new SRDefaultFloor(), 25, 50, 15, 10); //deadly
        obstacleColumns = setRectangleObstacles(obstacleColumns, new SRDefaultFloor(), 100, 9, 40, 5);
        
        return obstacleColumns;
    }
    
    private SRObstacle[][] giveLevel2()
    {
      SRObstacle[][] obstacleColumns = createObstacleColumns();
      obstacleColumns = setRectangleObstacles(obstacleColumns, new SRDefaultFloor(), 0, 9, 40, 5);
      obstacleColumns = setRectangleObstacles(obstacleColumns, new SRDefaultFloor(), 13, 30, 15, 10); //deadly
      obstacleColumns = setRectangleObstacles(obstacleColumns, new SRDefaultFloor(), 40, 9, 12, 12);
      obstacleColumns = setRectangleObstacles(obstacleColumns, new SRDefaultFloor(), 52, 21, 12, 8);
      obstacleColumns = setRectangleObstacles(obstacleColumns, new SRDefaultFloor(), 64, 29, 12, 8);
      obstacleColumns = setRectangleObstacles(obstacleColumns, new SRDefaultFloor(), 76, 9, 17, 20); //deadly
      obstacleColumns = setRectangleObstacles(obstacleColumns, new SRDefaultFloor(), 76, 37, 17, 10); //deadly
      obstacleColumns = setRectangleObstacles(obstacleColumns, new SRDefaultFloor(), 58, 47, 7, 3);
      obstacleColumns = setRectangleObstacles(obstacleColumns, new SRDefaultFloor(), 45, 50, 13, 5);
      obstacleColumns = setRectangleObstacles(obstacleColumns, new SRDefaultFloor(), 71, 55, 20, 5);
      obstacleColumns = setRectangleObstacles(obstacleColumns, new SRDefaultFloor(), 93, 29, 13, 8);
      obstacleColumns = setRectangleObstacles(obstacleColumns, new SRDefaultFloor(), 99, 9, 40, 5);
        
        return obstacleColumns;
    }
    
    private SRObstacle[][] giveLevel3() {
        SRObstacle[][] obstacleColumns = createObstacleColumns();
        obstacleColumns = setRectangleObstacles(obstacleColumns, new SRDefaultFloor(), 0, 9, 30, 5);
        obstacleColumns = setRectangleObstacles(obstacleColumns, new SRDefaultFloor(), 20, 20, 12, 5);
        obstacleColumns = setRectangleObstacles(obstacleColumns, new SRDefaultFloor(), 32, 20, 60, 5); //deadly
        obstacleColumns = setRectangleObstacles(obstacleColumns, new SRDefaultFloor(), 32, 30, 3, 10);
        obstacleColumns = setRectangleObstacles(obstacleColumns, new SRDefaultFloor(), 42, 40, 3, 10);
        obstacleColumns = setRectangleObstacles(obstacleColumns, new SRDefaultFloor(), 52, 50, 3, 10);
        obstacleColumns = setRectangleObstacles(obstacleColumns, new SRDefaultFloor(), 62, 60, 3, 10);
        obstacleColumns = setRectangleObstacles(obstacleColumns, new SRDefaultFloor(), 72, 50, 3, 10);
        obstacleColumns = setRectangleObstacles(obstacleColumns, new SRDefaultFloor(), 82, 40, 3, 10);
        obstacleColumns = setRectangleObstacles(obstacleColumns, new SRDefaultFloor(), 92, 30, 3, 10);
        obstacleColumns = setRectangleObstacles(obstacleColumns, new SRDefaultFloor(), 95, 9, 30, 5);
        
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
