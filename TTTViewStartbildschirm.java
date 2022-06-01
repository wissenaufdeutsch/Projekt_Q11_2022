import javax.swing.*;
import java.awt.event.*;
import java.awt.Font;

public class TTTViewStartbildschirm
{
 private JFrame fenster;

    private JPanel panel;

    private JButton button;

    private JLabel label;

 public TTTViewStartbildschirm()
 {
    fenster = new JFrame("TICTACTOE - Ein Spiel für Gewinner");
    fenster.setSize(300,150);
    fenster.getContentPane().setLayout(null);
    
    Font font = new Font("Courier", Font.BOLD,115);
        
    label = new JLabel();
        
    label.setVisible(true);
    label.setSize(1000,1000);
    label.setLocation(100,-400);
    label.setText("TICTACTOE");
    label.setVisible(true);
    fenster.add(label);
    fenster.setVisible(true);
    label.setFont(font);button = new JButton();
       
    button = new JButton();
    
    button.setVisible(true);
    button. setSize(150,50); 
    button. setLocation (150, 250);
    button. setText ("Computer");
    button. setVisible (true);
    fenster. add (button);
    fenster.setVisible(true);
    
    button = new JButton();
    
    button.setVisible(true);
    button. setSize(150,50); 
    button. setLocation (550, 250);
    button. setText ("1vs1");
    button. setVisible (true);
    fenster. add (button);
    fenster.setVisible(true);
    
    button = new JButton();
    
    button.setVisible(true);
    button. setSize(150,50); 
    button. setLocation (550, 350);
    button. setText ("Skin");
    button. setVisible (true);
    fenster. add (button);
    fenster.setVisible(true);
    
    button = new JButton();
    
    button. setSize(150,50); 
    button. setLocation (150, 350);
    button. setText ("Background");
    button. setVisible (true);
    fenster. add (button);
    fenster.setVisible(true);
 }
}
