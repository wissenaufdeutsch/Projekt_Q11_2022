import javax.swing.*;
import java.awt.event.*;
import java.awt.Font;

public class TicTacToeViewLogIn_Out
{
    private JFrame fenster;

    private JPanel panel;

    private JButton button;

    private JLabel label;
    
    static String[] board;
    static String turn;


 public TicTacToeViewLogIn_Out()
 {
    fenster = new JFrame("TICTACTOE - Ein Spiel für Gewinner");
    fenster.setSize(300,150);
    fenster.getContentPane().setLayout(null);
    
    Font font = new Font("Courier", Font.BOLD,115);
        
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
    fenster.setVisible(true);
        
    label = new JLabel();
        
    label.setVisible(true);
    label.setSize(1000,1000);
    label.setLocation(100,-250);
    label.setText("TICTACTOE");
    label.setVisible(true);
    fenster.add(label);
    fenster.setVisible(true);
    label.setFont(font);
        
    
    panel = new JPanel();
        
    panel.setVisible(true);
    panel.setSize(100,100);
    panel.setLocation(600,160);
    panel.setVisible(true);
    fenster.add(panel);
    fenster.setVisible(true);
    fenster = new JFrame("TicTacToe");
    fenster.setSize(300,150);
    fenster.getContentPane().setLayout(null);
    
 }
  /*  static void printBoard()
    {
        System.out.println("|---|---|---|");
        System.out.println("| " + board[0] + " | "
                           + board[1] + " | " + board[2]
                           + " |");
        System.out.println("|-----------|");
        System.out.println("| " + board[3] + " | "
                           + board[4] + " | " + board[5]
                           + " |");
        System.out.println("|-----------|");
        System.out.println("| " + board[6] + " | "
                           + board[7] + " | " + board[8]
                           + " |");
        System.out.println("|---|---|---|");
    }
  
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        board = new String[9];
        turn = "X";
        String winner = null;
  
        for (int a = 0; a < 9; a++) {
            board[a] = String.valueOf(a + 1);
        }
  
        System.out.println("Welcome to 3x3 Tic Tac Toe.");
        printBoard();
  
        System.out.println(
            "X will play first. Enter a slot number to place X in:");
  
        while (winner == null) {
            int numInput;
            
           // Exception handling.
           // numInput will take input from user like from 1 to 9.
           // If it is not in range from 1 to 9.
           // then it will show you an error "Invalid input."
            try {
                numInput = in.nextInt();
                if (!(numInput > 0 && numInput <= 9)) {
                    System.out.println(
                        "Invalid input; re-enter slot number:");
                    continue;
                }
            }
            catch (InputMismatchException e) {
                System.out.println(
                    "Invalid input; re-enter slot number:");
                continue;
            }
              
            // This game has two player x and O.
            // Here is the logic to decide the turn.
            if (board[numInput - 1].equals(
                    String.valueOf(numInput))) {
                board[numInput - 1] = turn;
  
                if (turn.equals("X")) {
                    turn = "O";
                }
                else {
                    turn = "X";
                }
  
                printBoard();
                winner = checkWinner();
            }
            else {
                System.out.println(
                    "Slot already taken; re-enter slot number:");
            }
        }
        
        // If no one win or lose from both player x and O.
        // then here is the logic to print "draw".
        if (winner.equalsIgnoreCase("draw")) {
            System.out.println(
                "It's a draw! Thanks for playing.");
        }
        
        // For winner -to display Congratulations! message.
        else {
            System.out.println(
                "Congratulations! " + winner
                + "'s have won! Thanks for playing.");
        }
    }*/
}



