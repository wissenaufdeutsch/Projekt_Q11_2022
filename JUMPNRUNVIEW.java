import javax.swing.*;
import java.awt.event.*;

public class JUMPNRUNVIEW
{
    private JFrame fenster;

    private JUMPNRUNPANEL panel;
    
    public JUMPNRUNVIEW()
    {
        fenster = new JFrame("Jump N' Run");
        fenster.setSize(300, 500);
        fenster.getContentPane().setLayout(null);
        fenster.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel = new JUMPNRUNPANEL();
        
        fenster.add(panel);
        fenster.setVisible(true);
        
        
    }
}

