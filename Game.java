import java.util.ArrayList;


public class Game
{

    SRView view;
    Player player;
    ArrayList<Obstacle[]> obstacleColumns;

    public Game(double[] startPosPlayer, SRView view) {
        this.view = view;

        obstacleColumns = new ArrayList<Obstacle[]>();

        int[] sizePlayer = {100, 100};
        player = new Player(startPosPlayer, sizePlayer);

        view.setObstacleColumns(obstacleColumns);
        view.setPlayer(player);
    }

    public ArrayList<Obstacle[]> getObstacleColumns() {
        return obstacleColumns;
    }

    public Player getPlayer() {
        return player;
    }
}
