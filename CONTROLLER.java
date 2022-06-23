

public class CONTROLLER
{
    boolean done;
    ENVIRONMENTHANDLER envHand;
    
    
    public CONTROLLER() 
    {
        this.done = false;
        envHand = new ENVIRONMENTHANDLER();
    }
    
    public void run() 
    {
        envHand.AddLevel();
        //update everything
    }
    
    public void ReactToKeyboard(String wich, PLAYER p)
    {
        switch (wich)
        {
            case "space": 
                p.jump();
                break;
                
            case "left":
                p.left();
                break;
                
            case "right":
                p.right();
                break;
        }
    }
}

