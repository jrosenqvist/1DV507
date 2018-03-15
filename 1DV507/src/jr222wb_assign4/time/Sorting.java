package jr222wb_assign4.time;

public class Sorting {
	public static void main(String[] args) {
		
	}
	
	public static int[] intInsertionSort(int[] in) {
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
	
	private static int[] intMergeSort(int[] in) {		
		if (in.length == 1) //After splitting to single elements, simply return them
			return in;		
		int[] left = new int[in.length / 2]; //Otherwise split into two arrays
		int[] right = new int[in.length - left.length];
		System.arraycopy(in, 0, left, 0, left.length);
		System.arraycopy(in, left.length, right, 0, right.length);
		intMergeSort(left); //And recursively run method on each array
		intMergeSort(right);
		
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


}
