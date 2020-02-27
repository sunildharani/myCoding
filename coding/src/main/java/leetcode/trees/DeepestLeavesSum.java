package leetcode.trees;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class DeepestLeavesSum {

	int maxHeight = 0;
	int sum = 0;
	int count = 0;
	
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5,null,6,7,null,null,null,null,8));
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
		DeepestLeavesSum dls = new DeepestLeavesSum();
		System.out.println(dls.deepestLeavesSum(root));

	}

	 public int deepestLeavesSum(TreeNode root) {
	       if(root == null) {
	    	   return 0;
	       }
	       getheight(root);
	       return sum;
	 }
	 
	 public void getheight(TreeNode root) {
		 if(root  == null) {
			 return;
		 }
		 count++;
		 getheight(root.left);
		 getheight(root.right);
		 if(count == maxHeight) {
			 sum += root.val;
		 }
		 if(count > maxHeight) {
			 sum = root.val;
			 maxHeight = count;
		 }		 
		 count--;
	 }
	 
	 
	
}
