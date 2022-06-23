import javax.swing.*;
import java.awt.*;
import java.awt.Image;
import javax.imageio.ImageIO;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;


public class JUMPNRUNVIEW
{
    private JFrame fenster;

    private JUMPNRUNPANEL panel;
    
    private JLabel LogoHase;
  
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
        
        
        
        
        
     }
     
     public void FigurAnzeigen()
     {
        try
        {
            Image img = ImageIO.read(getClass().getResource("Kika2.png"));
            img = img.getScaledInstance(100,100,Image.SCALE_DEFAULT);
            LogoHase = new JLabel(new ImageIcon("Kika2.png"));
            LogoHase.setSize(1000, 1000);
            LogoHase.setVisible(true);
            fenster.add(LogoHase); 
            panel.setBackground(Color.YELLOW);
        }
        catch (java.io.IOException ioe)
        {
            ioe.printStackTrace();
        }
         fenster.setVisible(true);
     }
    
     
}

