package src.main.java.org.classes;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.axis.DateTickUnit;
import org.jfree.chart.axis.DateTickUnitType;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.time.Day;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;

import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BurndownChart extends JFrame {

    public BurndownChart(String title, TimeSeriesData timeSeriesData) {
        super(title);

        TimeSeries series = new TimeSeries("Burndown");

        // Initialize with the provided data
        series.add(new Day(timeSeriesData.getStartDate()), timeSeriesData.getInitialWork());

        // Adding more realistic sample data points
        for (int i = 1; i <= timeSeriesData.getDays(); i++) {
            Date date = new Date(timeSeriesData.getStartDate().getTime() + i * 24 * 60 * 60 * 1000);
            int remainingWork = timeSeriesData.getInitialWork() - i * timeSeriesData.getWorkRatePerDay();
            series.addOrUpdate(new Day(date), remainingWork);
        }

        TimeSeriesCollection dataset = new TimeSeriesCollection(series);
        JFreeChart chart = ChartFactory.createTimeSeriesChart(
                "Burndown Chart",
                "Time",
                "Remaining Work",
                dataset
        );

        XYPlot plot = (XYPlot) chart.getPlot();
        plot.setDomainPannable(true);
        plot.setRangePannable(true);

        DateAxis domainAxis = new DateAxis("Time");
        domainAxis.setDateFormatOverride(new SimpleDateFormat("MM-dd"));
        domainAxis.setTickUnit(new DateTickUnit(DateTickUnitType.DAY, 1));
        plot.setDomainAxis(domainAxis);

        NumberAxis rangeAxis = new NumberAxis("Remaining Work");
        plot.setRangeAxis(rangeAxis);

        setLayout(new BorderLayout());
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new Dimension(800, 600));
        add(chartPanel, BorderLayout.CENTER);
    }

    // Data class to hold time series information
    public static class TimeSeriesData {
        private Date startDate;
        private int initialWork;
        private int workRatePerDay;
        private int days;

        public TimeSeriesData(Date startDate, int initialWork, int workRatePerDay, int days) {
            this.startDate = startDate;
            this.initialWork = initialWork;
            this.workRatePerDay = workRatePerDay;
            this.days = days;
        }

        public Date getStartDate() {
            return startDate;
        }

        public int getInitialWork() {
            return initialWork;
        }

        public int getWorkRatePerDay() {
            return workRatePerDay;
        }

        public int getDays() {
            return days;
        }
    }
}
