package exercise2;

public class Demo {
	
	public static void main(String[] args) {
		System.out.println("racecar is "+(palindrome("racecar")?"palindrome":"not palindrome"));
		System.out.println("gohangasalamiimalasagnahog is "+(palindrome("gohangasalamiimalasagnahog")?"palindrome":"not palindrome"));
		System.out.println("Yash is "+(palindrome("Yash")?"palindrome":"not palindrome"));
	}
	
	public static boolean palindrome(String s) {
		if(s.length() <= 1) {
			return true;
		}
		if(s.charAt(0)==s.charAt(s.length()-1)) {
			return palindrome(s.substring(1,s.length()-1));
		}
		return false;
	}
}
