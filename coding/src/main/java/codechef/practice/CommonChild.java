package codechef.practice;

import java.io.IOException;
import java.util.Scanner;

public class CommonChild {

	static int commonChild(String s1, String s2) {
		int[][] arr = new int[s1.length()+1][s1.length()+1];
		for(int i = 0; i< s1.length();i++) {
			arr[i][0] = 0;
			arr[0][i] = 0;
		}
		char[] c1 = s1.toCharArray();
		char[] c2 = s2.toCharArray();
		for(int i = 0 ;i< c2.length;i++) {
			boolean found = false;
			for(int j = 0; j< c1.length;j++) {
				if(c1[j] == c2[i]) {
					arr[i+1][j+1] = arr[i][j]+1;
					found = true;
				}else if(found){
					arr[i+1][j+1] = arr[i+1][j];
				}else {
					arr[i+1][j+1] = arr[i+1][j]; 
				}
			}
		}
		return arr[s1.length()][s1.length()];

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        String s1 = scanner.nextLine();

        String s2 = scanner.nextLine();

        int result = commonChild(s1, s2);
        
        System.out.println(result);
        
        scanner.close();
    }
	
	
}
