package leetcode.trees;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RemoveLeafNodes {
	
	ArrayList<TreeNode> list = new ArrayList<TreeNode>();
	TreeNode parent = null;

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>(Arrays.asList(1,3,3,3,2));
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
		RemoveLeafNodes dls = new RemoveLeafNodes();
		dls.getLeafNodes(root,3);
		for(TreeNode tr:dls.list) {
			System.out.println(tr.val);
		}
		dls.removeLeafNodes(root, 3);

	}
	
public TreeNode removeLeafNodes(TreeNode root, int target) {
        
        getLeafNodes(root,target);
		boolean found = true;
		int length = list.size();
        while(found) {
        	found = false;
        	for(int i = length-1; i>=0;i--) {
        		if(list.get(i).left != null && list.get(i).left.val == target) {
        			if(list.get(i).left.left == null && list.get(i).left.right == null) {
        				list.get(i).left = null;
        				found = true;
                    }
        		}
        		if(list.get(i).right != null && list.get(i).right.val == target) {
        			if(list.get(i).right.left == null && list.get(i).right.right == null) {
        				list.get(i).right = null;
        				found = true;
        			}
        		}
        	}
        	
        }
        if(root.left ==null && root.right ==null && root.val == target){
            return null;
        }
		return root;
    }
	
	public void getLeafNodes(TreeNode root, int target) {
		parent = root;
		boolean added = false;
		if(root.left != null && root.left.val == target ) {
     		added = true;
     		list.add(parent);
		 }
		if(root.right != null && root.right.val == target && ! added) {
     			list.add(parent);
		}
        if(root.left != null)
        	getLeafNodes(root.left,target);
        if(root.right != null)
        	getLeafNodes(root.right,target);    
    }
}
