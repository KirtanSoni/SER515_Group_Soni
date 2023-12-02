package org.SER.classes;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import javax.swing.*;
import java.awt.*;

public class BurndownChart extends JFrame {

    public BurndownChart(String title, int[] workDone) {
        super(title);

        int totalDays = workDone.length;
        for (int i = 0; i < totalDays; i++) {
            workDone[i] = 100 - workDone[i];
        }

        XYSeries series = new XYSeries("Work Done");

        for (int day = 1; day <= totalDays; day++) {
            series.add(day, workDone[day - 1]);
        }

        XYSeriesCollection dataset = new XYSeriesCollection(series);
        JFreeChart chart = ChartFactory.createXYLineChart(
                "Burndown Chart",
                "Day",
                "Work Remaining (%)",
                dataset
        );

        XYPlot plot = chart.getXYPlot();
        NumberAxis xAxis = (NumberAxis) plot.getDomainAxis();
        NumberAxis yAxis = (NumberAxis) plot.getRangeAxis();

        yAxis.setRange(0, 100);

        xAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
        yAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());

        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new Dimension(560, 370));
        setContentPane(chartPanel);
    }
}