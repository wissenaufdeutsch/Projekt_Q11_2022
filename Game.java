import java.util.ArrayList;


public class Game
{

    SRView view;
    Player player;
    ArrayList<Obstacle[]> obstacleColumns;

    public Game(int[] startPosPlayer, SRView view) {
        this.view = view;

        obstacleColumns = new ArrayList<Obstacle[]>();

        int[] sizePlayer = {30, 50};
        player = new Player(startPosPlayer, sizePlayer);

        view.setObstacleColumns(obstacleColumns);
        view.setPlayer(player);
    }
}
