package codechef.Y2021.june.longcontest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import codechef.Y2021.june.longcontest.Problem4.FastScanner;


public class Problem1 {

	public static void main(String[] args) {
		InputStream inputStream = System.in;
	    FastScanner in = new FastScanner(inputStream);
	    int tc = in.nextInt();
	    while(tc-- > 0) {
	    	int D = in.nextInt();
	    	int d = in.nextInt();
	    	int p = in.nextInt();
	    	int q = in.nextInt();
	    	int k = D/d;
	    	long sum = (long) ((k*p)+((q*(k-1)*k)/2));
	    	sum = d * sum; 
	    	if(D % d != 0) {
	    		int rem = D%d;
	    		sum += rem * (p+(k*q));
	    	}
	    	System.out.println(sum);
	    }
	    in.close();
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
