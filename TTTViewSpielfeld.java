import javax.swing.*;
import java.awt.event.*;
import java.awt.Font;


public class TTTViewSpielfeld
{
    private int Spielfeld[][];
    private JFrame fenster;
    
    private JLabel label;
    
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JButton button5;
    private JButton button6;
    private JButton button7;
    private JButton button8;
    private JButton button9;
    
    
    public TTTViewSpielfeld()
    {
        Spielfeld = new int[3][3];
    
        
        fenster = new JFrame("TICTACTOE - Ein Spiel für Gewinner");
        fenster.setSize(300,150);
        fenster.getContentPane().setLayout(null);
        fenster.setVisible(true);
        
        Font font = new Font("Courier", Font.BOLD,115);
        
        label = new JLabel();
        
        label.setVisible(true);
        label.setSize(800,800);
        label.setLocation(225,-300);
        label.setText("TICTACTOE");
        label.setVisible(true);
        label.setFont(font);
        fenster.add(label);
        
        
        button1 = new JButton();
    
        button1.setVisible(true);
        button1.setSize(175,175); 
        button1.setLocation (250, 250);
        button1.setText ("");
        button1.setVisible (true);
        fenster.add (button1);
    
    
        button2 = new JButton();
    
        button2.setVisible(true);
        button2.setSize(175,175); 
        button2.setLocation (250, 450);
        button2.setText ("");
        button2.setVisible (true);
        fenster.add (button2);
    
    
        button3 = new JButton();
    
        button3.setVisible(true);
        button3.setSize(175,175); 
        button3.setLocation (250, 650);
        button3.setText ("");
        button3.setVisible (true);
        fenster.add (button3);
        
        
        button4 = new JButton();
    
        button4.setVisible(true);
        button4.setSize(175,175); 
        button4.setLocation (450, 250);
        button4.setText ("");
        button4.setVisible (true);
        fenster.add (button4);
    
    
        button5 = new JButton();
    
        button5.setVisible(true);
        button5.setSize(175,175); 
        button5.setLocation (450, 450);
        button5.setText ("");
        button5.setVisible (true);
        fenster.add (button5);
    
    
        button6 = new JButton();
    
        button6.setVisible(true);
        button6.setSize(175,175); 
        button6.setLocation (450, 650);
        button6.setText ("");
        button6.setVisible (true);
        fenster.add (button6);
        
        button7 = new JButton();
    
        button7.setVisible(true);
        button7.setSize(175,175); 
        button7.setLocation (650, 250);
        button7.setText ("");
        button7.setVisible (true);
        fenster.add (button7);
    
    
        button8 = new JButton();
    
        button8.setVisible(true);
        button8.setSize(175,175); 
        button8.setLocation (650, 450);
        button8.setText ("");
        button8.setVisible (true);
        fenster.add (button8);
    
    
        button9 = new JButton();
    
        button9.setVisible(true);
        button9.setSize(175,175); 
        button9.setLocation (650, 650);
        button9.setText ("");
        button9.setVisible (true);
        fenster.add (button9);
    }
}
