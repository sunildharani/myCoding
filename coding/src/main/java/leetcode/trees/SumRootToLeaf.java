package leetcode.trees;

public class SumRootToLeaf {

	int sum = 0;
	 public int sumRootToLeaf(TreeNode root) {
		 if(root == null)
			 return 0;
		 int num = 0;
		 num = sumRoottoLeaf(root.left);
		 int leftnum = num >> root.val;
		 num = sumRoottoLeaf(root.right);
		 int rightnum = num >> root.val;
		 sum += leftnum+rightnum;
		 
	 }
	 
	 public static int sumRoot(TreeNode root,int num) {
		 return sumRoot(root.left) >> root.val;
	 }
	
	 
	 
	
}
