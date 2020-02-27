package leetcode.linkedlist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class NextGreaterNode {

	public static void main(String[] args) {

	}

	
	 public int[] nextLargerNodes(ListNode head) {
		  ListNode dupHead = head;
		  int length = 0;
		  while(head != null) {
			  length++;
			  head = head.next;
		  }
		  head = dupHead;
		  int[] ans = new int[length];
		  if(head == null) {
			  return ans;
		  }
		  ArrayList<ListNode> al = new ArrayList<ListNode>();	  
		  al.add(head);
		  int index = 1;
		  int answerindex = 0;
	      head = head.next;
	      while(head != null) {
	        	al.add(head);
	        	while(answerindex >= 0 && al.get(answerindex).val < head.val) {
	        		if(answerindex == 0) {
	        			ans[answerindex] = head.val;
	        		}
	        		answerindex = answerindex-1;
	        	}
	        	answerindex = index;
	        	index++;
	        	head = head.next;
	      }
	      return ans;
	 }
	
}
