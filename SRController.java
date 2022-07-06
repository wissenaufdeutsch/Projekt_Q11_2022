import java.util.Set;


//TODO: look here: https://learncodebygaming.com/blog/how-to-make-a-video-game-in-java-2d-basics ways of doing things
//TODO: PlayerMover, that contains a AccelerationPositionCalculator and a CollisionDetector
//TODO: make the obstacles scroll
//TODO: change rectangles to images, then rename method Figurzeichen to drawImg and use it for obstacle as well (img path in Obstacles)
//TODO: design levels and choose for infinity run


public class SRController
{

    LevelHandler levelHandler;
    Game game;
    SRView view;

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
        levelHandler = new LevelHandler(game);
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
    }

    private void reactToKey(char key)
    {
        switch (key)
        {
            case 'w':
                game.player.jump();
                break;

            case 'a':
                game.player.left();
                break;

            case 's':
                break;

            case 'd':
                game.player.right();
                break;
        }
    }

    private void displayGame() {
        view.repaint();
    }
}
