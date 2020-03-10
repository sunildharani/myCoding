package leetcode.bitwise;

public class SingleNumber {
	 public int singleNumber(int[] nums) {
	        int res = 1;
	        for(int i = 0; i< nums.length;i++){
	            res = res ^ nums[i];
	        }
	        return res ^ 1;
	    }
}
