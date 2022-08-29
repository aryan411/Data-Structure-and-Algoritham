package exercise1;

public class Product {

	public static void main(String[] args) {
		System.out.println("5 * 4 = "+multiply(5,4));
	}
	
	static int multiply(int n1,int n2) {
		if(n2 == 1)
			return n1;
		else
			return n1+multiply(n1,n2-1);
	}

}
