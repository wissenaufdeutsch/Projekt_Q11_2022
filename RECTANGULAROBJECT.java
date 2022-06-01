import java.awt.*;


import javax.swing.*;


public abstract class RECTANGULAROBJECT extends OBSTACLE

{
    private int w;
    private int h;
    private int x;
    private int y;
    public RECTANGULAROBJECT (int width, int height,int xpos, int ypos)
    {
        w = width;
        h = height;
        x = xpos;
        y = ypos;

    } 


}

