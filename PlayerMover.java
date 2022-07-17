import java.util.ArrayList;


class PlayerMover {

    CollisionDetection collisionDetection;
    Player player;
    ArrayList<Obstacle[]> obstacleColumns;
    boolean isAccelerating;
    boolean shouldJump;

    final double reboundReduction = 0;
    final double jumpVel = 25;
    final double gravity = 1.5;
    final double acc = 1;
    final double drag = acc / 3;
    final double maxXVel = 12.5;

    public PlayerMover(Game game) {
        player = game.getPlayer();
        isAccelerating = false;
        shouldJump = false;
    }

    //TODO: sometimes player pulled down to fast when collision on the floor
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
                shouldJump = false;
            } else {
                pos[1] = blockingYKoordinate;
                if (shouldJump) {
                    jump();
                }
            }

        } else {
            gravity();
        }
        pos[1] += vel[1];
        pos[0] += vel[0];
        isAccelerating = false;
        shouldJump = false;
    }

    public void tryJumping() {
        shouldJump = true;
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

    private void jump() {
        double[] vel = player.getVel();
        vel[1] = jumpVel;
    }

    private void gravity() {
        double[] vel = player.getVel();
        vel[1] -= gravity;
    }

    private void slowDown() {
        double[] vel = player.getVel();
        if (Math.abs(vel[0]) < drag) {
            vel[0] = 0;
            return;
        }
        vel[0] -= drag * (vel[0] / Math.abs(vel[0]));
    }
}
