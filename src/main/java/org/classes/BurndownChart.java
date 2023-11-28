package src.main.java.org.classes;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class BurndownChart extends JFrame {

    private List<Task> tasks;

    public BurndownChart(String title, List<Task> tasks) {
        super(title);
        this.tasks = tasks;

        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        Graphics2D g2d = (Graphics2D) g;

        int xOffset = 50;
        int yOffset = 50;

        // Draw X and Y axes
        g2d.drawLine(xOffset, getHeight() - yOffset, getWidth() - xOffset, getHeight() - yOffset);
        g2d.drawLine(xOffset, getHeight() - yOffset, xOffset, yOffset);

        int totalTasks = tasks.size();
        int xStep = (getWidth() - 2 * xOffset) / totalTasks;

        // Draw tasks and progress lines
        for (int i = 0; i < totalTasks; i++) {
            int x = xOffset + i * xStep;
            int remainingWork = tasks.get(i).getRemainingWork();
            int y = getHeight() - yOffset - remainingWork;

            // Draw the task rectangle
            g2d.drawRect(x, y, xStep, remainingWork);

            // Draw the progress line
            if (i < totalTasks - 1) {
                int nextX = xOffset + (i + 1) * xStep;
                int nextY = getHeight() - yOffset - tasks.get(i + 1).getRemainingWork();
                g2d.drawLine(x + xStep, y, nextX, nextY);
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            List<Task> tasks = new ArrayList<>();
            tasks.add(new Task(100));
            tasks.add(new Task(80));
            tasks.add(new Task(60));
            tasks.add(new Task(40));
            tasks.add(new Task(20));
            tasks.add(new Task(0));

            BurndownChart chart = new BurndownChart("Burndown Chart", tasks);
        });
    }

    private static class Task {
        private int remainingWork;

        Task(int remainingWork) {
            this.remainingWork = remainingWork;
        }

        public int getRemainingWork() {
            return remainingWork;
        }
    }
}
