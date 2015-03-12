package array;

import java.util.HashMap;
import java.util.Map;

public class MajorityElement169 {

    public int majorityElement(int[] num) {

    	if(num.length == 1){
    		return num[0];
    	}
    	
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i=0; i<num.length; i++){
        	if(map.containsKey(Integer.valueOf(num[i]))){
        		map.put(Integer.valueOf(num[i]), map.get(Integer.valueOf(num[i]))+1);
        	}else{
        		map.put(Integer.valueOf(num[i]), 1);
        	}
        }
        
        int len = num.length/2;
        int max = 0;
        for(Integer key: map.keySet()){
        	if(map.get(key) > len){
        		max = key;
        		break;
        	}
        }
        
        return max;
        
    }
    
	public static void main(String[] args) {
		
		MajorityElement169 me = new MajorityElement169();
		int[] a = {-1, 1, 1, 1, 2, 1};
		System.out.println(me.majorityElement(a));

	}

}
