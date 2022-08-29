package exercise02;

public class Stack {
	int top;
	int size;
	int[] stack;

	public Stack(int arraySize) {
		size = arraySize;
		stack = new int[size];
		top = -1;
	}

	boolean isEmpty() {
		return (top < 0);
	}

	public void push(int value) {
		if (top == size - 1) {
			System.out.println("Stack is full, can't push a value");
		} else {
			top = top + 1;
			stack[top] = value;
		}
	}

	public int pop() {
		if (top < 0) {
			System.out.println("stack is empty");
			return 0;
		} 
		return stack[top--];
	}

	public void display() {
		for (int i = 0; i <= top; i++) {
			System.out.print(stack[i] + " ");
		}
		System.out.println();
	}
}
