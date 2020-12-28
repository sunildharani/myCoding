package leetcode.month.october.week1;

import java.util.Arrays;
import java.util.HashMap;

public class RemoveDuplicateLetters {

	public static void main(String[] args) {
		RemoveDuplicateLetters rdl = new RemoveDuplicateLetters();
		System.out.println(rdl.removeDuplicateLetters("dcbc"));

	}
	
	public String removeDuplicateLetters(String s) {
        int[] loc = new int[26];
        char[] ch = s.toCharArray(); 
        int count = 0;
        Arrays.fill(loc,-1);
        for(int i = 0; i< s.length();i++){
            if(loc[ch[i]-97] != 1){
                count++;
            }
            loc[ch[i]-97] = 1;
        }
        char[] al = new char[count];
        int j = 0;
        HashMap<Character,Integer> pos = new  HashMap<Character,Integer>();
        for(int i = 0; i< loc.length;i++) {
        	if(loc[i] == 1) {
        		al[j] = (char) (97+i); 
        		pos.put((char) (97+i), j);
        		j++;
        	}
        }
        
        
        int[] res = new int[count];
        Arrays.fill(res,-1);
        res[pos.get(ch[0])] = 0;
        for(int i = 1; i <s.length();i++){
        	if(res[pos.get(ch[i])] == -1){
                res[pos.get(ch[i])] = i;
            }else if(pos.get(ch[i]) > 0 && res[pos.get(ch[i])-1] >  res[pos.get(ch[i])] ){
                res[pos.get(ch[i])] = i;
            }
        }
        char[] ans = new char[ch.length];
        Arrays.fill(ans,',');
        int k = 0;
        for(int i = 0;i < ch.length;i++){
            if(loc[i] == 1){
                ans[res[k]] = (char)(97+i);
                k++;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i<ans.length;i++){
            if(ans[i] != ','){
                sb.append(ans[i]);
            }
        }
        return sb.toString();
    }

}
