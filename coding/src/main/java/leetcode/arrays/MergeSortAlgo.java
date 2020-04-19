package leetcode.arrays;

import java.util.stream.Stream;

import javax.xml.transform.stream.StreamSource;

public class MergeSortAlgo {
	
	public static void main(String[] args) {
		int[] arr = new int[] {12,34,1,3,2,4,5,32,56,-4,-3,0,6,3,2};
		sort(arr,0,arr.length-1);
		for(int i =0; i< arr.length;i++) {
			System.out.println(arr[i]);
		}
	}

	private static void sort(int[] arr, int i, int len) {
		if(len-i == 1) {
			if(arr[i] > arr[len]) {
				int temp = arr[len];
				arr[len] = arr[i];
				arr[i] = temp;
			}
			return;
		}
		if(i < len) {
			int mid = (i+len)/2;
			sort(arr,i,mid);
			sort(arr,mid+1,len);
			mergeSort(arr,i,mid,len);
		}
		
	}

	private static void mergeSort(int[] arr, int i, int mid, int len) {
		int[] dup = new int[len-i+1];
		int k = mid;
		int start = i;
		int j = 0;
		while(i <= k && mid < len) {
			if(arr[i] > arr[mid+1]) {
				dup[j] = arr[mid+1];
				mid++;
			}else {
				dup[j] = arr[i];
				i++;
			}
			j++;
		}
		while(i <=k) {
			dup[j] = arr[i];
			j++;
			i++;
		}
		while(mid < len) {
			dup[j] = arr[mid+1];
			j++;
			mid++;
		}
		int l = 0;
		for(;l<dup.length;) {
			arr[start+l] = dup[l];
			l++;
		}
	}
	
	
	private static void mergeSortInPlace(int[] arr, int i, int mid, int len) {
		int k = mid;
		while(i <= k && mid < len) {
			if(arr[i] > arr[mid+1]) {
				int temp = arr[mid+1];
				arr[mid+1] = arr[i];
				arr[i] = temp;
				mid++;
			}
			i++;
		}
	}
	

}
