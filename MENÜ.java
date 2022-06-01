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
            TikTakToe.setLocation(40,40);
            TikTakToe.setBackground(Color.white);

<<<<<<< HEAD
            TikTakToe.setText("TikTakToe");
            TikTakToe.setVerticalTextPosition(JButton.BOTTOM);
=======
>>>>>>> 2b35a420505d0d28916a9e671be0a86311039026

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
            JumpNRun.setLocation(220,40);
            JumpNRun.setBackground(Color.white);

<<<<<<< HEAD

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
            JumpNRun.setLocation(220,40);
            JumpNRun.setBackground(Color.white);

=======
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
            JumpNRun.setLocation(220,40);
            JumpNRun.setBackground(Color.white);
>>>>>>> 2b35a420505d0d28916a9e671be0a86311039026
            JumpNRun.setText("JumpNRun");
            JumpNRun.setVerticalTextPosition(JButton.BOTTOM);

            fenster.add(JumpNRun);
            
            fenster.setVisible(true);
    }

}


