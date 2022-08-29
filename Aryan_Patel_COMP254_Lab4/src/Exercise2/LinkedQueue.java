package Exercise2;

public class LinkedQueue<E> implements Queue<E> {

	private SinglyLinkList<E> list = new SinglyLinkList<>();
	@Override
	public int size() {
		// TODO Auto-generated method stub
		return list.size();
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return list.isEmpty();
	}

	@Override
	public E first() {
		// TODO Auto-generated method stub
		return list.first();
	}

	@Override
	public void enqueue(E element) {
		// TODO Auto-generated method stub
		list.addLast(element);
		
	}

	@Override
	public E dequeue() {
		// TODO Auto-generated method stub
		return list.removeFirst();
	}
	
	public static <E> void concate(LinkedQueue<E> source,LinkedQueue<E> target)
	{
		while(!source.isEmpty())
		{
			target.enqueue(source.dequeue());
		}
	}
	public String toString()
	{
		return list.toString();
	}

}
