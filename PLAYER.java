public class PLAYER
{

    public int[] pos;
    public int[] size;

    public PLAYER(int[] startPos, int[] size)
    {
        pos = startPos;
        this.size = size;
    }
    
    public void jump()
    {
        pos[1] += 1;
    }
    
    public void left()
    {
        pos[0] += 1;
    }
    
    public void right()
    {
        pos[0] -= 1;
    }
}
