package jr222wb_assign1.intCollection;

public class ArrayIntList extends AbstractIntCollection implements IntList {

	public void add(int n) {
		if (size >= values.length)  //Check if array needs resizing
			resize();		
		values[size++] = n;	//Add value at last index and set new size	
	}	

	public void addAt(int n, int index) throws IndexOutOfBoundsException {
		try {
			int[] tmp = new int[size - index]; //Temporary array for all values right of index
			for (int i = index; i < size; i++) //Starting at index, save all values in new array
				tmp[i - index] = values[i];
			values[index] = n; //Insert new value at index
			if (size >= values.length) //Resize array if necessary
				resize();
			for (int i = 0; i < tmp.length; i++) //Insert temporary array into the original one
				values[1 + index++] = tmp[i];
			size++; //Set new size of array
		}
		catch (IndexOutOfBoundsException | NegativeArraySizeException e) {
			System.out.println("Error: Index is out of bounds"); //Print out error and checkIndex output
			checkIndex(index, size);
		}
	}

	public void remove(int index) throws IndexOutOfBoundsException {
		try {			
			for (int i = index; i < size; i++) { //Starting at index, move every value right of it one step to the left				
				values[i] = values[i + 1];				
			}		
			size--; //Set new size of array
		}		
		catch (IndexOutOfBoundsException e) {
			System.out.println("Error: Index is out of bounds"); //Print out error message and checkIndex
			checkIndex(index, size);
		}

	}

	public int get(int index) throws IndexOutOfBoundsException {
		try { return values[index]; } //Try to return
		catch (IndexOutOfBoundsException e) {
			System.out.println("Error: Index is out of bounds"); //Print out error if out of bounds
			checkIndex(index, size); 
			return 0;
		}
	}

	public int indexOf(int n) {
		for (int i = 0; i < size; i++) //Go through array 
			if (n == values[i]) //If index values matches n
				return i; //Return index number
		System.out.println("Value was not found"); //If not found, print out message and return -1
		return -1;
	}

}
