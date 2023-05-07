import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class GamePanel extends JPanel implements ActionListener {
    Timer timer;
    Random random;

    Mouse mouse = new Mouse();
    World world = new World(params.worldSize);

    GamePanel() {
        random = new Random();
        this.setPreferredSize(new Dimension(params.windowSize, params.windowSize));
        this.setBackground(Color.BLACK);
        this.setFocusable(true);
        this.addMouseListener(mouse);
        this.addMouseMotionListener(mouse);
        this.addMouseWheelListener(mouse);
        startGame();
    }

    public void startGame() {
        timer = new Timer(0, this);
        timer.start();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.setBackground(Color.BLACK);
        long start = System.nanoTime();
        draw(g);
        long duration = System.nanoTime() - start;
        //System.out.println("fps: " + 1000000000.0 / duration);
    }

    public void draw(Graphics g) {
        world.draw(g, params.offsetX, params.offsetY, params.scale);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }
}
