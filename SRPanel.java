import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.JPanel;


class SRPanel extends JPanel {

    ArrayList<Obstacle[]> obstacleColumns;
    Player player;

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
    }

    public void setObstacleColumns(ArrayList<Obstacle[]> obstacleColumns) {
        this.obstacleColumns = obstacleColumns;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2D = (Graphics2D) g;
        drawObstacles(g2D);
        if (player != null) {
            drawPlayer(g2D);
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

    public void drawPlayer(Graphics2D g2D) {
        g2D.setColor(Color.RED);
        g2D.drawRect((int) (player.pos[0]), (int) (bottomOfLevel - player.size[1] - player.pos[1]),
                     player.size[0], player.size[1]);
    }
}
