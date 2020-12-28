package codeforces;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Problem1 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		int num = 10000;
		while(tc-- > 0) {
			int k = Integer.parseInt(br.readLine());
			int n = 1;
			int temp = 1;
			int sum = 1;
			int a = 2;
			while(n < k) {
				n = n*10 + temp;
				sum += a;
				a++;
				if(n > num) {
					n = temp+1;
					temp++;
					a = 2;
				}
			}
			System.out.println(sum);
		}
		br.close();
		
	}	
	
}
