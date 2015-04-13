package recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutations {
	
    public List<List<Integer>> permute(int[] num) {
		List<List<Integer>> outerList = new ArrayList<List<Integer>>();
		if(num.length == 0) {
			List<Integer> innerList = new ArrayList<Integer>();
			outerList.add(innerList);	
			return outerList;
		}
		
		int first = num[0];
		List<List<Integer>> permList = permute(Arrays.copyOfRange(num, 1, num.length));
		for(int i=0; i<permList.size(); i++){
			List<Integer> perm = permList.get(i);
			for(int j=0; j<perm.size()+1; j++){
				List<Integer> newPerm = new ArrayList<Integer>(perm);
				newPerm.add(j, first);
				outerList.add(newPerm);
			}
		}
		
		return outerList;        
    }
    
    private final void show(List<List<Integer>> list){
    	
    	for(List<Integer> inner: list){
    		StringBuffer buf = new StringBuffer();
    		for(Integer i:inner){
    			buf.append(String.valueOf(i));
    		}
    		System.out.println(buf.toString());
    		buf.delete(0, buf.length());
    	}
    }
    
	public static void main(String[] args) {
		
		final int[] num = {1, 2, 3, 4};
		Permutations p = new Permutations();
		List<List<Integer>> list = p.permute(num);
		p.show(list);
		
	}

}
