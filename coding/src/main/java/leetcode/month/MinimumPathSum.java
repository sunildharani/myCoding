package leetcode.month;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MinimumPathSum {

	public static void main(String[] args) {
		int[][] arr = new int[][] {{1,10},{3,4}};
		  int[][] ans = new int[arr.length][arr[0].length];
		  for(int i = 0 ;i < ans.length;i++) {
			  Arrays.fill(ans[i], Integer.MAX_VALUE);
		  }
		  ans[0][0] = arr[0][0];
		  Queue<String> qu = new LinkedList<String>(); 
		  qu.add("0_0");
		  int pathsum= 0;
		  int leastsum = Integer.MAX_VALUE;
		  while(!qu.isEmpty()) {
			  String ind = qu.poll();
			  String[] a = ind.split("_");
			  int i = Integer.parseInt(a[0]);
			  int j = Integer.parseInt(a[0]);
			  pathsum += arr[i][j];
			  if(i == arr.length-1 && j == arr[0].length-1) {
				  leastsum = Math.min(leastsum, pathsum);
			  }
			  List<String> nei = getneighbours(arr,i,j);
		  }
		
	}

	private static List<String> getneighbours(int[][] arr, int i, int j) {
		List<String> li = new ArrayList<String>();
		if(i+1 < arr.length) {
			li.add((i+1)+"_"+j);
		}
		if(i-1 >= 0) {
			li.add((i-1)+"_"+j);
		}
		if(j+1 < arr[0].length) {
			li.add(i+"_"+(j+1));
		}
		if(j-1 > 0) {
			li.add(i+"_"+(j-1));
		}
		return li;
	}
	
	 

}
