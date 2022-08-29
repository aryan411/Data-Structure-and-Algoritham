package exe2;

public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DoublyLinkList<Integer> L = new DoublyLinkList<>();
		DoublyLinkList<Integer> M = new DoublyLinkList<>();
		L.addLast(1);
		L.addLast(2);
		L.addLast(3);
		System.out.println("L:- " + L.toString());
		M.addFirst(6);
		M.addFirst(5);
		M.addFirst(4);
		System.out.println("M:- "+ M.toString());		
		System.out.println("After concate");
		L = L.concate(M);
		System.out.println("L:- "+ L.toString());
		
	}
}
