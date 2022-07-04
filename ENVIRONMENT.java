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

    int[] sizePlayer = {30, 50};
    player = new PLAYER(startPosPlayer, sizePlayer);
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
