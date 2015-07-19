package dp;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {

    public List<List<String>> partition(String s) {
        
    	int len = s.length();
    	List<List<String>> resultList = new ArrayList<List<String>>();
    	if(len < 2){
    		List<String> list = new ArrayList<String>();
    		if(len==1)	list.add(s);
    		resultList.add(list);
    		return resultList;
    	}
    	
    	boolean[][] lenTable = new boolean[len][len];
    	for(int i=0; i<len; i++) lenTable[i][i] = true;
    	for(int i=1; i<len; i++){
    		if(s.charAt(i-1)==s.charAt(i)){
    			lenTable[i-1][i] = true;
    		}
    	}
    	for(int k=3; k<=len; k++){
    		for(int i=0; i <len-k+1; i++){
    			int j = i+k-1;
    			if(s.charAt(i) == s.charAt(j) && lenTable[i+1][j-1])	lenTable[i][j] = true;	
    			else	lenTable[i][j] = false;
    		}
    	}
    	
    	List<String> onelist = new ArrayList<String>();
    	for(int i=0; i<len; i++){
    		onelist.add(s.substring(i, i+1));
    	}
    	resultList.add(onelist);
    	
    	for(int k=len; k>0; k--){
    		for(int i=0; i+k<=len; i++){
    			int j = i+k-1;
//    			System.out.printf("i:%d, j:%d , value:%s \n", i, j, lenTable[i][j]);
    			if(lenTable[i][j] && i != j){
    				List<String> list = new ArrayList<String>();
    				String p = s.substring(i, j+1);
    				for(int m=0; m<i; m++)	list.add(s.substring(m, m+1));
    				list.add(p);
    				for(int m=j+1; m<len; m++)	list.add(s.substring(m, m+1));
    				resultList.add(list);
    			}
    		}
    	}
    	
        return resultList;
    }
    
	public static void main(String[] args) {
		
		String s = "cbbbcc";
		PalindromePartitioning pp = new PalindromePartitioning();
		List<List<String>> resultList = pp.partition(s);
		for(List<String> list: resultList){
			for(String str: list)
				System.out.printf("%s\t", str);
			System.out.println();
		}
		
		/**
		 * ["c","b","bb","cc"],["c","bb","b","cc"],["c","bbb","cc"]
		 */
		
	}

}
