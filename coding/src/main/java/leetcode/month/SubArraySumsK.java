package leetcode.month;

public class SubArraySumsK {

	public static void main(String[] args) {
		int[] arr = new int[] {1,2,3};
		int[] ans = new int[arr.length];
		int k = 3;
		int count = 0;
		int sum = 0;
		for(int i = 0; i< arr.length;i++) {	
			sum += arr[i];
			ans[i] = sum;
			if(ans[i] == k) {
				count++;
			}
		}
		for(int j = 0; j <arr.length;j++) {
			for(int i = j+1; i< arr.length;i++) {
				ans[i] = ans[i]-arr[j];
				if(ans[i] == k) {
					count++;
				}
			}
		}
		System.out.println(count);
	}
	
}
