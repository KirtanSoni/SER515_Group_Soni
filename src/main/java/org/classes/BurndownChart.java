package src.main.java.org.classes;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.NumberTickUnit;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import javax.swing.*;
import java.awt.*;

public class BurndownChart extends JFrame {

    public BurndownChart(String title, int[] workCompletedPercentages) {
        super(title);

        XYSeries series = new XYSeries("Burndown");

        // Initialize remaining work with the total work on the last day
        int remainingWork = workCompletedPercentages[workCompletedPercentages.length - 1];

        for (int i = 0; i < workCompletedPercentages.length; i++) {
            int day = i + 1;  // Day count starts from 1
            int workCompleted = workCompletedPercentages[i];
            remainingWork -= workCompleted;  // Convert to remaining work
            series.add(day, remainingWork);
        }

        XYSeriesCollection dataset = new XYSeriesCollection(series);
        JFreeChart chart = ChartFactory.createXYLineChart(
                "Burndown Chart",
                "Days",
                "Remaining Work",
                dataset
        );

        XYPlot plot = (XYPlot) chart.getPlot();
        plot.setDomainPannable(true);
        plot.setRangePannable(true);

        NumberAxis domainAxis = new NumberAxis("Days");
        int totalDataPoints = workCompletedPercentages.length;
        domainAxis.setTickUnit(new NumberTickUnit(1));
        domainAxis.setRange(1, totalDataPoints); // Set the range from 1 to the total number of data points
        plot.setDomainAxis(domainAxis);




        NumberAxis rangeAxis = new NumberAxis("Remaining Work");
        rangeAxis.setRange(0, 100); // Set the range from 0 to 100
        rangeAxis.setTickUnit(new NumberTickUnit(10)); // Set the tick unit to 10
        plot.setRangeAxis(rangeAxis);


        setLayout(new BorderLayout());
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new Dimension(800, 600));
        add(chartPanel, BorderLayout.CENTER);
    }
}
