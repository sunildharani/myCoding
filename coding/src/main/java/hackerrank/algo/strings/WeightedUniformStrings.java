package hackerrank.algo.strings;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.Scanner;

public class WeightedUniformStrings {

	static String[] weightedUniformStrings(String s, int[] queries) {
        HashMap<Integer,Integer> hm = new HashMap<Integer,Integer>();
        char[] c = s.toCharArray();
        char init = c[0];
        int j = 0;
        for(int i = 1;i <c.length;i++){
            if(c[i] != init){
                int val = (int) (init-'a'+1);
                int k = 2;
                while(j < i){
                    hm.put(val,1);
                    val = (init-'a'+1)*k;
                    k++;
                    j++;
                }
                init = c[i];
                j=i;
            }
        }
        int val = (int) (init-'a'+1);
        int k = 2;
        while(j < c.length){
            hm.put(val,1);
            val = (init-'a')*k;
            j++;
        }
        String[] arr = new String[queries.length];
        for(int i =0 ;i < queries.length;i++){
            if(hm.containsKey(queries[i])){
                arr[i] = "Yes";
            }else{
                arr[i] = "No";
            }
        }
        return arr;

    }
	
	private static final Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {

        String s = scanner.nextLine();

        int queriesCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] queries = new int[queriesCount];

        for (int i = 0; i < queriesCount; i++) {
       //     int queriesItem = scanner.nextInt();
       //     scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        //    queries[i] = queriesItem;
        }

      //  String[] result = weightedUniformStrings(s, queries);
        superReducedString(s);

        scanner.close();
	}
	
	static String superReducedString(String s) {
        char[] c = s.toCharArray();
        int i = 0;
        int j = 1;
        while(j < c.length){
            if(c[i] == c[j]){
                c[i] = c[j] = ' ';
                i--;
                while(i >=0 ) {
                	if(c[i] != ' ') {
                		break;
                	}
                	i--;
                }
                if(i < 0){
                    i = j+1;
                    j = i+1;
                }else{
                    j++;
                }
            }else{
                i = j;
                j = i+1;
            }
        }
       
        StringBuilder sb = new StringBuilder();
        for(int k = 0; k< c.length;k++){
            if(c[k] != ' '){
                sb.append(c[k]);
            }
        }
        if(sb.length() == 0){
            return "Empty String";
        }
        return sb.toString(); 

    }
	
}
