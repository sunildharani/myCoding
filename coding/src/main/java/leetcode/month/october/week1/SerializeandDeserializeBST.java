package leetcode.month.october.week1;

import java.util.Stack;

public class SerializeandDeserializeBST {

	public static void main(String[] args) {
		TreeNode t1 = new TreeNode(2);
		t1.left = new TreeNode(1);
		t1.left.right = new TreeNode(3);
		t1.right = new TreeNode(4);
		String ans = serialize(t1);
		System.out.println(ans);
		TreeNode res = deSerialize(ans);
		System.out.println(serialize(res));
		
	}
	
	public static String serialize(TreeNode t) {
		StringBuilder ans = new StringBuilder();
		depthFirst(t,ans);
		return ans.toString();
	}
	
	public static void depthFirst(TreeNode t,StringBuilder sb) {
		if(t == null) {
			sb.append(-1+",");
			return;
		}
		sb.append((char)t.val);
		depthFirst(t.left,sb);
		depthFirst(t.right,sb);
	}
	
	public static TreeNode deSerialize(String s) {
		
		String[] ans = s.split(",");
		if(ans[0].equals("-1")) {
			return null;
		}
		TreeNode root = new TreeNode(Integer.parseInt(ans[0]));
		Stack<TreeNode> st = new Stack<TreeNode>();
		st.add(root);
		boolean left = true;
		for(int i = 1; i< ans.length;i++) {
			int a = Integer.parseInt(ans[i]);
			if(a == -1) {
				if(left) {
					left = false;
				}else {
					st.pop();
				}
			}else {
				if(left) {
					st.peek().left = new TreeNode(a);
					st.push(st.peek().left);
				}else {
					TreeNode temp = new TreeNode(a);
					st.pop().right = temp;
					st.push(temp);
					left = true;
				}
			}
		}
		return root;
	}

}

class TreeNode {
	 int val;
	 TreeNode left;
	 TreeNode right;
	 TreeNode(int x) { val = x; }
}
