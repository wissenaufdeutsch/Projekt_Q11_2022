import java.util.ArrayList;
public class LEVEL
{
    private OBSTACLE [][] obstacles;
    private int ende;
    
    public LEVEL()
    {
        obstacles = new OBSTACLE [1000][1000];
        ende = 0;
        
        RECTANGULAROBJECT r = new RECTANGULAROBJECT (10, 10, 0, 0);
    }
    
    public OBSTACLE[] GiveLevel(int level)
    {
        return obstacles[level];
    }
    
    public void Level1()
    {
        int anzahl = 0;
        
        OBSTACLE o = new RECTANGULAROBJECT(50, 50, 0, 0);
        obstacles[0][0] = o;
        anzahl = anzahl+1;
        
        OBSTACLE a = new RECTANGULAROBJECT(100, 150, 400, 1000);
        obstacles[0][1] = a;
        anzahl = anzahl+1;
        
        OBSTACLE b = new RECTANGULAROBJECT(100, 150, 400, 500);
        obstacles[0][2] = b;
        anzahl = anzahl+1;
        for(int i=0; i<anzahl; i++)
        {
            obstacles[0][i].PaintComponent();
        }
    }
    
    }

