package leetcode.month.october.week1;

import java.util.Collections;
import java.util.Comparator;

public class SortList {

	public static void main(String[] args) {
		ListNode head = new ListNode(2);
		SortList sl = new SortList();
		sl.mergeList(head,null);
	}
	
	public void mergeList(ListNode head, ListNode tail) {
		if(head == tail || head == null) {
			return;
		}
		ListNode mid = findmid(head,tail);
		mergeList(head,mid);
		mergeList(mid.next,tail);
		merge(head,mid,tail);
	}

	private void merge(ListNode head, ListNode mid, ListNode tail) {
		ListNode head1 = head;
		ListNode head2 = mid.next;
		Collections.sort(list, new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return 0;
			}
			
		});
		
	}

	private ListNode findmid(ListNode head, ListNode tail) {
		if(head == null || head.next == null) {
			return head;
		}
		ListNode slow = head;
		ListNode fast = head.next;
		while(fast != tail && fast.next != tail) {
			slow = slow.next;
			fast = fast.next.next;
		}
		slow.next = null;
		return slow;
	}
		
}

class ListNode {
	 int val;
	 ListNode next;
	 ListNode() {}
	 ListNode(int val) { this.val = val; }
	 ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
