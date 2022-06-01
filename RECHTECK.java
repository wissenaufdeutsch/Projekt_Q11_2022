
public class RECHTECK extends RECTANGULAROBJECT 
<<<<<<< HEAD
{ 
=======

<<<<<<< HEAD






public class RECHTECK extends JPanel 

{  private int w;

=======
<<<<<<< HEAD
{
>>>>>>> 89f2c97c8c042b9596e026d8d6d52c182500bfce
    private int w;
<<<<<<< HEAD
=======
=======

public class RECHTECK extends JPanel 

{ private int w;
>>>>>>> 8f0e1bc4a719d07c453cd09237e1bbb533276b7c
>>>>>>> 2b35a420505d0d28916a9e671be0a86311039026
>>>>>>> 89f2c97c8c042b9596e026d8d6d52c182500bfce
    private int h;
    private int x;
    private int y;

<<<<<<< HEAD
    private boolean deadly;
    public RECHTECK (int width, int height,int xpos, int ypos, boolean deadly)
=======
    public RECHTECK (int width, int height,int xpos, int ypos)
>>>>>>> 2b35a420505d0d28916a9e671be0a86311039026
    {
        w = width;
        h = height;
        x = xpos;
        y = ypos;

         deadly = deadly;
        

    } 

<<<<<<< HEAD
=======
<<<<<<< HEAD

    public void paint(Graphics g) {
        super.paint(g);       
=======
<<<<<<< HEAD
=======
    public void paintComponent(Graphics g) {
        super.paintComponent(g);       
>>>>>>> 2b35a420505d0d28916a9e671be0a86311039026

        Graphics2D g2d = (Graphics2D) g;

        
        g2d.setRenderingHint(
            RenderingHints.KEY_ANTIALIASING,
            RenderingHints.VALUE_ANTIALIAS_ON );
        g2d.setRenderingHint(
            RenderingHints.KEY_TEXT_ANTIALIASING,
            RenderingHints.VALUE_TEXT_ANTIALIAS_ON); 

<<<<<<< HEAD

        g2d.drawRect(30, 50, 420, 120);

         }
=======
       
       
        }
>>>>>>> 2b35a420505d0d28916a9e671be0a86311039026


<<<<<<< HEAD
  }
=======
>>>>>>> 8f0e1bc4a719d07c453cd09237e1bbb533276b7c
>>>>>>> 89f2c97c8c042b9596e026d8d6d52c182500bfce
}
>>>>>>> 2b35a420505d0d28916a9e671be0a86311039026
