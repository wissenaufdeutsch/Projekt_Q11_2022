import java.awt.*;
import javax.swing.*;
import java.util.LinkedList;
import javafx.scene.Node;




public class RECHTECK extends JPanel

 { 
 

   private int w;

    private int h;
    private int x;
    private int y;
    Graphics2D g2d;

    private boolean deadly;
    public RECHTECK (int width, int height,int xpos, int ypos, boolean deadly)
    {
        w = width;
        h = height;
        x = xpos;
        y = ypos;

         deadly = deadly;
        

    } 


    public void paint(Graphics g) {
        super.paint(g);       

        Graphics2D g2d = (Graphics2D) g;

        
        g2d.setRenderingHint(
            RenderingHints.KEY_ANTIALIASING,
            RenderingHints.VALUE_ANTIALIAS_ON );
        g2d.setRenderingHint(
            RenderingHints.KEY_TEXT_ANTIALIASING,
            RenderingHints.VALUE_TEXT_ANTIALIAS_ON); 

        g2d.drawRect(30, 50, 420, 120);
       
        }


  }
