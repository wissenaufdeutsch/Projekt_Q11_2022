import java.awt.*;
<<<<<<< HEAD

import javax.swing.*;
=======
>>>>>>> 2b35a420505d0d28916a9e671be0a86311039026

import javax.swing.*;

<<<<<<< HEAD



public abstract class RECTANGULAROBJECT extends OBSTACLE

=======
public abstract class RECTANGULAROBJECT extends OBSTACLE
>>>>>>> 2b35a420505d0d28916a9e671be0a86311039026
{
<<<<<<< HEAD


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
=======
    private int w;
    private int h;
    private int x;
    private int y;


>>>>>>> 2b35a420505d0d28916a9e671be0a86311039026

    

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

