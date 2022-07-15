import java.util.Set;


//TODO: player can't jump over the level
//TODO: upwards collision doesn't work at all, downwards kindof but to far away
//TODO: think of a better architecture
//TODO: put collision detection into Controller and pass a collision to PlayerMover
//TODO: look here: https://learncodebygaming.com/blog/how-to-make-a-video-game-in-java-2d-basics ways of doing things
//TODO: drawImg in panel
//TODO: private methods in PlayerMover
//TODO: sometimes keypress is not detected
//TODO: make the obstacles scroll
//TODO: change rectangles to images, then rename method Figurzeichen to drawImg and use it for obstacle as well (img path in Obstacles)
//TODO: design levels and choose for infinity run


public class SRController
{

    LevelHandler levelHandler;
    Game game;
    SRView view;
    PlayerMover playerMover;
    CollisionDetection collisionDetection;

    boolean done;
    double interpolation = 0;
    final int TICKS_PER_SECOND = 25;
    final int SKIP_TICKS = 1000 / TICKS_PER_SECOND;
    final int MAX_FRAMESKIP = 5;

    public SRController()
    {
        this.done = false;

        view = new SRView(Levels.giveBoxesYDirection(), Levels.giveSizeBox());
        game = new Game(Levels.giveStartPosPlayer(), view);
        playerMover = new PlayerMover(game);
        levelHandler = new LevelHandler(game);
        collisionDetection = new CollisionDetection(game, Levels.giveSizeBox());
        levelHandler.addLevel();
        displayGame();
    }

    public void run() {
        double next_game_tick = System.currentTimeMillis();
        int loops;

        while (true) {
            loops = 0;
            while (System.currentTimeMillis() > next_game_tick
                    && loops < MAX_FRAMESKIP) {

                updateGame();

                next_game_tick += SKIP_TICKS;
                loops++;
            }

            interpolation = (System.currentTimeMillis() + SKIP_TICKS - next_game_tick
                    / (double) SKIP_TICKS);
            displayGame();
        }
    }

    private void updateGame() {
        Set<Character> pressedKeys = view.getPressedKeys();
        for (char key : pressedKeys) {
            reactToKey(key);
        }
        collisionDetection.updateKoordinatesPlayer();
        collisionDetection.updateBoxesPlayerIn();
        double blockingYKoordinate = collisionDetection.getYBoxBlockingMovement();
        playerMover.move(0, blockingYKoordinate);

    }

    private void reactToKey(char key)
    {
        switch (key)
        {
            case 'w':
                playerMover.jump();
                break;

            case 'a':
                playerMover.accLeft();
                break;

            case 'd':
                playerMover.accRight();
                break;
        }
    }

    private void displayGame() {
        view.repaint();
    }
}
