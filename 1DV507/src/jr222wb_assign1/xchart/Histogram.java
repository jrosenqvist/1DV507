package jr222wb_assign1.xchart;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import org.knowm.xchart.CategoryChart;
import org.knowm.xchart.CategoryChartBuilder;
import org.knowm.xchart.SwingWrapper;

public class Histogram {
	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("/home/spender/workspace/1DV507/src/jr222wb_assign1/xchart/heltal.dat");		 
		int[] yData = countInterval(file); //Count numbers in file and put in array
		int[] xData = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100}; //Put top of intervals in array
		
		CategoryChart chart = new CategoryChartBuilder().width(800).height(600).build(); //Create a new chart
		//Set titles
		chart.setTitle("Numbers in interval 1 - 100");
		chart.setXAxisTitle("Interval");
		chart.setYAxisTitle("Quantity");
		//Add data set
		chart.addSeries("From previous to", xData, yData);		
		
		new SwingWrapper<CategoryChart>(chart).displayChart(); //Display chart
	}

	private static int[] countInterval(File file) throws FileNotFoundException {		
		Scanner readFile = new Scanner(file);
		int[] counted = new int[10]; //Array for storing quantity per interval

		while (readFile.hasNextInt()) { //Go through every integer in file
			int n = readFile.nextInt();
			if (n > 0 && n < 101) { //Only count in valid interval
				if (n <= 10)
					counted[0]++;
				else if (n <= 20)
					counted[1]++;
				else if (n <= 30)
					counted[2]++;
				else if (n <= 40)
					counted[3]++;
				else if (n <= 50)
					counted[4]++;
				else if (n <= 60)
					counted[5]++;
				else if (n <= 70)
					counted[6]++;
				else if (n <= 80)
					counted[7]++;
				else if (n <= 90)
					counted[8]++;
				else if (n <= 100)
					counted[9]++;
			}
		}
		readFile.close();
		return counted;
	}

}
