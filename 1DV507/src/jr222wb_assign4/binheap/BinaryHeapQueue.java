package jr222wb_assign4.binheap;

public class BinaryHeapQueue implements PriorityQueue {
	private Task[] heap; //Array keeping heap
	private int size; //Storing size of heap
	
	public BinaryHeapQueue() { //Construct empty queue
		heap = new Task[11]; //Initialize heap with space for 10 tasks
		size = 0; //Set size
	}
	
	public BinaryHeapQueue(Task...tasks) { //Construct and add arbitrary number of tasks
		heap = new Task[tasks.length + 1]; //Initialize heap with enough space to fit all tasks
		size = 0; //Set size
		for (Task t : tasks) //Insert tasks
			insert(t);
	}
	
	public void insert(Task t) {		
		if (size + 1 == heap.length) { //If necessary, increase size of array
			Task[] tmp = new Task[heap.length * 2];
			System.arraycopy(heap, 0, tmp, 0, heap.length);
			heap = tmp;
		}				
		heap[size + 1] = t; //Add task to bottom of heap
		size++; //Increase size		
		percolateUp(); //Let task percolate up to the correct position		
	}	

	public Task pullHighest() {
		if (!isEmpty()) { //Only attempt pull if heap has elements
			Task returnValue = heap[1]; //Store highest value
			heap[1] = heap[size]; //Move up last value to top position
			size--; //Decrease size of heap before moving on
			percolateDown(); //Let top value percolate down to correct position
			return returnValue;	//Return the former highest value
		}
		throw new NullPointerException("Heap is empty"); //Throw exception if empty
	}

	public boolean contains(Task t) {
		for (int i = 1; i <= size; i++) //Go through heap
			if (heap[i].equals(t)) //See if any task matches
				return true;
		return false;
	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public Task peekHighest() {
		if (!isEmpty())
			return heap[1];
		throw new NullPointerException("Queue is empty");
	}	
	
	private void percolateUp() {
		int current = size; //Assign variables for current and parent
		int parent = size / 2;
		while (parent > 0 && heap[current].compareTo(heap[parent]) > 0) { //Compare to parent and swap if necessary
			Task tmp = heap[parent]; //Store value from parent
			heap[parent] = heap[current]; //Move t to parent
			heap[current] = tmp; //Move parent to previous position
			current = parent; //Update variables
			parent /= 2;			
		}
	}
	
	private void percolateDown() {
		int current = 1; //Current position in heap
		while (current * 2 <= size) { //While there are more children			
			int left = current * 2; //Assign variables for children
			int right = left + 1;
			int largest = current; //Assume left child is largest			
			if (left <= size && heap[left].compareTo(heap[largest]) > 0) //See if left child is larger
				largest = left;
			if (right <= size && heap[right].compareTo(heap[largest]) > 0) //See if there's a right child and if it's larger
				largest = right;
			if (current != largest) { //If largest child is larger than current node, swap them
				Task tmp = heap[largest];				
				heap[largest] = heap[current];
				heap[current] = tmp;				
			}			
			else //If not, work is done
				break;
			current = largest; //Continue from position of largest child
		}
	}

}
