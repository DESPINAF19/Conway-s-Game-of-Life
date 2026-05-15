import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameOfLifeGUI extends JPanel {
    private final int cellSize = 20;
    private final GameOfLife game;
    private boolean running = false;
    private Timer timer;

    public GameOfLifeGUI(GameOfLife game) {
        this.game = game;
        setPreferredSize(new Dimension(game.getGrid()[0].length * cellSize, game.getGrid().length * cellSize));

        // Timer για αυτόματη ανανέωση κάθε 200ms
        timer = new Timer(200, e -> {
            if (running) {
                game.NextGeneration();
                repaint();
            }
        });

        timer.start();
    }

    // Ζωγραφίζει το πλέγμα
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        boolean[][] grid = game.getGrid();

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j]) {
                    g.setColor(Color.BLACK); // Ζωντανό κελί
                    g.fillRect(j * cellSize, i * cellSize, cellSize, cellSize);
                } else {
                    g.setColor(Color.LIGHT_GRAY); // Νεκρό κελί
                    g.drawRect(j * cellSize, i * cellSize, cellSize, cellSize);
                }
            }
        }
    }

    // Έναρξη / Παύση
    public void toggleRunning() {
        running = !running;
    }

    // Επαναφορά
    public void reset() {
        running = false;
        game.reset();
        repaint();
    }
}
