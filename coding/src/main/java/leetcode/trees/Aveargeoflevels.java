package leetcode.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Aveargeoflevels {

	public List<Double> averageOfLevels(TreeNode root) {
		List<Double> res = new ArrayList<Double>();
        Queue<TreeNode> q1 = new LinkedList<TreeNode>();
        if(root == null) {
        	return res;
        }
        q1.add(root);
        while(!q1.isEmpty()) {
        	int size = q1.size();
        	double sum = 0;
        	for(int i=0;i<size;i++) {
        		TreeNode node = q1.poll();
        		sum += node.val;
        		if(node.left != null) {
        			q1.add(node.left);
        		}
        		if(node.right != null) {
        			q1.add(node.right);
        		}
        	}
        	res.add(sum/size);       	
        }
        return res;
        
    }
	
}
