package math;

public class Pow {

	private static int counter = 0;
	
	private double powDealer(double x, int n){
	
		counter++;
		if(n==0) return 1;
		if(n==1) return x;
		
/** bad recursive
		double mid = powDealer(x, n/2);
		if(n%2==0){
			return mid*mid;
		}else{
			return mid*mid*x;
		}			
**/
		
		if(n%2==0){
			return powDealer(x, n/2)*powDealer(x, n/2);
		}else{
			return powDealer(x, n/2)*powDealer(x, n/2)*x;
		}	
		
	}
	
	public double myPow(double x, int n){
		
		if(x==0.0) return 0.0d;
		if(n==0) return 1;
		
		if(n>0){
			return powDealer(x, n);
		}else{
			return 1.0d/powDealer(x, n);
		}
		
	}
	
	public static void main(String[] args) {
		
		Pow p = new Pow();
		double x = 2.0d;
		int n = 4;
		System.out.println("Ans: " + p.myPow(x, n));
		System.out.println("Timer: " + counter);
		
	}

}
