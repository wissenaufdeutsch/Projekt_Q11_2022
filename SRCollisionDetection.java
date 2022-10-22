import java.util.ArrayList;


class SRCollisionDetection {

    SRPlayer player;
    ArrayList<SRObstacle[]> obstacleColumns;

    double xLeftOfPlayer;
    double xRightOfPlayer;
    double yTopOfPlayer;
    double yBottomOfPlayer;

    int xBoxLeftOfPlayerIn;
    int xBoxRightOfPlayerIn;
    int yBoxTopOfPlayerIn;
    int yBoxBottomOfPlayerIn;

    int sizeBox;

    public SRCollisionDetection(SRGame game, int sizeBox) {
        this.sizeBox = sizeBox;

        player = game.getPlayer();
        obstacleColumns = game.getObstacleColumns();
    }

    public void updateKoordinatesPlayer() {
        double[] pos = player.getPos();
        int[] size = player.getSize();
        //TODO: do this in player
        //TODO: define the player by the sides and not the witdh
        xLeftOfPlayer = pos[0];
        xRightOfPlayer = pos[0] + size[0];
        yTopOfPlayer = pos[1] + size[1];
        yBottomOfPlayer = pos[1];
    }

    public void updateBoxesPlayerIn() {
        xBoxLeftOfPlayerIn = (int) (xLeftOfPlayer / sizeBox);
        xBoxRightOfPlayerIn = (int) (xRightOfPlayer / sizeBox);
        yBoxTopOfPlayerIn = (int) (yTopOfPlayer / sizeBox);
        yBoxBottomOfPlayerIn = (int) (yBottomOfPlayer / sizeBox);
    }

    //TODO: also Collision when vel = 0 but player.bottom
    public double getYBoxBlockingMovement() {
        double yVel = player.getVel()[1];
        int direction = getDirectionToLook(yVel);
        double sideDirectionOfMovement = getYAxisSideDirectionOfMovement(direction);
        int boxSideDirectionOfMovement = getYAxisBoxSideDirectionOfMovement(direction);
        double distancePlayerInOutsideBox = getDistancePlayerInOutsideBox(sideDirectionOfMovement);

        //System.out.println("vel: " + yVel + ", direction: " + direction + ", sideDirectionOfMovement: " + sideDirectionOfMovement +
        //                   ", boxSideDirectionOfMovement: " + boxSideDirectionOfMovement + ", distancePlayerInOutsideBox: " + distancePlayerInOutsideBox);
        for (int xBox = xBoxLeftOfPlayerIn; xBox < xBoxRightOfPlayerIn; ++xBox) {
            for (int yBox = 0; !isDistanceEnoughForMovement(yBox, yVel, distancePlayerInOutsideBox, direction); yBox += direction) {
                if (obstacleColumns.get(xBox)[boxSideDirectionOfMovement + yBox] != null) {
                    double blockingYKoordinate = (yBox + boxSideDirectionOfMovement) * sizeBox;
                    if (direction == -1) {
                        blockingYKoordinate += sizeBox;
                    }
                    return blockingYKoordinate;
                }
            }
        }
        return -1;
    }


    public double getXBoxBlockingMovement() {
        double xVel = player.getVel()[0];
        int direction = getDirectionToLook(xVel);
        double sideDirectionOfMovement = getYAxisSideDirectionOfMovement(direction);
        int boxSideDirectionOfMovement = getYAxisBoxSideDirectionOfMovement(direction);
        double distancePlayerInOutsideBox = getDistancePlayerInOutsideBox(sideDirectionOfMovement);

        //System.out.println("vel: " + xVel + ", direction: " + direction + ", sideDirectionOfMovement: " + sideDirectionOfMovement +
        //                   ", boxSideDirectionOfMovement: " + boxSideDirectionOfMovement + ", distancePlayerInOutsideBox: " + distancePlayerInOutsideBox);
        for (int yBox = yBoxBottomOfPlayerIn; yBox < yBoxTopOfPlayerIn; ++yBox) {
            for (int xBox = 0; !isDistanceEnoughForMovement(xBox, xVel, distancePlayerInOutsideBox, direction); xBox += direction) {
                if (obstacleColumns.get(yBox)[boxSideDirectionOfMovement + xBox] != null) {
                    double blockingXKoordinate = (xBox + boxSideDirectionOfMovement) * sizeBox;
                    if (direction == -1) {
                        blockingXKoordinate += sizeBox;
                    }
                    return blockingXKoordinate;
                }
            }
        }
        return -1;
    }

    private int getDirectionToLook(double vel) {
        if (vel > 0) {
            return 1;
        } else {
            return -1;
        }
    }

    private double getYAxisSideDirectionOfMovement(int direction) {
        if (direction == 1) {
            return yTopOfPlayer;
        } else {
            return yBottomOfPlayer;
        }
    }

    private double getXAxisSideDirectionOfMovement(int direction) {
        if (direction == 1) {
            return xRightOfPlayer;
        } else {
            return xLeftOfPlayer;
        }
    }

    private int getYAxisBoxSideDirectionOfMovement(int direction) {
        if (direction == 1) {
            return yBoxTopOfPlayerIn;
        } else {
            return yBoxBottomOfPlayerIn;
        }
    }

    private int getXAxisBoxSideDirectionOfMovement(int direction) {
        if (direction == 1) {
            return xBoxRightOfPlayerIn;
        } else {
            return xBoxLeftOfPlayerIn;
        }
    }

    private double getDistancePlayerInOutsideBox(double koordinateSidePlayer) {
        return koordinateSidePlayer % sizeBox;
    }


    private boolean isDistanceEnoughForMovement(int box, double vel, double distancePlayerInOutsideBox, int direction) {
        double blockingYKoordinate = Math.abs(box) * sizeBox;
        if (direction == -1) {
            blockingYKoordinate -= sizeBox;
        }
        return  blockingYKoordinate - distancePlayerInOutsideBox > Math.abs(vel);
    }
}
