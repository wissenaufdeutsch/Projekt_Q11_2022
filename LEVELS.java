import java.util.ArrayList;
import java.awt.Rectangle;

public class LEVELS
{
    private OBSTACLE [][] obstacles;
    private int ende;
    
    public LEVELS()
    {
        obstacles = new OBSTACLE [1000][1000];
        ende = 0;



    }
    public OBSTACLE[] GiveLevel(int level)
    {
        return obstacles[level];
    }
    
    }
    
    

