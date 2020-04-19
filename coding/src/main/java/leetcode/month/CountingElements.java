package leetcode.month;

public class CountingElements {
	
	public int countElements(int[] arr) {
		int[] ans = new int[1001];
		for(int i = 0;i < arr.length;i++) {
			ans[arr[i]]++;
		}
		int count = 0;
		for(int i = 0; i< arr.length-1;i++) {
			count += Math.min(ans[i], ans[i+1]);
		}
		return count;
    }

}
