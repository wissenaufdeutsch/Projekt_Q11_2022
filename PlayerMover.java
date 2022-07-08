class PlayerMover {

    Player player;

    final double jumpSpeed = 15;
    final double gravity = 1.5;
    final double acc = 1;
    final double maxXVel = 12.5;

    public PlayerMover(Player player) {
        this.player = player;
    }

    public void move() {
        double[] pos = player.getPos();
        double[] vel = player.getVel();
        pos[0] += vel[0];
        pos[1] += vel[1];
        gravity();
    }

    public void accLeft() {
        double[] vel = player.getVel();
        vel[0] -= acc;
        vel[0] = (vel[0] < -maxXVel) ?  -maxXVel : vel[0];
    }

    public void accRight() {
        double[] vel = player.getVel();
        vel[0] += acc;
        vel[0] = (vel[0] > maxXVel) ?  maxXVel : vel[0];
    }

    public void jump() {
        double[] vel = player.getVel();
        vel[1] = jumpSpeed;
    }

    public void gravity() {
        double[] vel = player.getVel();
        vel[1] -= gravity;
    }

    /*
    public void slowDown() {
        double[] vel = player.getVel();
        vel[0] -= acc * (vel[0] / (vel[0]);
    }
    */
}
