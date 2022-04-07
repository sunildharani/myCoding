package hackerrank.algo.recursion;

import java.util.HashMap;

public class PowerSum {

    private static HashMap<Integer,Integer> hm = new HashMap<>();

    public static void main(String[] args){
        int X = 100;
        int y = 2;
        hm.put(1,1);
    }

    public static int powerSum(int X, int N) {
        if(hm.containsKey(X)){
            return hm.get(X);
        }
        int i = 1;
        while(X-(int) Math.pow(i,N) >=1){
            powerSum(X-(int) Math.pow(i,N),N);
            i++;
        }
        return 1;
    }


}
