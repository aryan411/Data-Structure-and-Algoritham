package Exercise1;

public class Driver {

	public static void main(String[] arg)
	{
		// source Linklist stack
		LinkedStack<Integer> S = new LinkedStack<>();
		S.push(1);
		S.push(2);
		S.push(3);
		S.push(4);
		S.push(5);
		System.out.println("Source stack:  "+ S.toSting());
		// target LinkList stack
		LinkedStack<Integer> T = new LinkedStack<>();
		System.out.println("Target stack:  "+ T.toSting());
		LinkedStack.transfer(S, T);
		System.out.println("After Transfer:  ");
		System.out.println("Source stack:  "+ S.toSting());
		System.out.println("Target stack:  "+ T.toSting());
		
	}
}
