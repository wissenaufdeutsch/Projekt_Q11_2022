import java.util.ArrayList;
import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.Graphics2D;
import java.awt.Graphics;


class SUNRUNPANEL extends JPanel {

    public ArrayList<OBSTACLE[]> obstacleColumns;
    public PLAYER player;


    private int sizeBox;
    private int bottomOfLevel;

    public SUNRUNPANEL(int rectanglesYDirection, int sizeBox) {
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

        obstacleColumns = new ArrayList<OBSTACLE[]>();
    }

    public void setObstacleColumns(ArrayList<OBSTACLE[]> obstacleColumns) {
        this.obstacleColumns = obstacleColumns;
    }

    public void setPlayer(PLAYER player) {
        this.player = player;
    }

    public void setEntitys() {

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

    public void drawObstacles(Graphics2D g2D) {
        for (int x = 0; x < obstacleColumns.size(); x++) {
            for (int y = 0; y < obstacleColumns.get(x).length; y++) {
                OBSTACLE obstacle = obstacleColumns.get(x)[y];
                if (obstacle != null) {
                    drawObstacle(g2D, obstacle, x, y);
                }
            }
        }
    }

    public void drawObstacle(Graphics2D g2D, OBSTACLE obstacle, int xbox, int ybox) {
        g2D.setColor(Color.GREEN);
        g2D.drawRect(xbox * sizeBox, bottomOfLevel - (1 + ybox) * sizeBox, sizeBox, sizeBox);
    }

    public void drawPlayer(Graphics2D g2D) {
        g2D.setColor(Color.RED);
        g2D.drawRect(player.pos[0], bottomOfLevel - player.size[1] - player.pos[1],
                     player.size[0], player.size[1]);
    }
}
