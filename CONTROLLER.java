public class CONTROLLER
{

    boolean done;
    ENVIRONMENTHANDLER envHandler;

    public CONTROLLER() 
    {
        this.done = false;
        envHandler = new ENVIRONMENTHANDLER();
    }
    
    public void run() 
    {
        envHandler.addLevel();
        while (!done) {
            envHandler.update();
        }
    }
    
    public void ReactToKeyboard(String key, PLAYER player)
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

