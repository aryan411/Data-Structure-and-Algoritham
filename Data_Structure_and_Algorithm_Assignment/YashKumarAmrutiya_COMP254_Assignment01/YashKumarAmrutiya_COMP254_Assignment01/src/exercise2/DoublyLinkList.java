package exercise2;

public class DoublyLinkList {
public DoublyLinkListNode head;
	
	public DoublyLinkList() {
		head = null;
	}
	
	public void addAtFront(int data) {
		DoublyLinkListNode node = new DoublyLinkListNode(data);
		if(head == null) {
			head = node;
			return;
		}
		node.next = head;
		head.previous = node;
		head = node;
	}
	
	public DoublyLinkList addList(DoublyLinkList list) {
		DoublyLinkList newList = new DoublyLinkList();
		newList = this;
		DoublyLinkListNode current = newList.head;
		while(current.next != null) {
			current = current.next;
		}
		current.next = list.head;
		list.head.previous = current;
		return newList;
	}
	
	public void Display() {
		DoublyLinkListNode current = head;
		while(current.next != null) {
			System.out.print(current.data + " ");
			current = current.next;
		}
		System.out.print(current.data+"\n");
		
	}

}
