package string;

public class StringToInteger {

	/* ref */
	public int atoi(String str) {
	    if(str==null)
	    {
	        return 0;
	    }
	    str = str.trim();
	    if(str.length()==0)
	        return 0;
	    boolean isNeg = false;
	    int i = 0;
	    if(str.charAt(0)=='-' || str.charAt(0)=='+')
	    {
	        i++;
	        if(str.charAt(0)=='-')
	            isNeg = true;
	    }
	    int res = 0;
	    while(i<str.length())
	    {
	        if(str.charAt(i)<'0'||str.charAt(i)>'9')
	            break;
	        int digit = (int)(str.charAt(i)-'0');
	        if(isNeg && res>-((Integer.MIN_VALUE+digit)/10))
	            return Integer.MIN_VALUE;
	        else if(!isNeg && res>(Integer.MAX_VALUE-digit)/10)
	            return Integer.MAX_VALUE;
	        res = res*10+digit;
	        i++;
	    }
	    return isNeg?-res:res;
	}
	
    public int myAtoi(String str) {
    	
    	str =str.trim();
    	if(str.length()==0) 
    		return 0;
    	int i = 0;
    	int result = 0;
    	boolean isNeg = false;
    	if(str.charAt(i)== '-' | str.charAt(i)== '+'){
    		if( str.charAt(i)== '-')
    			isNeg = true;
    		i++;
    	}
    	
    	while(i<str.length()){
    		if((int)str.charAt(i) < (int)'0' | (int)str.charAt(i) > (int)'9')
    			break;
    		int digit = (int)str.charAt(i) - (int)'0';
    		/*check overflow and underflow*/
    		if(isNeg){
    			if(-result < (Integer.MIN_VALUE+digit)/10)
    				return Integer.MIN_VALUE;
    		}else{
    			if(result > (Integer.MAX_VALUE-digit)/10)
    				return Integer.MAX_VALUE;
    		}
    		result = result*10+digit;
    		i++;
    	}

    	return isNeg?-result:result;
    }
    
	public static void main(String[] args) {
		
		/* Test cases: "", "", */
		StringToInteger sti = new StringToInteger();
		String str = "2147483648";
		System.out.printf("%d\n", sti.myAtoi(str));
		
	}

}
