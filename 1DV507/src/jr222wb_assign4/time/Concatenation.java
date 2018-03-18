package jr222wb_assign4.time;

public class Concatenation {
	
	final static int RUNS = 5; //Number of test cycles
	
	public static void main(String[] args) {		
		int[][] results = new int[4][2 * RUNS]; //Store results from each cycle
		long before, current = 0; //Variables for time-keeping
		int count; //Counter for tests
		String str; //String for concatenation tests

		//Warm-up, make sure everything is properly initialized before running real tests
		before = System.currentTimeMillis();
		str = "";
		while (current < 2000) {
			current = System.currentTimeMillis() - before;
			str += "0";
		}
		
		//Tests
		for (int i = 0; i < RUNS; i++) {
			System.out.println("Starting run " + (i + 1));
			int index = 2 * i; //Index used for storing results

			//Plus operator, short string
			count = 0;
			str = "";
			current = 0;
			before = System.currentTimeMillis();			
			while (current <= 1000) {				
				str += "0";
				count++;
				current = System.currentTimeMillis() - before;
			}
			results[0][index] = count;
			results[0][index + 1] = str.length(); 		

			//Plus operator, long string
			count = 0;		
			str = "";
			current = 0;
			before = System.currentTimeMillis();
			while (current <= 1000) {			
				str += "01234567890123456789012345678901234567890123456789012345678901234567890123456789";
				count++;
				current = System.currentTimeMillis() - before;
			}
			results[1][index] = count;
			results[1][index + 1] = str.length();

			//StringBuilder, short string					
			current = 0;
			StringBuilder sb1 = new StringBuilder();
			count = 0;
			before = System.currentTimeMillis();
			while (current <= 1000) {			
				sb1.append("0");
				count++;
				current = System.currentTimeMillis() - before;
				sb1.toString();
			}	
			results[2][index] = count;
			results[2][index + 1] = sb1.length();

			//StringBuilder, long string			
			current = 0;
			StringBuilder sb2 = new StringBuilder();
			count = 0;
			before = System.currentTimeMillis();		
			while (current <= 1000) {			
				sb2.append("01234567890123456789012345678901234567890123456789012345678901234567890123456789");
				count++;
				current = System.currentTimeMillis() - before;
				sb2.toString();
			}		
			results[3][index] = count;
			results[3][index + 1] = sb2.length();		
		}
		
		//Print out final results
		System.out.println("\n========= CONCATENATION - SHORT STRING =========");
		System.out.print("Number of concatenations:\t");
		for (int i = 0; i < RUNS * 2; i += 2) 
			System.out.print(results[0][i] + " ");		
		System.out.print("\nFinal string lengths:\t\t");
		for (int i = 1; i < RUNS * 2; i += 2) 
			System.out.print(results[0][i] + " ");
				
		System.out.println("\n\n========= CONCATENATION - LONG STRING =========");
		System.out.print("Number of concatenations:\t");
		for (int i = 0; i < RUNS * 2; i += 2) 
			System.out.print(results[1][i] + " ");		
		System.out.print("\nFinal string lengths:\t\t");
		for (int i = 1; i < RUNS * 2; i += 2) 
			System.out.print(results[1][i] + " ");
		
		System.out.println("\n\n========= STRINGBUILDER - SHORT STRING =========");
		System.out.print("Number of concatenations:\t");
		for (int i = 0; i < RUNS * 2; i += 2) 
			System.out.print(results[2][i] + " ");		
		System.out.print("\nFinal string lengths:\t\t");
		for (int i = 1; i < RUNS * 2; i += 2) 
			System.out.print(results[2][i] + " ");
		
		System.out.println("\n\n========= STRINGBUILDER - LONG STRING =========");
		System.out.print("Number of concatenations:\t");
		for (int i = 0; i < RUNS * 2; i += 2) 
			System.out.print(results[3][i] + " ");		
		System.out.print("\nFinal string lengths:\t\t");
		for (int i = 1; i < RUNS * 2; i += 2) 
			System.out.print(results[3][i] + " ");
	}
}
