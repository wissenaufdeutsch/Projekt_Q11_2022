import javax.swing.*;
import java.awt.event.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import javax.imageio.ImageIO;



public class MENÜ
  
{
    private JFrame fenster;
    private JButton TikTakToe;
    private JButton JumpNRun;
    private JButton HighscoreT;
    private JButton HighscoreJ;
    private JLabel Benutzer;
    
    private int asdf;
    public MENÜ()
        
    {
            fenster = new JFrame("Spielmenü");
            fenster.setSize(800, 700);
            fenster.getContentPane().setLayout(null);
            fenster.getContentPane().setBackground(Color.black);
            
            TikTakToe = new JButton();
            try {
                Image img = ImageIO.read(getClass().getResource("TikTakToeBild.png"));
                img = img.getScaledInstance(100,100,Image.SCALE_DEFAULT);
                TikTakToe.setIcon(new ImageIcon(img));
              } catch (Exception ex) {
                System.out.println(ex);
              }
            TikTakToe.addActionListener(new ActionListener() 
            { 
                public void actionPerformed(ActionEvent e) { 
                    TikTakToe.setText("");
                } 
            } );
            TikTakToe.setVisible(true);
            TikTakToe.setSize(140,200);
            TikTakToe.setLocation(40,80);
            TikTakToe.setBackground(Color.white);
            TikTakToe.setText("TikTakToe");
            TikTakToe.setVerticalTextPosition(JButton.BOTTOM);
            fenster.add(TikTakToe);
           
            JumpNRun = new JButton();
            try {
                Image img = ImageIO.read(getClass().getResource("JumpNRunBild.jpg"));
                img = img.getScaledInstance(100,100,Image.SCALE_DEFAULT);
                JumpNRun.setIcon(new ImageIcon(img));
              } catch (Exception ex) {
                System.out.println(ex);
              }
            JumpNRun.addActionListener(new ActionListener()
            { 
                public void actionPerformed(ActionEvent e) { 
                    JumpNRun.setText("");
                } 
            } );
            JumpNRun.setVisible(true);
            JumpNRun.setSize(140,200);
            JumpNRun.setLocation(220,80);
            JumpNRun.setBackground(Color.white);
            JumpNRun.setText("JumpNRun");
            JumpNRun.setVerticalTextPosition(JButton.BOTTOM);
            fenster.add(JumpNRun);
                      
            HighscoreT = new JButton();
            HighscoreT.addActionListener(new ActionListener()
            { 
                public void actionPerformed(ActionEvent e) { 
                    HighscoreT.setText("");
                } 
            } );
            HighscoreT.setVisible(true);
            HighscoreT.setSize(140,40);
            HighscoreT.setLocation(40,300);
            HighscoreT.setBackground(Color.white);
            HighscoreT.setText("Highscoreliste");
            HighscoreT.setVerticalTextPosition(JButton.BOTTOM);
            fenster.add(HighscoreT);
            
            HighscoreJ = new JButton();
            HighscoreJ.addActionListener(new ActionListener()
            { 
                public void actionPerformed(ActionEvent e) { 
                    HighscoreJ.setText("");
                } 
            } );
            HighscoreJ.setVisible(true);
            HighscoreJ.setSize(140,40);
            HighscoreJ.setLocation(220,300);
            HighscoreJ.setBackground(Color.white);
            HighscoreJ.setText("Highscoreliste");
            HighscoreJ.setVerticalTextPosition(JButton.BOTTOM);
            fenster.add(HighscoreJ);
            
            Benutzer = new JLabel();
            Benutzer.setVisible(true);
            Benutzer.setSize(700,700);
            Benutzer.setText("Name, Klasse");
            Benutzer.setLocation(650,-310);
            Benutzer.setForeground(Color.white);
            
            fenster.add(Benutzer);
            
            fenster.setVisible(true);
    }
    
    
    
}
