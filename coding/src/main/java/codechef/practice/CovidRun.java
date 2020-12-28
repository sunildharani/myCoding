package codechef.practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CovidRun {

	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		while(tc-- > 0) {
			String line = br.readLine();
			String[] num = line.split(" ");
			int n = Integer.parseInt(num[0]);
			int k = Integer.parseInt(num[1]);
			int x = Integer.parseInt(num[2]);
			int y = Integer.parseInt(num[3]);
			if(x == y) {
				System.out.println("YES");
				continue;
			}
			int pos = (x+k) % n;
			int prevexor = x ^ pos ;
			int exor = pos;
			while(pos != y) {
				pos = (pos+k) % n;
				prevexor ^= pos;
				if(prevexor == exor) {
					break;
				}
				exor ^= pos ;
			}
			if(pos == y) {
				System.out.println("YES");
			}else {
				System.out.println("NO");
			}
				
		}
		br.close();
	}
	
}
