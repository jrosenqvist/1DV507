package jr222wb_assign4.binheap;

public interface PriorityQueue {
	void insert(Task t);
	Task pullHighest();
	boolean contains(Task t);
	int size();
	boolean isEmpty();
	Task peekHighest();
}
