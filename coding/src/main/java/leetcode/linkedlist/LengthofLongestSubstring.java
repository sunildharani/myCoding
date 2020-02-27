package leetcode.linkedlist;

import java.util.HashMap;

public class LengthofLongestSubstring {
	
	public static void main(String[] args) {
		System.out.println(lengthOfLongestSubstring("cdd"));
	}
	
	public static int lengthOfLongestSubstring(String s) {
		HashMap<Character,Integer> hm = new HashMap<Character,Integer>();
        char[] ch = s.toCharArray();
        int length = 1;
        hm.put(ch[0], 0);
        int lastindexofrepeatedcharacter = -1;
        int i = 1;
        for(;i<ch.length;i++) {
        	if(hm.containsKey(ch[i])) {
        		int val = hm.get(ch[i]);
        		val = Math.max(lastindexofrepeatedcharacter, val);
        		if(i-val > length)
        			length = i - val; 
        		lastindexofrepeatedcharacter = val;
        	}
        	hm.put(ch[i],i);
        }        
        if(i - lastindexofrepeatedcharacter-1 > length) {
        	return i - lastindexofrepeatedcharacter-1;
        }
        return length;
    }

}
