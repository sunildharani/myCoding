package codechef.practice.easy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class BUYING2 {

	public static void main(String[] args) throws Exception {
		InputStream inputStream = System.in;
	    OutputStream outputStream = System.out;
	    FastScanner in = new FastScanner(inputStream);
	    PrintWriter out = new PrintWriter(outputStream);
	    int tc = in.nextInt();
		while(tc-- > 0) {
			int noofnotes = in.nextInt();
			int cost = in.nextInt();
			int[] arr = new int[noofnotes];
			int sum = 0;
			for(int i =0 ;i < noofnotes;i++) {
				arr[i] = in.nextInt();
				sum += arr[i];
			}
			int ans = sum/cost;
			int rem = sum % cost;
			for(int i= 0; i< noofnotes;i++) {
				if(arr[i] <= rem) {
					ans = -1;
					break;
				}
			}
			out.println(ans);
		}
		in.close();
		out.close();
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
