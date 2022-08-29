package exercise02;

public class Demo {
	public static void main(String args[]) {
		System.out.print("Stack 1: ");
		Stack s1 = new Stack(10);
		s1.push(31);
		s1.push(26);
		s1.push(43);
		s1.display();
		
		System.out.print("\nStack 2: ");
		Stack s2 = new Stack(10);
		s2.push(12);
		s2.push(20);
		s2.push(37);
		s2.push(51);
		s2.display();
		
		System.out.print("\nAfter Transfer from stack1 to stack2: ");
		transfer(s1,s2);
		s2.display();
		

	}

	public static void transfer(Stack s, Stack t) {
		while (s.top >= 0) {
			t.push(s.pop());
		}
	}

}
