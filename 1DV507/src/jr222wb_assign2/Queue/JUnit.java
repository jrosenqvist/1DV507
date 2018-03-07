package jr222wb_assign2.Queue;

//Support for JUnit annotations (e.g. @Test)
import org.junit.jupiter.api.Test;
//Make static Assert methods available
import static org.junit.jupiter.api.Assertions.*;

import java.util.Iterator;

public class JUnit {
	
	//Helper method for building a new queue. Change to the type of queue you want to test.
	private Queue build() {		
		//return new LinkedQueue(); 
		return new ArrayQueue();
	}
	
	@Test
	public void testEmpty() {
		Queue q = build();
		assertEquals(true, q.isEmpty());
	}
	
	@Test
	public void testFirst() { //Test that 'first' method returns the right object
		Queue q = build();
		for (int i = 1; i <= 100; i++)
			q.enqueue(new testObj(i));
		assertEquals(1, ((testObj) q.first()).value);	
		q.dequeue();
		q.dequeue();
		q.enqueue(new testObj());
		assertEquals(3, ((testObj) q.first()).value);
	}
	
	@Test
	public void testFirstLast() { //Test that 'last' method returns the right object		
		Queue q = build();
		for (int i = 1; i <= 100; i++)
			q.enqueue(new testObj(i));
		assertEquals(1, ((testObj) q.first()).value); //First	
		assertEquals(100, ((testObj) q.last()).value); //Last
		q.dequeue();
		q.dequeue();
		q.enqueue(new testObj()); //Default constructor has value 0
		assertEquals(3, ((testObj) q.first()).value); //First
		assertEquals(0, ((testObj) q.last()).value); //Last
	}
	
	@Test
	public void testEnqueueSize() { //Test 'enqueue' and 'size'		
		Queue q1 = build();
		for (int i = 1; i <= 5000000; i++)
			q1.enqueue(new testObj(i));
		assertEquals(5000000, q1.size());
		
		Queue q2 = build();
		q2.enqueue(new testObj());
		assertEquals(1, q2.size());
		q2.dequeue();
		assertEquals(0, q2.size());
	}
	
	@Test
	public void testDequeueToString() {
		//Test small and standard queues
		Queue q1 = build();
		assertThrows(NullPointerException.class, () -> q1.dequeue()); //Test that empty queue throws exception
		assertEquals("[ ]", q1.toString()); //Test that empty queue returns the correct string
		for (int i = 1; i < 11; i++)
			q1.enqueue(new testObj(i));
		assertEquals("[ 1 2 3 4 5 6 7 8 9 10 ]", q1.toString());
		assertEquals(1, ((testObj) q1.dequeue()).value);
		assertEquals(2, ((testObj) q1.dequeue()).value);
		assertEquals(3, ((testObj) q1.dequeue()).value);
		
		//Test that returned dequeue object matches the expected one for long queues
		Queue q2 = build();		
		for (int i = 1; i <= 20000; i++)
			q2.enqueue(new testObj(i));		
		for (int i = 1; i <= 20000; i++) 			
			assertEquals(i, ((testObj) q2.dequeue()).value);
		
		//Test if a really long string matches toString()
		Queue q3 = build();		
		StringBuilder s = new StringBuilder();
		s.append("[ ");
		for (int i = 1; i <= 20000; i++) {
			s.append(i + " ");
			q3.enqueue(new testObj(i));
		}
		s.append("]");
		assertEquals(s.toString(), q3.toString());
	}
	
	@Test
	public void testIterator() {
		Queue q = build();
		Iterator<Object> qIter = q.iterator(); //Create iterator from empty queue
		assertEquals(false, qIter.hasNext()); 
		assertEquals(null, qIter.next()); 
		for (int i = 0; i < 2000; i++) //Fill queue with 2000 elements
			q.enqueue(new testObj(i));
		Iterator<Object> qIter2 = q.iterator(); //Create iterator from filled queue
		assertEquals(true, qIter2.hasNext()); 
		for (int i = 0; i < 1999; i++) //Remove all but one element
			q.dequeue();
		Iterator<Object> qIter3 = q.iterator(); //Create new iterator
		assertEquals(true, qIter3.hasNext()); 
		q.dequeue(); //Remove last element
		Iterator<Object> qIter4 = q.iterator(); //Create new iterator
		assertEquals(false, qIter4.hasNext()); 
	}
	
	private static class testObj {
		int value = 0;
		testObj(int n) { value = n;	}		
		testObj() {	}		
		public String toString() { return Integer.toString(value); }
	}
}
