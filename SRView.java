import java.awt.Dimension;
import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import javax.swing.JFrame;

public class SRView {

    JFrame frame;
    SRPanel panel;
    SRSoundPlayer soundPlayer;

    Set<Character> pressedKeys;

    public SRView(int rectanglesYDirection, int sizeBox) {
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

        soundPlayer = new SRSoundPlayer();
        // TODO: try to get better sound quality
        soundPlayer.playBackgroundMusic();

        // TODO: put this into an extra class
        pressedKeys = new HashSet<Character>();

        KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(new KeyEventDispatcher() {
            @Override
            public boolean dispatchKeyEvent(final KeyEvent e) {
                if (e.getID() == KeyEvent.KEY_PRESSED) {
                    pressedKeys.add(e.getKeyChar());
                }

                if (e.getID() == KeyEvent.KEY_RELEASED) {
                    pressedKeys.remove(e.getKeyChar());
                }
                return false;
            }
        });
    }

    public void setViewedPoint(double[] viewedPoint) {
        panel.setViewedPoint(viewedPoint);
    }

    public void reactToKeys(Set<Character> pressedKeys) {
        panel.reactToKeys(pressedKeys);
    }

    public Set<Character> getPressedKeys() {
        return pressedKeys;
    }

    public void setObstacleColumns(ArrayList<SRObstacle[]> obstacleColumns) {
        panel.setObstacleColumns(obstacleColumns);
    }

    public void setPlayer(SRPlayer player) {
        panel.setPlayer(player);
    }

    public void repaint() {
        panel.repaint();
    }
}
