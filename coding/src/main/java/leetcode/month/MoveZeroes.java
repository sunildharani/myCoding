package leetcode.month;

public class MoveZeroes {

	 public void moveZeroes(int[] nums) {
	        int j = 0;
	        int i = 0;
	        for(;i < nums.length && j < nums.length;){
	            if(nums[j] != 0){
	                nums[i] = nums[j];
	                i++;
	            }
	            j++;
	        }
	        for(;i<nums.length;i++){
	            nums[i] = 0;
	        }
	    }
	
}
