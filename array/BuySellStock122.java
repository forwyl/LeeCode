package array;

public class BuySellStock122 {

    public int maxProfit(int[] prices) {
        
    	int total = 0;
        for(int i=0; i<prices.length-1; i++){
        	if(prices[i] < prices[i+1]){
        		total +=  prices[i+1] -  prices[i];
        	}
        }
        
        return total;
    }
    
	public static void main(String[] args) {
		
		BuySellStock122 bss = new BuySellStock122();
		int A[] = {6, 1, 3, 2, 4, 7};
		System.out.println( "max profit is: " + bss.maxProfit(A));

	}

}
