package jr222wb_assign4.binheap;

public class BinaryIntHeap {
	private int size;
	private int[] heap;

	public BinaryIntHeap() { // Constructs an empty heap
		size = 0;
		heap = new int[11];
	}

	//TODO remove this method
	public String toString() {
		String s = "";
		for (int i = 1; i <= size; i++)
			s += heap[i] + " ";
		return s;
	}

	public void insert(int n) { // Add n to heap
		int current = size + 1;
		if (size + 1 == heap.length) {
			int[] tmp = new int[heap.length * 2];
			System.arraycopy(heap, 0, tmp, 0, heap.length);
			heap = tmp;
		}
		int parent = current / 2;		
		heap[current] = n; //Add number to bottom of heap
		while (n > heap[parent] && parent > 0) { //Compare to parent and swap if necessary
			int tmp = heap[parent]; //Store value from parent
			heap[parent] = n; //Move n to parent
			heap[current] = tmp; //Move parent to previous position
			current = parent; //Update variables
			parent /= 2;			
		}
		size++;
	}

	public int pullHighest() { // Return and remove element with highest priority
		if (!isEmpty()) {
			int returnValue = heap[1]; //Store highest value
			heap[1] = heap[size]; //Move up last value to top position
			size--; //Decrease size of heap before moving on
			int current = 1; //Current position in heap
			while (current * 2 <= size) { //While there are more children			
				int left = current * 2;
				int right = left + 1;
				int largest = current; //Assume left child is largest			
				if (left <= size && heap[left] > heap[largest]) //See if left child is larger
					largest = left;
				if (right <= size && heap[right] > heap[largest]) //See if there's a right child and if it's larger
					largest = right;
				if (current != largest) { //If largest child is larger than current node, swap them
					int tmp = heap[largest];				
					heap[largest] = heap[current];
					heap[current] = tmp;				
				}			
				else //If not, work is done
					break;
				current = largest; //Continue from position of largest child
			}
			return returnValue;	//Return the former highest value
		}
		throw new NullPointerException("Heap is empty");
	}

	public int size() { // Current heap size         
		return size;
	}

	public boolean isEmpty() { // True if heap is empty 
		return size == 0;
	}
}
