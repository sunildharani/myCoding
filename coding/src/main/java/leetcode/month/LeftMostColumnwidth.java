package leetcode.month;

public class LeftMostColumnwidth {
	
	public static void main(String[] args) {
		int[][] mat = new int[][] {{1,0},{1,1}};
		int j = mat[0].length-1;
		int i = 0;
		boolean found = false ;
		for(;i< mat.length;i++) {
			if(mat[i][j] == 1) {
				j = findrow(mat,i,0,j);
				found = true;
				if(j == 0) {
					break;
				}
			}
		}
		if(found) {
			System.out.println(j);
		} else {
			System.out.println(-1);
		}
	}

	private static int findrow(int[][] mat, int i , int start, int end) {
		int minj = end;
		while(start <= end) {
			int mid = start+(end-start)/2;
			if(mat[i][mid] == 1) {
				end = mid-1;
				minj = mid;
			}else {
				start = mid+1;
			}
		}
		return minj;
	}

}
