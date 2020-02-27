package leetcode.trees;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BalancedBinaryTree {

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>(Arrays.asList(1,2,2,3,3,null,null,4,4));
		Queue<TreeNode> qu = new LinkedList<TreeNode>();
		TreeNode root = null;
		for(int i = 0; i< list.size();i++) {
			if(qu.isEmpty()) {
				qu.add(new TreeNode(list.get(i)));
				root = qu.peek();
				i++;
			}
			if(qu.peek().left == null && i < list.size()) {
				if(list.get(i) != null){
					qu.peek().left = new TreeNode(list.get(i));
					qu.add(qu.peek().left);
				}
				i++;
			}
			if(qu.peek().right == null && i < list.size()) {
				if(list.get(i) != null){
					qu.peek().right = new TreeNode(list.get(i));
					qu.add(qu.peek().right);
				}
				qu.poll();
			}
		}
		System.out.println(isBalanced(root));
		
	}
	
	 public static boolean isBalanced(TreeNode root) {
		int val = heightofTree(root);
		if(val == -1) {
			return false;
		}
		return true;
	 }
	
	 public static int heightofTree(TreeNode root) {
		 if(root == null) {
			 return 0;
		 }	
	 
		 int leftheight = heightofTree(root.left);
		 int rightheight = heightofTree(root.right);
		 if(leftheight == -1) {
			 return -1;
		 }
		 if(rightheight == -1) {
			 return -1;
		 }
		 if(Math.abs(leftheight -rightheight) > 1) {
			 return -1;
		 }
		 return 1+Math.max(leftheight, rightheight);
		 
	 }
	 
}

class TreeNode {
	     int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	  }