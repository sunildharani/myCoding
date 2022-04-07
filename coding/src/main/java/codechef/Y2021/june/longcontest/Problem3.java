package codechef.Y2021.june.longcontest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;


public class Problem3 {

	public static void main(String[] args) {
		InputStream inputStream = System.in;
	    FastScanner in = new FastScanner(inputStream);
	    int tc = in.nextInt();
	    while(tc-- > 0) {
	    	int cities = in.nextInt();
	    	int travellers = in.nextInt();
	    	int[] fastesttime = new int[cities];
	    	int[] city = new int[cities];
	    	int[] members = new int[travellers];
	    	for(int i = 0;i<cities;i++) {
	    		city[i] = in.nextInt();
	    	}
	    	for(int i = 0;i<travellers;i++) {
	    		members[i] = in.nextInt();
	    	}
	    	fastesttime[0] = 0;
	    	int time = 0;
	    	int i = 0;
	    	while(i< cities && city[i] != 1) {
	    		fastesttime[i] = Integer.MAX_VALUE;
	    		i++;
	    	}
	    	for( ;i< cities;i++) {
	    		if(city[i] == 1) {
	    			time = 0;
	    		}else {
	    			time++;
	    		}
	    		fastesttime[i] = time;
	    	}
	    	time = 0;
	    	i = cities-1;
	    	while(i>= 0 && city[i] != 2) {
	    		i--;
	    	}
	    	for( ;i>= 0;i--) {
	    		if(city[i] == 2) {
	    			time = 0;
	    		}else {
	    			time++;
	    		}
	    		if(time < fastesttime[i]) {
	    			fastesttime[i] = time;
	    		}
	    	}
	    	StringBuilder sb = new StringBuilder(); 
	    	for(int j = 0; j<travellers;j++) {
	    		if(fastesttime[members[j]-1] != Integer.MAX_VALUE) {
	    			sb.append(fastesttime[members[j]-1]);
	    		}else {
	    			sb.append("-1");
	    		}
	    		if(j != travellers-1) {
	    			sb.append(" ");
	    		}
	    	}
	    	System.out.println(sb.toString());
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
