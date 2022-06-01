import javax.swing.*;
import java.awt.*;

public class JUMPNRUNVIEW
{
    private JFrame fenster;

    private JUMPNRUNPANEL panel;
    
    public JUMPNRUNVIEW()
    {
        Dimension size
            = Toolkit.getDefaultToolkit().getScreenSize();
        
        // width will store the width of the screen
        int width = (int)size.getWidth();
        
        // height will store the height of the screen
        int height = (int)size.getHeight();
        
    
        fenster = new JFrame("Jump N' Run");
        fenster.setSize(width,height);
        fenster.getContentPane().setLayout(null);
        fenster.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel = new JUMPNRUNPANEL();
        
        fenster.add(panel);
        fenster.setVisible(true);
        
        
    }
}

