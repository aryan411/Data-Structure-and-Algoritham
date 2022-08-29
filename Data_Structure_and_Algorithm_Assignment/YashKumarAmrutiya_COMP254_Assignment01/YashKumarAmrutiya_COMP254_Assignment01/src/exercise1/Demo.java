package exercise1;

public class Demo {
public static void main(String[] args) {
		
		// Single List
		System.out.println("Single Link List:\n");
		LinkedList list = new LinkedList();
		list.append(24);
		list.append(21);
		list.prepend(1);
		list.append(45);
		list.append(55);
		list.append(5);
		list.append(47);
		list.Display();
		System.out.println("\nAfter swaping 24 with 55\n");
		list.swap(24, 55);
		list.Display();
		
		
	}
}
