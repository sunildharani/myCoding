package codechef.december.launchtime;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Problem4 {

	public static void main(String[] args) {
		InputStream inputStream = System.in;
	    FastScanner in = new FastScanner(inputStream);
	    int tc = in.nextInt();
	    while(tc-- > 0) {
	    	int n = in.nextInt();
	    	int m = in.nextInt();
	    	int[] arr = new int[m];
	    	int gcd = 1;
	    	for(int i = 0; i< m;i++) {
	    		arr[i] = in.nextInt();
	    		if(i == 0) {
	    			gcd = arr[0];
	    		}else {
	    			gcd = findGCD(gcd,arr[i]);
	    		}
	    	}
	    	if(n > gcd) {
	    		System.out.println(n-gcd);
	    	}else {
	    		System.out.println(n-1);	
	    	}
	    }
	}
	
	
	private static int findGCD(int gcd, int i) {
		if(gcd < i) {
			gcd = gcd+i;
			i = gcd-i;
			gcd = gcd-i;
		}
		while(i != 0) {
			int temp = i;
			i = gcd % i;
			gcd = temp;
		}
		return gcd;
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
