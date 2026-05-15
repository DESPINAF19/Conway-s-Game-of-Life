
import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        GameOfLife game = new GameOfLife(30,30);
        GameOfLifeGUI gamePanel = new GameOfLifeGUI(game);

        JFrame frame = new JFrame("Game of Life");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout()); // Εναλλακτικό Layout

        JButton startButton = new JButton("Start / Pause");
        startButton.addActionListener(e -> gamePanel.toggleRunning());

        JButton resetButton = new JButton("Reset");
        resetButton.addActionListener(e -> gamePanel.reset());

        JPanel controlPanel = new JPanel();
        controlPanel.add(startButton);
        controlPanel.add(resetButton);

        frame.add(gamePanel);
        frame.add(controlPanel);

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}

