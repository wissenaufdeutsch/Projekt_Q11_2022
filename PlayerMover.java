import java.util.ArrayList;


class PlayerMover {

    CollisionDetection collisionDetection;
    Player player;
    ArrayList<Obstacle[]> obstacleColumns;
    boolean isAccelerating;

    final double reboundReduction = 0;
    final double jumpSpeed = 25;
    final double gravity = 1.5;
    final double acc = 1;
    final double drag = acc / 3;
    final double maxXVel = 12.5;

    public PlayerMover(Game game) {
        player = game.getPlayer();
        isAccelerating = false;
    }

    public void move(double blockingXKoordinate, double blockingYKoordinate) {
        if (!isAccelerating) {
            slowDown();
        }
        double[] pos = player.getPos();
        double[] vel = player.getVel();
        int[] size = player.getSize();
        if (blockingYKoordinate != -1) {
            vel[1] *= -reboundReduction;
            if (blockingYKoordinate > pos[1] + size[1] / 2) {
                pos[1] = blockingYKoordinate - size[1];
            } else {

                pos[1] = blockingYKoordinate;
            }

        } else {
            gravity();
        }
        pos[1] += vel[1];
        pos[0] += vel[0];
        isAccelerating = false;
    }

    public void accLeft() {
        isAccelerating = true;
        double[] vel = player.getVel();
        vel[0] -= acc;
        vel[0] = (vel[0] < -maxXVel) ?  -maxXVel : vel[0];
    }

    public void accRight() {
        isAccelerating = true;
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

    public void slowDown() {
        double[] vel = player.getVel();
        if (Math.abs(vel[0]) < drag) {
            vel[0] = 0;
            return;
        }
        vel[0] -= drag * (vel[0] / Math.abs(vel[0]));
    }
}
