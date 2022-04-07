package codechef.starters23;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Problem3 {

	public static void main(String[] args) {
		InputStream inputStream = System.in;
	    FastScanner in = new FastScanner(inputStream);
	    int tc = in.nextInt();
	    while(tc-- > 0) {
	    	int n = in.nextInt();
			int k = in.nextInt();
			int x = in.nextInt();
			if(x> k+1){
				System.out.println(-1);
				continue;
			}
            int[] arr = new int[n];
			int i = 0;
			while(i < n && i != x){
				  arr[i] = i;
				  i++;
			}
			i++;
			while(i < n && i <= k+1){
				arr[i] = i;
				i++;
			}
			for(int  j=0;j < n;j++){
				System.out.print(arr[j]+" ");
			}
			System.out.println();
	    }
	}
	
	
	static class FastScanner {
        private BufferedReader bufferedReader;
        private StringTokenizer stringTokenizer;

        public FastScanner(InputStream inputStream) {
            bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        }

        public String next() {
            while (stringTokenizer == null || !stringTokenizer.hasMoreElements()) {
                try {
                    stringTokenizer = new StringTokenizer(bufferedReader.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return stringTokenizer.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public void close() {
        	try {
				bufferedReader.close();
			} catch (IOException e) {
				
			}
        }
        
    }
}
