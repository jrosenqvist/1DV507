package jr222wb_assign3;

public class EuclideanMain {
	public static void main(String[] args) {
		System.out.println(gcd(1029, 1071));
	}
	
	private static long gcd (long a, long b) {
		if (b > a) { long n = b; b = a; a = n; } //Change a and b if necessary			
		if (b == 0) //When b is 0, GCD is found as a
			return a;
		return gcd(b, a % b); //Else call self with b as new a and rest of a divided by b as new b
	}
}


