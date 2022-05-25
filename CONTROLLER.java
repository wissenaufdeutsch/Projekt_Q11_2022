


public class CONTROLLER
{
    boolean done;
    ENVIRONMENT environment;
    String mode;
    
    public CONTROLLER(String mode) {
        this.mode = mode;
        this.done = false;
        LEVEL level = chooseLevel();
        //create env
        
    }
    
    public LEVEL chooseLevel() {
        //choose a Level (whatch mode)
        return null;
    }
    
    public void run() {
        while(!done) {
            //update everything
        }
    }
}
