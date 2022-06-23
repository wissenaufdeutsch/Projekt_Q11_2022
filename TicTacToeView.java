import javax.swing.*;
import java.awt.event.*;
import java.awt.Font;
import java.awt.*;  

public class TicTacToeView
{
    private JFrame fenster;

    private JButton button;

    private JLabel label;
    private JPanel panel;
    
    private JInternalFrame Wasistdas;

    
    static String[] board;
    static String turn;


public TicTacToeView()
{
    fenster = new JFrame("TICTACTOE - Ein Spiel für Gewinner");
    fenster.setSize(300,150);
    fenster.getContentPane().setLayout(null);
    
    Font font = new Font("Courier", Font.BOLD,115);
        
    panel = new JPanel(){
        
        public void paint(Graphics g)
        {
            g.drawRect(100, 100, 10, 10);
        }
    };
       
    panel.setSize(1000,1000);
    panel.setLocation(100,-250);
    panel.setVisible(true);
    fenster.add(panel);
    
    button = new JButton();
        
    button.setVisible(true);
    button. setSize(15,10); 
    button. setLocation (386, 250);
    button. setText ("");
    button. setVisible (true);
    fenster. add (button);
    fenster.setVisible(true);
    
    button = new JButton();
        
    button.setVisible(true);
    button. setSize(50,50); 
    button. setLocation (750, 260);
    button. setText ("nd");
    button. setVisible (true);
    fenster. add (button);
        
    label = new JLabel();
        
    label.setVisible(true);
    label.setSize(1000,1000);
    label.setLocation(100,-250);
    label.setText("TICTACTOE");
    label.setVisible(true);
    fenster.add(label);
    fenster.setVisible(true);
    label.setFont(font);
    
    
    

    
    Wasistdas = new JInternalFrame();
    
    Wasistdas.setVisible(true);
    Wasistdas.setSize(900,500);
    Wasistdas.setLocation(10,0);
    Wasistdas.setVisible(true);
    fenster.add(Wasistdas);
}
}