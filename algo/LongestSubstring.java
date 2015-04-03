package algo;

public class LongestSubstring {

    public int lengthOfLongestSubstring(String s) {
        
    	int start = 0;
        int len = 0;
        int maxLen = 0;
        StringBuffer strBuf = new StringBuffer();
        for(int i=0; i <s.length(); i++){
        	String str = String.valueOf(s.charAt(i));
        	int result = strBuf.toString().indexOf(str);
        	if(result == -1){
        		strBuf.append(str);
        		len++;
        	}else{
        		start += result + 1;
        		strBuf.delete(0, strBuf.length());
        		strBuf.append(s.substring(start, i+1));
        		len = i - start +1;
        	}
        	
        	if(len > maxLen){
        		maxLen = len;
        	}
        }
        
        return maxLen;
    }
    
	public static void main(String[] args) {

		LongestSubstring ls = new LongestSubstring();
		System.out.println("Max length:" + ls.lengthOfLongestSubstring("b"));
		
	}

}
