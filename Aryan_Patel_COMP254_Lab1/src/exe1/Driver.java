package exe1;


public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SinglyLinkList<Integer> L = new SinglyLinkList<>();
		L.addLast(1);
		L.addLast(2);
		L.addLast(3);
		L.addLast(4);
		L.addLast(5);
		L.addLast(6);
		System.out.println("L:- " + L.toString());
		L.swapNode(2, 3);
		System.out.println("L:- " + L.toString());
	}

}
