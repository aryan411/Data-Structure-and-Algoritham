package exercise01;

public class LinkedQueue<T> {
	
	LinkListNode head;
	LinkListNode tail;
	
	public LinkedQueue() {
		head = null;
		tail = null;
	}
	
	public void enQueue(T num) {
		
		LinkListNode node = new LinkListNode(num);
		if (this.head == null) {
			this.head = node;
			this.tail = node;
		}else {
			this.tail.next = node;
			this.tail = node;
		}
		
	}
	
	public void deQueue() {
		if(this.head == null) {
			this.tail = null;
		}
		else {
			this.head = this.head.next;
		}
	}
	
	public void concatenate(LinkedQueue<T> queue) {
		if(this.head == null) {
			this.head = queue.head;
		}else {
			this.tail.next = queue.head;
			this.tail = queue.tail;
		}
	}
	
	public void printQueue() {
		LinkListNode current = head;
		while (current != null) {
			System.out.print(current.data+" ");
			current = current.next;
		}
		System.out.println();
	}
	
	
}
