package hackerrank.algo.strings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;

public class MaximumPalindromes {
	
	static HashMap<Integer,BigDecimal> factorials;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		char[] c = line.toCharArray();
		Queue<HashNode> qu = new LinkedList<HashNode>();
		for(int i = 0;i < c.length;i++) {
			HashNode h = new HashNode(i+1, i+1);
			h.hm.put(c[i], 1);
			qu.add(h);
		}
		HashNode root = buildSegmentTree(qu);
		factorials = new HashMap<Integer,BigDecimal>();
		factorials.put(1, BigDecimal.ONE);
		factorials.put(0, BigDecimal.ONE);
		int tc = Integer.parseInt(br.readLine());
		while(tc-- > 0) {
			line = br.readLine();
			String[] l = line.split(" ");
			int a = Integer.parseInt(l[0]);
			int b = Integer.parseInt(l[1]);
			HashMap<Character,Integer> hm = retriveCharacterCount(a,b,root);
			long ans = calculateMaxPalindrome(hm).longValue();
			ans = ans % ((long)Math.pow(10, 9)+7);
			System.out.println(ans);
		}
		br.close();
	}

	private static BigDecimal calculateMaxPalindrome(HashMap<Character, Integer> hm) {
		 int evensum = 0;
	        int oddcount = 0;
	        BigDecimal denomprod = BigDecimal.ONE;
	        for(Map.Entry<Character,Integer> entry : hm.entrySet()) {
	            int val = entry.getValue();
	            if(val %2 != 0) {
	                val--;
	                oddcount++;
	            }
	            evensum += val;
	            if(!factorials.containsKey(val/2)) {
	            	BigDecimal ans = calculatefactorial(val/2);
	                factorials.put(val/2, ans);
	            }
	            denomprod  = denomprod.multiply(factorials.get(val/2));
	        }
	        BigDecimal numprod = calculatefactorial(evensum/2);
	        if(oddcount != 0) {
	            numprod = numprod.multiply(new BigDecimal(oddcount));
	        }
	        if(evensum == 0) {
	        	return new BigDecimal(oddcount);
	        }
	        return numprod.divide(denomprod);
	}
	
	 private static BigDecimal calculatefactorial(int val) {
	        BigDecimal ans = BigDecimal.ONE;
	        if(factorials.containsKey(val)) {
	            return factorials.get(val);
	        }else{
	            ans = new BigDecimal(val).multiply(calculatefactorial(val-1));
	        }
	        return ans;
	    }

	private static HashMap<Character,Integer> retriveCharacterCount(int a, int b, HashNode root) {
		HashMap<Character,Integer> an = new HashMap<Character,Integer>();
		if(a == root.i && b == root.j) {
			an.putAll(root.hm);
			return an;
		}
		if(a >= root.left.i && b <= root.left.j) {
			return retriveCharacterCount(a,b,root.left);
		}
		if(a >= root.right.i && b <= root.right.j) {
			return retriveCharacterCount(a,b,root.right);
		}
		HashMap<Character,Integer> hm = retriveCharacterCount(a,root.left.j,root.left);
		HashMap<Character,Integer> hm2 = retriveCharacterCount(root.right.i,b,root.right);
		for(Entry<Character,Integer> entry : hm2.entrySet()) {
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
				if(quNew.size() == 1) {
					break;
				}else {
					qu = quNew;
					quNew = new LinkedList<HashNode>();
					continue;
				}
			}
			HashNode firstNode = qu.poll();
			HashNode secondNode = qu.poll();
			HashNode h = new HashNode(firstNode.i, secondNode.j);
			h.left  = firstNode;
			h.right = secondNode;
			h.hm.putAll(firstNode.hm);
			for(Entry<Character,Integer> entry : secondNode.hm.entrySet()) {
				if(h.hm.containsKey(entry.getKey())) {
					h.hm.put(entry.getKey(),entry.getValue()+h.hm.get(entry.getKey()));
				}else {
					h.hm.put(entry.getKey(),entry.getValue());
				}
			}
			quNew.add(h);
			if(qu.isEmpty()) {
				qu = quNew;
				quNew = new LinkedList<HashNode>();
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
