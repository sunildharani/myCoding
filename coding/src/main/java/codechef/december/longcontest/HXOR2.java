package codechef.december.longcontest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class HXOR2 {

		public static void main(String[] args) {
			InputStream inputStream = System.in;
		    FastScanner in = new FastScanner(inputStream);
		    int[] pow2 = new int[32];
	    	for(int i = 0;i < 32;i++) {
	    		pow2[i] = (int) Math.pow(2, i);
	    	}
		    int tc = in.nextInt();
		    while(tc-- > 0) {
		    	int n = in.nextInt();
		    	int x = in.nextInt();
		    	int[] arr = new int[n];
		    	List<Stack<Integer>> li = new ArrayList<Stack<Integer>>();
		    	for(int i = 0 ;i < n;i++) {
		    		arr[i] = in.nextInt();
		    		li.add(new Stack<Integer>());
		    		for(int j = 0; j< 32;j++) {
		    			if((arr[i] >= pow2[j]) && (arr[i] & pow2[j]) > 0) {
		    				li.get(i).add(j);
		    			}
		    		}
		    	}
		    	
		    	int[] powcount = new int[32];
		    	int i = 0;
		    	for(; i < n-1;i++) {
		    		if(x == 0) {
		    			break;
		    		}
		    		if(arr[i] == 0) {
		    			continue;
		    		}
	    			if(x >= li.get(i).size()) {
	    				x  = x-li.get(i).size();
	    				Stack<Integer> st  = li.get(i);
	    				while(!st.isEmpty()) {
	    					powcount[st.pop()]++;
	    				}
	    				arr[i] = 0;
	    			}else {
	    				Stack<Integer> st  = li.get(i);
	    				while(x-- > 0) {
	    					int m = st.pop();
	    					powcount[m]++;
	    					arr[i] = arr[i] ^ pow2[m];
	    				}
	    				break;
	    			}
		    	}
		    	
		    	for(int j = i;j < n;j++) {
		    		Stack<Integer> st  = li.get(j);
		    		while(!st.isEmpty()) {
		    			int m = st.pop();
		    			if(powcount[m] > 0) {
		    				arr[j] = arr[j] ^ pow2[m];
		    				powcount[m]--;
		    			}
		    		}
		    	}
		    	for(int j = 0 ;j < 32;j++) {
		    		if(powcount[j] %2 != 0) {
		    			arr[n-1] = arr[n-1] ^ pow2[j];
		    		}
		    	}
		    			    	
		    	if(x > 0 && x %2 != 0) {
		    		int j  = 0;
		    		for(; j< n-1;j++) {
		    			if(arr[j] > 0) {
		    				break;
		    			}
		    		}
		    		if(j == n-1) {
		    			arr[n-2] = arr[n-2] ^ 1;
		    			arr[n-1] = arr[n-1] ^ 1;
		    		}else {
		    			int hi = -1;
		    			int num = arr[j];
		    			while(num > 0) {
		    				num = num/2;
		    				hi++;
		    			}
		    			arr[j] = arr[j] ^ pow2[hi];
		    			arr[n-1] = arr[n-1] ^ pow2[hi];
		    		}
		    	}
		    	StringBuilder sb = new StringBuilder();
		    	for(int j= 0; j< arr.length-1;j++) {
	    			sb.append(arr[j]+" ");
	    		}
		    	sb.append(arr[arr.length-1]);
		    	System.out.println(sb);
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

