package leetcode.month.october.week3;

public class RotateArrayNoExtraSpace {
	
	public static void main(String[] args) {
		int[] nums = new int[] {1,2,3,4,5,6};
		int k = 4;
		k = k % nums.length;
		if(k > 0) {
			int j = nums.length-k;
			int origj = j;
			if(k < nums.length/2) {
				j = nums.length-k;
				int i = j-k;
				while(i >= 0) {
					while(i < origj) {
						int temp = nums[j];
						nums[j] = nums[i];
						nums[i] = temp;
						i++;
						j++;
					}
					j = origj-k;
					origj = j;
					i = j-k;
				}
				i = 0 ;
				while(k > 0) {
					int temp = nums[j];
					nums[j] = nums[i];
					nums[i] = temp;
					i++;
					j++;
					k--;
				}
			}else {
				int i = 0;
				while(j < nums.length) {
					int temp = nums[j];
					nums[j] = nums[i];
					nums[i] = temp;
					i++;
					j++;
				}
				j = nums.length-1;
				int temp = nums[j];
				while(j > i) {
					nums[j] = nums[j-1];
					j--;
				}
				nums[j] = temp;
			}
		}
		
		for(int i= 0; i< nums.length;i++) {
			System.out.print(nums[i]+",");
		}
		
	}

}
