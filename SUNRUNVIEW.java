import java.awt.Dimension;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.KeyboardFocusManager;
import java.awt.KeyEventDispatcher;
import java.awt.event.KeyEvent;
import java.awt.Image;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.util.Set;
import java.util.HashSet;



public class SUNRUNVIEW
{

    private JFrame frame;
    private JPanel panel;
    private int sizeBox;
    private int bottomOfLevel;
    private Set<Character> pressedKeys;

    public SUNRUNVIEW(int rectanglesYDirection)
    {
        Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
        int screenWidth = (int) size.getWidth();
        int screenHeight = (int) size.getHeight();
        frame = new JFrame("Sun Run");
        frame.setSize(screenWidth, screenHeight);
        frame.getContentPane().setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        panel = new JPanel();
        panel.setSize(screenWidth, screenHeight);
        panel.setLocation(0, 0);
        panel.setVisible(true);
        panel.setBackground(Color.WHITE);
        frame.add(panel);

        sizeBox = 10;
        bottomOfLevel = screenHeight / 2 + (rectanglesYDirection / 2) *  sizeBox;

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

    public void drawObstacle(OBSTACLE obstacle, int xbox, int ybox) {
        Graphics2D graphics2D = (Graphics2D) panel.getGraphics();
        graphics2D.setColor(Color.GREEN);
        graphics2D.drawRect(xbox * sizeBox, bottomOfLevel - ybox * sizeBox, sizeBox, sizeBox);
    }

    public void drawPlayer(PLAYER player) {
        Graphics2D graphics2D = (Graphics2D) panel.getGraphics();
        graphics2D.setColor(Color.RED);
        graphics2D.drawRect(player.pos[0], player.pos[1], player.size[0], player.size[1]);
    }
}
