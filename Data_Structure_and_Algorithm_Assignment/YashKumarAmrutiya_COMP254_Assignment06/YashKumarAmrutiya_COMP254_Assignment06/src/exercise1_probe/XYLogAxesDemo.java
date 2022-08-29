package exercise1_probe;

import java.awt.Color;
import java.util.Random;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.LogarithmicAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class XYLogAxesDemo extends ApplicationFrame {

	public XYLogAxesDemo(final String title) {

		super(title);

		final XYSeries s6 = new XYSeries("Alpha 0.50");
		final XYSeries s7 = new XYSeries("Alpha 0.75");
		final XYSeries s8 = new XYSeries("Alpha 0.90");
		final XYSeries s9 = new XYSeries("Alpha 0.95");
		final XYSeries s10 = new XYSeries("Alpha 0.99");

		int[] capacities = { 1003, 2003, 4001, 8009, 16001, 32003, 64007, 128003 };

		for (int i = 0; i < capacities.length; i++) {
			ProbeHashMap phm = new ProbeHashMap(capacities[i], 109345121, 0.50);
			double startTime = System.currentTimeMillis();
			for (int j = 0; j <= capacities[i] - 1; j++) {
				phm.put(j, j);
			}
			double endTime = System.currentTimeMillis();
			double runningTime = (endTime - startTime) * 1000;
			s6.add(capacities[i], runningTime);

			phm = new ProbeHashMap(capacities[i], 109345121, 0.75);
			startTime = System.currentTimeMillis();
			for (int j = 0; j <= capacities[i] - 1; j++) {
				phm.put(j, j);
			}
			endTime = System.currentTimeMillis();
			runningTime = (endTime - startTime) * 1000;
			s7.add(capacities[i], runningTime);

			phm = new ProbeHashMap(capacities[i], 109345121, 0.90);
			startTime = System.currentTimeMillis();
			for (int j = 0; j <= capacities[i] - 1; j++) {
				phm.put(j, j);
			}
			endTime = System.currentTimeMillis();
			runningTime = (endTime - startTime) * 1000;
			s8.add(capacities[i], runningTime);

			phm = new ProbeHashMap(capacities[i], 109345121, 0.95);
			startTime = System.currentTimeMillis();
			for (int j = 0; j <= capacities[i] - 1; j++) {
				phm.put(j, j);
			}
			endTime = System.currentTimeMillis();
			runningTime = (endTime - startTime) * 1000;
			s9.add(capacities[i], runningTime);

			phm = new ProbeHashMap(capacities[i], 109345121, 0.99);
			startTime = System.currentTimeMillis();
			for (int j = 0; j <= capacities[i] - 1; j++) {
				phm.put(j, j);
			}
			endTime = System.currentTimeMillis();
			runningTime = (endTime - startTime) * 1000;
			s10.add(capacities[i], runningTime);

			System.gc();
		}

		final XYSeriesCollection dataset = new XYSeriesCollection();

		dataset.addSeries(s6);
		dataset.addSeries(s7);
		dataset.addSeries(s8);
		dataset.addSeries(s9);
		dataset.addSeries(s10);

		final JFreeChart chart1 = ChartFactory.createXYLineChart("Probe Map Load Factor Demo", // chart title
				"Category", // domain axis label
				"Value", // range axis label
				dataset, // data
				PlotOrientation.VERTICAL, true, // include legend
				true, false);

		final XYPlot plot = chart1.getXYPlot();
		final NumberAxis domainAxis = new NumberAxis("Capacity");
		final NumberAxis rangeAxis = new NumberAxis("Time");
		plot.setDomainAxis(domainAxis);
		plot.setRangeAxis(rangeAxis);
		chart1.setBackgroundPaint(Color.white);
		plot.setOutlinePaint(Color.black);
		final ChartPanel chartPanel = new ChartPanel(chart1);
		chartPanel.setPreferredSize(new java.awt.Dimension(500, 270));
		setContentPane(chartPanel);

	}

	public static void main(final String[] args) {
		System.gc();
		final XYLogAxesDemo demo = new XYLogAxesDemo("Probe Map");
		demo.pack();
		RefineryUtilities.centerFrameOnScreen(demo);
		demo.setVisible(true);
	}
}