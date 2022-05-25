import java.util.ArrayList;
import java.awt.Rectangle;

public class LEVEL
{
    private OBSTACLE [][] obstacles;
    private int ende;
    
    public LEVEL()
    {
        obstacles = new OBSTACLE [1000][1000];
        ende = 0;
        
        RECHTECK r = new RECHTECK (10, 10, 0, 0, false);
    }
    
    public OBSTACLE GiveObstacle(int level, int obstacle)
    {
        return obstacles[level][obstacle];
    }
    

    }

