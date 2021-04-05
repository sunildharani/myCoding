package hackerrank.algo.strings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class SherlockAna {

	static int[] primes;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		buildPrimes();	
		int tc = Integer.parseInt(br.readLine());
		while(tc-- > 0) {
			String line = br.readLine();
			char[] c = line.toCharArray();
			int l = 1;
			int ans = 0;
			while(l <= c.length) {
				int i = 0;
				int j = i+l;
				HashMap<Long,Integer> len = new HashMap<Long,Integer>();
				while(j <= c.length) {
					long val = 1l;
					for(int k = i; k< j;k++) {
						val = val * primes[c[k]-'a'];
					}
					if(len.containsKey(val)) {
						len.put(val, len.get(val)+1);
					}else {
						len.put(val, 1);
					}
					i++;
					j++;
				}
				for(Map.Entry<Long, Integer> entry :len.entrySet()) {
					if(entry.getValue() > 1) {
						int val = entry.getValue();
						ans += (val*(val-1))/2;
					}
				}
				l++;
			}	
			System.out.println(ans);
		}
	}

	private static void buildPrimes() {
		primes = new int[26];
		primes[0] = 2;
		primes[1] = 3;
		for(int i = 2;i <26;i++) {
			int num = primes[i-1]+2;
			boolean found = false;
			while(!found) {
				boolean f = true;
				int sqrtnum = (int) Math.sqrt(num);
				for(int j=0;primes[j] <= sqrtnum;j++) {
					if(num % primes[j]  == 0) {
						f = false;
						break;
					}
				}
				if(f) {
					found = true;
					break;
				}
				num++;
			}
			if(found) {
				primes[i] = num;
			}
		}
	}
}