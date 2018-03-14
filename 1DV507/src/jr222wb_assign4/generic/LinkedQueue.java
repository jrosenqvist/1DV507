package jr222wb_assign4.generic;

import java.util.Iterator;

public class LinkedQueue<T> implements Queue<T> {
	private int size = 0;
	private Node head = null;
	private Node tail = null;	

	private class Node {		
		T content;
		Node next = null;		
		Node (T element) {
			content = element;
		}
	}
	
	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}

	public void enqueue(T element) {
		Node node = new Node(element);
		if (tail == null) 			
			head = node;		
		else 
			tail.next = node;		
		tail = node;
		size++;
	}
	
	public T dequeue() {
		if (!isEmpty()) {
			T returnObj = head.content;
			head = head.next;
			size--;
			return returnObj;
		}
		throw new NullPointerException("Queue is empty");
	}
	
	public T first() {		
		return head.content;
	}
	
	public T last() {		
		return tail.content;
	}
	
	public Iterator<T> iterator() {		
		return new QueueIterator();
	}

	private class QueueIterator implements Iterator<T> {
		Node node = head;
		public boolean hasNext() {			
			return node != null;
		}

		public T next() {
			T content = node.content;
			node = node.next;
			return content;
		}		
	}
	
	public String toString() {
		QueueIterator iter = new QueueIterator();
		StringBuilder sb = new StringBuilder();
		while (iter.hasNext()) {
			sb.append(iter.next() + " ");
		}			
		return "[ " + sb.toString() + "]";
	}
}


