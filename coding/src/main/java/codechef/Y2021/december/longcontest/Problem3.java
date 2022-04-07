package codechef.Y2021.december.longcontest;

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
	  	    String line = in.next();
	  	    char[] c= line.toCharArray();
	  	    boolean found = false;
	  	    for(int i = 0;i < c.length;i++) {
	  	    	int count = 0;
	  	    	while(i < c.length && c[i] == '*') {
	  	    		count++;
	  	    		i++;
	  	    	}
	  	    	if(count >= k) {
	  	    		found = true;
	  	    		break;
	  	    	}
	  	    }
	  	    if(found) {
	  	    	System.out.println("YES");
	  	    }else {
	  	    	System.out.println("NO");
	  	    }
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
