package leetcode.strings;

public class LengthOfLastWord {

	
	public int lengthOfLastWord(String s) {
		char[] c = s.toCharArray();
		int ans = 0;
		for(int i =c.length-1 ; i>=0;i--) {
			if(c[i] != ' ') {
				ans++;
			}else if(ans != 0){
				break;
			}
		}
		return ans;
    }

}
