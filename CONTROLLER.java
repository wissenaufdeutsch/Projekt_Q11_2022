public class CONTROLLER
{

    boolean done;
    ENVIRONMENTHANDLER envHandler;
    SUNRUNVIEW view;

    public CONTROLLER() 
    {
        this.done = false;
        view = new SUNRUNVIEW(LEVELS.giveBoxesYDirection());
        envHandler = new ENVIRONMENTHANDLER(view);
    }
    
    public void run() 
    {
        envHandler.addLevel();
        while (!done) {
            envHandler.update();
        }
    }
    
    public void reactToKeyboard(String key, PLAYER player)
    {
        switch (key)
        {
            case "space": 
                player.jump();
                break;
                
            case "left":
                player.left();
                break;
                
            case "right":
                player.right();
                break;
        }
    }
}

