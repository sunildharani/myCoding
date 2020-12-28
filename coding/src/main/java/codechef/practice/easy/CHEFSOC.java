package codechef.practice.easy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;



//a different version submitted in codechef which exceeded time limit
public class CHEFSOC {
	
	private static long count = 0l;
	
	private static HashMap<Integer,Long> hm= new HashMap<Integer,Long>();
	
	public static void main(String[] args) {
		InputStream inputStream = System.in;
	    FastScanner in = new FastScanner(inputStream);
	    int tc = in.nextInt();
	    int val = (int) (Math.pow(10, 9)) +7;
	    while(tc-- > 0) {
	    	int n = in.nextInt();
	    	int[] arr =new int[n];
	    	boolean[] vi = new boolean[n];
	    	for(int i = 0; i < n;i++) {
	    		arr[i] = in.nextInt();
	    	}
	    	getCount(0,arr,vi);
	    	System.out.println(hm.get(0) % val);
	    	hm = new HashMap<Integer,Long>();
	    	count = 0L;
	    }
	}
	
	private static long getCount(int i, int[] arr, boolean[] vi) {
		if(hm.containsKey(i)) {
			return hm.get(i);
		}
		vi[i] = true;
		int s = arr[i];
		long localcount = 1;
		if(i-1 >= 0) {
			if(!vi[i-1]) {
				localcount += getCount(i-1,arr,vi);
			}
		}if(i+1 <arr.length) {
			if(!vi[i+1]) {
				localcount += getCount(i+1,arr,vi);
			}
		}
		if(s == 2) {
			if(i-2 >= 0) {
				if(!vi[i-2]) {
					localcount += getCount(i-2,arr,vi);
				}
			}if(i+2 <arr.length) {
				if(!vi[i+2]) {
					localcount += getCount(i+2,arr,vi);
				}
			}
		}
		vi[i] = false;
		if(!hm.containsKey(i)) {
			hm.put(i, localcount);
		}
		return localcount;
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
