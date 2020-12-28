package codechef.practice.easy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Stack;
import java.util.StringTokenizer;

import codechef.practice.easy.NUM239.FastScanner;

public class PUMPWAT {

	public static void main(String[] args) {
		InputStream inputStream = System.in;
	    OutputStream outputStream = System.out;
	    FastScanner in = new FastScanner(inputStream);
	    PrintWriter out = new PrintWriter(outputStream);
	    int tc = in.nextInt();
	    while(tc-- > 0){
	    	int n =  in.nextInt();
	    	Stack<Integer> index = new Stack<Integer>();
	    	int[] arr = new int[n];
	    	int i = 0;
	    	int max = 0;
	    	while(n-- > 0) {
	    		arr[i] = in.nextInt();
	    		if(max <arr[i]) {
	    			max = arr[i];
	    		}
	    		i++;
	    	}
	    	out.println(calculateReservoirsRequired(arr,0,arr.length-1));
	    }
	    out.close();
	    in.close();
	}

	private static int calculateReservoirsRequired(int[] arr, int left, int right) {
		if(left == right) {
			return 1;
		}
		int maxIndex = left;
		for(int i= left;i <= right;i++){
			if(arr[maxIndex] < arr[i]) {
				maxIndex = i;
			}
		}
		if(maxIndex == left || maxIndex == right) {
			return 1;
		}
		return 1+Math.min(calculateReservoirsRequired(arr, left,maxIndex-1),calculateReservoirsRequired(arr,maxIndex+1,right));
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
