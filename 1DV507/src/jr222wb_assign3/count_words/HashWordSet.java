package jr222wb_assign3.count_words;

import java.util.Iterator;

public class HashWordSet implements WordSet {
	private int size = 0;
	private Node[] buckets = new Node[8]; 

	public Iterator<Object> iterator() {
		return new HashIterator();		
	}	

	public void add(Word w) {
		int pos = getBucketNumber(w);
		Node bucket = buckets[pos];

		while (bucket != null) { //If bucket not empty, look for node containing word
			if (bucket.word.equals(w)) //Exit out of add method if found
				return;
			else				
				bucket = bucket.next; //Continue looking until no more nodes in bucket
		}

		//If word was not found in bucket
		bucket = new Node(w); //Create new node containing word
		bucket.next = buckets[pos];
		buckets[pos] = bucket;
		size++;
		if (size == buckets.length)
			rehash();
	}	

	private void rehash() {
		Node[] temp = buckets;
		buckets = new Node[2 * temp.length];
		size = 0;
		for (Node n : temp) {
			if (n == null)
				continue;
			while (n != null) {
				add(n.word);
				n = n.next;
			}
		}
	}

	public boolean contains(Word w) {
		int pos = getBucketNumber(w);
		Node node = buckets[pos];
		while (node != null) {
			if (node.word.equals(w))
				return true;
			else
				node = node.next;
		}
		return false;		
	}

	public int size() {		
		return size;
	}

	private class Node {
		Word word;
		Node next = null;

		public Node(Word w) { word = w;	}

		public String toString() {
			return word.toString();
		}
	}
	
	private int getBucketNumber(Word w) {
		int hc = w.hashCode();
		if (hc < 0)
			hc = -hc;
		return hc % buckets.length;
	}

	private class HashIterator implements Iterator<Object> {
		private int bucket = -1;
		private Node current = null;

		public boolean hasNext() {
			if (current != null && current.next != null)
				return true;
			for (int i = bucket + 1; i < buckets.length; i++) 				
				if (buckets[i] != null) {
					System.out.println("Next node found at " + i);
					return true; 		
				}
			return false;
		}
		//TODO någonstans måste current uppdateras som det ska ELLER?! Skriv pseudokod

		public Object next() {			
			if (current != null && current.next != null) 
				current = current.next;							
			else {
				while (current == null && bucket < buckets.length) {					
					bucket++;					
				}
				current = buckets[bucket];
			}
			return current;
		}		
	}
}


