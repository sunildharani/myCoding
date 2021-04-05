package codechef.Y2021.february.longcontest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;


public class Problem4 {

	public static void main(String[] args) {
		InputStream inputStream = System.in;
	    FastScanner in = new FastScanner(inputStream);
	    int tc = in.nextInt();
	    while(tc-- > 0) {
	    	int n = in.nextInt();
	    	int[] weights = new int[n];
	    	int[] steps = new int[n];
	    	HashMap<Integer,Integer> hm = new HashMap<Integer,Integer>();
	    	for(int i =0 ;i<n;i++) {
	    		weights[i] = in.nextInt();
	    		hm.put(weights[i], i);
	    	}
	    	for(int i =0 ;i<n;i++) {
	    		steps[i] = in.nextInt();
	    	}
	    	Arrays.sort(weights);
	    	int count = 0;
	    	int pos = hm.get(weights[0]);
	    	for(int i = 1; i< n;i++) {
	    		int cur = hm.get(weights[i]);
	    		int initpos = cur;
	    		while(cur <= pos) {
	    			count++;
	    			cur += steps[initpos];
	    		}
	    		pos = cur;
	    	}
	    	System.out.println(count);
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
