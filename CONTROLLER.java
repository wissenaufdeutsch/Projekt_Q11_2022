


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
        while(!done)
        {
            //update everything
        }
    }
    
    
}
