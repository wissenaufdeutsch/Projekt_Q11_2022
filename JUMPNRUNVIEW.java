import javax.swing.*;
import java.awt.event.*;

public class JUMPNRUNVIEW
{
    private JFrame fenster;

    private JPanel panel;
    public JUMPNRUNVIEW()
    {
        fenster = new JFrame("Jump N' Run");
        fenster.setSize(3000, 5000);
        fenster.getContentPane().setLayout(null);
        fenster.setVisible(true);

        panel = new JPanel();

        panel.setVisible(true);
        panel.setSize(100,100);
        panel.setLocation(500,160);
        panel.setVisible(true);
        fenster.add(panel);
        fenster.setVisible(true);
        
        
    }
}

