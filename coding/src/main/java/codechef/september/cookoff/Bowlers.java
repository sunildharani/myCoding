package codechef.september.cookoff;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Bowlers {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
	    int tc = scan.nextInt();
		while(tc > 0) {
			int overs = scan.nextInt();
			int players = scan.nextInt();
			int eachPlayer = scan.nextInt();
			if(overs > players * eachPlayer) {
				System.out.println(-1);
			}else if(overs > 1 && players == 1){
			    System.out.println(-1);    
			}else {
				StringBuffer sb = new StringBuffer();
				int i = 1;
				for(; i<= players  && i <= overs ;i++) {
					sb.append(i+" ");
				}
				int completed = players;
				while(completed * 2 <= overs) {
					sb.append(sb);
					completed += completed;
				}
				i = 1;
				while(completed < overs) {
					sb.append(i+" ");
					i++;
					completed++;
					if(i > players) {
						i = 1;
					}
				}
				sb.deleteCharAt(sb.length()-1);
				System.out.println(sb.toString());
			}
			tc--;
		}
		scan.close();	
	}
	
}
