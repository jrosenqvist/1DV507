package jr222wb_mathset.my_own;
import java.util.ArrayList;
import java.util.Iterator;

import jr222wb_mathset.math_set.*;

public class MySet implements MathSet {
	ArrayList<Node> buckets = new ArrayList<>();
	int size = 0;
	
	@Override
	public int size() {		
		return size;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public boolean contains(Object element) {
		int index = element.hashCode() % buckets.size();
		if (buckets.get(index) != null) {
			Node node = buckets.get(index);
			while (node != null) {
				if (node.value.equals(element))
					return true;
			}			
		}
		return false;
	}

	@Override
	public Iterator<Object> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MathSet intersection(MathSet ms) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MathSet union(MathSet ms) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MathSet difference(MathSet ms) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MathSet copy() {
		// TODO Auto-generated method stub
		return null;
	}
	
	private class Node {
		Object value;		
		Node next = null;
		
		Node(Object value) {
			this.value = value;
		}
		
		Object getValue() {
			return value;
		}
	}

}
