package sort;

public class QuickSelectSort {

	private int[] sort(int[] nums, int start, int end){
		if(start < end){
			int pivot = partition(nums, start, end);
			sort(nums, start, pivot-1);
			sort(nums, pivot+1, end);
		}
		return nums;
	}
	
	private int partition(int[] nums, int start, int end){
		
		int index = start;
		int tmp = nums[index];
		nums[index] = nums[end];
		nums[end] = tmp;
		
		for(int i=start; i<end; i++){
			if(nums[i] <= nums[end] ){
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

		for(int i: nums){
			System.out.printf("%d \t", i);
		}
		System.out.println("\n----");
		
		return index;
	}
	public static void main(String[] args) {

		QuickSelectSort qss = new QuickSelectSort();
		int[] nums = {4, 5, 3, 7, 2}; //{3,2,1,5,6,4}, {16, 52, 28, 9, 7}, {3,2,1,5,6,4}
		qss.partition(nums, 0, nums.length-1);
//		int[] a = qss.sort(nums, 0, nums.length-1);
//		for(int i: a){
//			System.out.printf("%d \t", i);
//		}
//		System.out.println("\n----");

	}

}
