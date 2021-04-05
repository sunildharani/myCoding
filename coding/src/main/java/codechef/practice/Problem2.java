package codechef.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.StringTokenizer;


public class Problem2 {

	public static void main(String[] args) {
		InputStream inputStream = System.in;
	    FastScanner in = new FastScanner(inputStream);
	    int tc = in.nextInt();
	    while(tc-- > 0) {
	    	String line = in.next();
	    	char[] c = line.toCharArray();
	    	HashMap<Character,Integer> hm = new HashMap<Character,Integer>();
	    	for(int i =0 ;i < c.length;i++) {
	    		if(hm.containsKey(c[i])) {
	    			hm.put(c[i],hm.get(c[i])+1);
	    		}else {
	    			hm.put(c[i], 1);
	    		}
	    	}
	    	int evensum = 0;
	    	int oddcount = 0;
	    	for(Entry<Character,Integer> entry : hm.entrySet()) {
	    		if(entry.getValue() %2 == 0) {
	    			evensum += entry.getValue();
	    		}else {
	    			oddcount++;
	    			evensum += entry.getValue()-1;
	    			
	    		}
	    	}
	    	int evenpairs = evensum/2;
	    	
	    	int ans = 0;
	    	if(evenpairs > oddcount) {
	    		ans = oddcount;
	    		evenpairs -= oddcount;
	    		ans = ans +(evenpairs*2/3);
	    	}else {
	    		ans = evenpairs;
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
