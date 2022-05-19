import java.util.ArrayList;
public class LEVEL
{
    private OBSTACLE [][] obstacles;
    private int ende;
    public LEVEL()
    {
        obstacles = new OBSTACLE [1000][1000];
        ende = 0;
    }
    
    public OBSTACLE GiveObstacle(int level, int obstacle)
    {
        return obstacles[level][obstacle];
    }
    }

