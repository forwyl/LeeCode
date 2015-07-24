package recursion;

import java.util.ArrayList;
import java.util.List;

public class PermutationsII {

    public List<List<Integer>> permuteUnique(int[] nums) {
        
    	List<List<Integer>> res = new ArrayList<List<Integer>>();
    	if(nums ==null || nums.length == 0)
    		return res;
    	boolean[] visit = new boolean[nums.length];
    	List<Integer> numList = new ArrayList<Integer>();
    	dfs(res, numList, visit, nums, nums.length);
    	
    	return res;
    }
    
    public void dfs(List<List<Integer>> res, List<Integer> numList, boolean[] visit, int[] nums, int len){
    	
    	if(numList.size()==len){
    		List<Integer> cloneList = new ArrayList<Integer>(numList);
    		res.add(cloneList);
    		return;
    	}
    	
    	List<Integer> usedList = new ArrayList<Integer>();
    	for(int i=0; i<len; i++){
    		if(!visit[i]){
    			if(usedList.contains(nums[i])){
    				continue;
    			}else{
    				usedList.add(nums[i]);
    			}
        		visit[i] = true;
        		numList.add(nums[i]);
        		dfs(res, numList, visit, nums, len);    		
        		numList.remove(numList.size()-1);
        		visit[i] = false;
    		}
    	}
    	
    }

    private void show(List<List<Integer>> list){
    	
    	System.out.printf("size:%d\n", list.size());
    	for(List<Integer> inner: list){
    		StringBuffer buf = new StringBuffer();
    		for(Integer num: inner){
    			buf.append(String.valueOf(num));
    		}
    		System.out.printf("%s\n", buf.toString());
    		buf.delete(0, buf.length());
    	}
    }
    
	public static void main(String[] args) {

		final int[] num = {1,1,2};
		PermutationsII p = new PermutationsII();
		List<List<Integer>> list = p.permuteUnique(num);
		p.show(list);
		
	}

}
