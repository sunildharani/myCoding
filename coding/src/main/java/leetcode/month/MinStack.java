package leetcode.month;

public class MinStack {

    int i;
    int min = Integer.MAX_VALUE;
    MinStack next;
    
    /** initialize your data structure here. */
    public MinStack() {
        
    }
    
    public void push(int x) {
        MinStack temp = new MinStack();
        temp.i = i;
        temp.min = min;
        temp.next = next;
        this.next = temp;
        this.min = Math.min(temp.min,x);
        this.i = x;
    }
    
    public void pop() {
        if(next != null){
            this.i = next.i;
            this.min = next.min;
            this.next = next.next;
        }else{
            this.i = 0;
            this.next = null;
            this.min = 0;
        }
    }
    
    public int top() {
        return this.i;
    }
    
    public int getMin() {
        return this.min;
    }
    
    public static void main(String[] args) {
    	MinStack obj = new MinStack();
    	 obj.push(-2);
    	 obj.push(0);
    	 obj.push(-3);
    	 System.out.println(obj.getMin());
    	 obj.pop();
    	 obj.top();
    	 System.out.println(obj.getMin());
    }
	//["MinStack","push","push","push","getMin","pop","top","getMin"]
}
