import java.util.Set;


//TODO: use the paint method because otherwise player is not erased
//TODO: player not in environment
//TODO: movement of player like in real life (acceleration, velocity, position)
//TODO: collision detection
//TODO: make the obstacles scroll
//TODO: rename method Figurzeichen to drawImg and use it for obstacle as well (img path in Obstacles)
//TODO: change rectangles to images
//TODO: design levels
//TODO: entitys


public class SUNRUNCONTROLLER
{

    boolean done;
    ENVIRONMENTLEVELHANDLER envHandler;
    ENVIRONMENT env;
    SUNRUNVIEW view;

    double interpolation = 0;
    final int TICKS_PER_SECOND = 25;
    final int SKIP_TICKS = 1000 / TICKS_PER_SECOND;
    final int MAX_FRAMESKIP = 5;

    public SUNRUNCONTROLLER()
    {
        this.done = false;

        view = new SUNRUNVIEW(LEVELS.giveBoxesYDirection());
        env = new ENVIRONMENT(LEVELS.giveStartPosPlayer(), view);
        envHandler = new ENVIRONMENTLEVELHANDLER(env);
        envHandler.addLevelEnv();
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
                env.player.jump();
                break;

            case 'a':
                env.player.left();
                break;

            case 's':
                System.out.println("not implemented");
                break;

            case 'd':
                env.player.right();
                break;
        }
    }

    public void displayGame() {
        env.drawObstacles();
        env.drawPlayer();
    }
}
