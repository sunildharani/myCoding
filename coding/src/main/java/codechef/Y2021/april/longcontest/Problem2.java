package codechef.Y2021.april.longcontest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.MathContext;
import java.util.StringTokenizer;


public class Problem2 {

	public static void main(String[] args) {
		InputStream inputStream = System.in;
	    FastScanner in = new FastScanner(inputStream);
	    int tc = in.nextInt();
	    while(tc-- > 0) {
	    	BigDecimal k1 = new BigDecimal(in.next());
		    BigDecimal k2 = new BigDecimal(in.next());
		    BigDecimal k3 = new BigDecimal(in.next());
		    BigDecimal v = new BigDecimal(in.next());
		    BigDecimal speed = k1.multiply(k2).multiply(k3).multiply(v);
		    MathContext mc = new MathContext(3);
		    BigDecimal timetaken = new BigDecimal(100).divide(speed, 2, BigDecimal.ROUND_HALF_UP);
		    BigDecimal record = new BigDecimal(9.58).setScale(2,BigDecimal.ROUND_HALF_UP);
		    if(timetaken.min(record).equals(record)){
		    	System.out.println("NO");
		    }else {
		    	System.out.println("YES");
		    }
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
