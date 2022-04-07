package codechef.practice.easy;

import java.io.*;
import java.util.HashSet;
import java.util.StringTokenizer;

public class SEDMAX {
    public static void main(String[] args) throws Exception {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        FastScanner in = new FastScanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        int tc = in.nextInt();
        while(tc-- > 0) {
            HashSet<Integer> set = new HashSet();
            int n = in.nextInt();
            int[] arr = new int[n];
            for(int i =0;i<n;i++){
                arr[i] = in.nextInt();
            }
            int previousFirstIndex = 0;
            int previousSecondIndex = 0;
            for(int i=0;i<n-1;i++){
                int firstLargest = arr[i];
                int firstLargestIndex = i;
                int secondLargest = arr[i+1];
                int secondLargestIndex = i+1;
                if(firstLargest < secondLargest){
                    firstLargest = secondLargest;
                    secondLargest = arr[i];
                    secondLargestIndex = i;
                    firstLargestIndex=i+1;
                }
                boolean found = true;
                set.add(firstLargest-secondLargest);
                for(int j =i+2;j<n;j++){
                    if(j >= previousFirstIndex && j >= previousSecondIndex){
                        found = false;
                        break;
                    }
                    if(arr[j] >= firstLargest){
                        secondLargest = firstLargest;
                        secondLargestIndex = firstLargestIndex;
                        firstLargest = arr[j];
                        firstLargestIndex = j;
                    }else if(arr[j] >= secondLargest){
                        secondLargest = arr[j];
                        secondLargestIndex = j;
                    }
                    set.add(firstLargest-secondLargest);
                }
                if(!found) {
                    previousFirstIndex = firstLargestIndex;
                    previousSecondIndex = secondLargestIndex;
                }
            }
            System.out.println(set.size());
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
