package array;

public class BuySellStock121 {

    public int maxProfit(int[] prices) {
        
    	if(prices.length <= 1){
    		return 0;
        }
        
    	int profit = 0;
    	int buyPrice = prices[0];
    	
    	for(int i=1; i<prices.length; i++){
    		if(prices[i] - buyPrice > profit){
    			profit = prices[i] - buyPrice;
    		}else if( prices[i] < buyPrice){
    			buyPrice = prices[i];   			
    		}
    	}
    	
        return profit;
    	
    }
    
	public static void main(String[] args) {
		
		BuySellStock121 bss = new BuySellStock121();
		int[] prices1 = {1,2};
		System.out.println("Best Day is:" + bss.maxProfit(prices1) + " (expected value:1)");	
		int[] prices2 = {2,1};
		System.out.println("Best Day is:" + bss.maxProfit(prices2) + " (expected value:0)");			
		int[] prices3 = {3,3};
		System.out.println("Best Day is:" + bss.maxProfit(prices3) + " (expected value:0)");
		int[] prices4 = {1,2,4};
		System.out.println("Best Day is:" + bss.maxProfit(prices4) + " (expected value:3)");
		int[] prices5 = {6,1,3,2,4,7};
		System.out.println("Best Day is:" + bss.maxProfit(prices5) + " (expected value:6)");
		
	}

}
