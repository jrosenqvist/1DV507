package jr222wb_assign3.count_words;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class HashWordSet implements WordSet {
	private int size = 0; //Size of set
	private Node[] buckets = new Node[8]; //Array acting as buckets for nodes 

	public Iterator<Object> iterator() {
		return new HashIterator();		
	}	

	public void add(Word w) {
		if (contains(w)) //Return out of method if word already exists
			return;		

		Node bucket = new Node(w); //Otherwise, create a new node containing the word
		int pos = getBucketNumber(w); //Get bucket to store it in		
		bucket.next = buckets[pos]; //Attach node to bucket
		buckets[pos] = bucket;
		size++; //Increase size
		if (size == buckets.length) //If necessary, increase size of array
			rehash();
	}	

	public boolean contains(Word w) { 
		int pos = getBucketNumber(w); //Get bucket where word should be
		Node node = buckets[pos];
		while (node != null) { //Search through nodes in bucket
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

	private void rehash() {
		Node[] temp = buckets; //Store current array
		buckets = new Node[2 * temp.length]; //Create new array twice current's size
		size = 0; //Reset size before transferring nodes to new array
		for (Node n : temp)  //For each node in old array, add it to new array using add method		
			while (n != null) {
				add(n.word);
				n = n.next;
			}		
	}

	private class Node {
		Word word; //Field containing word
		Node next = null; //Where to find next node
		public Node(Word w) { 
			word = w; 	
		}		
	}

	private int getBucketNumber(Word w) {
		int hc = w.hashCode(); //Calculate a hashcode of word
		if (hc < 0) 
			hc = -hc; //Make sure it's positive
		return hc % buckets.length; //Assign it a position that fits within array
	}

	private class HashIterator implements Iterator<Object> {
		int pos = -1; //Current position in array
		Node current = null; //Current node		

		public boolean hasNext() {
			if (current != null && current.next != null) //If additional nodes in bucket
				return true;			
			for (int i = pos + 1; i<buckets.length; i++) //Else, search rest of array for next bucket with nodes
				if (buckets[i] != null) 
					return true;				
			return false; //No more nodes in array
		}

		public Object next() {	
			if (current != null && current.next != null) //Move to next linked node if one exists
				current = current.next;						
			else //Else, loop through array in search of next node				
				do {
					if (pos + 1 == buckets.length)
						throw new NoSuchElementException(); //Throw exception if trying to do next when end is reached
					current = buckets[++pos];					
				} while (current == null); //Until node found
			return current.word; //Return currently selected node
		}
	}
}


