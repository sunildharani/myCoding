package codechef.Y2021.february.longcontest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
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
	    	String line = in.next();
	    	String[] funny  = line.split(" ");
	    	HashMap<String,Integer> hm = new HashMap<String,Integer>();
	    	for(int i = 0;i<n;i++) {
	    		hm.put(funny[i], 1);
	    	}
	    	long count = 0;
	    	for(int i = 0 ;i<n;i++) {
	    		char[] first = funny[i].toCharArray(); 
	    		char temp = first[0];
	    		HashMap<Character,Integer> testedfalse = new HashMap<Character,Integer>();
	    		for(int j = i+1;j<n;j++) {
	    			boolean possible = true;
	    			char[] second = funny[j].toCharArray();
	    			if(testedfalse.containsKey(second[0])) {
	    				continue;
	    			}
	    			first[0] = second[0];
	    			second[0] = temp;
	    			if(hm.containsKey(new String(first))) {
	    				testedfalse.put(first[0], 1);
	    				possible = false;
	    			}
	    			if(hm.containsKey(new String(second))) {
	    				possible = false;
	    			}
	    			if(possible) {
	    				count++;
	    			}
	    		}
	    	}
	    	
			System.out.println(count*2);
	    }
	    
	}


	static class FastScanner {
        private BufferedReader bufferedReader;
        private StringTokenizer stringTokenizer;

        public FastScanner(InputStream inputStream) {
            bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        }

        public String next() {
                try {
                    return bufferedReader.readLine();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return "";
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
