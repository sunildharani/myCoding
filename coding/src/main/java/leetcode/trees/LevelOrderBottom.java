package leetcode.trees;

import java.util.ArrayList;
import java.util.List;

public class LevelOrderBottom {
	
	List<List<Integer>> result = new ArrayList<List<Integer>>();

	public List<List<Integer>> levelOrderBottom(TreeNode root) {
		List<TreeNode> children = new ArrayList<TreeNode>(); 
		children.add(root);
        levelorder(children);
        return result;
    }
	
	private List<List<Integer>> levelorder(List<TreeNode> nodes) {		
		if(nodes.isEmpty()) {
			return result;
		}
		List<TreeNode> children = new ArrayList<TreeNode>(); 
		List<Integer> ans = new ArrayList<Integer>();
		for(TreeNode node :  nodes) {
			if(node.left != null) {
				children.add(node.left);
			}
			if(node.right != null) {
				children.add(node.right);
			}			
			ans.add(node.val);
		}
		levelorder(children);
		result.add(ans);
		return result;
	}
	
}
