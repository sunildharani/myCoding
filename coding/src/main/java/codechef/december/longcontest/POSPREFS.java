package codechef.december.longcontest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class POSPREFS {

	public static void main(String[] args) {
		InputStream inputStream = System.in;
	    FastScanner in = new FastScanner(inputStream);
	    int tc = in.nextInt();
	    while(tc-- > 0) {
	    	int n = in.nextInt();
	    	int k = in.nextInt();
	    	int[] arr = new int[n];
	    	int k1 = 0;
	    	for(int i = 0; i< arr.length;i++) {
	    		arr[i] = i+1;
	    		if(arr[i] % 2 != 0) {
	    			arr[i] = -arr[i];
	    		}
	    	}
	    	arr[0] = 1;
	    	k1 = n/2 + 1;
	    	if(k1 > k) {
	    		for(int i = arr.length-1; i>= 0;i--) {
	    			if(arr[i] > 0) {
	    				arr[i] = -arr[i];
	    				k1--;
	    				if(k1 == k) {
	    					break;
	    				}
	    			}
	    		}
	    	}else if(k1 < k) {
	    		for(int i = arr.length-1; i>= 0;i--) {
	    			if(arr[i] <= 0) {
	    				arr[i] = -arr[i];
	    				k1++;
	    				if(k1 == k) {
	    					break;
	    				}
	    			}
	    		}
	    	}
	    	StringBuilder sb = new StringBuilder();
	    	for(int i = 0;i<n-1;i++) {
	    		sb.append(arr[i]+" ");
	    	}
	    	sb.append(arr[n-1]);
	    	System.out.println(sb);
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
