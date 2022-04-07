package leetcode.trees;

public class SumRootToLeaf {

	int sum = 0;
	 public int sumRootToLeaf(TreeNode root) {
		 if(root == null)
			 return 0;
		 int num = 0;
		 num = sumRootToLeaf(root.left);
		 int leftnum = num >> root.val;
		 num = sumRootToLeaf(root.right);
		 int rightnum = num >> root.val;
		 sum += leftnum+rightnum;
		 return sum;
	 }
	 

	
	 
	 
	
}
