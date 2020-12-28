package codechef.october.cookoff;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Problem3 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		while(n-- > 0) {
			int l = Integer.parseInt(br.readLine());
			TreeNode[] ans = new TreeNode[l];
			while(l-- > 0) {
				String line = br.readLine();
				String[] val = line.split(" ");
				int a = Integer.parseInt(val[0]);
				a--;
				int b = Integer.parseInt(val[0]);
				b--;
				if(ans[a] == null) {
					ans[a] = new TreeNode(a);
				}
				if(ans[b] == null) {
					ans[b] = new TreeNode(b);
				}
				ans[a].al.add(ans[b]);
				ans[b].al.add(ans[a]);
			}
			int j = 1; 
			for(int i =0; i<ans.length;i++) {
				if(!ans[i].visited) {
					ans[i].visited = true;
					j = assignValues(ans[i],j,1);
					j++;
				}
			}
		}
	}

	private static int assignValues(TreeNode treeNode, int i,int pathsize) {
		treeNode.visited = true;
		int j = i;
		if(treeNode.al.size() == 1) {
			treeNode.assign = i;
			return i;
		}else {
			pathsize++;
			for(TreeNode a : treeNode.al) {
				if(a.visited) {
					continue;
				}
				j = assignValues(a,j,pathsize);
				j++;
				while(j % pathsize != 0) {
					j++;
				}
				a.assign = j;
			}
			pathsize--;
		}
		return j;
		
	}
	
}

class TreeNode{
	int i;
	boolean visited;
	int assign;
	ArrayList<TreeNode> al;
	TreeNode(int i) {
		this.i = i;
		this.al = new ArrayList<TreeNode>();
	}	
}
