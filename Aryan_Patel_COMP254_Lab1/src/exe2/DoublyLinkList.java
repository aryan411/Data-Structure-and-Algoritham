package exe2;

public class DoublyLinkList<E> {
	private static class Node<E> {
		private E value;
		private Node<E> pre;
		private Node<E> next;
		public Node(Node<E> p, E v, Node<E> n)
		{
			pre = p;
			value = v;
			next = n;
		}
		public E getValue(){return value;}
		
		public Node<E> getNext(){return next;}
		public Node<E> getPre(){return pre;}
		
		public void setNext(Node<E> n){next = n;}
		public void setPre(Node<E> p){pre = p;}
	}
	
	public Node<E> head = new Node<>(null,null,null);
	public Node<E> tail = new Node<>(head,null,null);
	private int size = 0;
	public int size() { return size;}
	public boolean isEmpty() { return size == 0;}
	public E getFirst() {
		if(isEmpty()) return null;
		return head.getNext().getValue();
	}
	public E getLast() {
		if(isEmpty()) return null;
		return tail.getPre().getValue();
	}
	public void addFirst(E e)
	{
		if(isEmpty()) 
		{
			addBetween(head, e, tail);
		}
		else
		{
			addBetween(head, e, head.getNext());
		}
		
	}
	public void addLast(E e)
	{
		addBetween(tail.getPre(), e, tail);
	}
	public E removeFirst()
	{
		if(isEmpty()) return null;
		return remove(head.getNext());
	}
	public E removeLast()
	{
		if(isEmpty()) return null;
		return remove(tail.getPre());
	}
	private void addBetween(Node<E> a, E b, Node<E> c)
	{
		Node<E> newest = new Node<>(a, b, c);
		a.setNext(newest);
		c.setPre(newest);
		size++;
	}
	private E remove(Node<E> node)
	{
		Node<E> p = node.getPre();
		Node<E> n = node.getNext();
		n.setPre(p);
		p.setNext(n);
		size--;
		return node.getValue();
	}
	public DoublyLinkList<E> concate(DoublyLinkList<E> b)
	{
		Node<E> lastOfa = tail.getPre();
		Node<E> firstOfb = b.head.getNext();
		lastOfa.setNext(firstOfb);
		firstOfb.setPre(lastOfa);
		tail.setPre(b.tail.getPre());
		return this;
	}
	public String toString()
	{
		String list = "";
		Node<E> dNode = head.getNext();
		while(dNode.getNext() != null)
		{
			list = list + dNode.getValue().toString() + ", ";
			dNode = dNode.getNext();
		}
		return list;
	}
}
