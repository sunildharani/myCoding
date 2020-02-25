package leetcode.linkedlist;

import java.util.List;

public class RemoveNthNodeFromEnd {

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
	//	head.next.next = new ListNode(3);
	//	head.next.next.next = new ListNode(4);
		ListNode dup = removeNthFromEnd(head,1);
		while(dup!= null) {
			System.out.println(dup.val);
			dup = dup.next;
		}
	}
	
	public static ListNode removeNthFromEnd(ListNode head, int n) {
		if(head == null ||n == 0) {
			return head;
		}

		ListNode second = head;
		for(int i =0;i < n;i++) {
			second = second.next;
		}
		ListNode parent = null;
		while(second != null) {
			second = second.next;
			if(parent == null) {
				parent = head;
			}else {
				parent = parent.next;
			}
			
		}
		if(parent == null) {
			return head.next;
		}
		if(n == 1) {
			parent.next = null;
		}else {
			parent.next = parent.next.next;
		}
		return head;
    }
}


class ListNode {
	     int val;
	      ListNode next;
	      ListNode(int x) { val = x; }
	  }