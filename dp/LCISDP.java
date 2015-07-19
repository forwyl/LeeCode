package dp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LCISDP {

	private int table[] = null;
	
	public int len(int[] ary){
		int maxLen = 1;
		table = new int[ary.length];
		table[0] = 1;
		for(int i=1; i<ary.length; i++){
			if(ary[i-1] < ary[i]){
				table[i] = table[i-1]+1;
				if(table[i] > maxLen)
					maxLen = table[i];
			}else{
				table[i] = 1;
			}
		}
		
		return maxLen;
	}
	
	public void showAll(int[] ary){
		List<List<Integer>> resultList = new ArrayList<List<Integer>>();
		int i = 0;
		while(i < table.length-1){
			if(table[i] == 1){
				List<Integer> list = new ArrayList<Integer>();
				while(i < table.length-1 && table[i] < table[i+1]){
					list.add(ary[i++]);
				}
				list.add(ary[i++]);
				resultList.add(list);
			}			
		}
		
		Collections.sort(resultList, new ListComparer());
		for(List<Integer> list : resultList){
			StringBuffer buf = new StringBuffer();
			for(int j = 0; j<list.size(); j++){
				if(j== list.size()-1){
					buf.append(list.get(j));
				}else{
					buf.append(list.get(j) + "\t");							
				}		
			}
			System.out.println("LCIS is: " + buf.toString());
			buf.delete(0, buf.length());
		}
		
	}
	
	public static void main(String[] args){
		
		int[] ary = {1, 2, 5, 3, 4}; // test case 1:{1, 2, 5, 3, 4}, test case2:  {2,4,6,1,2,3,2,4,5}
		LCISDP lcis = new LCISDP();
		System.out.println("Max len: " + lcis.len(ary));
		lcis.showAll(ary);
		
	}
	
	public class ListComparer implements Comparator<List<Integer>>{
		@Override
		public int compare(List<Integer> list1, List<Integer> list2) {
			int len = Math.max(list1.size(), list2.size());
			for(int i=0; i<len; i++){
				if(list1.get(i) < list2.get(i)){
					return -1;
				}else if(list1.get(i) > list2.get(i)){
					return 1;
				}
			}
			if(list1.size() < list2.size()){
				return -1;
			}else if(list1.size() > list2.size()){
				return 1;
			}
			return 0;
		}
	}
	
}
