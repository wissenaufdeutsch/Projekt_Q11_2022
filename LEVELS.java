import java.util.ArrayList;
import java.awt.Rectangle;


public class LEVELS
{
    private OBSTACLE [][][] obstaclesColumnsLevels;
    
    public LEVELS()
    {
        obstaclesColumnsLevels = new OBSTACLE [1000][1000][20];
    }
    
    public OBSTACLE[][] GiveLevel(int level)
    {
        return obstaclesColumnsLevels[level];
    }
}
    
    

