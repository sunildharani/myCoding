package codechef.practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class FNCS {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] num = new int[n];
		FunNode[] fun = new FunNode[n];
		ArrayList<ArrayList<Integer>> ref = new ArrayList<ArrayList<Integer>>();
		for(int i = 0; i< n;i++) {
			ArrayList<Integer> al = new ArrayList<Integer>();
			ref.add(al);
		}
		String line = br.readLine();
		String[] nu = line.split(" ");
		for(int i =0; i< n;i++) {
			num[i] = Integer.parseInt(nu[i]); 
			fun[i] = new FunNode(i,i);
		}
		int temp = 0;
		while(temp < n) {
			line = br.readLine();
			nu = line.split(" ");
			int a = Integer.parseInt(nu[0]);
			a--;
			int b = Integer.parseInt(nu[1]);
			b--;
			for(int i = a; i<=b;i++) {
				fun[temp].sum += num[i]; 
				ref.get(i).add(temp);
			}
			temp++;
		}
		int q = Integer.parseInt(br.readLine());
		FunNode root = buildSegmentTree(fun);
		while(q-- > 0) {
			line = br.readLine();
			nu = line.split(" ");
			int a = Integer.parseInt(nu[0]);
			if(a == 1) {
				int x = Integer.parseInt(nu[1]);
				x--;
				int y = Integer.parseInt(nu[2]);
				int change = y-num[x];
				num[x] = y;
				for(Integer w : ref.get(x)) {
					incrementValue(root,w,change);
				}
			}else {
				int x = Integer.parseInt(nu[1]);
				x--;
				int y = Integer.parseInt(nu[2]);
				y--;
				long sum = findSum(root,x,y);
				System.out.println(sum);
			}
		}
		br.close();

	}

	private static void incrementValue(FunNode funNode, int i, int change) {
		if(funNode.i == funNode.j) {
			funNode.sum += change;
			return;
		}

		if(i <= funNode.left.j) {
			incrementValue(funNode.left,i,change);
		}else {
			 incrementValue(funNode.right,i,change);
		}
		funNode.sum  = funNode.left.sum + funNode.right.sum;
		return ;
	}

	private static long findSum(FunNode root, int x, int y) {
		if(root.i == root.j) {
			return root.sum;
		}
		if(root.i == x) {
		  if(y == root.j) {
			  return root.sum;
		  }else if (y > root.j) {
			  FunNode p = root;
			  while(p.j < y) {
				  p = p.parent;
			  }
			  return root.sum + findSum(p,root.j+1, y);
		  }
		}
		
		if(x <= root.left.j) {
			return findSum(root.left, x, y);
		}
		return findSum(root.right, x, y);
	
	}

	//buld for sums not numbers for 0 to n
	private static FunNode buildSegmentTree(FunNode[] fun) {
		Queue<FunNode> qu = new LinkedList<FunNode>();
		for(int i = 0; i<fun.length;i++) {
			qu.add(fun[i]);
		}
		Queue<FunNode> sq = new LinkedList<FunNode>();
		while(!qu.isEmpty()) {
			if(qu.size() > 1) {
				FunNode a = qu.poll();
				FunNode b = qu.poll();
				FunNode fn = new FunNode(a.i,b.j);
				a.parent = fn;
				b.parent = fn;
				fn.sum = a.sum+b.sum;
				fn.left = a;
				fn.right = b;
				sq.add(fn);
			}else {
				sq.add(qu.poll());
			}
			if(qu.isEmpty()) {
				if(sq.size() == 1) {
					break;
				}else {
					qu = sq;
					sq = new LinkedList<FunNode>();
				}
			}
		}
		return sq.poll();
	}

}

class FunNode{
	int i;
	int j;
	long sum;
	FunNode left;
	FunNode right;
	FunNode parent;
	FunNode(int i,int j){
		this.i = i;
		this.j = j;
	}
	public void setSum(long sum) {
		this.sum = sum;
	}
}
