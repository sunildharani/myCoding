package leetcode.linkedlist;

public class RotateRight {
	
	public static void main(String[] args) {
		
	}

	
	 public ListNode rotateRight(ListNode head, int k) {
		 	if(k == 0 || head == null) {
		 		return head;
		 	}
	        int length = 0;
	        ListNode dupHead = head;
	        while(head != null) {
	        	head = head.next;
	        	length++;
	        }
	        if(k >= length) {
	        	k = k % length;
	        }
	        ListNode parent = new ListNode(0);
	        head = dupHead;
	        int i = 0;
	        while(i < (length-k)) {
	        	parent = head;
	        	head = head.next;
	        	i++;
	        }
	        while(head.next != null) {
	        	head = head.next;
	        }
	        head.next = dupHead;
	        head = parent.next;
	        parent.next = null;
	        return head;
	 }
	
}
