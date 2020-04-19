package leetcode.arrays;

public class HeapSortAlgo {
	
	public static void main(String[] args) {
		int[] arr = new int[] {1,4,2,5,2,4,7,8,45,78,68,23};
		for(int i = arr.length/2; i>= 0;i--) {
			heapify(arr,i,arr.length);
		}
		for(int i = arr.length-1;i > 0;i--) {
			int temp = arr[i];
			arr[i] = arr[0];
			arr[0] = temp;
			heapify(arr,0,i-1);
		}
		for(int i = 0; i< arr.length;i++) {
			System.out.println(arr[i]);
		}
	}

	private static void heapify(int[] arr, int i, int heaplength) {
		int left = 2*i+1;
		int right = 2*(i+1);
		int largest = i;
		if(left < heaplength && arr[left] > arr[i]) {
			largest = left;
		}
		if(right < heaplength && arr[right] > arr[largest]) {
			largest = right;
		}
		if(largest != i) {
			int temp = arr[largest];
			arr[largest] = arr[i];
			arr[i] = temp;
			heapify(arr,largest,heaplength);
		}		
	}

}
