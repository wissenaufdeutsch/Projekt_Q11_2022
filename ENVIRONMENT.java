import java.util.ArrayList;


public class ENVIRONMENT
{

  public SUNRUNVIEW view;
  public ArrayList<OBSTACLE[]> obstacleColumns;

  public ENVIRONMENT(int boxesYDirection)
  {
    obstacleColumns = new ArrayList<OBSTACLE[]>();
    view = new SUNRUNVIEW(boxesYDirection);
  }

    public void draw() {
        for (int x = 0; x < obstacleColumns.size(); x++) {
            for (int y = 0; y < obstacleColumns.get(x).length; y++) {
              OBSTACLE obstacle = obstacleColumns.get(x)[y];
              if (obstacle != null) {
                view.drawObstacle(obstacle, x, y);
              }

            }
        }
    }
}
