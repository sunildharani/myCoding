package leetcode.month.october.week1;

import java.util.HashMap;

public class BuddyStrings {

	public static void main(String[] args) {
		BuddyStrings bd = new BuddyStrings();
		System.out.println(bd.buddyStrings("abc", "acb"));
	}
	
	public boolean buddyStrings(String A, String B) {
        if(A.length() != B.length()){
            return false;
        }
        char[] a = A.toCharArray();
        char[] b = B.toCharArray();
        int mark = -1;
        int j = 0;
        HashMap<Character,Integer> hm = new HashMap<Character,Integer>();
        boolean duplicate = false;
        for(int i = 0;i < a.length;i++){
            if(hm.containsKey(a[i])){
                duplicate = true;
            }else{
                hm.put(a[i],1);
            }
            if(a[i] != b[j]){
                if(mark == -1){
                    mark = i;
                }else if(mark == -2){
                    return false;
                }else{
                    if(a[mark] == b[j] && b[mark] == a[i]){
                        mark = -2;
                    }else{
                        return false;
                    }
                }
            }
            j++;
        }
        if(mark > -1){
            return false;
        }
        if(mark == -1 && ! duplicate){
            return false;
        }
        return true;
    }
}
