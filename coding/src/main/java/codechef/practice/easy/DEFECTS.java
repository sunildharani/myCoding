package codechef.practice.easy;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class DEFECTS {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		while(tc-- > 0) {
			String line = br.readLine();
			String[] num = line.split(" ");
			int m = Integer.parseInt(num[0]);
			int n = Integer.parseInt(num[1]);
			char[][] arr = new char[m][n];
			for(int i = 0; i<m;i++) {
				line = br.readLine();
				char[] ar = line.toCharArray();
				for(int j = 0,k= 0; j< n;j++) {
					arr[i][j] = ar[k]; 
					k = k+2;
				}
			}
			int zerogroups = 0;
			int onegroups = 0;
			for(int i = 0; i< m;i++) {
				for(int j =0 ; j < n;j++ ) {
					if(arr[i][j] != 'v') {
						if(arr[i][j] == '0') {
							zerogroups++;
						}else {
							onegroups++;
						}
						markallneighbours(arr,i,j);
					}
				}
			}
			System.out.println(Math.min(zerogroups, onegroups));
		}
		br.close();
	}

	private static void markallneighbours(char[][] arr, int i, int j) {
		char temp = arr[i][j];
		arr[i][j] = 'v';
		if(i+1 < arr.length && arr[i+1][j] == temp) {
			markallneighbours(arr,i+1,j);
		}
		if(i-1 >=0 && arr[i-1][j] == temp) {
			markallneighbours(arr,i-1,j);
		}
		if(j+1 < arr[0].length && arr[i][j+1] == temp) {
			markallneighbours(arr,i,j+1);
		}
		if(j-1 >=0 && arr[i][j-1] == temp) {
			markallneighbours(arr,i,j-1);
		}
	}
	
}
