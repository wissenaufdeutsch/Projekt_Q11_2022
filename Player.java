public class Player
{

    double[] pos;
    double[] vel;
    int[] size;

    public Player(double[] startPos, int[] size)
    {
        pos = startPos;

        double[] startVel = {0, 0};
        vel = startVel;

        this.size = size;
    }

    public double[] getPos() {
        return pos;
    }

    public double[] getVel() {
        return vel;
    }

    public void setPos(double[] pos) {
        this.pos = pos;
    }

    public void setVel(double[] vel) {
        this.vel = vel;
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
