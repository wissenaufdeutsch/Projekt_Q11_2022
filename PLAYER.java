
public class PLAYER
{
    private int xpos;
    private int ypos;
    private int height;
    private int width;


    public PLAYER()
    {
        xpos = 0;
        ypos = 1000;
        width = 40;
        height = 40;
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
