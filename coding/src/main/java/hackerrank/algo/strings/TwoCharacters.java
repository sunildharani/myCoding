package hackerrank.algo.strings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TwoCharacters {

	// Complete the alternate function below.
	static int alternate(String s) {
		if (s.length() == 1) {
			return 0;
		}
		int maxLength = 0;
		char[] c = s.toCharArray();
		if(c.length == 2 && c[0] != c[1]) {
			return 2;
		}
		int[] arr = new int[26];
		for (int i = 0; i < c.length ; i++) {
			arr[c[i] - 97]++;
		}
		int count = 0;
		for(int i = 0; i< 25;i++) {
			if(arr[i] == 0) {
				continue;
			}
			for(int j = i+1;j<26;j++) {
				if(arr[j] == 0) {
					continue;
				}
				if(arr[j] <= arr[i]+1 && arr[j] >= arr[i]-1){
					char firstchar = (char) (j+97);
					char secondchar = (char) (i+97);
					count = validateString(c,firstchar,secondchar);
					if(maxLength < count) {
						maxLength = count;
					}
					count = validateString(c,secondchar,firstchar);
					if(maxLength < count) {
						maxLength = count;
					}
				}
			}

		}
		return maxLength;
	}

	private static int validateString(char[] c, char firstchar, char secondchar) {
		boolean for1 = true;
		boolean possible = true;
		int droppedchars = 0;
		for (int i = 0; i < c.length; i++) {
			if(for1) {
				if (c[i] == secondchar) {
					possible = false;
					break;
				}
				if (c[i] != firstchar) {
					droppedchars++;
				}else {
					for1 = false;
				}
			}else {
				if (c[i] == firstchar) {
					possible = false;
					break;
				}
				if (c[i] != secondchar) {
					droppedchars++;
				}else {
					for1 = true;
				}
			}
		}
		if (possible) {
			return c.length - droppedchars;
		}
		return 0;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

		int l = Integer.parseInt(bufferedReader.readLine().trim());

		String s = bufferedReader.readLine();

		int result = alternate(s);

		System.out.println(result);
	}

}
