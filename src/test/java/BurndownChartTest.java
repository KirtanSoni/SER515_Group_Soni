package src.test.java;

import src.main.java.org.classes.BurndownChart;

import javax.swing.*;
import java.awt.EventQueue;

public class BurndownChartTest implements ITest {
    public BurndownChartTest() {
        test();
    }

    @Override
    public void test() {
        testCase1();
    }

    private void testCase1() {
        EventQueue.invokeLater(() -> {
            try {
                // Create an instance of BurndownChart with the test data
                BurndownChart burndownChart = new BurndownChart("Burndown Chart Test", new int[]{10, 20, 40,60,76,90,100});

                // Maximize the frame
                burndownChart.setExtendedState(JFrame.MAXIMIZED_BOTH);

                burndownChart.setDefaultCloseOperation(BurndownChart.EXIT_ON_CLOSE);
                burndownChart.setVisible(true);

                System.out.println("Burndown Chart Test case 1 passed!");
            } catch (Exception e) {
                System.out.println("Error in Burndown Chart Test case 1: " + e);
            }
        });
    }
}
