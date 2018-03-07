package jr222wb_assign1;

public class PascalMain {
	public static void main(String[] args) {
		for (int n : pascalRow(7)) //Print out row 7 of Pascal's triangle
			System.out.print(n + " ");		
	}

	private static int[] pascalRow(int n) {		
		if (n == 0) { //Return a fixed array for n = 0
			int[] row = {1};
			return row;			
		}				 
		int[] row = new int[n + 1];	//Create an array of the row's length	
		int[] prevRow = pascalRow(n - 1); //Create an array with the numbers from previous row
		row[0] = 1; //Set the first and last numbers of current row to 1
		row[n] = 1;		
		for (int i = 1; i < n; i++) { //Iterate through remainder of current row and set to sum of numbers above it on previous row 			
			row[i] = prevRow[i - 1] + prevRow[i]; 
		}
		return row;	//Return array of row values	
	}	
}
