package dp;

import java.util.Scanner;

public class ClimbingStairs {
	
	public int climbStairsByRecur(int n){

		if(n<3) 
			return n;
		else
			return climbStairs(n-1)+climbStairs(n-2);
	}
	
	public int climbStairs(int n){

		if(n<3) return n;
		
		int[] mem = new int[n+1];
		for(int i=0;i<3;i++)	mem[i] = i;
		for(int i=3; i<n+1; i++)	mem[i] = mem[i-1]+mem[i-2];
		
		return mem[n];
	}
	
	public static void main(String[] args) {
		
		System.out.print("please initialize n: ");
		int n = new Scanner(System.in).nextInt();
		ClimbingStairs cs = new ClimbingStairs();
		System.out.printf("possible ways of %d stairs are: %d\n", n, cs.climbStairs(n));
//		System.out.println(cs.climbStairs(n)==cs.climbStairsByRecur(n));

	}

}
