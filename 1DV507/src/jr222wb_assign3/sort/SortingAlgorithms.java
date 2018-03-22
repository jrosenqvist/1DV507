package jr222wb_assign3.sort;

import java.util.Comparator;

public class SortingAlgorithms {

	//Based on description from https://www.khanacademy.org/computing/computer-science/algorithms/insertion-sort/a/insertion-sort
	public int[] insertionSort(int[] in) {
		int[] sorted = new int[in.length];
		System.arraycopy(in, 0, sorted, 0, in.length); //Make copy of array
		for (int i = 1; i < in.length; i++) { //Iterate over array
			int key = sorted[i]; //Set compare value
			for (int j = i - 1; j >= 0; j--) { //Iterate backwards from current position to beginning of array
				if (key < sorted[j]) { //If compare value is smaller than current position in array, move that position to the right					
					sorted[j + 1] = sorted[j];
				}
				else if (key >= sorted[j]) {	//If compare value is larger or equal, break loop				
					break;
				}
				sorted[j] = key; //Set last position reached to compare value
			}			
		}		
		return sorted;
	}
	
	public String[] insertionSort(String[] in, Comparator<String> c) {
		String[] sorted = new String[in.length];
		System.arraycopy(in, 0, sorted, 0, in.length); //Make copy of array
		for (int i = 1; i < in.length; i++) { //Iterate over array
			String key = sorted[i]; //Set compare value
			for (int j = i - 1; j >= 0; j--) { //Iterate backwards from current position to beginning of array
				if (c.compare(key, sorted[j]) < 0) { //If compare value is smaller than current position in array, move that position to the right					
					sorted[j + 1] = sorted[j];
				}
				else if (c.compare(key, sorted[j]) >= 0) {	//If compare value is larger or equal, break loop				
					break;
				}
				sorted[j] = key; //Set last position reached to compare value
			}			
		}		
		return sorted;
	}
		
	//Only makes a copy of original array and sends to "helper" method
	public int[] mergeSort(int[] in) {
		int[] sorted = new int[in.length]; //Make copy of array
		System.arraycopy(in, 0, sorted, 0, in.length);		
		return mergeSortHelper(sorted); //Call helper method that does the merging and sorting
	}
	
	public String[] mergeSort(String[] in, Comparator<String> c) {
		String[] sorted = new String[in.length]; //Make copy of array
		System.arraycopy(in, 0, sorted, 0, in.length);		
		return mergeSortHelper(sorted, c); //Call helper method that does the merging and sorting
	}
	
	//Based on description in slides and example in book
	private static int[] mergeSortHelper(int[] in) {		
		if (in.length == 1) //After splitting to single elements, simply return them
			return in;		
		int[] left = new int[in.length / 2]; //Otherwise split into two arrays
		int[] right = new int[in.length - left.length];
		System.arraycopy(in, 0, left, 0, left.length);
		System.arraycopy(in, left.length, right, 0, right.length);
		mergeSortHelper(left); //And recursively run method on each array
		mergeSortHelper(right);
		
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
		return in; //Return merged array
	}	
	
	private static String[] mergeSortHelper(String[] in, Comparator<String> c) {		
		if (in.length == 1) //After splitting to single elements, simply return them
			return in;		
		String[] left = new String[in.length / 2]; //Otherwise split into two arrays
		String[] right = new String[in.length - left.length];
		System.arraycopy(in, 0, left, 0, left.length);
		System.arraycopy(in, left.length, right, 0, right.length);
		mergeSortHelper(left, c); //And recursively run method on each array
		mergeSortHelper(right, c);
		
		//Merging		
		int i = 0, li = 0, ri = 0; //Indices used for merging
		while (li < left.length && ri < right.length) { //For length of returned arrays
			if (c.compare(left[li], right[ri]) < 0) //Add smallest value to original array
				in[i++] = left[li++];
			else
				in[i++] = right[ri++];
		}
		while (li < left.length) //Add leftovers from longer array
			in[i++] = left[li++];
		while (ri < right.length)
			in[i++] = right[ri++];		
		return in; //Return merged array
	}	
}
