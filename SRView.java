import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.KeyboardFocusManager;
import java.awt.KeyEventDispatcher;
import java.awt.event.KeyEvent;
import java.awt.Image;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.util.Set;
import java.util.HashSet;
import java.util.ArrayList;



public class SRView
{

    JFrame frame;
    SRPanel panel;
    Set<Character> pressedKeys;

    public SRView(int rectanglesYDirection, int sizeBox)
    {
        frame = new JFrame("Sun Run");
        Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
        int screenWidth = (int) size.getWidth();
        int screenHeight = (int) size.getHeight();
        frame.setSize(screenWidth, screenHeight);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        panel = new SRPanel(rectanglesYDirection, sizeBox);
        frame.add(panel);

        pressedKeys = new HashSet<Character>();

        KeyboardFocusManager.getCurrentKeyboardFocusManager()
            .addKeyEventDispatcher(new KeyEventDispatcher() {
                @Override
                public boolean dispatchKeyEvent(final KeyEvent e) {
                    if(e.getID() == KeyEvent.KEY_PRESSED){
                        pressedKeys.add(e.getKeyChar());
                    }


                    if(e.getID() == KeyEvent.KEY_RELEASED){
                        pressedKeys.remove(e.getKeyChar());
                    }
                    return false;
                }
            });
    }

    public Set<Character> getPressedKeys() {
         return pressedKeys;
    }

    public void setObstacleColumns(ArrayList<Obstacle[]> obstacleColumns) {
        panel.setObstacleColumns(obstacleColumns);
    }

    public void setPlayer(Player player) {
        panel.setPlayer(player);
    }

    // TODO: change this to drawImg so it works for all images (scaling to size, path to img)
    public void FigurAnzeigen()
    {
        // FIXME: why is a try-catch needed?
        try {
            Image img = ImageIO.read(getClass().getResource("Kika2.png"));
            img = img.getScaledInstance(100, 100, Image.SCALE_DEFAULT);

            JLabel icon = new JLabel(new ImageIcon("Kika2.png"));
            icon.setSize(1000, 1000);
            icon.setVisible(true);
            frame.add(icon);

        } catch (java.io.IOException ioe) {
            ioe.printStackTrace();
        }
        frame.setVisible(true);
    }

    public void repaint() {
        panel.repaint();
    }
}
