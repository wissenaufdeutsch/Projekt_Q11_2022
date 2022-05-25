import java.awt.*;

import javax.swing.*;


<<<<<<< HEAD
public class RECTANGULAROBJECT extends OBSTACLE

 abstract public  class RECTANGULAROBJECT

=======
 abstract public  class RECTANGULAROBJECT extends OBSTACLE
>>>>>>> 8dd55383fe49744be52f4c32bf0d25ccc17f2a8f
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


=======
>>>>>>> 8dd55383fe49744be52f4c32bf0d25ccc17f2a8f
    
<<<<<<< HEAD

    }



    void ChangeRectangle(RECTANGULAROBJECT r, int width, int height, int xpos, int ypos)
    {
        r.w = width;
        r.h = height;
        r.x = xpos;
        r.y = ypos;
    }

=======
>>>>>>> 8dd55383fe49744be52f4c32bf0d25ccc17f2a8f
}


<<<<<<< HEAD
=======

>>>>>>> 8dd55383fe49744be52f4c32bf0d25ccc17f2a8f
