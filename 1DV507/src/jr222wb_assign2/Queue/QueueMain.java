package jr222wb_assign2.Queue;

import java.util.Iterator;

public class QueueMain {
	public static void main(String[] args) {
		//Linked Queue
		LinkedQueue lq = new LinkedQueue(); //Create new linked queue
		lq.enqueue(new testObj(1)); //Add three elements
		lq.enqueue(new testObj(2));
		lq.enqueue(new testObj(3));
		Iterator<Object> lqIter = lq.iterator(); //Create an iterator
		System.out.println(lqIter.hasNext()); //See if hasnext works
		System.out.println(lq.toString()); //Print queue to string
		lq.dequeue(); //Dequeue two elements
		lq.dequeue();
				
		System.out.println(lq.toString()); //Print to string again
		
		//Array Queue
		System.out.println("\nARRAY QUEUE");
		ArrayQueue aq = new ArrayQueue();
		
		for (int i = 0; i < 7; i++)	//Enqueue and dequeue 7 times		
			aq.enqueue(new testObj(i));
		for (int i = 0; i < 7; i++)
			aq.dequeue();
		
		for (int i = 0; i < 11; i++) //Add 11 new objects, forces queue to expand
			aq.enqueue(new testObj(i));
		System.out.println("Size: " + aq.size()); //See that size is correct
		Iterator<Object> aqIter = aq.iterator(); //Create iterator
		while (aqIter.hasNext())			
			System.out.println(aqIter.next().toString()); //Print out each element in queue		
		System.out.println(aq);	//Print out toString of queue
	}
	
	
	private static class testObj {
		private int content;
		testObj(int n) {
			content = n;			
		}
		public String toString() {
			return Integer.toString(content);
		}
	}
}
