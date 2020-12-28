package leetcode.month.october.week1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {

	static List<List<Integer>> res;
	
	public static void main(String[] args) {
		int[] arr = new int[] {1};
		Arrays.sort(arr);
		int sum = 2;
		combinationSum(arr,sum);
	}

	 public static List<List<Integer>> combinationSum(int[] candidates, int target) {
	        res = new ArrayList<List<Integer>>();
	        Arrays.sort(candidates);
			ArrayList<Integer> r1 = new ArrayList<Integer>();
			checkSum(candidates,0,target,r1);
			return res;
	    }
	
	private static int checkSum(int[] arr,int i, int sum,ArrayList<Integer> r1) {
		if(sum < 0) {
			return -1;
		}
		if(sum == 0) {
			return 0;
		}
		for(int j = i ;j < arr.length ; j++) {
			 r1.add(arr[j]);
			 int ans = checkSum(arr,j,sum-arr[j],r1);
			 if(ans == -1) {
				 r1.remove(r1.size()-1);
				 return 1;
			 }
			 if(ans == 0) {
				 ArrayList<Integer> r2 =  new ArrayList<Integer>(r1.size());
				 for(Integer a : r1) {
					 r2.add(a);
				 } 
				 res.add(r2);
			 }
			 r1.remove(r1.size()-1);
		}
		return 1;
	}

}
