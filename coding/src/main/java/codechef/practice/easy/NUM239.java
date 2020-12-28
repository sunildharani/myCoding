package codechef.practice.easy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import codechef.practice.easy.BUYING2.FastScanner;

public class NUM239 {

	public static void main(String[] args) {
		InputStream inputStream = System.in;
	    OutputStream outputStream = System.out;
	    FastScanner in = new FastScanner(inputStream);
	    PrintWriter out = new PrintWriter(outputStream);
	    int tc = in.nextInt();
	    while(tc-- > 0){
	    	int count = 0;
	    	int left = in.nextInt();
	    	int right = in.nextInt();
	    	while(left % 10 != 0) {
	    		int a = left % 10;
	    		if(a == 2 || a== 3 || a ==9 ) {
	    			count++;
	    		}
	    		left++;
	    	}
	    	while(right % 10 != 0) {
	    		int a = right % 10;
	    		if(a == 2 || a== 3 || a ==9 ) {
	    			count++;
	    		}
	    		right--;
	    	}
	    	count += ((right-left)/10)*3;
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
