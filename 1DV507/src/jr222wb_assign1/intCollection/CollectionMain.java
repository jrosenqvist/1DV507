package jr222wb_assign1.intCollection;

public class CollectionMain {
	public static void main(String[] args) {		
		//Test code for ArrayIntList
		System.out.println("\tArrayIntList");
		ArrayIntList list = new ArrayIntList(); //Creating new intlist		
		for (int i = 1; i < 12; i++) //Adding numbers 1-11
			list.add(i);		
		System.out.println(list); //Write out list		
		list.remove(1); //Remove value at index 1 
		list.remove(1);
		list.remove(1);
		System.out.println(list); //Write out list		
		list.addAt(2, 1); //Add '2' to index 1
		System.out.println(list); //Write out list		
		System.out.println("Index 1 value: " + list.get(1)); //Write out value of index 1
		System.out.println("Index of '8': " + list.indexOf(8)); //Write out index of value '8'
		
		//Test code for ArrayIntStack
		System.out.println("\n\tArrayIntStack");
		ArrayIntStack stack = new ArrayIntStack(); //Creating new intstack
		for (int i = 1; i < 15; i++) //Adding 15 values to stack
			stack.push(i);		
		System.out.println(stack); //Write out stack content
		System.out.println(stack.pop()); //Pop stack
		System.out.println(stack.peek()); //Peek top value
		System.out.println(stack); //Pop more items than are in stack
		for (int i = 0; i < 15; i++)
			stack.pop();		
		System.out.println(stack.peek()); //Try to peep empty stack
		stack.push(4); //Push new value
		System.out.println(stack); //Write out stack content
	}	
}
