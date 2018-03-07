package jr222wb_assign2.Queue;

import java.util.Iterator;

public class ArrayQueue implements Queue {
	private int first = 0, last = 0, size = 0;	//Variables for first, last and queue size
	private Object[] arr = new Object[10]; //Initialize array
	private boolean wrapped = false; //Boolean to make sure first and last are equal because last caught up

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public void enqueue(Object element) {		
		if (last == arr.length) { //Check if array needs to wrap around
			last = 0; //Set last to 0
			wrapped = true; //Keep track of the array being wrapped around						
		}
		if (first == last && wrapped) { //Check if array needs expansion
			last = arr.length; //Set last to length of array before expanding
			Object[] tmp = new Object[arr.length * 2]; //New temporary array of double size
			System.arraycopy(arr,0, tmp, 0, arr.length); //Copy contents into temporary array
			arr = tmp; //Set temporary array as new work array		
			first = 0; //Make sure first gets set to 0 if it wasn't
			//System.out.println("Expanding array...");
		}		
		arr[last++] = element; //Add element and change 'last'		
		size++; //Increase size		
	}

	public Object dequeue() { 
		if (!isEmpty()) { //Check that queue isn't empty			
			if (first == arr.length) { //Have first wrap around if necessary
				Object returnObj = arr[first];
				first = 0;
				size--;
				return returnObj;
			}
			if (first + 1 == last) //Make sure enqueue method doesn't unnecessarily expand array
				wrapped = false;
			size--; //Decrease size
			return arr[first++]; //Return object and move first one step
		}
		else
			throw new NullPointerException("Queue is empty"); //Throw exception on empty queue
	}

	public Object first() {		
		return arr[first]; //Return first object
	}

	public Object last() {		
		return arr[last - 1]; //Return last object
	}

	public Iterator<Object> iterator() {		
		return new QueueIterator(); //Create a new iterator and return
	}

	private class QueueIterator implements Iterator<Object> {
		int index = first, steps = 0; //Index and a counter, start iterating at 'first'
		public boolean hasNext() {			
			return steps < size; //As long as counter is smaller than queue size, we have more elements
		}
		public Object next() {
			if (index == arr.length) //Make sure the iterator wraps around
				index = 0;
			steps++; //Increase count
			return arr[index++]; //Return element and set new index		
		}		
	}

	public String toString() { //Use iterator to print out objects as string
		QueueIterator iter = new QueueIterator(); 
		StringBuilder sb = new StringBuilder();
		while (iter.hasNext()) { 
			sb.append(iter.next() + " "); //Add each element using string builder
		}			
		return "[ " + sb.toString() + "]"; //Return string
	}
}
