package Exercise2;

public class Palindrome {
	public Boolean isPalindrome(String a)
	{
		int size = a.length();
		if(a.length() == 1)
			return true;
		else if(a.length() == 2)
		{
			if(a.charAt(0) == a.charAt(size-1))
			{
				return true;
			}
			else
			{
				return false;
			}
			
		}
		else
		{
			if(a.charAt(0) == a.charAt(size-1))
			{
				return isPalindrome(a.substring(1, size-1));
			}
			else
			{
				return false;
			}
			
		}
		
	}
}
