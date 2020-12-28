package leetcode.month.october.week2;

import java.util.ArrayList;

public class HouseRobber2 {
	
	int maxSum = Integer.MIN_VALUE;
	ArrayList<Integer> indexes;
	
	public static void main(String[] args) {
		HouseRobber2 h = new HouseRobber2();
		h.rob(new int[] {1,3,1,3,100});
		System.out.println(h.maxSum);
	}
	
	public int rob(int[] nums) {
		ArrayList<Integer> al = new ArrayList<Integer>();
		getsum(al, 0, 0, nums);
		getsum(al,1,0,nums);
		return maxSum;
	}
	
	public int getsum(ArrayList<Integer> al, int i, int sum, int[] nums) {
		if(i >= nums.length) {
			return 0;
		}
		sum += nums[i];
		al.add(i);
		if(i == nums.length-1) {
			if(al.get(0) == 0) {
				if(nums[0] < nums[nums.length-1]) {
					sum -= nums[0];
				}
			}
			if(sum > maxSum) {
				maxSum = sum;
				indexes = new ArrayList<Integer>();
				for(Integer a : al) {
					indexes.add(a);
				}
			}
			al.remove(al.size()-1);
			return 0;
		}
	
		for(int j = i+2 ;j < nums.length;j++) {
			getsum(al,j,sum,nums);
			al.remove(al.size()-1);
		}
		
		return sum;
	}

}
