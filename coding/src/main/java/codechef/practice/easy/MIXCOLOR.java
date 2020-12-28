package codechef.practice.easy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.StringTokenizer;

import codechef.practice.easy.NUM239.FastScanner;

public class MIXCOLOR {
	
	public static void main(String[] args) {
		InputStream inputStream = System.in;
	    OutputStream outputStream = System.out;
	    FastScanner in = new FastScanner(inputStream);
	    PrintWriter out = new PrintWriter(outputStream);
	    int tc = in.nextInt();
	    while(tc-- > 0){
	    	int n = in.nextInt();
	    	HashSet<Integer> hs = new HashSet<Integer>();
	    	int count = 0;
	    	while(n-- > 0) {
	    		if(!hs.add(in.nextInt())) {
	    			count++;
	    		}
	    	}
	    	out.println(count);
	    }
	    out.close();
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
