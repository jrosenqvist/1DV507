package jr222wb_assign1.xchart;

import java.util.ArrayList;

import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.XYChart;
import org.knowm.xchart.XYChartBuilder;
import org.knowm.xchart.XYSeries.XYSeriesRenderStyle;

public class SinMain {
	public static void main(String[] args) {
		XYChart chart = new XYChartBuilder().width(1000).height(500).build(); //Create a new chart
		
		//Set the styling of the chart
		chart.getStyler().setChartTitleVisible(false); 
		chart.getStyler().setLegendVisible(false);
		chart.getStyler().setDefaultSeriesRenderStyle(XYSeriesRenderStyle.Line);
		chart.getStyler().setMarkerSize(0);
		
		//Lists to store data points
		ArrayList<Double> xData = new ArrayList<Double>();
		ArrayList<Double> yData = new ArrayList<Double>();
		
		//Added a resolution variable to get a reasonable amount of data points for the chart
		int resolution = 130; //Set amount of data points per x value. For best result, total 
							  //data points should not be higher than width of the chart
		for (double i = 0; i <= Math.PI*2*resolution; i++) { //Do loop between 0 and pi*2, with added resolution
			double x = i / resolution; //Divide by resolution to get correct values
			xData.add(x);
			yData.add((1 + x/Math.PI)*Math.cos(x)*Math.cos(40*x)); //Calculate according to formula	    	
		}

		chart.addSeries("Sine", xData, yData); //Add data to chart

		new SwingWrapper<XYChart>(chart).displayChart(); //Display chart
	}
}


