import java.util.ArrayList;


public class ENVIRONMENT
{

  public SUNRUNVIEW view;

  public ArrayList<OBSTACLE[]> obstacleColumns;
  public PLAYER player;

  public ENVIRONMENT(int[] startPosPlayer, SUNRUNVIEW view)
  {
    this.view = view;

    obstacleColumns = new ArrayList<OBSTACLE[]>();
    player = new PLAYER(startPosPlayer[0], startPosPlayer[1], 50, 50);
  }

  public void drawObstacles() {
    for (int x = 0; x < obstacleColumns.size(); x++) {
      for (int y = 0; y < obstacleColumns.get(x).length; y++) {
        OBSTACLE obstacle = obstacleColumns.get(x)[y];
        if (obstacle != null) {
          view.drawObstacle(obstacle, x, y);
        }
      }
    }
  }

  public void drawPlayer() {
    view.drawPlayer(player);
  }
}
