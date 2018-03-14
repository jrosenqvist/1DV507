package jr222wb_assign4.generic;

import java.util.Iterator;

public class QueueMain {
	public static void main(String[] args) {
		Queue<String> q = new LinkedQueue<>();
		q.enqueue("Apa");
		q.enqueue("Ninja");
		Iterator<String> qi = q.iterator();
		while (qi.hasNext())
			System.out.println(qi.next());

		Queue<Integer> q2 = new LinkedQueue<>();
		q2.enqueue(1);
		q2.enqueue(2);
		Iterator<Integer> qi2 = q2.iterator();
		while (qi2.hasNext())
			System.out.println(qi2.next());

		//System.out.println(q.dequeue() + " " + q.dequeue() + " " + q.dequeue());
	}
}
