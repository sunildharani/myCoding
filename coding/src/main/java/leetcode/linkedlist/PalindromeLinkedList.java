package leetcode.linkedlist;

public class PalindromeLinkedList {
	
	static ListNode mainhead = null;

	public static void main(String[] args) {
		ListNode head = new ListNode(3);
		head.next = new ListNode(2);
		head.next.next = new ListNode(2);
		head.next.next.next = new ListNode(3);
		mainhead = head;
		System.out.println(isPalindrome(head,head));

	}
	
	public static boolean isPalindrome(ListNode head,ListNode tail) {
		if(tail.next == null) {
			if(head.val == tail.val) {
	        	return true;
	        }else {
	        	return false;
	        }
		}
		
        boolean val =  isPalindrome(head,tail.next); 
        mainhead = mainhead.next;
        if(mainhead.next == tail) {
			return mainhead.val == tail.val;
		}else if (mainhead == tail) {
			return true;
		}else {
			return val && mainhead.val == tail.val; 
		}
    }

}
