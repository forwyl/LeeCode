package array;

public class MaximumSubarray53 {

    public int maxSubArray(int[] A) {
    	
    	int max, max_here;
    	max = max_here = A[0];
    	for(int i=1; i<A.length; i++){
    		max_here = Math.max(A[i], max_here + A[i]);
    		max = Math.max(max, max_here);
    	}
    	
    	return max;
    }
    
	public static void main(String[] args) {
		
		int[] A = { -2, 1, -3, 4, -1, 2, 1, -5, 4};
		MaximumSubarray53 ms = new MaximumSubarray53();
		System.out.println("max sum is :" + ms.maxSubArray(A));
		
	}

}
