package codechef.december.longcontest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;


public class VACCINE1 {
	
	public static void main(String[] args) {
		InputStream inputStream = System.in;
	    OutputStream outputStream = System.out;
	    FastScanner in = new FastScanner(inputStream);
	    int d1 = in.nextInt();
	    int n1 = in.nextInt();
	    int d2 = in.nextInt();
	    int n2 = in.nextInt();
	    int total = in.nextInt();
	    int sum = 0;
	    int days = d1 <= d2 ? d1 :d2;
	    days--;
	    while(d1 < d2) {
	    	sum += n1;
	    	d1++;
	    	days++;
	    	if(sum >= total) {
	    		break;
	    	}
	    }
	    while(d2 < d1 && sum < total) {
	    	sum += n2;
	    	d2++;
	    	days++;
	    	if(sum >= total) {
	    		break;
	    	}
	    }
	    if(sum < total) {
	    	total -= sum;
	    	days = days + (total/(n1+n2));
	    	if(total % (n1+n2) != 0) {
	    		days++;
	    	}
		}
	    System.out.println(days);
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
