package leetcode.month;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class NoOfIslands {
	
	public static void main(String[] args) {
		char[][] arr = new char[][] {{'0','1'},{'1','1'}};
		int ans = numIslands(arr);
		System.out.println(ans);
	}
	
	 public static int numIslands(char[][] grid) {
		 Island[][] arr = new Island[grid.length][grid[0].length];
		 for(int i = 0; i<grid.length;i++) {
			 for(int j = 0; j< grid[0].length;j++) {
				 arr[i][j] = new Island(i,j,grid[i][j]);
			 }
		 }
		 int count = 0;
		 for(int i =0 ; i< arr.length;i++) {
			 for(int j = 0;j<arr[0].length;j++) {
				 if(!arr[i][j].visited && arr[i][j].value == '1') {
					 Stack<Island> st = new Stack<Island>();
					 st.push(arr[i][j]);
					 count++;
					 while(!st.isEmpty()) {
						 Island is = st.pop();
						 is.visited = true;
						 List<Island> li = getNeighbours(arr,is);
						 st.addAll(li);
					 }
				 }
			 }
		 }
		 return count;
		 
	 }

	private static List<Island> getNeighbours(Island[][] arr,Island is) {
		int i = is.i;
		int j = is.j;
		List<Island> nei = new ArrayList<Island>();
		if(i+1 < arr.length && !arr[i+1][j].visited && arr[i+1][j].value == '1') {
			nei.add(arr[i+1][j]);
		}
		if(j+1 < arr[0].length && !arr[i][j+1].visited && arr[i][j+1].value == '1') {
			nei.add(arr[i][j+1]);
		}
		if(i-1 >= 0 && !arr[i-1][j].visited && arr[i-1][j].value == '1') {
			nei.add(arr[i-1][j]);
		}
		if(j-1 >= 0 && !arr[i][j-1].visited && arr[i][j-1].value == '1') {
			nei.add(arr[i][j-1]);
		}
		return nei;
	}

}


class Island{
	char value = 0;
	int i = 0;
	int j = 0;
	boolean visited;
	Island(int i, int j, char value){
		this.i = i;
		this.j = j;
		this.value = value;
	}
}