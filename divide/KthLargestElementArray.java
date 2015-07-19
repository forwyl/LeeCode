package divide;

public class KthLargestElementArray {
	
	private int partition(int[] nums, int start, int end){
		
		int index = start;
		int tmp = nums[index];
		nums[index] = nums[end];
		nums[end] = tmp;
		
		for(int i=start; i<end; i++){
			if(nums[i] >= nums[end] ){
				tmp = nums[index];
				nums[index] = nums[i];
				nums[i] = tmp;
				index++;
				if(index == end) break;
			}
		}
		tmp = nums[index];
		nums[index] = nums[end];
		nums[end] = tmp;

		return index;
	}
	
    public int findKthLargest(int[] nums, int k) {
        
    	if(nums.length == 1)
    		return nums[0];
    	
    	int start = 0;
    	int end = nums.length -1;
    	int index = partition(nums, start, end);
    	
    	while(index != k -1){
        	if(index > k -1){
        		end = index-1;
        	}else if(index < k -1){
        		start = index+1;
        	}
    		index = partition(nums, start, end);
    	}
    	
    	return nums[index];
    }
	
	public static void main(String[] args) {
		
		KthLargestElementArray klea = new KthLargestElementArray();
		int[] nums = {3,2,1,5,6,4}; //{3,2,1,5,6,4}, {16, 52, 28, 9, 7}, 
		int k = 3;
		System.out.printf("%dth largest num is %d\n", k, klea.findKthLargest(nums, k));

	}

}
