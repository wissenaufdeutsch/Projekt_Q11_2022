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
        pos[1] += 5;
    }
    
    public void left()
    {
        pos[0] -= 5;
    }
    
    public void right()
    {
        pos[0] += 5;
    }
}
