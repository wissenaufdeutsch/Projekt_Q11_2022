


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
        environment = new ENVIRONMENT();
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
    
    public void Level0()
    {
        LEVEL level = new LEVEL();
        
        OBSTACLE[] obstaclesLevel0 = level.GiveLevel(0);
        for (OBSTACLE obstacle: obstaclesLevel0)
        {
          environment.obstacles.add(obstacle);
        }
    }
}
