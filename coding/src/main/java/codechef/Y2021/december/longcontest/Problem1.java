package codechef.Y2021.december.longcontest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Problem1 {

	public static void main(String[] args) {
		InputStream inputStream = System.in;
	    FastScanner in = new FastScanner(inputStream);
	    int tc = in.nextInt();
        while(tc-- > 0){
            String a = in.next();
            String b = in.next();
            String c = in.next();
            String[] arr = new String[]{a,b,c};
            String x = in.next();
            String y = in.next();
            int ans = 2;
            for(int i =0;i<arr.length;i++){
                if(ans > i && (arr[i].equals(x) || arr[i].equals(y))) {
                    ans = i;
                }
            }
            System.out.println(arr[ans]);
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
