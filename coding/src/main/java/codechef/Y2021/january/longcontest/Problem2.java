package codechef.Y2021.january.longcontest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Problem2 {

	public static void main(String[] args) {
		InputStream inputStream = System.in;
	    FastScanner in = new FastScanner(inputStream);
	    int tc = in.nextInt();
	    int[] pow = new int[4];
	    pow[0] = 1;
	    pow[1] = 2;
	    pow[2] = 4;
	    pow[3] = 8;
	    while(tc-- > 0) {
	    	int n = in .nextInt();
	    	String line = in.next();
	    	char[] c = line.toCharArray();
	    	StringBuilder sb = new StringBuilder();
	    	for(int i = 0; i<= c.length-4;) {
	    		int j = 3;
	    		int sum = 0;
	    		while(j >=0) {
	    			if(c[i] == '1') {
	    				sum += pow[j];
	    			}
	    			i++;
	    			j--;
	    		}
	    		sb.append((char)('a'+sum));
	    	}
	    		System.out.println(sb);
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
