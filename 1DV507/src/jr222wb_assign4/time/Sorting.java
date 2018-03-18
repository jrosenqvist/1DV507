package jr222wb_assign4.time;

import java.util.Comparator;
import java.util.Random;

public class Sorting {
	public static void main(String[] args) {
		//Insertion sort, integer
		long current = 0;
		int arrSize = 60000; //Initial approximation based on previous results
		while (true) {
			int[] arr = generateIntArray(arrSize);
			long before = System.currentTimeMillis();
			insertionSort(arr);
			current = System.currentTimeMillis() - before;
			//System.out.println(current);
			if (current < 990)
				arrSize *= 1.05;
			else if (current > 1010)
				arrSize *= 0.95;
			else {
				System.out.println("Insertion Sort integer: " + arr.length + ", time: " + current);
				break;
			}
		}

		//Insertion sort, string
		current = 0;
		arrSize = 15000; //Initial approximation based on previous results
		while (true) {
			String[] arr = generateStringArray(arrSize);
			long before = System.currentTimeMillis();
			insertionSort(arr, Comparator.naturalOrder());
			current = System.currentTimeMillis() - before;
			//System.out.println(current);
			if (current < 990)
				arrSize *= 1.05;
			else if (current > 1010)
				arrSize *= 0.95;
			else {
				System.out.println("Insertion Sort string: " + arr.length + ", time: " + current);
				break;
			}
		}

		//Merge sort, integer
		current = 0;
		arrSize = 3000000;
		while (true) {
			int[] arr = generateIntArray(arrSize);
			long before = System.currentTimeMillis();
			mergeSort(arr);
			current = System.currentTimeMillis() - before;
			//System.out.println(current);
			if (current < 990)
				arrSize *= 1.05;
			else if (current > 1010)
				arrSize *= 0.95;
			else {
				System.out.println("Merge Sort integer: " + arr.length + ", time: " + current);
				break;
			}
		}

		//Merge sort, string
		current = 0;
		arrSize = 2000000; //Initial approximation based on previous results
		double resizeFactor = 1.05;
		while (true) {
			String[] arr = generateStringArray(arrSize);
			long before = System.currentTimeMillis();
			mergeSort(arr, Comparator.naturalOrder());
			current = System.currentTimeMillis() - before;
			//System.out.println(current);
			if (current > 950 && current < 1050)
				resizeFactor = 1.01;
			if (current < 990)
				arrSize *= resizeFactor;
			else if (current > 1010)
				arrSize /= resizeFactor;
			else {
				System.out.println("Merge Sort string: " + arr.length + ", time: " + current);
				break;
			}
		}
	}

	private static int[] generateIntArray(int size) {
		int[] arr = new int[size];
		Random r = new Random();
		for (int i = 0; i < size; i++)
			arr[i] = r.nextInt(size * 2);
		return arr;
	}

	private static String[] generateStringArray(int size) {
		String[] arr = new String[size];
		Random r = new Random();
		String chars = "abcdefghijklmnopqrstuvwxyzåäöABCDEFGHIJKLMNOPQRSTUVWXYZÅÄÖ0123456789";
		for (int i = 0; i < size; i++) {
			StringBuilder sb = new StringBuilder();			
			for (int j = 0; j < 10; j++) {				
				sb.append(chars.charAt(r.nextInt(chars.length())));
			}
			arr[i] = sb.toString();			
		}
		return arr;
	}

	private static void insertionSort(int[] in) {		
		System.arraycopy(in, 0, in, 0, in.length); //Make copy of array
		for (int i = 1; i < in.length; i++) { //Iterate over array
			int key = in[i]; //Set compare value
			for (int j = i - 1; j >= 0; j--) { //Iterate backwards from current position to beginning of array
				if (key < in[j]) { //If compare value is smaller than current position in array, move that position to the right					
					in[j + 1] = in[j];
				}
				else if (key >= in[j]) {	//If compare value is larger or equal, break loop				
					break;
				}
				in[j] = key; //Set last position reached to compare value
			}			
		}		
	}
	private static void insertionSort(String[] in, Comparator<String> c) {		
		System.arraycopy(in, 0, in, 0, in.length); //Make copy of array
		for (int i = 1; i < in.length; i++) { //Iterate over array
			String key = in[i]; //Set compare value
			for (int j = i - 1; j >= 0; j--) { //Iterate backwards from current position to beginning of array
				if (c.compare(key, in[j]) < 0) { //If compare value is smaller than current position in array, move that position to the right					
					in[j + 1] = in[j];
				}
				else if (c.compare(key, in[j]) >= 0) {	//If compare value is larger or equal, break loop				
					break;
				}
				in[j] = key; //Set last position reached to compare value
			}			
		}		
	}

	private static void mergeSort(int[] in) {		
		if (in.length == 1) //After splitting to single elements, simply return them
			return;		
		int[] left = new int[in.length / 2]; //Otherwise split into two arrays
		int[] right = new int[in.length - left.length];
		System.arraycopy(in, 0, left, 0, left.length);
		System.arraycopy(in, left.length, right, 0, right.length);
		mergeSort(left); //And recursively run method on each array
		mergeSort(right);

		//Merging		
		int i = 0, li = 0, ri = 0; //Indices used for merging
		while (li < left.length && ri < right.length) { //For length of returned arrays
			if (left[li] < right[ri]) //Add smallest value to original array
				in[i++] = left[li++];
			else
				in[i++] = right[ri++];
		}
		while (li < left.length) //Add leftovers from longer array
			in[i++] = left[li++];
		while (ri < right.length)
			in[i++] = right[ri++];		
	}	

	private static void mergeSort(String[] in, Comparator<String> c) {		
		if (in.length == 1) //After splitting to single elements, simply return them
			return;		
		String[] left = new String[in.length / 2]; //Otherwise split into two arrays
		String[] right = new String[in.length - left.length];
		System.arraycopy(in, 0, left, 0, left.length);
		System.arraycopy(in, left.length, right, 0, right.length);
		mergeSort(left, c); //And recursively run method on each array
		mergeSort(right, c);

		//Merging		
		int i = 0, li = 0, ri = 0; //Indices used for merging
		while (li < left.length && ri < right.length) { //For length of returned arrays
			if (c.compare(in[li], in[ri]) < 0) //Add smallest value to original array
				in[i++] = left[li++];
			else
				in[i++] = right[ri++];
		}
		while (li < left.length) //Add leftovers from longer array
			in[i++] = left[li++];
		while (ri < right.length)
			in[i++] = right[ri++];		
	}
}
