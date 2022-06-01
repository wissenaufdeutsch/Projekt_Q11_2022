import javax.swing.*;
import java.awt.*;

public class JUMPNRUNPANEL extends JPanel
{
    
      
    public JUMPNRUNPANEL()
    {
        setVisible(true);
        setSize(100,100);
        setLocation(500,160);
        setVisible(true);
    }
    
    public void paint(Graphics g)
    {
       g.setColor(Color.green);
       g.fillRect(10,10,100,100);
    }
    }

