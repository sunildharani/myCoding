package codechef.Y2021.february.longcontest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Problem2 {

	public static void main(String[] args) {
		InputStream inputStream = System.in;
	    FastScanner in = new FastScanner(inputStream);
	    int tc = in.nextInt();
	    while(tc-- > 0) {
	    	int n = in.nextInt();
	    	int[] arr = new int[n];
	    	for(int i = 0; i< n;i++) {
	    		arr[i] = in.nextInt();
	    	}
	    	long smallestNumber = Long.MAX_VALUE;
	    	long largestNumber = Long.MIN_VALUE;
	    	long secondsmallest = Long.MAX_VALUE;
	    	long secondLargest = Long.MIN_VALUE;
	    	long ans1 = 0;
	    	for(int i =0 ; i<n;i++) {
	    		if(arr[i] >= secondLargest) {
	    			if(arr[i] >= largestNumber) {
	    				secondLargest = largestNumber;
	    				largestNumber = arr[i];
	    			}else {
	    				secondLargest = arr[i];
	    			}
	    		}
	    		if(arr[i] <= secondsmallest) {
	    			if(arr[i] <= smallestNumber) {
	    				secondsmallest = smallestNumber;
	    				smallestNumber = arr[i];
	    			}else {
	    				secondsmallest = arr[i];
	    			}
	    		}
	    	}
	    	ans1 += Math.abs(largestNumber-smallestNumber);
	    	ans1 += Math.abs(secondLargest-largestNumber);
	    	ans1 += Math.abs(smallestNumber-secondLargest);
	    	long ans2 = Math.abs(largestNumber-smallestNumber);;
	    	ans2 += Math.abs(secondsmallest-largestNumber);
	    	ans2 += Math.abs(smallestNumber-secondsmallest);
	    	if(ans1 > ans2) {
	    		System.out.println(ans1);
	    	}else {
	    		System.out.println(ans2);
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
