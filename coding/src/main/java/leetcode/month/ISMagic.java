package leetcode.month;

import java.util.HashSet;

public class ISMagic {
	 public boolean isHappy(int n) {
		 HashSet<Integer> hs = new HashSet<Integer>();
		 int sum = 0;
		 while(true) {
			 int dig = n % 10;
			 sum += dig * dig;
			 n = n/10;
			 if(n == 0) {
				 if(!hs.add(sum)) {
					 return false;
				 }
				 if(sum == 1) {
					 return true;
				 }
				 n = sum;
				 sum = 0;
			 }
		 }
		 
	 }
	 
	 public static void main(String[] args) {
		 ISMagic isMagic = new ISMagic();
		 System.out.println(isMagic.isHappy(11)); 
	 }
}
