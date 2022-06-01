
public class RECHTECK extends RECTANGULAROBJECT 

<<<<<<< HEAD
{
    private int w;
=======

public class RECHTECK extends JPanel 

{ private int w;
>>>>>>> 8f0e1bc4a719d07c453cd09237e1bbb533276b7c
    private int h;
    private int x;
    private int y;

    public RECHTECK (int width, int height,int xpos, int ypos)
    {
        w = width;
        h = height;
        x = xpos;
        y = ypos;

    } 

<<<<<<< HEAD
=======
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


>>>>>>> 8f0e1bc4a719d07c453cd09237e1bbb533276b7c
}
