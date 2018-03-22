package jr222wb_assign3.sort;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Random;

import org.junit.jupiter.api.Test;

class SortTest {
	SortingAlgorithms sort = new SortingAlgorithms();

	@Test
	void insertionInt() { //Test insertion sort, integers
		//Small array
		int[] arr1 = {1, -3};
		int[] sorted1 = sort.insertionSort(arr1);
		assertEquals(-3, sorted1[0]);
		
		//Large array
		int[] arr2 = new int[50000]; //Create large array
		Random r = new Random();
		for (int i = 0; i < arr2.length; i++) //Fill with random values starting from 0
			arr2[i] = r.nextInt();
		arr2[r.nextInt(arr2.length)] = Integer.MIN_VALUE; //Insert minimum integer at random position
		arr2[r.nextInt(arr2.length)] = Integer.MAX_VALUE; //Insert maximum integer at random position
		int[] sorted2 = sort.insertionSort(arr2);
		//Assert that they've been properly sorted
		assertEquals(Integer.MIN_VALUE, sorted2[0]);
		assertEquals(Integer.MAX_VALUE, sorted2[sorted2.length - 1]);		
	}
	
	@Test
	void mergeInt() { //Test merge sort, integers
		//Small array
		int[] arr1 = {1, -3};
		int[] sorted1 = sort.mergeSort(arr1);
		assertEquals(-3, sorted1[0]);
		
		//Large array
		int[] arr2 = new int[50000]; //Create large array
		Random r = new Random();
		for (int i = 0; i < arr2.length; i++) //Fill with random values starting from 0
			arr2[i] = r.nextInt();
		arr2[r.nextInt(arr2.length)] = Integer.MIN_VALUE; //Insert minimum integer at random position
		arr2[r.nextInt(arr2.length)] = Integer.MAX_VALUE; //Insert maximum integer at random position
		int[] sorted2 = sort.mergeSort(arr2);
		//Assert that they've been properly sorted
		assertEquals(Integer.MIN_VALUE, sorted2[0]);
		assertEquals(Integer.MAX_VALUE, sorted2[sorted2.length - 1]);		
	}
	
	@Test
	void insertionString() { //Test insertion sort, strings
		//Small array
		String[] arr1 = {"Ove", "Lennart"};
		String[] sorted1 = sort.insertionSort(arr1, (s1, s2) -> s1.compareToIgnoreCase(s2));
		assertEquals("Lennart", sorted1[0]);
		
		//Large array
		String[] arr2 = new String[50000]; //Create large array
		String alphabet = "bcdefghijklmnopqrstuvwxy"; //Possible letters to generate words from
		Random r = new Random();
		for (int i = 0; i < arr2.length; i++) {
			String str = ""; //Empty string
			for (int k = 0; k < r.nextInt(25) + 1; k++) //Create word between lengths 1 and 25 
				str += alphabet.charAt(r.nextInt(alphabet.length())); //Insert random characters into string
			arr2[i] = str;
		}
		arr2[r.nextInt(arr2.length)] = "a"; //Insert a at random position
		arr2[r.nextInt(arr2.length)] = "z"; //Insert z at random position
		String[] sorted2 = sort.insertionSort(arr2, (s1, s2) -> s1.compareToIgnoreCase(s2));
		//Assert that they've been properly sorted
		assertEquals("a", sorted2[0]);
		assertEquals("z", sorted2[sorted2.length - 1]);
	}
	
	@Test
	void mergeString() { //Test merge sort, strings
		//Small array
		String[] arr1 = {"Ove", "Lennart"};
		String[] sorted1 = sort.mergeSort(arr1, (s1, s2) -> s1.compareToIgnoreCase(s2));
		assertEquals("Lennart", sorted1[0]);
		
		//Large array
		String[] arr2 = new String[50000]; //Create large array
		String alphabet = "bcdefghijklmnopqrstuvwxy"; //Possible letters to generate words from
		Random r = new Random();
		for (int i = 0; i < arr2.length; i++) {
			String str = ""; //Empty string
			for (int k = 0; k < r.nextInt(25) + 1; k++) //Create word between lengths 1 and 25 
				str += alphabet.charAt(r.nextInt(alphabet.length())); //Insert random characters into string
			arr2[i] = str;
		}
		arr2[r.nextInt(arr2.length)] = "a"; //Insert a at random position
		arr2[r.nextInt(arr2.length)] = "z"; //Insert z at random position
		String[] sorted2 = sort.mergeSort(arr2, (s1, s2) -> s1.compareToIgnoreCase(s2));
		//Assert that they've been properly sorted
		assertEquals("a", sorted2[0]);
		assertEquals("z", sorted2[sorted2.length - 1]);
	}

}
