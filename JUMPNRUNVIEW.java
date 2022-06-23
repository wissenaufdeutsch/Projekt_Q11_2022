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
    
    private int sizeBox;
  
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
        
        sizeBox = 10;        
        
        
        try
        {
            Image img = ImageIO.read(getClass().getResource("Kika.png"));
            img = img.getScaledInstance(100,100,Image.SCALE_DEFAULT);
            LogoHase = new JLabel(new ImageIcon("Kika.png"));
            LogoHase.setSize(1000, 1000);
            LogoHase.setVisible(true);
            fenster.add(LogoHase); 
        }
        catch (java.io.IOException ioe)
        {
            ioe.printStackTrace();
        }
         fenster.setVisible(true);
     }
    
     public void setzeLogo() 
    {
        panel.setVisible(true);
    }
        
    public void drawObstacle(int xpos, int ypos) {
        paintComponent(panel.getGraphics(), xpos, ypos);
    }
    
    private void paintComponent(Graphics graphics, int xpos, int ypos) {
        panel.paintComponents(graphics);
        Graphics2D graphics2D = (Graphics2D) graphics;
        graphics2D.setColor(Color.YELLOW);
        graphics2D.drawRect(xpos * sizeBox, ypos * sizeBox, sizeBox, sizeBox);
    }
}

