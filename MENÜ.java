import javax.swing.*;
import java.awt.event.*;
import java.awt.Color;
import java.awt.Font;

public class MENÜ
  
{
    private JFrame fenster;
    private JButton TikTakToe;
    
    public MENÜ()
        
    {
            fenster = new JFrame("Spielmenü");
            fenster.setSize(800, 700);
            fenster.getContentPane().setLayout(null);
            fenster.getContentPane().setBackground(Color.black);
            TikTakToe = new JButton();
            TikTakToe.addActionListener(new ActionListener() 
            { 
                public void actionPerformed(ActionEvent e) { 
                    TikTakToe.setText("TikTakToe");
                } 
            } );
    }

}


