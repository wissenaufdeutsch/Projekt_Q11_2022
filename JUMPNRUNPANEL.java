import javax.swing.*;
import java.awt.*;

public class JUMPNRUNPANEL extends JPanel
{
    
      
    public JUMPNRUNPANEL()
    {
        Dimension size
            = Toolkit.getDefaultToolkit().getScreenSize();
        
        // width will store the width of the screen
        int width = (int)size.getWidth();
        
        // height will store the height of the screen
        int height = (int)size.getHeight();
        
        setSize(width,height);
        setLocation(0,0);
        setVisible(true);
    }
    
    public void paint(Graphics g)
    {
       g.setColor(Color.green);
       //g.fillRect(10,10,100,100);
    }

    }

