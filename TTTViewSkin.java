import javax.swing.*;
import java.awt.event.*;
import java.awt.Font;

public class TTTViewSkin
{
    private JFrame fenster;

    private JPanel panel;

    private JButton button;

    private JLabel label;


 public TTTViewSkin()
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
    button. setSize(200,150); 
    button. setLocation (150, 250);
    button. setText ("");
    button. setVisible (true);
    fenster. add (button);
    fenster.setVisible(true);
    
    label = new JLabel();
        
    label.setVisible(true);
    label.setSize(1000,1000);
    label.setLocation(210,-85);
    label.setText("Eigene Fotos");
    label.setVisible(true);
    fenster.add(label);
    fenster.setVisible(true);
    
    button = new JButton();
        
    button.setVisible(true);
    button. setSize(200,50); 
    button. setLocation (500, 215);
    button. setText ("Standard");
    button. setVisible (true);
    fenster. add (button);
    fenster.setVisible(true);
    
    button = new JButton();
        
    button.setVisible(true);
    button. setSize(200,50); 
    button. setLocation (500, 275);
    button. setText ("Dreieck__Rechteck");
    button. setVisible (true);
    fenster. add (button);
    fenster.setVisible(true);
    
     button = new JButton();
        
    button.setVisible(true);
    button. setSize(200,50); 
    button. setLocation (500, 335);
    button. setText ("XBox__PS4");
    button. setVisible (true);
    fenster. add (button);
    fenster.setVisible(true);
    
     button = new JButton();
        
    button.setVisible(true);
    button. setSize(200,50); 
    button. setLocation (500, 395);
    button. setText ("Team Rocket__Pikachu");
    button. setVisible (true);
    fenster. add (button);
    fenster.setVisible(true);
    

 }
}
