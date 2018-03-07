package jr222wb_assign1.intCollection;

public class ArrayIntStack extends AbstractIntCollection implements IntStack {

	public void push(int n) {
		if (size == values.length) //Check if array needs resizing
			resize();
		values[size++] = n;	//Add integer to top of stack
	}

	public int pop() throws IndexOutOfBoundsException {
		if (size == 0) { //See if stack is empty, if so don't pop
			System.out.println("Error: Stack is empty");
			return 0;
		}
		else 
			return values[size-- - 1]; //Return top value and decrease size
	}

	public int peek() throws IndexOutOfBoundsException {
		try { 
			return values[size - 1]; //Try to return top value of stack
		}
		catch (IndexOutOfBoundsException e) { //Catch exception
			System.out.println("Error: Index out of bounds");
			return 0;
		}
	}

}
