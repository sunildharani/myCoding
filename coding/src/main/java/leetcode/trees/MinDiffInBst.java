package leetcode.trees;

public class MinDiffInBst {

	public int minDiffInBST(TreeNode root) {
		if(root == null) {
			return 0;
		}
		return minDiff(root);
	}
	
	public int minDiff(TreeNode root) {
		if(root == null) {
			return Integer.MAX_VALUE;
		}
		int leftval = Integer.MAX_VALUE;
		if(root.left != null) {
			if(root.left.right != null) {
				leftval = Math.min(root.val-root.left.right.val,minDiff(root.left));
			}else {
				leftval = Math.min(root.val-root.left.val,minDiff(root.left));
			}
		}
		int rightval = Integer.MAX_VALUE;
		if(root.right != null) {
			if(root.right.left!=null) {
				rightval = Math.min(root.right.left.val-root.val,minDiff(root.right));
			}else {
				rightval = Math.min(root.right.val-root.val,minDiff(root.right));
			}
		}
		return Math.min(leftval, rightval);
		
	}
	

}
