package array;

public class MinRotatedSortedArray153 {

    public int findMin(int[] num) {
        
    	if(num.length==1){
        	return num[0];
        }
        
    	if(num[0] > num[1]){
    		return num[1];
    	}else{
    		int min = num[0];
    		for(int i=num.length-1; i>1; i--){
    			if(num[i] < min){
    				min = num[i];
    			}else{
    				break;
    			}
    		}
    		return min;
    	}
        
    }
    
	public static void main(String[] args) {
		
		int[] num1 = {0, 1, 2, 4, 5, 6, 7};
		int[] num2 = {4, 5, 6, 7, 0, 1, 2};
		MinRotatedSortedArray153 msa = new MinRotatedSortedArray153();
		System.out.println("min value is:" + msa.findMin(num1) + " (should be: 0)");
		System.out.println("min value is:" + msa.findMin(num2) + " (should be: 0)");
	}

}
