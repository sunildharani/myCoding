package leetcode.month;

public class ContiguousArray {

	public static int findMaxLength(int[] nums) {
		int length = 0;
		int zeros = 0;
		int ones = 0;
		for(int i = 0 ;i < nums.length-length;i++) {
			int len = 0;
			for(int j = i+length;j < nums.length;j++) {
				if(nums[j] == 0) {
					zeros++;
				}
				if(nums[j] == 1) {
					ones++;
				}
				if(zeros == ones) {
					len = 2*ones;
				}
			}
			if(len > length) {
				length = len;
				zeros = length/2;
				ones = length/2;
			}			if(length > 1) {
				if(nums[i] == 0) {
					zeros--;
				}else {
					ones--;
				}
				if(i+length < nums.length) {
					if(nums[i+length] == 0) {
						zeros++;
					}else {
						ones++;
					}
				}
			}
		}
		return length;
		
	}

	public static void main(String[] args) {
		int[] nums = new int[] {0,1,1,1,0,0,0,0,1,1,1,1,1,1,0,1,0,0,0,1};
		System.out.println(findMaxLength(nums));
	}
	
}
