package exercise01;

public class Demo {

	public static void main(String[] args) {
		
		System.out.print("Queue 1: ");
		LinkedQueue q1 = new LinkedQueue();
		q1.enQueue(12);
		q1.enQueue(23);
		q1.enQueue(4);
		q1.enQueue(6);
		q1.printQueue();
		
		System.out.print("\nQueue 2: ");
		LinkedQueue q2 = new LinkedQueue();
		q2.enQueue(5);
		q2.enQueue(1);
		q2.enQueue(41);
		q2.enQueue(20);
		q2.printQueue();
		
		System.out.print("\nConcatenate: ");
		q1.concatenate(q2);
		q1.printQueue();
	}

}
