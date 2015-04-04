package algo;

public class LongestPalindromicSubstring {

    public String longestPalindrome(String s) {
    	
        int size = s.length();
    	boolean table[][] = new boolean[size][size];
    	String lps = "";
    	int maxLen = 0;
    	
    	for(int i=0; i<size; i++)
    		table[i][i] = true;
    	
    	for(int i=0; i<size-1; i++){
    		if(s.charAt(i)==s.charAt(i+1)){
    			table[i][i+1] = true;
    			maxLen = 2;
    			lps = s.substring(i, i+2);
    		}
    	}
    	
    	for(int k=3; k<=size; k++){
    		for(int i=0; i <size-k+1; i++){
    			int j = i+k-1;
    			if(s.charAt(i) == s.charAt(j) && table[i+1][j-1]){
    				table[i][j] = true;
    				if(k > maxLen){
    					maxLen = k;
    					lps = s.substring(i, j+1);
    				}
    				
    				
    			}else{
    				table[i][j] = false;
    			}
    		}
    	}
    
    	return lps;
    }
    
	public static void main(String[] args) {
		
		String s = "aasba";
		LongestPalindromicSubstring lps = new LongestPalindromicSubstring();
		System.out.println("Longest palindromic substring of  ' " + s + " ' is:" + lps.longestPalindrome(s));
		
	}

}
