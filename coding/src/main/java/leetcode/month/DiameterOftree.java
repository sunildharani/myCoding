package leetcode.month;

public class DiameterOftree {
	
	  int maxdepth = 0;
		
		public int diameterOfBinaryTree(TreeNode root) {
	        if(root == null){
	            return 0;
	        }
			heightoftree(root);
	        return maxdepth-1;
	    }
	    
	    public int heightoftree(TreeNode root){
	        if(root == null) {
				return 0;
			}
			int leftdepth =  1+heightoftree(root.left);
			int rightdepth = 1+heightoftree(root.right);
			if(maxdepth < leftdepth+rightdepth-1) {
				maxdepth = leftdepth+rightdepth-1;
			}
			return Math.max(leftdepth, rightdepth);
	    }
}


class TreeNode {
	 int val;
	 TreeNode left;
	 TreeNode right;
	 TreeNode(int x) { val = x; }
}