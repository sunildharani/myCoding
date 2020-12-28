package codechef.december.cookoff;

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
	    	String line = in.next();
	    	char[] arr = line.toCharArray();
	    	if(arr.length %2 == 0) {
	    		int[] co = new int[2];
	    		for(int i = 0; i< arr.length;i++) {
	    			if(arr[i] == '0') {
	    				co[0]++;
	    			}else {
	    				co[1]++;
	    			}
	    		}
	    		if(co[0] == co[1]) {
	    			System.out.println(0);
	    			continue;
	    		}
	    		int ans = Math.abs(co[0]-co[1])/2;
	    		int pairs = 0;
	    		for(int i = 0,j=1; i< arr.length& j < arr.length;) {
	    			if((arr[i] == '0' && arr[j] == '1') || (arr[i] == '1' && arr[j] == '0')) {
	    				pairs++;
	    				i--;
	    				j++;
	    				if(i < 0) {
	    					i = j;
	    					j++;
	    				}
	    			}
	    			i++;
	    			j++;
	    		}
	    		if(pairs >= ans) {
	    			System.out.println(ans);
	    		}else {
	    			System.out.println(-1);
	    		}
	    	}else {
	    		System.out.println(-1);
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
