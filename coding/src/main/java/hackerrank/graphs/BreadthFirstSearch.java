package hackerrank.graphs;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class BreadthFirstSearch {
	
	private static final Scanner scanner = new Scanner(System.in);
	   public static void main(String[] args) throws IOException {
	  
	        int q = scanner.nextInt();
	        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

	        for (int qItr = 0; qItr < q; qItr++) {
	            String[] nm = scanner.nextLine().split(" ");

	            int n = Integer.parseInt(nm[0]);

	            int m = Integer.parseInt(nm[1]);

	            int[][] edges = new int[m][2];

	            for (int i = 0; i < m; i++) {
	                String[] edgesRowItems = scanner.nextLine().split(" ");
	                scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

	                for (int j = 0; j < 2; j++) {
	                    int edgesItem = Integer.parseInt(edgesRowItems[j]);
	                    edges[i][j] = edgesItem;
	                }
	            }

	            int s = scanner.nextInt();
	            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

	            int[] result = bfs(n, m, edges, s);
	            for(int i = 0; i <result.length;i++) {
	            	System.out.println(result[i]);
	            }
	        }
	            scanner.close();
	   }

	 static int[] bfs(int n, int m, int[][] edges, int s) {
		 int[] ans = new int[n+1];
		 Circle[] circles = new Circle[n+1];
		 for(int i = 1; i< circles.length;i++) {
			 circles[i] = new Circle(i);
			 ans[i] = -1;
		 }
		 for(int i = 0;i <edges.length;i++) {
			 int a = edges[i][0];
			 int b = edges[i][1];
			 circles[a].nei.add(circles[b]);
			 circles[b].nei.add(circles[a]);
		 }

		 Circle start = circles[s];
		 Queue<Circle> st = new LinkedList<Circle>();
		 st.add(start);
		 int dist = 0;
		 while(!st.isEmpty()) {
			 int size = st.size();
			 for(int i = 0; i< size;i++) {
				 Circle cir= st.poll();
				 if(cir.visited) {
					 continue;
				 }
				 cir.visited = true;
				 ans[cir.i] = dist;
				 List<Circle> li = cir.nei;
				 for(Circle c : li) {
					 if(!c.visited) {
						 st.add(c);
					 }
				 }
			 }
			 dist += 6;
		 }
		 for(int i = 1; i<ans.length-1;i++) {
			 if(s <= i) {
				 ans[i] = ans[i+1];
			 }
		 }
		 return Arrays.copyOfRange(ans, 1, n);
		 
	 }
}

class Circle{
	int i;
	Circle(int i){
		this.i = i;
		this.nei = new ArrayList<Circle>(); 
	}
	List<Circle> nei;
	boolean visited;
}