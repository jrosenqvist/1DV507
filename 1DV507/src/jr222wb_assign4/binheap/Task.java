package jr222wb_assign4.binheap;

public interface Task extends Comparable<Task> {	
	void setPriority(int p);
	int getPriority();
	void setDescription(String d);
	String getDescription();
	int compareTo(Task t);
	boolean equals(Task t);
}
