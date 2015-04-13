package dp;

public class LongestCommonSubstring {

	public int longestSubstr(String first, String second) {
	    if (first == null || second == null || first.length() == 0 || second.length() == 0) {
	        return 0;
	    }
	 
	    int maxLen = 0;
	    int fl = first.length();
	    int sl = second.length();
	    int[][] table = new int[fl+1][sl+1];
	 
	    for(int s=0; s <= sl; s++)
	      table[0][s] = 0;
	    for(int f=0; f <= fl; f++)
	      table[f][0] = 0;
	    
	    for (int i = 1; i <= fl; i++) {
	        for (int j = 1; j <= sl; j++) {
	            if (first.charAt(i-1) == second.charAt(j-1)) {
	                if (i == 1 || j == 1) {
	                    table[i][j] = 1;
	                }
	                else {
	                    table[i][j] = table[i - 1][j - 1] + 1;
	                }
	                if (table[i][j] > maxLen) {
	                    maxLen = table[i][j];
	                }
	            }
	        }
	    }
	    return maxLen;
	}
	
	public int lcstrLen(String s1, String s2){
		
		int s1Len = s1.length();
		int s2Len = s2.length();
		int maxLen = 0;
		int table [][] = new int[s1Len+1][s2Len+1];
		StringBuffer buf = new StringBuffer();
		for(int i=0; i<s1Len+1; i++){
			table[i][0] = 0;
		}
		for(int i=0; i<s2Len+1; i++){
			table[0][i] = 0;
		}
		
		for(int i=1; i<s1Len+1; i++){
			for(int j=1; j<s2Len+1; j++){
				if(s1.charAt(i-1) == s2.charAt(j-1)){
					table[i][j] = table[i-1][j-1] + 1;
					if(table[i][j] > maxLen)
						maxLen = table[i][j];
				}

			}
		}
		
		return table[s1Len][s2Len];
	}
	
	public static void main(String[] args) {
		
		LongestCommonSubstring lcstr = new LongestCommonSubstring();
		System.out.println("" + lcstr.lcstrLen("aabbccc", "aabbbccc"));
		System.out.println("" + lcstr.longestSubstr("aabbccc", "aabbbccc"));
		
	}

}
