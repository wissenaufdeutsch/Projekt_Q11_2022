import javax.swing.*;
import java.awt.event.*;
import java.awt.Font;
import java.awt.*; 

public class TTTViewSpielfeld
{
    private int Spielfeld[][];
    private JFrame fenster;
    
    private JLabel label;
    private JLabel label1;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JButton button5;
    private JButton button6;
    private JButton button7;
    private JButton button8;
    private JButton button9;
    int [] besetzt;
    Client c;
    TIKTAKTOE t;
    public TTTViewSpielfeld(Client cl)
    {
        Spielfeld = new int[3][3];
        c = cl;
        besetzt = new int[9];
        t = new TIKTAKTOE();
        for (int i= 0; i<9; i++){
         besetzt[i] = 0;
        }
        fenster = new JFrame("TICTACTOE - Ein Spiel für Gewinner");
        fenster.setSize(1200,1000);
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
        
        label1 = new JLabel();
        
        label.setSize(800,800);
        label1.setLocation(225,-300);
        label1.setFont(font);
        fenster.add(label1);
        
        button1 = new JButton();
    
        button1.setVisible(true);
        button1.setSize(175,175); 
        button1.setLocation (250, 250);
        button1.setText ("");
        button1.setVisible (true);
        fenster.add (button1);
        button1.addActionListener(new ActionListener() 
            { 
                public void actionPerformed(ActionEvent e) { 
                    if(c.bistdran&& besetzt[0]==0){
                    c.sendnewchoice("1");
                    updatebutton("1", true);
                }
                } 
            } );
    
    
        button4 = new JButton();
    
        button4.setVisible(true);
        button4.setSize(175,175); 
        button4.setLocation (250, 450);
        button4.setText ("");
        button4.setVisible (true);
        fenster.add (button4);
        button4.addActionListener(new ActionListener() 
            { 
                public void actionPerformed(ActionEvent e) { 
                    if(c.bistdran&& besetzt[3]==0){
                    c.sendnewchoice("4");
                    updatebutton("4", true);
                }
                } 
            } );
    
    
        button7 = new JButton();
    
        button7.setVisible(true);
        button7.setSize(175,175); 
        button7.setLocation (250, 650);
        button7.setText ("");
        button7.setVisible (true);
        fenster.add (button7);
        button7.addActionListener(new ActionListener() 
            { 
                public void actionPerformed(ActionEvent e) { 
                    if(c.bistdran&& besetzt[6]==0){
                    c.sendnewchoice("7");
                    updatebutton("7", true);
                }
                } 
            } );
        
        button2 = new JButton();
    
        button2.setVisible(true);
        button2.setSize(175,175); 
        button2.setLocation (450, 250);
        button2.setText ("");
        button2.setVisible (true);
        fenster.add (button2);
        button2.addActionListener(new ActionListener() 
            { 
                public void actionPerformed(ActionEvent e) { 
                    if(c.bistdran&& besetzt[1]==0){
                    c.sendnewchoice("2");
                    updatebutton("2", true);
                }
                } 
            } );
    
        
        button5 = new JButton();
    
        button5.setVisible(true);
        button5.setSize(175,175); 
        button5.setLocation (450, 450);
        button5.setText ("");
        button5.setVisible (true);
        fenster.add (button5);
        button5.addActionListener(new ActionListener() 
            { 
                public void actionPerformed(ActionEvent e) { 
                    if(c.bistdran&& besetzt[4]==0){
                    c.sendnewchoice("5");
                    updatebutton("5", true);
                }
                } 
            } );
    
        button8 = new JButton();
    
        button8.setVisible(true);
        button8.setSize(175,175); 
        button8.setLocation (450, 650);
        button8.setText ("");
        button8.setVisible (true);
        fenster.add (button8);
        button8.addActionListener(new ActionListener() 
            { 
                public void actionPerformed(ActionEvent e) { 
                    if(c.bistdran&& besetzt[7]==0){
                    c.sendnewchoice("8");
                    updatebutton("8", true);
                }
                } 
            } );
        
        
        button3 = new JButton();
    
        button3.setVisible(true);
        button3.setSize(175,175); 
        button3.setLocation (650, 250);
        button3.setText ("");
        button3.setVisible (true);
        fenster.add (button3);
        button3.addActionListener(new ActionListener() 
            { 
                public void actionPerformed(ActionEvent e) { 
                    if(c.bistdran&& besetzt[2]==0){
                    c.sendnewchoice("3");
                    updatebutton("3", true);
                }
                } 
            } );
    
        button6 = new JButton();
    
        button6.setVisible(true);
        button6.setSize(175,175); 
        button6.setLocation (650, 450);
        button6.setText ("");
        button6.setVisible (true);
        fenster.add (button6);
        button6.addActionListener(new ActionListener() 
            { 
                public void actionPerformed(ActionEvent e) { 
                    if(c.bistdran&& besetzt[5]==0){
                    c.sendnewchoice("6");
                    updatebutton("6", true);
                }
                } 
            } );
    
        button9 = new JButton();
    
        button9.setVisible(true);
        button9.setSize(175,175); 
        button9.setLocation (650, 650);
        button9.setText ("");
        button9.setVisible (true);
        fenster.add (button9);
        button9.addActionListener(new ActionListener() 
            { 
                public void actionPerformed(ActionEvent e) { 
                    if(c.bistdran && besetzt[8]==0){
                    c.sendnewchoice("9");
                    updatebutton("9", true);
                }
                } 
            } );
    }
    void updatebutton(String s, boolean whosturn){
        int x = Integer.parseInt(s);
        int whowon = t.updated(x, whosturn);
        Color c;
        if (whosturn){
            c =  Color.green;
            besetzt[x-1] = 1;
        }
        else{
            c = Color.red;
            besetzt[x-1] = 2;
        }
        switch(x){
            case 1:button1.setForeground(c);
                    button1.setBackground(c);
                
                    break;
            case 2:button2.setForeground(c);
            button2.setBackground(c);
            break;
            case 3:button3.setForeground(c);
                    button3.setBackground(c);
                    break;
            case 4:button4.setForeground(c);
            button4.setBackground(c);
            break;
            case 5:button5.setForeground(c);
            button5.setBackground(c);
            break;
            case 6:button6.setForeground(c);
            button6.setBackground(c);
            break;
            case 7:button7.setForeground(c);
            button7.setBackground(c);
            break;
            case 8:button8.setForeground(c);
            button8.setBackground(c);
            break;
            case 9:button9.setForeground(c);
            button9.setBackground(c);
            break;
        }
        if (whowon == 0){
        
        }
        if (whowon == 1){
            for (int i= 0; i<9; i++){
         besetzt[i] = 3;
         
        }
        label.setText("You won");
        
        }
        if (whowon == 2){
            for (int i= 0; i<9; i++){
             besetzt[i] = 3;
          }
          label.setText("You lost");
          
        }
    }
}
