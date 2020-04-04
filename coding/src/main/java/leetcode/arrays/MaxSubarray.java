package leetcode.arrays;

public class MaxSubarray {
	
	public static void main(String[] args) {
		int[] arr = new int[] {-2,1,4};
		int maxSum = Integer.MIN_VALUE;
		int sum = 0;
		for( int k = 0;k <arr.length;k++) {
			if(maxSum < arr[k]) {
				maxSum = arr[k];
			}
		}
		if(maxSum < 0) {
		   System.out.println(maxSum);	
		}
		int i = 0,j = 0;
		for( ; i< arr.length && j<arr.length;) {
			sum += arr[j];
			if(sum < 0) {
				j++;
				i = j;
			}else {
				j++;
			}
			if(sum > maxSum) {
				maxSum = sum;
			}
		}
		System.out.println(maxSum);
	}

}
