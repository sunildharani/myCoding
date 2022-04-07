package codechef.Y2021.december.longcontest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.MathContext;
import java.util.HashMap;
import java.util.StringTokenizer;


public class Problem2 {

	public static void main(String[] args) {
		InputStream inputStream = System.in;
	    FastScanner in = new FastScanner(inputStream);
	    int tc = in.nextInt();
	    while(tc-- > 0) {
	    	int n = in.nextInt();
			HashMap<Integer,Integer> hm = new HashMap<>();
			int maxValue = 0;
			for(int i =0;i<n;i++){
				int x = in.nextInt();
				if(hm.containsKey(x)){
					hm.put(x,hm.get(x)+1);
					if(maxValue < hm.get(x)){
						maxValue = hm.get(x);
					}
				}else{
					hm.put(x,1);
				}
			}
			if(n == 1 || maxValue == n){
				System.out.println(0);
			}else if(maxValue == 0){
				System.out.println(-1);
			}else{
				System.out.println(n-maxValue+1);
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
