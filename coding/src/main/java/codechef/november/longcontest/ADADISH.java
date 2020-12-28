package codechef.november.longcontest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;


public class ADADISH {

	static int mindiff = 0;
	public static void main(String[] args) throws Exception {
		InputStream inputStream = System.in;
	    OutputStream outputStream = System.out;
	    FastScanner in = new FastScanner(inputStream);
	    PrintWriter out = new PrintWriter(outputStream);
	    int tc = in.nextInt();
		while(tc-- > 0) {
			int n = in.nextInt();
			int[] arr = new int[n];
			int sum = 0;
			for(int i = 0 ;i < n;i++) {
				arr[i] = in.nextInt();
				sum += arr[i];
			}
			if(sum % 2 != 0) {
				sum++;
			}
			sum = sum/2;
			mindiff = sum;
			calculateTime(arr,0,sum);
			out.println(sum+mindiff);
			
		}
		out.close();
		in.close();
	}
	
	
	private static int calculateTime(int[] arr, int i,int sum) {
		if(i > arr.length) {
			return 0 ;
		}
		int a = 0;
		for(; i< arr.length;i++) {
			a = arr[i] + calculateTime(arr,i+1,sum);
			if(Math.abs(sum-a) < mindiff) {
				mindiff = Math.abs(sum-a);
			}
		}
		return a;
		
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
