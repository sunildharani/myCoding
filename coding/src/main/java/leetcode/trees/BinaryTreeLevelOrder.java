package leetcode.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		Queue<TreeNode> q1 = new LinkedList<TreeNode>();
		Queue<TreeNode> q2 = new LinkedList<TreeNode>();
		if(root == null) {
			return null;
		}
		q1.add(root);
		List<Integer> level = new ArrayList<Integer>();
		while(!q1.isEmpty()) {
			TreeNode node = q1.poll();
			level.add(node.val);
			if(node.left != null) {
				q2.add(node.left);
			}
			if(node.right != null) {
				q2.add(node.right);
			}
			if(q1.isEmpty()) {
				q1 = q2;
				q2 = new LinkedList<TreeNode>();
				result.add(level);
				level = new ArrayList<Integer>();
			}
		}
		return result;
    }

	
}
