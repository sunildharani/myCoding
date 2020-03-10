package leetcode.trees;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class InOrderTraversal {
	
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>(Arrays.asList(1,2,2,3,3,null,null,4,5));
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
		inorderTraversal(root);
		
	}
	
	public static List<Integer> inorderTraversal(TreeNode root) {
		Stack<TreeNode> st = new Stack<TreeNode>();
		st.add(root);
		ArrayList<Integer> result = new ArrayList<Integer>();
		while(!st.isEmpty()) {
			while(!st.isEmpty() && st.peek().left != null) {
				st.add(st.peek().left);
			}
			result.add(st.peek().val);
			System.out.println(st.peek().val);
			TreeNode node = st.pop();
			if(node.right != null) {
				st.add(node.right);
			}
		}
		return result;
	}
	
	
}
