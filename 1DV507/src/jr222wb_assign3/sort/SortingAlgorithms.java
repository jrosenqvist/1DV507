package jr222wb_assign3.sort;

import java.util.Arrays;

public class SortingAlgorithms {
	public static void main(String[] args) {
		int[] arr =  { 1, 2, 9, 8, 7, 6, 5, -2 };		
		System.out.println("INSERTION SORT\nUnsorted:\t" + Arrays.toString(arr));
		insertionSort(arr);
		System.out.println("Sorted: \t" + Arrays.toString(arr));

		int[] arr2 =  { 1, 2, 9, 8, 7, 6, 5, -2 };
		System.out.println("\nMERGE SORT\nUnsorted:\t" + Arrays.toString(arr2));
		mergeSort(arr2);
		System.out.println("Sorted: \t" + Arrays.toString(arr2));
	}

	//Based on description from https://www.khanacademy.org/computing/computer-science/algorithms/insertion-sort/a/insertion-sort
	public static int[] insertionSort(int[] in) {
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
		return in;
	}


	public static int[] mergeSort(int[] in) { //Standard method that calls overloaded method
		return mergeSort(in, 0, in.length);
	}

	public static int[] mergeSort(int[] in, int min, int max) {		
		int mid = (max - min) / 2;		
		if (max - min > 1) {
			mergeSort(in, min, mid);
			mergeSort(in, mid + 1, max);
			merge(in, min, max, mid);
		}
		return in; 
	}
	
	private static int[] merge(int[] in, int min, int max, int mid) {
		int pos = min;
		while (pos <= mid) {
			int tmp = in[pos];
			if (in[li] < in[ri]) {
				System.out.println(in[li] + " smaller than " + in[ri]);
				in[pos] = in[li];
				in[li] = tmp;
				li++;
			}
			else {
				System.out.println(in[ri] + " smaller than " + in[li]);
				in[pos] = in[ri];
				in[ri] = tmp;
				ri++;				
			}
			pos++;
		}
		while (li < left) {
			in[pos++] = in[li++];			
		}
		while (ri < end) {
			in[pos++] = in[ri++];
		}
		return in;		
	}
}
