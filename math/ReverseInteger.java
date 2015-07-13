package math;

public class ReverseInteger {

    public int reverse(int x) {
        
    	if(x<=9 && x>=-9 ) return x;
    	
    	/* divide zero tail*/
    	while(x%10==0) x = x/10;
    	if(x<=9 && x>=-9 ) return x;
    	int newNum = 0;
    	int tmp = 0;
    	int quo = 0;
    	int remain = 0;
    	do{
    		quo = x/10; 
    		remain = x%10;
    		/* check overflow or underflow using XOR or this solution*/
    		tmp = newNum*10 + remain;
    		if((tmp-remain)/10 != newNum)
    			return 0;
    		newNum = tmp;
//    		System.out.printf("newNum:%d, quo:%d, remain:%d \n", newNum, quo, remain);
    		x = quo;
    	}while(quo != 0);
    	
    	return newNum;
    }
    
	public static void main(String[] args) {

		/* Test cases: 1534236469, -2147483412, -1000000003, 1000000003, 2000, -100, -4, 99, 782*/
		int[] testAry = {1534236469, -2147483412, -1000000003, 1000000003, 2000, -100, -4, 99, 782};
		ReverseInteger ri = new ReverseInteger();
		for(int i: testAry){
			int result = ri.reverse(i);
			System.out.printf("result: %d\n", result);			
		}

	}

}
