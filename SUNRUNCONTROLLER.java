import java.util.Set;


//TODO: look here: https://learncodebygaming.com/blog/how-to-make-a-video-game-in-java-2d-basics ways of doing things
//TODO: movement of player like in real life (acceleration, velocity, position)
//TODO: collision detection
//TODO: make the obstacles scroll
//TODO: rename method Figurzeichen to drawImg and use it for obstacle as well (img path in Obstacles)
//TODO: change rectangles to images
//TODO: design levels
//TODO: entitys


public class SUNRUNCONTROLLER
{

    LEVELHANDLER levelHandler;
    GAME game;
    SUNRUNVIEW view;

    boolean done;
    double interpolation = 0;
    final int TICKS_PER_SECOND = 25;
    final int SKIP_TICKS = 1000 / TICKS_PER_SECOND;
    final int MAX_FRAMESKIP = 5;

    public SUNRUNCONTROLLER()
    {
        this.done = false;

        view = new SUNRUNVIEW(LEVELS.giveBoxesYDirection(), LEVELS.giveSizeBox());
        game = new GAME(LEVELS.giveStartPosPlayer(), view);
        levelHandler = new LEVELHANDLER(game);
        levelHandler.addLevel();
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

    public void updateGame() {
        Set<Character> pressedKeys = view.getPressedKeys();
        for (char key : pressedKeys) {
            reactToKey(key);
        }
    }

    public void reactToKey(char key)
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

    public void displayGame() {
        view.repaint();
    }
}
