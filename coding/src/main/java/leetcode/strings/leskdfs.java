package leetcode.strings;

public class leskdfs {

	public static void main(String[] args) {
		StringBuilder abc = new StringBuilder("sadjas");
		System.out.println(abc.deleteCharAt(-1));
		String ans = deleteCharat(abc.toString().toCharArray(),'8');
		System.out.println(ans);
	}
	
	private static String deleteCharat(char[] ch,char a){
		boolean found = false;
		for(int i = ch.length-1;i >=0;i--) {
			if(ch[i] == a) {
				found = true;
				for(int j = i;j<ch.length-1;j++) {
					ch[j] = ch[j+1];
				}
				break;
			}
		}
		if(found) {
			return new String(ch,0,ch.length-1);
		}
			return new String(ch);
	}

}
