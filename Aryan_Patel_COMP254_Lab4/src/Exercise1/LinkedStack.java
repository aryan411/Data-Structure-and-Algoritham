package Exercise1;

public class LinkedStack<E> implements Stack<E>  {

	private SingliLinkList<E> list  = new SingliLinkList<>();
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
	public E top() {
		// TODO Auto-generated method stub
		return list.first();
	}

	@Override
	public void push(E element) {
		// TODO Auto-generated method stub
		list.addFirst(element);;
		
	}

	@Override
	public E pop() {
		// TODO Auto-generated method stub
		return list.removeFirst();
	}
	
	public static <E> void transfer(LinkedStack<E> source, LinkedStack<E> target)
	{
		while(!source.isEmpty()) {
			target.push(source.pop());
		};	
	}
	public String toSting()
	{
		return list.toString();
	}
}
