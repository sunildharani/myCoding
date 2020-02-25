package leetcode.linkedlist;

public class MergeKLinkedLists {

	public static void main(String[] args) {
		ListNode[] listnodes = new ListNode[5];
		ListNode head = new ListNode(1);
		head.next = new ListNode(1);
		ListNode head1 = new ListNode(2);
		head1.next = new ListNode(4);
		ListNode head2 = new ListNode(3);
		head2.next = new ListNode(6);
		ListNode head3 = new ListNode(4);
		head3.next = new ListNode(4);
		ListNode head4 = new ListNode(5);
		head4.next = new ListNode(8);
		listnodes[0] = head;
		listnodes[1] = head1;
		listnodes[2] = head2;
		listnodes[3] = head3;
		listnodes[4] = head4;
		mergeKLists(listnodes);

	}

	public static ListNode mergeKLists(ListNode[] lists) {
		if(lists.length == 0) {
			return null;
		}
        int small = Integer.MAX_VALUE;
        int indexvalue = 0;
        ListNode head = null;
        ListNode headDup = null;
        boolean atleatoneelement = true;
        while(atleatoneelement) {
        	atleatoneelement = false;
        	for(int i = 0 ;i< lists.length;i++) {
        		if(lists[i] != null) {
        			atleatoneelement = true;
        			if(small > lists[i].val) {
        				small = lists[i].val;
        				indexvalue = i;
        			}
        		}
        	}
        	if(!atleatoneelement) {
        		if(head != null){
        		    head.next = null;
                }
        		break;
        	}
        	if(head == null) {
        	   head = lists[indexvalue];
        	   headDup = head;
            }else {
               head.next = lists[indexvalue];
               head = head.next;
            }
        	lists[indexvalue] = lists[indexvalue].next;
        	small = Integer.MAX_VALUE;
        }
    
        return headDup;
    }
}

