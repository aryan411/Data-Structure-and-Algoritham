package exercise1;

public class LinkListNode {
	public int data;
	public LinkListNode next;
	
	public LinkListNode(int data, LinkListNode next) {
		this.data = data;
		this.next = next;
	}
	
	public String toString() {
		return(Integer.toString(data));
	}
}
