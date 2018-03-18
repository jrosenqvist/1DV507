package jr222wb_assign4.binheap;

public class WorkMain {	
	public static void main(String[] args) {
		PriorityQueue pq = new BinaryHeapQueue(); //Construct empty queue
		for (int i = 0; i < 20; i++) {	//Add 20 tasks with growing priority			
			pq.insert(new WorkTask(i, "Work task " + (i + 1)));
		}
		for (int i = 0; i < 5; i++) //Tasks are returned by highest priority
			System.out.println(pq.pullHighest().getDescription());

		//Construct a queue with existing tasks
		Task[] tasks = new Task[10];
		for (int i = 0; i < 10; i++)
			tasks[i] = new WorkTask(i, "Work task " + (i + 1));
		PriorityQueue pq2 = new BinaryHeapQueue(tasks);
		for (int i = 0; i < 5; i++) //Tasks are returned by highest priority
			System.out.println(pq2.pullHighest().getDescription());

		//See if contains method works
		System.out.println(pq2.contains(tasks[1])); //Hasn't been pulled, should return true
		System.out.println(pq2.contains(tasks[8])); //Has been pulled, should return false

		//Size
		System.out.println(pq2.size()); //Expecting 5
		//Peek
		System.out.println(pq2.peekHighest().getDescription());

		//Empty
		System.out.println(pq2.isEmpty()); //Expecting false
		try {
			for (int i = 0; i < 6; i++) //Pulling too many tasks
				pq2.pullHighest();
		} catch (Exception e) {
			System.out.println(e);
		}
		System.out.println(pq2.isEmpty()); //Expecting true
	}
}
