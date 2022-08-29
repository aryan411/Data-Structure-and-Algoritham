package Exercise2;

public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedQueue<Integer> S = new LinkedQueue<>();
		LinkedQueue<Integer> T = new LinkedQueue<>();
		T.enqueue(1);
		T.enqueue(2);
		T.enqueue(3);
		T.enqueue(4);
		T.enqueue(5);
		S.enqueue(6);
		S.enqueue(7);
		S.enqueue(8);
		S.enqueue(9);
		S.enqueue(10);
		System.out.println("Queue source:  " +  S.toString());
		System.out.println("Queue target:  " +  T.toString());
		LinkedQueue.concate(S, T);
		System.out.println("After concating two queues");
		System.out.println("Queue source:  " +  S.toString());
		System.out.println("Queue target:  " +  T.toString());
	}

}
