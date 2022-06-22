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

    
    public void AddObstacle(int width, int height, int xpos, int ypos, int level, OBSTACLE obstacletype)
    {
        for (int j = 0; j<height; j++)
        {
            for (int k = 0; k<width; k++)
            {
                obstaclesColumnsLevels[level][xpos+k][ypos+j] = obstacletype;
            }
        }
    }
}

