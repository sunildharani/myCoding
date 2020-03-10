package leetcode.trees;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class IsValidBST {

	/** TODO **/
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>(
				Arrays.asList(10,5,15,null,null,6,20));
		Queue<TreeNode> qu = new LinkedList<TreeNode>();
		TreeNode root = null;
		for (int i = 0; i < list.size(); i++) {
			if (qu.isEmpty()) {
				qu.add(new TreeNode(list.get(i)));
				root = qu.peek();
				i++;
			}
			if (qu.peek().left == null && i < list.size()) {
				if (list.get(i) != null) {
					qu.peek().left = new TreeNode(list.get(i));
					qu.add(qu.peek().left);
				}
				i++;
			}
			if (qu.peek().right == null && i < list.size()) {
				if (list.get(i) != null) {
					qu.peek().right = new TreeNode(list.get(i));
					qu.add(qu.peek().right);
				}
				qu.poll();
			}
		}
		System.out.println(isValidBST(root));
	}

	public static boolean isValidBST(TreeNode root) {
		if (root == null) {
			return true;
		}
		return isValid(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	public static boolean isValid(TreeNode node, int min, int max) {
		if (node == null) {
			return true;
		}
		
		if(min >=node.val || max <= node.val) {
			return false;
		}
		
		return isValid(node.left,min,node.val) && isValid(node.right,node.val,max);
		
	}
	
	
	
	

}
