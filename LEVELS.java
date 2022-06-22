import java.util.ArrayList;
import java.awt.Rectangle;


public class LEVELS
{ 
    private OBSTACLE [][][] obstaclesColumnsLevels;
    
    public LEVELS()
    {
        obstaclesColumnsLevels = new OBSTACLE [1000][1000][20];
        obstaclesColumnsLevels[0][0][0] = new DEFAULTFLOOR();
    }
    
    
    public OBSTACLE[][] GiveLevel(int level)
    {
        return obstaclesColumnsLevels[level];
    }
}
    
    

