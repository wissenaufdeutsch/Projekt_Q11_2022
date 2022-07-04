    import javax.swing.*;
    import java.awt.*;
    import java.awt.Image;
    import javax.imageio.ImageIO;


public class SUNRUNVIEW
{

    private JFrame frame;
    private SUNRUNPANEL panel;
    private int sizeBox;
    private int bottomOfLevel;

    public SUNRUNVIEW(int rectanglesYDirection)
    {
        Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
        int screenWidth = (int) size.getWidth();
        int screenHeight = (int) size.getHeight();

        sizeBox = 10;
        bottomOfLevel = screenHeight / 2 + (rectanglesYDirection / 2) *  sizeBox;

        frame = new JFrame("Sun Run");
        frame.setSize(screenWidth, screenHeight);
        frame.getContentPane().setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        panel = new SUNRUNPANEL();
        frame.add(panel);
    }

    // TODO: return pressed keys
    public String[] getPressedKeys() {
        return null;
    }

    public void FigurAnzeigen()
    {
        // why is a try-catch needed?
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
