package array;
/**
 * Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be 
 * if it were inserted in order.You may assume no duplicates in the array.
 */
public class SearchInsertPosition35 {

	public int searchInsert(int[] A, int target) {

		for(int i=0; i<A.length; i++){
			if(target <= A[i]){
				return i;
			}
		}
		
		return A.length;
	
	}
	public static void main(String[] args) {
		
		SearchInsertPosition35 sip = new SearchInsertPosition35();
		int[] A = {1,3,5,6};
		System.out.println("position should be:"+ sip.searchInsert(A, 5)+ " (expect:2)");
		System.out.println("position should be:"+ sip.searchInsert(A, 2)+ " (expect:1)");
		System.out.println("position should be:"+ sip.searchInsert(A, 7)+ " (expect:4)");
		System.out.println("position should be:"+ sip.searchInsert(A, 0)+ " (expect:0)");
		
	}

}
