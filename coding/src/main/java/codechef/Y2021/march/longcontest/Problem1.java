package codechef.Y2021.march.longcontest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Problem1 {

	public static void main(String[] args) {
		InputStream inputStream = System.in;
	    FastScanner in = new FastScanner(inputStream);
	    int tc = in .nextInt();
	    while(tc-- > 0) {
	    	String line = in.next();
	    	char[] arr = line.toCharArray();
	    	int groups = 0;
	    	int i = 0;
	    	while(i < arr.length) {
	    		if(arr[i] == '1') {
	    			groups++;
	    			i++;
	    			while(i < arr.length && arr[i] == '1') {
	    				i++;
	    			}
	    		}else {
	    			i++;
	    		}
	    	}
	    	System.out.println(groups);
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
