import java.awt.*;

import javax.swing.*;

public  class RECTANGULAROBJECT extends OBSTACLE
{

    public RECTANGULAROBJECT()
    {

    }
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

    void zeichnen(Graphics g)
    {
        g.drawRect(w,h,x,y);

    }

    void ChangeRectangle(RECTANGULAROBJECT r, int width, int height, int xpos, int ypos)
    {
        r.w = width;
        r.h = height;
        r.x = xpos;
        r.y = ypos;
    }

}

