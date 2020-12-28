package leetcode.month.october.week1;

import java.util.ArrayList;

public class NumberOfRecentCalls {

	public static void main(String[] args) {
		NumberOfRecentCalls.RecentCounter rc = new NumberOfRecentCalls().new RecentCounter();
		rc.ping(1);
		rc.ping(100);
		rc.ping(3001);
		rc.ping(3002);
	}
	
	class RecentCounter {
		 ArrayList<Integer> time;
		    
		    public RecentCounter() {
		        this.time = new ArrayList<Integer>();
		    }
		    
		    public int ping(int t) {
		        time.add(t);
		        int i = time.size()-1;
		        int res = 1;
		        if(i-1 >= 0 && t-time.get(i-1) <=3000 && t-time.get(i-1) >=0){
		            res++;
		            i--;
		        }
		        return res;
		    }
	}

}
