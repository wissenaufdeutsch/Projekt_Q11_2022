public class CONTROLLER
{

    boolean done;
    ENVIRONMENTLEVELHANDLER envHandler;
    ENVIRONMENT env;
    SUNRUNVIEW view;

    public CONTROLLER()
    {
        this.done = false;

        view = new SUNRUNVIEW(LEVELS.giveBoxesYDirection());
        env = new ENVIRONMENT(LEVELS.giveStartPosPlayer(), view);
        envHandler = new ENVIRONMENTLEVELHANDLER(env);
        envHandler.addLevelEnv();
    }
    
    public void run() 
    {
        while (!done) {
            //String [] pressedKeys = view.getPressedKeys();
            //reactToKeyboard(pressedKeys);
            env.drawObstacles();
            env.drawPlayer();
        }
    }

    public void reactToKeyboard(String[] keys)
    {
        for (String key : keys) {
            switch (key)
            {
                case "space":
                    // player jump
                    break;

                case "left":
                    // player go right
                    break;

                case "right":
                    // player go left
                    break;
            }
        }
    }
}

