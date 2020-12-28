package codechef.Y2020.january.longcontest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BRKBKS {

	public static void main(String[] args) {
		InputStream inputStream = System.in;
	    FastScanner in = new FastScanner(inputStream);
	    int tc = in.nextInt();
	    while(tc-- > 0) {
	    	int s = in.nextInt();
	    	int w1 = in.nextInt();
	    	int w2 = in.nextInt();
	    	int w3 = in.nextInt();
	    	if(w1+w2+w3 <= s) {
	    		System.out.println(1);
	    	}else if(w1+w2 <= s){
	    		System.out.println(2);
	    	}else if(w2+w3 <=s) {
	    		System.out.println(2);
	    	}else {
	    		System.out.println(3);
	    	}
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
