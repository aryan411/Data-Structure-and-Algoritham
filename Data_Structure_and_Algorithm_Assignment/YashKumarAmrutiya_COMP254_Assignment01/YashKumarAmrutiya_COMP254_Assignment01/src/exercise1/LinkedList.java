package exercise1;

public class LinkedList {
	LinkListNode head;
	int size;
	
	public LinkedList() {
		head = null;
		size = 0;
	}
	
	public void append(int data) {
		if(head == null) {
			head = new LinkListNode(data,null);
			size++;
			return;
		}
		LinkListNode current = head;
		while(current.next != null) {
			current = current.next;
		}
		current.next = new LinkListNode(data,null);
		size++;
	}
	
	public void prepend(int data) {
		LinkListNode newNode = new LinkListNode(data,null); 
		if(head == null) {
			head = newNode;
			size++;
			return;
		}
		newNode.next = head;
		head = newNode;
		size++;
	}
	
	public void delete(int data) {
		if(head == null) {
			return;
		}
		if(head.data == data) {
			head = head.next;
			size--;
			return;
		}
		LinkListNode current = head;
		while(current.next != null) {
			if(current.next.data == data) {
				current.next = current.next.next;
				size--;
				return;
			}
			current = current.next;
		}
	}
	
	public void swap(int n1, int n2) {
		LinkListNode node1 = null;
		LinkListNode node2 = null;
		LinkListNode node1Prev = null;
		LinkListNode node2Prev = null;
		
		LinkListNode current = head;
		while(current.next != null) {
			if(current.data == n1) {
				node1 = current;
			}
			if(current.data == n2) {
				node2 = current;
			}
			if(current.next.data == n1) {
				node1Prev = current;
			}
			if(current.next.data == n2) {
				node2Prev = current;
			}
			current = current.next;
		}
		if(node1 == null || node2 == null) {
			System.out.println("Node not found");
			return;
		}
		
		if(node1Prev == null) {
			head = node2;
		}else {
			node1Prev.next = node2;
		}
		
		if(node2Prev == null) {
			head = node1;
		}else {
			node2Prev.next = node1;
		}
		LinkListNode temp = node1.next;
		node1.next = node2.next;
		node2.next = temp;
		
	}
	
	public void Display() {
		LinkListNode current = head;
		while(current.next != null) {
			System.out.print(current.data + " ");
			current = current.next;
		}
		System.out.print(current.data+"\n");
		
	}
}
