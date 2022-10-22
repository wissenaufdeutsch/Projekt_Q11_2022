public class SRPlayer
{

    double[] pos;
    double[] vel;
    int[] size;

    public SRPlayer(double[] startPos, int[] size)
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

    public int[] getSize() {
        return size;
    }

    public void setPos(double[] pos) {
        this.pos = pos;
    }

    public void setVel(double[] vel) {
        this.vel = vel;
    }
}
