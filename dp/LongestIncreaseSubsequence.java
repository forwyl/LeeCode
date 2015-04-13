package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LongestIncreaseSubsequence {
	
	public int binarySearchIndex(int[] tailTable, int s, int e, int key){
		
		int mid;
		while(s <= e){
			mid = (s+e)/2;
			if(key > tailTable[mid])
				s = mid + 1;
			else
				e = mid - 1;
		}
		
		return s;
	}
	
	public int lcsLen(int[] ary){
		
		int aryLen = ary.length;
		int[] tailTable = new int[aryLen];
		int len = 1;
		for(int i=0; i<aryLen; i++){
			tailTable[i] = 0;
		}
		tailTable[1] = ary[0];
		for(int i=1; i< aryLen; i++){
			if(ary[i] < tailTable[1]){
				// new min value
				tailTable[1] = ary[i];
			}else if( ary[i] > tailTable[len]){
				//extended to the largest subsequence
				tailTable[++len] = ary[i];
			}else{
				tailTable[binarySearchIndex(tailTable, 1, len, ary[i])] = ary[i];
			}
		}
		
		System.out.println("LongestIncreaseSubsequence is:");
		for(int i=0; i<len; i++){
			System.out.print(tailTable[i]);
			if(i != len -1)
				System.out.print("\t");
			else
				System.out.print("\n");
		}
		
		return len;
	}
	
	public static void main(String[] args){
		
		LongestIncreaseSubsequence lis = new LongestIncreaseSubsequence();
		try{
		    BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
		    int len = Integer.valueOf(bufferRead.readLine().trim());
		    int[] ary = new int[len];
		    for (int i=0; i<len; i++){
		    	ary[i] = Integer.valueOf(bufferRead.readLine().trim());
		    }
		    System.out.println(lis.lcsLen(ary));
		    
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	
}
