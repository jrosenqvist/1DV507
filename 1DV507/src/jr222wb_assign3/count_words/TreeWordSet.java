package jr222wb_assign3.count_words;

import java.util.Iterator;

public class TreeWordSet implements WordSet {
	private TreeNode root = null;
	private int size = 0;

	public Iterator<Object> iterator() {		
		return new TreeIterator();
	}

	public void add(Word word) {
		if (root == null) {
			root = new TreeNode(word);
			size++;
		}
		else
			root.add(word);
	}

	public boolean contains(Word word) {		
		return root.contains(word);
	}

	public int size() {		
		return size;
	}

	private class TreeNode {
		Word word;
		TreeNode left = null;
		TreeNode right = null;		

		TreeNode(Word w) { word = w; }

		void add(Word w) {
			if (w.compareTo(word) < 0) {
				if (left == null) {
					left = new TreeNode(w);					
					size++;
				}
				else
					left.add(w);
			}

			else if (w.compareTo(word) > 0) {
				if (right == null) {
					right = new TreeNode(w);
					size++;
				}
				else
					right.add(w);
			}				
		}

		boolean contains(Word w) {
			if (w.compareTo(word) < 0) { 
				if (left == null)
					return false;
				else
					return left.contains(w);
			}

			else if (w.compareTo(word) > 0) {
				if (right == null)
					return false;
				else
					return right.contains(w);
			}
			return true;
		}
	}

	private class TreeIterator implements Iterator<Object> {
		private int index = 0;
		private Word[] words; //Store words from tree here when an iterator is created

		private TreeIterator() {			
			if (root == null) //Do not initialize if tree is empty
				return;			
			words = new Word[size]; //Initialize array
			readTree(root); //Populate array
			index = 0; //Set index to 0 again for iteration purposes			
		}

		private void readTree(TreeNode node) { //Traverse tree recursively and store words in array
			if (node.left != null)
				readTree(node.left);			
			words[index++] = node.word;			
			if (node.right != null)
				readTree(node.right);
		}

		public boolean hasNext() {
			return index < size;
		}

		public Word next() {
			return words[index++];
		}
	}
}
