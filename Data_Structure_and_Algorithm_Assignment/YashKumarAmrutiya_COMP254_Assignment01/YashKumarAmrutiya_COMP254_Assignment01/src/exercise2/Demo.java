package exercise2;

public class Demo {
public static void main(String[] args) {
		
		System.out.print("List 1: ");
		DoublyLinkList list1 = new DoublyLinkList();
		list1.addAtFront(21);
		list1.addAtFront(34);
		list1.addAtFront(2);
		list1.Display();
		
		System.out.print("\nList 2: ");
		DoublyLinkList list2 = new DoublyLinkList();
		list2.addAtFront(55);
		list2.addAtFront(12);
		list2.addAtFront(40);
		list2.Display();
		
		System.out.println("\nAfter adding list2 to list1");
		System.out.print("\nNew List: ");
		DoublyLinkList newList = list2.addList(list1);
		newList.Display();
	}
}
