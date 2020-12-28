package codechef.practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class RGAME {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		while(tc-- > 0) {
			int n = Integer.parseInt(br.readLine());
			int[] arr = new int[n+1];
			String line = br.readLine();
			String[] num = line.split(" ");
			for(int i = 0; i< num.length;i++) {
				arr[i] = Integer.parseInt(num[i]);
			}
			if(arr.length == 1) {
				System.out.println(arr[0]);
				continue;
			}
			long sum = 0;
			int k = n;
			int j = 1;
			for(;j < n+1;j++) {
				long prod = (long) Math.pow(2, k);
				for(int i = 0;i < j;i++) {
					sum += arr[i] * arr[j] * prod;
				}
				if(j+1 < n) {
					sum += arr[j]*arr[j+1]*prod;
				}
				k--;
			}
			System.out.println(sum);
		}
		br.close();
	}

}
