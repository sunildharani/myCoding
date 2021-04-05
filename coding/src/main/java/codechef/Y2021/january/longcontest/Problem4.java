package codechef.Y2021.january.longcontest;

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
	    while(tc-- > 0) {
	    	int n = in.nextInt();
	    	int k = in.nextInt();
	    	int x = in.nextInt();
	    	int y = in.nextInt();
	    	int c = y-x;
	    	int[] ans = new int[8];
	    	if(y > x) {
	    		ans[1] = n;
	    		ans[0] = n-c;
	    		c = ans[0]+ans[1];
	    		ans[2] = n;
	    		ans[3] = -ans[0]+c;
	    		c = ans[3]-ans[2];
	    		ans[5] = 0;
	    		ans[4] = -c;
	    		c=ans[4]+ans[5];
	    		ans[6] = 0;
	    		ans[7] = c;
	    	}else if(y < x) {
	    		ans[0] = n;
	    		ans[1] = n+c;
	    		c = ans[0]+ans[1];
	    		ans[3] = n;
	    		ans[2] = c-ans[3];
	    		c = ans[3]-ans[2];
	    		ans[4] = 0;
	    		ans[5] = c;
	    		c = ans[4]+ans[5];
	    		ans[7] = 0;
	    		ans[6] = c;
	    	}else {
	    		System.out.println(5+" "+5);
	    		continue;
	    	}
	    	k = k % 4;
	    	k = (2*k)-2;
	    	System.out.println(ans[k]+" "+ans[k+1]);
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
