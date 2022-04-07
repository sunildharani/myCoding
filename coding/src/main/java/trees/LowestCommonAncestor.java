package trees;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class LowestCommonAncestor {

    static Node ans ;
    public static void main(String[] args){
        Node head = new Node(1);
        head.left = new Node(2);
        head.right = new Node(3);
        head.right.left = new Node(4);
        head.right.right = new Node(5);
        find(head,1,5);
        System.out.println(ans.data);
    }

    private static boolean find(Node head, int i,int j) {
        if (head == null) {
            return false;
        }
        if (head.data == i || head.data == j) {
            return true;
        }
        if (find(head.right, i, j)) {
                ans = head;
                return true;
        }
        return false;
    }

}

class Node {
    int data;
    Node left;
    Node right;

    Node(int i){
        this.data = i;
    }
}
