package jr222wb_assign4.binheap;

public class WorkTask implements Task {
	private int priority;
	private String description;
	
	public WorkTask(int priority, String description) {
		this.priority = priority;
		this.description = description;
	}
	
	public void setPriority(int p) {
		priority = p;		
	}

	public int getPriority() {
		return priority;
	}

	public void setDescription(String d) {
		description = d;
	}

	public String getDescription() {
		return description;
	}

	public int compareTo(Task t) { //Compare priorities
		return priority - t.getPriority();		
	}

	public boolean equals(Task t) { //Only check if descriptions match
		return description == t.getDescription();
	}
}
