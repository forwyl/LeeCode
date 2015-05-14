package dp;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class LISDP {

	private int[][] len= null;
	private int[][] type = null;
	
	public int len(int[] ary){
		int[] ori = Arrays.copyOf(ary, ary.length);
		Arrays.sort(ary);
		int oriLen = ori.length;
		int aryLen = ary.length;
		len = new int[oriLen+1][aryLen+1];
		type = new int[oriLen+1][aryLen+1];
		
		for(int i=0; i<oriLen+1; i++)
			len[i][0] = 0;
		for(int j=0; j<aryLen+1; j++)
			len[0][j] = 0;
		
		for(int i=1; i<oriLen+1; i++){
			for(int j=1; j<aryLen+1; j++){
				if(ori[i-1] == ary[j-1]){
					len[i][j] = len[i-1][j-1]+1;
					type[i][j] = 1;
				}else{
					if(len[i-1][j] > len[i][j-1]){
						len[i][j] = len[i-1][j];
						type[i][j] = 2;
					}else{
						len[i][j] = len[i][j-1];
						type[i][j] = 3;
					}
				}
			}			
		}
		
		return len[oriLen][aryLen];
	}
	
	public void back(int[] ary, int i, int j, StringBuffer lis){
		
		if(i==0 | j==0){
			System.out.println("LIS:" + lis.toString());
			return;
		}
		
		switch(type[i][j]){
			case 1:
				back(ary, i-1, j-1, new StringBuffer().append(ary[j-1] + " " + lis.toString()));
				break;
			case 2:
				back(ary, i-1, j, lis);
				break;
			case 3:
				back(ary, i, j-1, lis);
				break;
		}
		
	}
	
	public static void main(String[] args) {
		int[] ary = {0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15};
		
		LISDP lis = new LISDP();
		System.out.println("Len: " + lis.len(ary));
		lis.back(ary, ary.length, ary.length, new StringBuffer());
	}

}
