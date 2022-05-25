

public class RECHTECK 
{ 
    private int w;
    private int h;
    private int x;
    private int y;
    public RECHTECK(int width, int height,int xpos, int ypos)
    {
        w = width;
        h = height;
        x = xpos;
        y = ypos;
        
        
    } 

    void ChangeRectangle(RECHTECK r, int width, int height, int xpos, int ypos)
    {
        r.w = width;
        r.h = height;
        r.x = xpos;
        r.y = ypos;
    }
}