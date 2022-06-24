    import javax.swing.*;
    import java.awt.*;
    import java.awt.Image;
    import javax.imageio.ImageIO;


public class SUNRUNVIEW
{

    private JFrame fenster;
    private SUNRUNPANEL panel;
    private int sizeBox;
    private int bottomOfLevel;
    private int screenWidth;
    private int screenHeight;

    public SUNRUNVIEW(int rectanglesYDirection)
    {
        Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
        screenWidth = (int) size.getWidth();
        screenHeight = (int) size.getHeight();

        sizeBox = 10;
        bottomOfLevel = screenHeight / 2 + (rectanglesYDirection / 2) *  sizeBox;

        fenster = new JFrame("Sun Run");
        fenster.setSize(screenWidth, screenHeight);
        fenster.getContentPane().setLayout(null);
        fenster.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fenster.setVisible(true);

        panel = new SUNRUNPANEL();
        fenster.add(panel);
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
            fenster.add(icon);

        } catch (java.io.IOException ioe) {
            ioe.printStackTrace();
        }
        fenster.setVisible(true);
    }

    public void drawObstacle(OBSTACLE obstacle, int xpos, int ypos) {
        Graphics2D graphics2D = (Graphics2D) panel.getGraphics();
        graphics2D.setColor(Color.GREEN);
        graphics2D.drawRect(xpos * sizeBox, bottomOfLevel - ypos * sizeBox, sizeBox, sizeBox);
    }
}
