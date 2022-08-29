package Exercise2;



public class SinglyLinkList<E> {
	private static class Node<E>{
		private E value;
		private Node<E> next;
		public Node(E v,Node<E> n) {
			value = v;
			next = n;
		}
		public E getValue() {return value;}
		public Node<E> getNext() {return next;}
		public void setNext(Node<E> n) {next = n;}
	}
	public Node<E> head = null;
	public Node<E> tail = null;
	private int size = 0;
	public SinglyLinkList() {}
	public int size() { return size;}
	public boolean isEmpty() { return size == 0;}
	public E first() {
		if(isEmpty()) return null;
		return head.getValue();
	}
	public E last() {
		if(isEmpty()) return null;
		return tail.getValue();
	}
	public void addFirst(E e)
	{
		head = new Node<E>(e, head);
		if(size == 0)
			tail = head;
		size++;
	}
	public void addLast(E e)
	{
		Node<E> newest = new Node<>(e,null);
		if(isEmpty())
			head = newest;
		else
		    tail.setNext(newest);
		tail = newest;
		size++;
	}
	public E removeFirst()
	{
		E rValue;
		if(isEmpty())
		{
			return null;
		}
	    else if(size == 1)
		{
	    	rValue = head.getValue();
			head = null;
			tail = null;
			size--;
			return rValue;
		}
		else 
		{
			rValue = head.getValue();
			head = head.getNext();
			size--;
			return rValue;
		}
	}
	// optional
	public E removeLast()
	{
		E rValue;
		if(size == 0)
		{
			return null;
		}
	    else if(size == 1)
		{
	    	rValue = head.getValue();
			head = null;
			tail = null;
			size--;
			return rValue;
		}
		else 
		{
			Node<E> newLast = null;
			newLast = head.getNext();
			while(newLast.getNext() != tail);
			{
				newLast = newLast.getNext();
			}
			rValue = tail.getValue();
			tail = newLast;
			size--;
			return rValue;
			
		}
	}
	
	public void swapNode(E a, E b) 
	{
		if(a == b || isEmpty() || size == 1) return;
		//Node<E> tempNode = new Node<>(null,null);
		Node<E> A = null;
		Node<E> B = null;
		Node<E> preA = preNode(a, head);
		Node<E> preB = preNode(b, head);
		A = preA.getNext();
		B = preB.getNext();
		
		if(A != null && B !=null)
		{
			if(preA != null)
				preA.setNext(B);
			
			if(preB != null)
				preB.setNext(A);
			Node<E> temp = A.getNext();
			A.setNext(B.getNext());
			B.setNext(temp);
		}
		
		else
		{
			System.out.println("Swapping is not possible");
		}
	}
	public Node<E> preNode(E value1, Node<E> start){
		if(start.getValue() == value1) return start;
		while(start.getNext().getValue()!= value1)
		{
			start =  start.getNext();
		}
		return start;
	}
	public String toString()
	{
		String list = "";
		Node<E> dNode = head;
		if(head == null || head.getValue() == "")
		{
			return null;
		}
			
		while(dNode.getNext() != null)
		{
			list = list + dNode.getValue().toString() + ", ";
			dNode = dNode.getNext();
		}
		list += dNode.getValue().toString();
		return list;
	}
}
