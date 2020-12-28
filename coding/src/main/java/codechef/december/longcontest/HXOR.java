package codechef.december.longcontest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class HXOR {

	public static void main(String[] args) {
		InputStream inputStream = System.in;
	    FastScanner in = new FastScanner(inputStream);
	    int tc = in.nextInt();
	    while(tc-- > 0) {
	    	int n = in.nextInt();
	    	int x = in.nextInt();
	    	int[] arr = new int[n];
	    	int[] pow2 = new int[33];
	    	for(int i = 0;i < 32;i++) {
	    		pow2[i] = (int) Math.pow(2, i);
	    	}
	    	pow2[32] = Integer.MAX_VALUE; 
	    	PriorityQueue<Integer>[] ll = new PriorityQueue[33];
	    	for(int i= 0; i< 32;i++) {
	    		ll[i] = new PriorityQueue<Integer>();
	    	}
	    	for(int i = 0 ;i < n;i++) {
	    		arr[i] = in.nextInt();
	    		int num = arr[i];
	    		int count = 0;
	    		while(num > 0) {
	    			num = num/2;
	    			count++;
	    		}
	    		ll[count].add(arr[i]);
	    	}
	    	
	    	while(x-- > 0) {
	    		int highestposition = -1;
	    		int lowestindex = n;
	    		for(int i = 0; i < 31;i++) {
	    			if(!ll[i].isEmpty()) {
	    				int index = ll[i].poll();
	    				if(index <= lowestindex) {
	    					lowestindex = index;
	    					highestposition = i;
	    				}
	    			}
	    		}
	    		
	    		if(lowestindex < n) {
	    			if(ll[highestposition].size() == 1) {
	    				int j = ll[highestposition].poll();
	    				if(lowestindex != n-1) {
	    					arr[j] =  arr[j] ^ pow2[highestposition];
	    					int num = arr[n-1];
	    		    		int count = 0;
	    		    		while(num > 0) {
	    		    			num = num/2;
	    		    			count++;
	    		    		}
	    		    		ll[count].remove(arr[j]);
	    					arr[n-1] = arr[n-1] ^ pow2[highestposition];
	    				}else {
	    					arr[n-2] = 1;
	    					arr[n-1] = arr[n-1] ^ 1;
	    					break;
	    				}
	    			}else {
	    				int j = ll[highestposition].poll();
	    				arr[j]  =  arr[j] ^ pow2[highestposition];
	    				j = ll[highestposition].poll();
	    				arr[j]  =  arr[j] ^ pow2[highestposition];
	    			}
	    		}else {
	    			x++;
	    			break;
	    		}
	    		
	    	}
	    	if(x > 0 && x %2 != 0) {
	    		arr[n-2] = arr[n-2] ^ 1;
	    		arr[n-1] = arr[n-1] ^ 1;  		
	    	}
	    	StringBuilder sb = new StringBuilder();
	    	for(int i= 0; i< arr.length-1;i++) {
    			sb.append(arr[i]+" ");
    		}
	    	sb.append(arr[arr.length-1]);
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
