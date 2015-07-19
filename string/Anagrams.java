package string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Anagrams {

    public List<String> anagrams(String[] strs) {
        
		List<String> resultLlist = new ArrayList<String>();
    	if(strs.length < 2)
    		return resultLlist;
    	
    	Map<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
    	for(String str: strs){
    		char[] chrAry = str.toCharArray();
    		Arrays.sort(chrAry); //key point!
    		String s = new String(chrAry);
    		if(map.containsKey(s)){
    			ArrayList<String> list = map.get(s);
    			list.add(str);
    			map.put(s, list);
    		}else{
    			ArrayList<String> list = new ArrayList<String>();
    			list.add(str);
    			map.put(s, list);
    		}    		
    	}

    	for(String key:map.keySet()){
    		ArrayList<String> list = map.get(key);
    		if(list.size()>1){
    			for(String s: list)
    				resultLlist.add(s);
    		}
    	}
    	return resultLlist;
    }
    
	public static void main(String[] args) {

		Anagrams ag = new Anagrams();
		
	}

}
