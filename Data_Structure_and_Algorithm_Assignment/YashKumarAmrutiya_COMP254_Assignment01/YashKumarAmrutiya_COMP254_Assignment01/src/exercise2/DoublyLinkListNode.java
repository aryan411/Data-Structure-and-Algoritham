package exercise2;

public class DoublyLinkListNode {
	public int data;
	public DoublyLinkListNode next;
	public DoublyLinkListNode previous;
	
	public DoublyLinkListNode(int data) {
		this.data=data;
		next = null;
		previous = null;
	}
	
	public String toString() {
		return("Node is: "+Integer.toString(data));
	}
}
