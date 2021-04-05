package codechef.Y2021.january.longcontest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;


public class Problem5 {

	static ArrayList<Object[]> towers = null;
	
	public static void main(String[] args) {
		InputStream inputStream = System.in;
	    FastScanner in = new FastScanner(inputStream);
	    int tc = in.nextInt();
	    while(tc-- > 0) {
	    	int n = in.nextInt();
	    	int k = in.nextInt();
	    	towers = new ArrayList<Object[]>();
	    	int[] arr = new int[n];
	    	for(int i =0; i< arr.length;i++) {
	    		arr[i] = in.nextInt();
	    	}
	    	Arrays.sort(arr);
	    	
			/*
			 * Stack<Integer> st = new Stack<Integer>(); calculateblocks(0,arr,st,k,0);
			 * st.add(m); sum = arr[i]+calculateblocks(m,arr,st,k,sum); if(sum == k) {
			 * Object[] ar = new Object[st.size()]; st.copyInto(ar); towers.add(ar); } sum
			 * -= arr[st.pop()];
			 */
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
