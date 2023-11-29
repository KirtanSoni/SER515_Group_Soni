package src.test.java;

import src.main.java.org.classes.BurndownChart;
import src.main.java.org.classes.BurndownChart.TimeSeriesData;

import java.awt.EventQueue;
import java.util.Date;

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
                // Create a TimeSeriesData object with test values
                TimeSeriesData testData = new TimeSeriesData(new Date(), 150, 20, 5);

                // Create an instance of BurndownChart with the test data
                BurndownChart burndownChart = new BurndownChart("Burndown Chart Test", testData);

                // Display the chart
                burndownChart.setSize(800, 600);
                burndownChart.setLocationRelativeTo(null);
                burndownChart.setDefaultCloseOperation(BurndownChart.EXIT_ON_CLOSE);
                burndownChart.setVisible(true);

                System.out.println("Burndown Chart Test case 1 passed!");
            } catch (Exception e) {
                System.out.println("Error in Burndown Chart Test case 1: " + e);
            }
        });
    }
}
