package codechef.Y2021.may.longcontest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;



public class Problem1 {

	public static void main(String[] args) {
		InputStream inputStream = System.in;
	    FastScanner in = new FastScanner(inputStream);
	    int tc = in.nextInt();
	    while(tc-- > 0) {
	    	int x = in.nextInt();
	    	int a = in.nextInt();
	    	int b = in.nextInt();
	    	int dissolve = 10 * (((100-x) * b) + a);
	    	System.out.println(dissolve);
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
