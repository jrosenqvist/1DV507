package jr222wb_assign2.Queue;
/**
 * A class for a Linked Queue. Every new element will be added to the queue as a node. Only first and last objects
 * of the queue can be reached. 
 * 
 * @author Joakim Rosenqvist
 */
import java.util.Iterator;
//TODO kolla mer på det här med javadoc
public class LinkedQueue implements Queue {
	private int size = 0;
	private Node head = null;
	private Node tail = null;	

	private class Node {		
		Object content;
		Node next = null;		
		Node (Object element) {
			content = element;
		}
	}
	
	/**
	 * Returns current size of queue.
	 */
	public int size() {
		return size;
	}
	
	/**
	 * Check if queue is empty.
	 * @return <code>true</code> if queue is empty.
	 */
	public boolean isEmpty() {
		return size == 0;
	}

	/**
	 * Add an object to end of queue.
	 * @param element element to add to queue
	 */
	public void enqueue(Object element) {
		Node node = new Node(element);
		if (tail == null) 			
			head = node;		
		else 
			tail.next = node;		
		tail = node;
		size++;
	}
	
	/**
	 * Removes and returns first object in queue.
	 * @return First object in queue. 
	 * @throws NullPointerException if queue is empty.
	 */
	public Object dequeue() {
		if (!isEmpty()) {
			Object returnObj = head.content;
			head = head.next;
			size--;
			return returnObj;
		}
		throw new NullPointerException("Queue is empty");
	}
	
	/**
	 * Returns first object in queue without removing it.
	 */
	public Object first() {		
		return head.content;
	}
	
	/**
	 * Returns last object in queue without removing it.
	 */
	public Object last() {		
		return tail.content;
	}
	
	/**
	 * Returns an <code>Iterator</code> object.
	 */
	public Iterator<Object> iterator() {		
		return new QueueIterator();
	}

	private class QueueIterator implements Iterator<Object> {
		Node node = head;
		public boolean hasNext() {			
			return node != null;
		}

		public Object next() {
			Object content = node.content;
			node = node.next;
			return content;
		}		
	}
	
	/**
	 * Returns string of objects in queue from first to last.
	 */
	public String toString() {
		QueueIterator iter = new QueueIterator();
		StringBuilder sb = new StringBuilder();
		while (iter.hasNext()) {
			sb.append(iter.next() + " ");
		}			
		return "[ " + sb.toString() + "]";
	}
}
