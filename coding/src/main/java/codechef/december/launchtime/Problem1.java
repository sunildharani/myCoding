package codechef.december.launchtime;

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
	    	int l = in.nextInt();
	    	String line = in.next();
	    	char[] c = line.toCharArray(); 
	    	String p = in.next();
	    	char[] b = p.toCharArray();
	    	int cones = 0;
	    	int czeros = 0;
	    	int pones = 0;
	    	int pzeros = 0;
	    	for(int i =0 ; i< c.length;i++) {
	    		if(c[i] == '0') {
	    			czeros++;
	    		}else {
	    			cones++;
	    		}
	    	}
	    	for(int i =0 ; i< b.length;i++) {
	    		if(b[i] == '0') {
	    			pzeros++;
	    		}else {
	    			pones++;
	    		}
	    	}
	    	if(cones == pones && czeros == pzeros) {
	    		System.out.println("Yes");
	    	}else {
	    		System.out.println("No");
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
