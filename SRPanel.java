import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Set;


import javax.imageio.ImageIO;
import javax.swing.JPanel;


class SRPanel extends JPanel {

    ArrayList<Obstacle[]> obstacleColumns;
    Player player;
    BufferedImage playerImage;

    char lastXSidePressed;
    int sizeBox;
    int bottomOfLevel;

    public SRPanel(int rectanglesYDirection, int sizeBox) {
        Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
        int screenWidth = (int) size.getWidth();
        int screenHeight = (int) size.getHeight();
        setSize(screenWidth, screenHeight);
        setLocation(0, 0);
        setVisible(true);
        setBackground(Color.WHITE);
        setLayout(null);

        this.sizeBox = sizeBox;
        bottomOfLevel = screenHeight / 2 + (rectanglesYDirection / 2) *  sizeBox;

        obstacleColumns = new ArrayList<Obstacle[]>();
        lastXSidePressed = 'r';
    }

    public void setObstacleColumns(ArrayList<Obstacle[]> obstacleColumns) {
        this.obstacleColumns = obstacleColumns;
    }

    public void setPlayer(Player player) {
        this.player = player;
        try {
            playerImage = ImageIO.read(getClass().getResourceAsStream("/Bunny.png"));
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    public void reactToKeys(Set<Character> pressedKeys)
    {
        if (pressedKeys.contains('a') && pressedKeys.contains('d')) {

        }
        else if (pressedKeys.contains('a')) {
            if (lastXSidePressed == 'r') {
                flipPlayerImage();
            }
            lastXSidePressed = 'l';
        }
        else if (pressedKeys.contains('d')) {
            if (lastXSidePressed == 'l') {
                flipPlayerImage();
            }
            lastXSidePressed = 'r';
        }
    }

    private void flipPlayerImage() {
        playerImage = flipImageHorizontally(playerImage);
    }

    private BufferedImage flipImageHorizontally(BufferedImage image) {
        AffineTransform tx = AffineTransform.getScaleInstance(-1, 1);
        tx.translate(-image.getWidth(null), 0);
        AffineTransformOp op = new AffineTransformOp(tx,
            AffineTransformOp.TYPE_NEAREST_NEIGHBOR);
        image = op.filter(image, null);
        return image;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2D = (Graphics2D) g;
        drawObstacles(g2D);
        if (player != null) {
            drawPlayer(g);
        }
    }

    private void drawObstacles(Graphics2D g2D) {
        for (int x = 0; x < obstacleColumns.size(); x++) {
            for (int y = 0; y < obstacleColumns.get(x).length; y++) {
                Obstacle obstacle = obstacleColumns.get(x)[y];
                if (obstacle != null) {
                    drawObstacle(g2D, obstacle, x, y);
                }
            }
        }
    }

    private void drawObstacle(Graphics2D g2D, Obstacle obstacle, int xbox, int ybox) {
        g2D.setColor(Color.GREEN);
        g2D.drawRect(xbox * sizeBox, bottomOfLevel - (1 + ybox) * sizeBox, sizeBox, sizeBox);
    }

    private void drawPlayer(Graphics g) {
        int[] size = player.getSize();
        double[] pos = player.getPos();

        g.drawImage(playerImage, (int) (pos[0]), (int) (bottomOfLevel - size[1] - pos[1]),
                     size[0], size[1], null);
    }
}
