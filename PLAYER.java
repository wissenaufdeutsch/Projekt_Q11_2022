public class PLAYER
{

    public int xpos;
    public int ypos;
    public int width;
    public int height;

    public PLAYER(int startX, int startY, int width, int height)
    {
        xpos = startX;
        ypos = startY;
        this.width = width;
        this.height = height;
    }
    
    public void jump()
    {
        ypos = ypos+1;
    }
    
    public void left()
    {
        xpos = xpos+1;
    }
    
    public void right()
    {
        xpos = xpos-1;
    }
}
