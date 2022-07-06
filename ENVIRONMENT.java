import java.util.ArrayList;


public class ENVIRONMENT
{

    public SUNRUNVIEW view;

    public ArrayList<OBSTACLE[]> obstacleColumns;
    public PLAYER player;

    public ENVIRONMENT(int[] startPosPlayer, SUNRUNVIEW view) {

        this.view = view;

        obstacleColumns = new ArrayList<OBSTACLE[]>();

        int[] sizePlayer = {30, 50};
        player = new PLAYER(startPosPlayer, sizePlayer);

        view.setObstacleColumns(obstacleColumns);
        view.setPlayer(player);
    }
}
