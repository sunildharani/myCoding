package codechef.Y2021.december.longcontest;

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
	    while(tc -- > 0) {
	    	long totalsum = 0l;
	    	int n = in.nextInt();
	    	int layers = n/4;
	    	if(layers >= 1) {
	    		totalsum = (long) (layers-1) * 36;
	    		totalsum += 60;
	    	}
	    	int rem = n % 4;
	    	if(rem == 1) {
	    		totalsum += 20;
	    		if(layers >= 1) {
	    			totalsum -= 6;
	    		}
	    	}else if(rem == 2) {
	    		totalsum += 36;
	    		if(layers >= 1) {
	    			totalsum -= 12;
	    		}
	    	}else if(rem == 3) {
	    		totalsum += 51;
	    		if(layers >= 1) {
	    			totalsum -= 18;
	    		}
	    	}
	    	System.out.println(totalsum);
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
