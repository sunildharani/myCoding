package hackerrank.algo.strings;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    static HashNode root = null;
    static HashMap<Integer,Long> factorials = null;
    
    public static void initialize(String s) {
        char[] c = s.toCharArray();
        Queue<HashNode> qu = new LinkedList<HashNode>();
        for(int i = 0;i < c.length;i++) {
            HashNode h = new HashNode(i+1, i+1);
            h.hm.put(c[i], 1);
            qu.add(h);
        }
        root = buildSegmentTree(qu);
        factorials = new HashMap<Integer,Long>();
        factorials.put(1, 1L);
        factorials.put(0, 1L);

    }

    /*
     * Complete the 'answerQuery' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER l
     *  2. INTEGER r
     */

    public static int answerQuery(int l, int r) {
        HashMap<Character,Integer> hm = retriveCharacterCount(l,r,root);
        long a = calculateMaxPalindrome(hm);
        int ans = (int) (a % ((long)Math.pow(10, 9)+7));
        return ans;
    }
    
    private static long calculateMaxPalindrome(HashMap<Character, Integer> hm) {
        int evensum = 0;
        int oddcount = 0;
        long denomprod = 1l;
        for(Map.Entry<Character,Integer> entry : hm.entrySet()) {
            int val = entry.getValue();
            if(val %2 != 0) {
                val--;
                oddcount++;
            }
            evensum += val;
            if(!factorials.containsKey(val)) {
                long ans = calculatefactorial(val);
                factorials.put(val, ans);
            }
            denomprod  = denomprod * factorials.get(val);
        }
        long numprod = 1l;
        int initial = evensum;
        while(evensum >= initial/2) {
            numprod = numprod * evensum;
            evensum--;
        }
        if(oddcount != 0) {
            numprod = numprod * oddcount;
        }
        return numprod/denomprod;
    }

    private static long calculatefactorial(int val) {
        long ans = 1l;
        if(factorials.containsKey(val)) {
            return val;
        }else{
            ans = val * calculatefactorial(val-1);
        }
        return ans;
    }

    private static HashMap<Character,Integer> retriveCharacterCount(int a, int b, HashNode root) {
        if(a == root.i && b == root.j) {
            return root.hm;
        }
        if(a >= root.left.i && b <= root.left.j) {
            return retriveCharacterCount(a,b,root.left);
        }
        if(a >= root.right.i && b <= root.right.j) {
            return retriveCharacterCount(a,b,root.right);
        }
        HashMap<Character,Integer> hm = retriveCharacterCount(a,root.left.j,root.left);
        HashMap<Character,Integer> hm2 = retriveCharacterCount(root.right.i,b,root.right);
        for(Map.Entry<Character,Integer> entry : hm2.entrySet()) {
            if(hm.containsKey(entry.getKey())) {
                hm.put(entry.getKey(),entry.getValue()+hm.get(entry.getKey()));
            }else {
                hm.put(entry.getKey(),entry.getValue());
            }
        }
        return hm;
    }

    private static HashNode buildSegmentTree(Queue<HashNode> qu) {
        if(qu.isEmpty()) {
            return null;
        }
        
        if(qu.size() == 1) {
            return qu.poll();
        }
        Queue<HashNode> quNew = new LinkedList<HashNode>();
        while(!qu.isEmpty()) {
            if(qu.size() == 1) {
                quNew.add(qu.poll());
                break;
            }
            HashNode firstNode = qu.poll();
            HashNode secondNode = qu.poll();
            HashNode h = new HashNode(firstNode.i, secondNode.j);
            h.left  = firstNode;
            h.right = secondNode;
            h.hm.putAll(firstNode.hm);
            for(Map.Entry<Character,Integer> entry : secondNode.hm.entrySet()) {
                if(h.hm.containsKey(entry.getKey())) {
                    h.hm.put(entry.getKey(),entry.getValue()+h.hm.get(entry.getKey()));
                }else {
                    h.hm.put(entry.getKey(),entry.getValue());
                }
            }
            quNew.add(h);
            if(qu.isEmpty()) {
                qu = quNew;
            }
        }
        return quNew.poll();
    }

}

class HashNode{
    int i;
    int j;
    HashNode left;
    HashNode right;
    HashMap<Character,Integer> hm;
    
    HashNode(int i ,int j){
        this.i = i;
        this.j = j;
        hm = new HashMap<Character,Integer>();
    }
    
    
}


public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        Result.initialize(s);

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, q).forEach(qItr -> {
            try {
                String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

                int l = Integer.parseInt(firstMultipleInput[0]);

                int r = Integer.parseInt(firstMultipleInput[1]);

                int result = Result.answerQuery(l, r);

                bufferedWriter.write(String.valueOf(result));
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
