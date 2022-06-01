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


        //RECTANGULAROBJECT r = new RECTANGULAROBJECT (10, 10, 0, 0);


        RECHTECK r = new RECHTECK (10, 10, 0, 0, false);

        RECTANGULAROBJECT r = new RECTANGULAROBJECT (10, 10, 0, 0);

    }
    
    public OBSTACLE[] GiveLevel(int level)
    {
        return obstacles[level];
    }
    
    public void Level1()
    {
        int anzahl = 0;
        
        OBSTACLE o = new RECHTECK(50, 50, 0, 0, true);
        obstacles[0][0] = o;
        anzahl = anzahl+1;
        
        OBSTACLE a = new RECHTECK(150, 100, 400, 1000, true);
        obstacles[0][1] = a;
        anzahl = anzahl+1;
        
        OBSTACLE b = new RECHTECK(150, 100, 400, 500, true);
        obstacles[0][2] = b;
        anzahl = anzahl+1;
        
        OBSTACLE c = new RECHTECK(500, 100, 900, 700, false);
        for(int i=0; i<anzahl; i++)
        {
            obstacles[0][i].PaintComponent();
        }
    }
    
    
    
    public OBSTACLE[] GiveLevel(int level)
    {
        return obstacles[level];
    }
    
    public void Level1()
    {
        int anzahl = 0;
        
        // OBSTACLE o = new RECHTECK(50, 50, 0, 0);
        // obstacles[0][0] = o;
        // anzahl = anzahl+1;
        
        // OBSTACLE a = new RECHTECK(150, 100, 400, 1000);
        // obstacles[0][1] = a;
        // anzahl = anzahl+1;
        
        // OBSTACLE b = new RECHTECK(150, 100, 400, 500);
        // obstacles[0][2] = b;
        // anzahl = anzahl+1;
        
        // OBSTACLE c = new RECHTECK(500, 100, 900, 700);
        // for(int i=0; i<anzahl; i++)
        // {
            // obstacles[0][i].PaintComponent();
        // }
    }
    
    }

