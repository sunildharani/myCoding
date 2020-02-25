package leetcode.linkedlist;

public class MergKLinkedListsOptimized {

	public static void main(String[] args) {
		ListNode[] listnodes = new ListNode[2];
		ListNode head = new ListNode(1);
		head.next = new ListNode(1);
		ListNode head1 = new ListNode(2);
		head1.next = new ListNode(4);
		listnodes[0] = head;
		listnodes[1] = head1;
		mergeKLists(listnodes);
		for(int i =0;i< listnodes.length;i++){
            System.out.println(listnodes[i]);
        }
	}

	public static ListNode mergeKLists(ListNode[] lists) {
		MergeTwoSortedLists mt = new MergeTwoSortedLists();
		int n = lists.length;
		if(n % 2 == 1) {
			n = n-1;
		}
		while(n > 1) {
			for(int i = 0; i<= n/2;i++) {
				lists[i] = mt.mergeTwoLists(lists[i], lists[n-i-1]);
				lists[n-i-1] = null;
			}
			n = n/2;
		}
		if(lists.length % 2 == 1) {
			lists[0] = mt.mergeTwoLists(lists[0], lists[lists.length-1]);
		}
		return lists[0];
	}
}
