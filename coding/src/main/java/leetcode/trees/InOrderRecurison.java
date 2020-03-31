package leetcode.trees;

import java.util.ArrayList;
import java.util.List;

public class InOrderRecurison {
	
	ArrayList<Integer> list = new ArrayList<Integer>()
	/**TODO **/
	public List<Integer> inorderTraversal(TreeNode root) {
		recursion(root);
		return list;
    }
	
	private void recursion(TreeNode root) {
		if(root == null) {
			return;
		}
		recursion(root.left);
		list.add(root.val);
		recursion(root.right);
	}
	
}
