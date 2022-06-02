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


        obstacles[0][0] = new RECHTECK(10, 10, 0, 0);
        ende = ende+1;
        
        obstacles[0][1] = new RECHTECK(50, 100, 500, 600);
        ende = ende+1;
    }
    
    public OBSTACLE[] GiveLevel(int level)
    {
        return obstacles[level];
    }
    
    }
    
    

