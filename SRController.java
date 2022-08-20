import java.util.Set;

//TODO: player can't jump over the level
//TODO: make the obstacles scroll
//TODO: change rectangles to images
//TODO: design levels and choose for infinity run
//TODO: maybe use interpolation in the game loop and the display

public class SRController {

    LevelHandler levelHandler;
    Game game;
    SRView view;
    PlayerMover playerMover;
    CollisionDetection collisionDetection;

    boolean done;
    double interpolation = 0;
    double[] viewedPoint;

    final int TICKS_PER_SECOND = 25;
    final int SKIPPED_MILISECS_PER_TICK = 1000 / TICKS_PER_SECOND;
    final int MAX_FRAMESKIP = 5;
    final double SCROLLING_SPEED = 2;

    public SRController() {
        done = false;
        viewedPoint = new double[2];
        viewedPoint[0] = 0;
        viewedPoint[1] = 0;

        view = new SRView(Levels.giveBoxesYDirection(), Levels.giveSizeBox());
        game = new Game(Levels.giveStartPosPlayer(), view);
        playerMover = new PlayerMover(game);
        levelHandler = new LevelHandler(game);
        collisionDetection = new CollisionDetection(game, Levels.giveSizeBox());
        levelHandler.addLevel();
        displayGame();
    }

    // TODO: cap the fps
    public void run() {
        double deltaTime;
        double accumulator = 0;
        double timeLastUpdate = System.currentTimeMillis();

        int loops;
        while (true) {
            deltaTime = System.currentTimeMillis() - timeLastUpdate;
            timeLastUpdate += deltaTime;
            accumulator += deltaTime;
            loops = 0;

            while (accumulator > SKIPPED_MILISECS_PER_TICK && loops < MAX_FRAMESKIP) {
                updateGame();

                accumulator -= SKIPPED_MILISECS_PER_TICK;
                loops++;
            }

            displayGame();
        }
    }

    private void updateGame() {
        Set<Character> pressedKeys = view.getPressedKeys();
        reactToKeys(pressedKeys);
        collisionDetection.updateKoordinatesPlayer();
        collisionDetection.updateBoxesPlayerIn();
        double blockingYKoordinate = collisionDetection.getYBoxBlockingMovement();
        playerMover.move(0, blockingYKoordinate);

        viewedPoint[0] += SCROLLING_SPEED;
    }

    private void reactToKeys(Set<Character> pressedKeys) {
        if (pressedKeys.contains('w')) {
            playerMover.tryJumping();
        }
        if (pressedKeys.contains('a') && pressedKeys.contains('d')) {

        } else if (pressedKeys.contains('a')) {
            playerMover.accLeft();
        } else if (pressedKeys.contains('d')) {
            playerMover.accRight();
        }
    }

    private void displayGame() {
        Set<Character> pressedKeys = view.getPressedKeys();
        view.reactToKeys(pressedKeys);
        view.setViewedPoint(viewedPoint);
        view.repaint();
    }
}
