package jr222wb_assign4.generic;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Iterator;

import org.junit.jupiter.api.Test;


class QueueTest {
	//Helper methods
	private Queue<String> buildString() { return new LinkedQueue<String>();	}
	private Queue<Integer> buildInteger() { return new LinkedQueue<Integer>(); }
	
	@Test
	public void testEmpty() {
		Queue<String> qs = buildString();
		Queue<Integer> qi = buildInteger(); 
		assertEquals(true, qs.isEmpty());
		assertEquals(true, qi.isEmpty());
	}
	
	@Test
	public void testFirst() { //Test that 'first' method returns the right object
		Queue<String> qs = buildString();
		Queue<Integer> qi = buildInteger();
		for (int i = 1; i <= 100; i++) {
			qs.enqueue("String " + i);
			qi.enqueue(i);
		}
		assertEquals("String 1", qs.first());
		assertEquals(1, qi.first());
		qs.dequeue();
		qi.dequeue();
		qs.enqueue("");
		qi.enqueue(0);
		assertEquals("String 2", qs.first());
		assertEquals(2, qi.first());
	}
	
	@Test
	public void testFirstLast() { //Test that 'last' method returns the right object		
		Queue<String> qs = buildString();
		Queue<Integer> qi = buildInteger();
		for (int i = 1; i <= 100; i++) {
			qs.enqueue(Integer.toString(i));
			qi.enqueue(i);
		}
		assertEquals("1", qs.first()); //First	
		assertEquals("100", qs.last()); //Last
		qs.dequeue();
		qi.dequeue();
		qs.enqueue("0"); 
		qi.enqueue(0);
		assertEquals("2", qs.first()); //First
		assertEquals("0", qs.last()); //Last
		assertEquals(2, qi.first()); //First
		assertEquals(0, qi.last()); //Last
	}
	
	@Test
	public void testEnqueueSize() { //Test 'enqueue' and 'size'		
		Queue<String> qs1 = buildString();
		Queue<Integer> qi1 = buildInteger();
		for (int i = 1; i <= 500000; i++) {
			qs1.enqueue(Integer.toString(i));
			qi1.enqueue(i);
		}
		assertEquals(500000, qs1.size());
		assertEquals(500000, qi1.size());
		
		Queue<String> qs2 = buildString();
		Queue<Integer> qi2 = buildInteger();
		qs2.enqueue("0");
		qi2.enqueue(0);
		assertEquals(1, qs2.size());
		assertEquals(1, qi2.size());
		qs2.dequeue();
		qi2.dequeue();
		assertEquals(0, qs2.size());
		assertEquals(0, qi2.size());
	}
	
	@Test
	public void testDequeueToString() {
		//Test small and standard queues
		Queue<String> qs1 = buildString();
		Queue<Integer> qi1 = buildInteger();
		assertThrows(NullPointerException.class, () -> qs1.dequeue()); //Test that empty queue throws exception
		assertThrows(NullPointerException.class, () -> qi1.dequeue()); //Test that empty queue throws exception
		assertEquals("[ ]", qs1.toString()); //Test that empty queue returns the correct string
		assertEquals("[ ]", qi1.toString()); //Test that empty queue returns the correct string
		for (int i = 1; i < 11; i++) {
			qs1.enqueue(Integer.toString(i));
			qi1.enqueue(i);
		}
		assertEquals("[ 1 2 3 4 5 6 7 8 9 10 ]", qs1.toString());
		assertEquals("[ 1 2 3 4 5 6 7 8 9 10 ]", qi1.toString());
		assertEquals("1", qs1.dequeue());
		assertEquals("2", qs1.dequeue());
		assertEquals(1, qi1.dequeue());
		assertEquals(2, qi1.dequeue());
				
		//Test that returned dequeue object matches the expected one for long queues
		Queue<String> qs2 = buildString();
		Queue<Integer> qi2 = buildInteger();
		for (int i = 1; i <= 20000; i++) {
			qs2.enqueue(Integer.toString(i));
			qi2.enqueue(i);
		}
		for (int i = 1; i <= 20000; i++) { 			
			assertEquals(Integer.toString(i), qs2.dequeue());
			assertEquals(i, qi2.dequeue());
		}
		
		//Test if a really long string matches toString()
		Queue<String> qs3 = buildString();
		Queue<Integer> qi3 = buildInteger();
		StringBuilder s = new StringBuilder();
		s.append("[ ");
		for (int i = 1; i <= 20000; i++) {
			s.append(i + " ");
			qs3.enqueue(Integer.toString(i));
			qi3.enqueue(i);
		}
		s.append("]");
		assertEquals(s.toString(), qs3.toString());
		assertEquals(s.toString(), qi3.toString());
	}
	
	@Test
	public void testIterator() {
		Queue<String> qs = buildString();
		Queue<Integer> qi = buildInteger();
		Iterator<String> qsIter = qs.iterator(); //Create iterator from empty queue
		Iterator<Integer> qiIter = qi.iterator(); //Create iterator from empty queue
		assertEquals(false, qsIter.hasNext());		
		assertEquals(false, qiIter.hasNext());		
		for (int i = 0; i < 2000; i++) { //Fill queue with 2000 elements
			qs.enqueue(Integer.toString(i));
			qi.enqueue(i);
		}
		Iterator<String> qsIter2 = qs.iterator(); //Create iterator from filled queue
		Iterator<Integer> qiIter2 = qi.iterator(); //Create iterator from filled queue
		assertEquals(true, qsIter2.hasNext());
		assertEquals(true, qiIter2.hasNext());
		for (int i = 0; i < 1999; i++) { //Remove all but one element
			qs.dequeue();
			qi.dequeue();
		}
		Iterator<String> qsIter3 = qs.iterator(); //Create new iterator
		Iterator<Integer> qiIter3 = qi.iterator(); //Create new iterator
		assertEquals(true, qsIter3.hasNext());
		assertEquals(true, qiIter3.hasNext()); 
		qs.dequeue(); //Remove last element
		qi.dequeue(); //Remove last element
		Iterator<String> qsIter4 = qs.iterator(); //Create new iterator
		Iterator<Integer> qiIter4 = qi.iterator(); //Create new iterator
		assertEquals(false, qsIter4.hasNext());
		assertEquals(false, qiIter4.hasNext());
	}
	
}
