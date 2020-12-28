package hackerrank.algo.strings;

public class CaesarCipher {

	static String caesarCipher(String s, int k) {
        char[] arr = s.toCharArray();
        k = k % 26;
        if(k == 0){
            return s;
        }
        for(int i = 0; i< arr.length;i++){     
            if(arr[i] >= 'a' && arr[i] <= 'z') {
            	char ans = (char) (arr[i] + k);
            	if(ans > 'z'){
            		ans = (char)('a' + ans - 'z'-1);
            	}
            	arr[i] = ans;
            }
            if(arr[i] >='A' && arr[i] <= 'Z') {
            	char ans = (char) (arr[i] + k);
            	if(ans > 'Z') {
            		ans = (char) ('A' + ans - 'Z'-1);
            	}
            	arr[i] = ans;
            }
        }
        return new String(arr);

    }
	
	public static void main(String[] args) {
		String s = caesarCipher("middle-Outz",2);
		System.out.println(s);
	}
	
}
