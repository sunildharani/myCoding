package codechef.december.longcontest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.StringTokenizer;

import codechef.december.longcontest.VACCINE1.FastScanner;

public class VACCINE2 {

	public static void main(String[] args) {
		InputStream inputStream = System.in;
	    FastScanner in = new FastScanner(inputStream);
	    int tc = in.nextInt();
	    while(tc-- > 0) {
	    	int n = in.nextInt();
	    	int perday = in.nextInt();
	    	int riskgroup = 0;
	    	int group = 0;
	    	while(n-- > 0) {
	    		int a = in.nextInt();
	    		if(a >= 80 || a <=9) {
	    			riskgroup++;
	    		}else {
	    			group++;
	    		}
	    	}
	    	int ans = riskgroup/perday;
	    	if(riskgroup % perday != 0) {
	    		ans++;
	    	}
	    	ans += group/perday;
	    	if(group % perday != 0) {
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
