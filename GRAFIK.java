import javax.swing.*;

public class GRAFIK
{
    private JFrame fenster;

    private JPanel panel;
    
 public GRAFIK()
 {
    fenster = new JFrame("Das steht im Titel");
        fenster.setSize(300,150);
        fenster.getContentPane().setLayout(null);
        fenster.setVisible(true);
     //panel = new Panel(nodes , windowWidth, windowHeight);
 

        SwingUtilities.invokeLater(new Runnable() 
        {
            public void run() 
            {
                //createAndShowGraph(); 
            }

       });      

    }
}