package hackerrank.algo;

import java.math.BigDecimal;

public class Meantrim {

	public static void main(String[] args) {
		int[] ar = new int[] {1,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,3};
		Meantrim mt = new Meantrim();
		mt.mergeSort(ar, 0, ar.length-1);
		int sum =0;
		int i = (ar.length * 5)/100;
        for(int j=i;j<=ar.length-1-i;j++){
            sum += ar[j];
        }
		BigDecimal ans1 = new BigDecimal(sum);
		ans1 = ans1.divide(new BigDecimal(ar.length-(2*i)));ans1.doubleValue();
		int x = 0;
		int y = 0;
		int[][] ans = new int[][]{{x,y},{x+1,y},{x,y+1},{x-1,y},{x,y-1},{x-1},{y-1}};
		for(int k =0; k< ans.length;k++) {
			for(int m = 0; m<2;m++) {
				System.out.println(ans[k][m]);
			}
		}
	}
	
	private void mergeSort(int[] arr, int left ,int right){
		if(left >= right) {
			return;
		}
		if(right-left == 1) {
			if(arr[left] > arr[right]) {
				int temp = arr[left];
				arr[left] = arr[right];
				arr[right] = temp;
			}
			return;
		}
		int mid = left + (right-left)/2;
		mergeSort(arr,left,mid);
		mergeSort(arr,mid+1,right);
		mergeArrays(arr,left,mid,right);
		
	}

	private void mergeArrays(int[] arr, int left, int mid, int right) {
		int[] newArr = new int[right-left+1];
		int i = left;
		int j = mid+1;
		int k = 0;
		while(i <= mid && j <= right) {
			if(arr[i] <= arr[j]) {
				newArr[k] = arr[i];
				i++;
			}else {
				newArr[k] = arr[j];
				j++;
			}
			k++;
		}
		while(i <= mid) {
			newArr[k] = arr[i];
			k++;
			i++;
		}
		while(j <= right) {
			newArr[k] = arr[j];
			k++;
			j++;
		}
		k = 0;
		for(;left <= right;left++) {
			arr[left] = newArr[k];
			k++;
		}
	}
	
}
