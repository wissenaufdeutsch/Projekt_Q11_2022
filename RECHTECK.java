import java.awt.*;
import javax.swing.*;
import java.util.LinkedList;
import javafx.scene.Node;



public class RECHTECK extends JPanel 

{ private int w;
    private int h;
    private int x;
    private int y;
    Graphics2D g2d;

    LinkedList<Node> nodes;
    public RECHTECK (int width, int height,int xpos, int ypos)
    {
        w = width;
        h = height;
        x = xpos;
        y = ypos;

    } 

    public void paintComponent(Graphics g) {
        super.paintComponent(g);       

        Graphics2D g2d = (Graphics2D) g;

        if (nodes.size() < 40)        
        { g2d.setStroke(new BasicStroke(2));}  

        g2d.setRenderingHint(
            RenderingHints.KEY_ANTIALIASING,
            RenderingHints.VALUE_ANTIALIAS_ON );
        g2d.setRenderingHint(
            RenderingHints.KEY_TEXT_ANTIALIASING,
            RenderingHints.VALUE_TEXT_ANTIALIAS_ON); 

       
       
        }


}
