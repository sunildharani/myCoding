package codechef.october.cookoff;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Problem2 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		while(n-- > 0) {
			String line = br.readLine();
			String[] ans = line.split(" ");
			int a = Integer.parseInt(ans[0]);
			int b = Integer.parseInt(ans[1]);
			int res = b;
			if(res / 2 < a) {
				System.out.println(res);
			}else {
				System.out.println(-1);
			}
		} 
	}

}
