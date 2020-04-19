package leetcode.month;

public class LastStoneWeight {
	
	public static void main(String[] args) {
		int[] arr = new int[] {2};
		for(int i = arr.length/2; i>= 0;i--) {
			buildheap(arr,i,arr.length-1);
		}
		int temp = arr.length-1;
		while(temp >= 1) {
			int a = arr[0];
			arr[0] = arr[temp];
			arr[temp] = 0;
			temp--;
			buildheap(arr,0,temp);
			int b = arr[0];
			arr[0] = a-b;
			buildheap(arr,0,temp);
		}
		System.out.println(arr[0]);
	}

	private static void buildheap(int[] arr, int i ,int heaplength) {
		int left = 2*i+1;
		int right = 2*(i+1);
		int largest = i;
		if(left <= heaplength && arr[left] > arr[i]) {
			largest = left;
		}
		if(right <= heaplength && arr[right] > arr[largest]) {
			largest = right;
		}
		if(largest != i) {
			int temp = arr[largest];
			arr[largest] = arr[i];
			arr[i] = temp;
			buildheap(arr,largest,heaplength);
		}
	}

}
