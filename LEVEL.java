import java.util.ArrayList;
public class LEVEL
{
    private OBSTACLE [][] obstacles;
    private int ende;
    
    public LEVEL()
    {
        obstacles = new OBSTACLE [1000][1000];
        ende = 0;
        
        obstacles[0][0] = new RECHTECK(10, 10, 0, 0);
        obstacles[0][1] = new RECHTECK(50, 100, 500, 600);
    }
    
    public OBSTACLE[] GiveLevel(int level)
    {
        return obstacles[level];
    }
    
    }

