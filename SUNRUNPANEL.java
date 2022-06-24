import javax.swing.*;
import java.awt.*;


public class SUNRUNPANEL extends JPanel
{

    public SUNRUNPANEL()
    {
        Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
        
        int screenWidth = (int)size.getWidth();
        int screenHeight = (int)size.getHeight();
        
        setSize(screenWidth, screenHeight);
        setLocation(0, 0);
        setVisible(true);
        setBackground(Color.WHITE);
    }
}
