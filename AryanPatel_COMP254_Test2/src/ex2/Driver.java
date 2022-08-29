package ex2;

public class Driver {
	public static void main(String arg[])
	{
		UnsortedTableMap<Integer, String> map = new UnsortedTableMap<>();
		// simple put method 
		map.put(1, "one");
		map.put(2, "two");
		map.put(3, "three");
		map.put(4, "four");
		map.put(5, "five");
		
		System.out.println("add 3 as key and 'four' as value if key is exist then it will return corrosponding value\n"+map.putOnlyIfAbsent(3, "four"));
		
		System.out.println("add 6 as key and 'six' as value if key is exist then it will return corrosponding value\n"+map.putOnlyIfAbsent(6, "six"));
		
	}

}
