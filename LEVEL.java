import java.util.ArrayList;
public class LEVEL
{
    private OBSTACLE [][] obstacles;
    private int ende;
    
    public LEVEL()
    {
        obstacles = new OBSTACLE [1000][1000];
        ende = 0;
        
        RECHTECK r = new RECHTECK(10, 10, 0, 0);
    }
    
    public OBSTACLE GiveObstacle(int level, int obstacle)
    {
        return obstacles[level][obstacle];
    }
    
    public void Level1()
    {
        OBSTACLE o = new RECTANGULAROBJECT();
        
        obstacles[0][0] = o;
    }
    
    }

