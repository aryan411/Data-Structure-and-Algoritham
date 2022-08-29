import java.util.Random;

public class Demo {
	
	
	public static void main(String[] args) {
		double[] a = new double[100000];
		for(int i=0;i< a.length;i++) {
			a[i] = Math.random();
		}
		System.out.println("prefixAverage1----\n");
		double[] newArry = prefixAverage1(a);
		System.out.println("\nprefixAverage2----\n");
		double[] newArry1 = prefixAverage2(a);
	}
	
	public static double[] prefixAverage1(double[] x){
		long startTime1 = System.currentTimeMillis();
		int n = x.length;
		double[] a = new double[n];
		for(int j=0; j<n; j++){
			double total = 0;
			for(int i=0; i<= j; i++)
				total += x[i];
			a[j] = total/(j+1);
		}
		long endTime1 = System.currentTimeMillis();
		long elapsed1 = endTime1-startTime1;
		System.out.println("endTime:- "+endTime1);
		System.out.println("startTime:- "+startTime1);
		System.out.println("elapsed:- "+elapsed1);
		return a;
	}
	
	public static double[] prefixAverage2(double[] x){
		long startTime = System.currentTimeMillis();
		int n = x.length;
		double[ ] a =new double[n];
		// filled with zeros by default
		double total = 0;
		// compute prefix sum as x[0] + x[1] + ...
		for(int j=0; j<n; j++){
			total += x[j];
			// update prefix sum to include x[j]
			a[j] = total/(j+1);
		}
		long endTime = System.currentTimeMillis();
		long elapsed = endTime-startTime;
		System.out.println("endTime:-"+endTime);
		System.out.println("startTime:-"+startTime);
		System.out.println("elapsed:-"+elapsed);
		return a;
	}
}
