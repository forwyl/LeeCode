package string;

public class LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {
        
    	if(strs.length == 0)
    		return "";
    	char[] ary = strs[0].toCharArray();
    	int i=0;
    	outerloop:for(i=0;  i<ary.length; i++){
    		innerloop:for(int j=1;  j<strs.length; j++){
        		if(i>strs[j].length()-1 || ary[i] != strs[j].charAt(i)){
//        			System.out.printf("%c, %c \n", ary[i], strs[j].charAt(i));
        			break outerloop;
        		}    			
    		}
    	}
    	
    	if(i==0){
    		return "";
    	}else{
    		return strs[0].substring(0, i);
    	}
    	
    }
    
	public static void main(String[] args) {

		LongestCommonPrefix lcp = new LongestCommonPrefix();
		String[] ary = {"aa","a"}; //{"aba", "abce", "abcfg"}, {"aa","a"}
		System.out.printf("Result: %s\n", lcp.longestCommonPrefix(ary));

	}

}
