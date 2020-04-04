package hackerrank.graphs;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SnakesandLadders {
	
	 static int quickestWayUp(int[][] ladders, int[][] snakes) {
		 int[] board = new int[101];
		 boolean[] visited = new boolean[101];
		 for(int i = 1; i<board.length;i++) {
			 board[i] = i;
		 }
		 for(int i = 0; i< ladders.length;i++) {
			 int a = ladders[i][0];
			 int b = ladders[i][1];
			 board[a] = b;
		 }
		 for(int i = 0; i< snakes.length;i++) {
			 int a = snakes[i][0];
			 int b = snakes[i][1];
			 board[a] = b;
		 }
		 
		 int num = 0;
		 int steps = 0;
		 Queue<Integer> qu = new LinkedList<Integer>();
		 for(int j = 2; j < 8;j++) {
			 qu.add(board[j]);
			 visited[board[j]] = true;
		 }
		 boolean end = false;
		 while(!qu.isEmpty()) {
			 int size = qu.size();
			 for(int i = 0; i<size;i++) {
				num = qu.poll();
				if(num >= 94) {
					end = true;
					break;
				}else {
				   for(int k = 1; k<7;k++) {
						if(!visited[board[num+k]]) {
							qu.add(board[num+k]);
							visited[board[num+k]] = true;
						}
					}
				}	 
			 }
			 steps++;
			 if(end) {
				 break;
			 }
		}
		if(num >= 94) {
			if(num == 100) {
				return steps;
			}
			return steps++;
		}
		return -1;
		 
	 }
	 
	 private static final Scanner scanner = new Scanner(System.in);

	    public static void main(String[] args) throws IOException {

	        int t = scanner.nextInt();
	        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

	        for (int tItr = 0; tItr < t; tItr++) {
	            int n = scanner.nextInt();
	            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

	            int[][] ladders = new int[n][2];

	            for (int i = 0; i < n; i++) {
	                String[] laddersRowItems = scanner.nextLine().split(" ");
	                scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

	                for (int j = 0; j < 2; j++) {
	                    int laddersItem = Integer.parseInt(laddersRowItems[j]);
	                    ladders[i][j] = laddersItem;
	                }
	            }

	            int m = scanner.nextInt();
	            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

	            int[][] snakes = new int[m][2];

	            for (int i = 0; i < m; i++) {
	                String[] snakesRowItems = scanner.nextLine().split(" ");
	                scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

	                for (int j = 0; j < 2; j++) {
	                    int snakesItem = Integer.parseInt(snakesRowItems[j]);
	                    snakes[i][j] = snakesItem;
	                }
	            }

	            int result = quickestWayUp(ladders, snakes);
	            System.out.println(result);

	        }

	        scanner.close();
	    }

}
