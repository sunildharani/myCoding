package leetcode.month;

public class B2BSS {
	
	public int maxProfit(int[] prices) {
		int i = 0; int j = 1;
		int sum = 0;
		for(;i < prices.length && j < prices.length;) {
			int localsum = 0;
			if(prices[j] <= prices[i]) {
				i = j;
			}else {
				while(j < prices.length && prices[j] > prices[j-1]) {
					localsum = prices[j]-prices[i];
					j++;	
				}
				sum += localsum;
				i = j;
			}
			j++;
		}
		return sum;
    }

}
