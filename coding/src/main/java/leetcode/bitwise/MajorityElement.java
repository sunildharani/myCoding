package leetcode.bitwise;

public class MajorityElement {

	private final int INT_SIZE = 32;
	
	 public int majorityElement(int[] nums) {
		 int result = 0;
		 for(int i =0; i< INT_SIZE;i++) {
			 int x = 1 << i;
			 int ones = 0;
			 for(int j = 0; j <nums.length;j++) {
				 if((nums[j] & x) != 0) {
					 ones++;
				 }			
			 }
			 if(ones > nums.length/2) {
				 result |= x;
			 }
		 }
		 System.out.println(result);
		 return result;
	 
	 }
	 
	 public static void main(String[] args) {
		 MajorityElement me = new MajorityElement();
		 int[] arr = new int[] {2,2,1,1,1,2,2,4,5,6,2,2};
		 me.majorityElement(arr);
	 }
	
	
}
