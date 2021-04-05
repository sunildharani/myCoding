package leetcode.implementation;

import java.util.ArrayList;

public class MinStackMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	
	class MinStack{
		ArrayList<MinStackObject> al;
		public MinStack() {
			al = new ArrayList<MinStackObject>();
	    }
	    
	    public void push(int x) {
	    	MinStackObject obj = new MinStackObject();
	    	obj.i = x;
	    	if(al.size() > 0) {
	    		int min = al.get(al.size()-1).min;
	    		if(min < x) {
	    			obj.min = min;
	    		}else {
	    			obj.min = x; 
	    		}
	    	}
	    	al.add(obj);
	    }
	    
	    public void pop() {
	        al.remove(al.size()-1);
	    }
	    
	    public int top() {
	        return al.get(al.size()-1).i;
	    }
	    
	    public int getMin() {
	        return al.get(al.size()-1).min;
	    }
	}
	
	class MinStackObject{
		int i;
		int min;
	}

}
