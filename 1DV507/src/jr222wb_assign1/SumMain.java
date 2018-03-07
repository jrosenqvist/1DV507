package jr222wb_assign1;

public class SumMain {	

	public static void main(String[] args) {		
		System.out.println(sum(10,1)); //Call method with max value and lowest value
		//System.out.println(sumItr(10,1)); //Call to iterative method used as a control
	}
	
	static int sum(int n, int first) { //Take max number n and first number		
		if (n == first)
			return n;
		else
			return sum((n + first) / 2, first) + sum(n, (n + first) / 2 + 1);
			/* First part will send a new n, allowing the second part to send a new first value, which
			 * in turn will give the first part a new n. Eventually n == first in both cases, and n
			 * can be returned. 
			 * 
			 * Dividing the solution in two parts like this is unnecessarily complicated and requires more 
			 * calculations than doing it in "one sweep." 2n-1 calculations versus n calculations (I've counted). 
			 */
	}
	
	/* Iterative solution for controlling result
	static int sumItr(int n, int first) {
		int sum = 0;
		for (int i = first; i <= n; i++)
			sum += i;
		return sum;
	} */
}
