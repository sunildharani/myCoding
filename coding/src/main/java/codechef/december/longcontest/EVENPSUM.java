package codechef.december.longcontest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.StringTokenizer;


public class EVENPSUM {

	public static void main(String[] args) {
		InputStream inputStream = System.in;
	    FastScanner in = new FastScanner(inputStream);
	    int tc = in.nextInt();
	    while(tc-- > 0) {
	    	int a = in.nextInt();
	    	int b = in.nextInt();
	        long ans = 0l;
	        ans += (a/2) * (b/2);
	        ans *= 2;
	        if(a % 2 != 0) {
	        	ans += b/2;
	        }
	        if(b % 2 != 0) {
	        	ans += a/2;
	        }
	        if( a %2 !=0 && b %2 != 0) {
	        	ans++;
	        }
	        
	        System.out.println(ans);
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
