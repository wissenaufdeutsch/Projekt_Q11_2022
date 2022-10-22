import java.util.ArrayList;


public class SRGame
{

    SRView view;
    SRPlayer player;
    ArrayList<SRObstacle[]> obstacleColumns;

    public SRGame(double[] startPosPlayer, SRView view) {
        this.view = view;

        obstacleColumns = new ArrayList<SRObstacle[]>();

        int[] sizePlayer = {100, 100};
        player = new SRPlayer(startPosPlayer, sizePlayer);

        view.setObstacleColumns(obstacleColumns);
        view.setPlayer(player);
    }

    public ArrayList<SRObstacle[]> getObstacleColumns() {
        return obstacleColumns;
    }

    public SRPlayer getPlayer() {
        return player;
    }
}
