package leetcode.trees;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class PreOrderTraversalRecursion {
	
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>(Arrays.asList(1,null,2,3));
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
		preorderTraversal(root);
		
	}
	
	  public static List<Integer> preorderTraversal(TreeNode root) {
	        Stack<TreeNode> st = new Stack<TreeNode>();
	        ArrayList<Integer> al = new ArrayList<Integer>();
	        if(root == null) {
	        	return al;
	        }
	        st.add(root);
	        while(!st.isEmpty()) {
	        	TreeNode data = st.pop();      
	        	al.add(data.val);
	        	if(data.right != null) {
	        		st.push(data.right);
	        	}
	        	if(data.left != null) {	
	        		st.push(data.left);
	        	}
	        }
	        return al;
	  }

}
