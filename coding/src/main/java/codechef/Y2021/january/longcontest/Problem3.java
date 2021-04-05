package codechef.Y2021.january.longcontest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Problem3 {

	public static void main(String[] args) {
		InputStream inputStream = System.in;
	    FastScanner in = new FastScanner(inputStream);
	    int tc = in.nextInt();
	    while(tc-- > 0) {
	    	int n = in.nextInt();
	    	int m = in .nextInt();
	    	int[] arr1 = new int[n];
	    	int[] arr2 = new int[m];
	    	long sum1 = 0;
	    	long sum2 = 0;
	    	for(int i = 0; i<n;i++) {
	    		arr1[i] = in.nextInt();
	    		sum1 += arr1[i];
	    	}
	    	for(int i = 0; i< m;i++) {
	    		arr2[i] = in.nextInt();
	    		sum2 += arr2[i];
	    	}
	    	long count = 0;
	    	long diff = sum2-sum1;
	    	if(diff >=0) {
	    		Arrays.sort(arr1);
	    		Arrays.sort(arr2);
	    		int i = 0;
	    		int j = m-1;
	    		while(i < n && j > 0) {
	    			if(arr1[i] < arr2[j]) {
	    				count++;
	    				diff  = diff+2*(arr1[i]-arr2[j]);;
	    				if(diff < 0) {
	    					break;
	    				}
	    				i++;
	    				j--;
	    			}
	    		}
	    	}
	    	if(diff >= 0) {
	    		System.out.println(-1);
	    	}else {
	    		System.out.println(count);
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
