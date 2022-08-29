package Exercise1;

public class ArithmaticOperations {
	int ans = 0;

	public int multiplicatinUAddSub(int m, int n)
	{
		if(n>0)
		{
			ans =  m + multiplicatinUAddSub(m, n-1);
		}
		return ans;
	}
}
