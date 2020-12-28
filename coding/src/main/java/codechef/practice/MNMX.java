package codechef.practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class MNMX {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		while(tc-- > 0) {
			int l = Integer.parseInt(br.readLine());
			String line = br.readLine();
			int max = Integer.MIN_VALUE;
			int maxi = 0 ;
			int maxj = 0;
			int[] ar = new int[l];
			String[] val = line.split(" ");
			ar[0] = Integer.parseInt(val[0]);
			//use segment tree
		}
	}

}
