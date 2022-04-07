package hackerrank.graphs;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class StoryOfTree {
	
	 static String storyOfATree(int n, int[][] edges, int k, int[][] guesses) {
	        Gnode[] nodes = new Gnode[n+1];
	        for(int i =1 ;i < n+1;i++) {
	        	nodes[i] = new Gnode(i);
	        }
	        for(int i = 0; i<edges.length;i++) {
	        	int a = edges[i][0];
	        	int b = edges[i][1];
	        	nodes[a].nei.add(nodes[b]);
	        	nodes[b].nei.add(nodes[a]);
	        }
	        int noofGuesses = countGuesses(guesses,nodes);
			return "";
	 }

	    private static int countGuesses(int[][] guesses, Gnode[] nodes) {
		// TODO Auto-generated method stub
		return 0;
	}

		private static final Scanner scanner = new Scanner(System.in);

	    public static void main(String[] args) throws IOException {

	        int q = Integer.parseInt(scanner.nextLine().trim());

	        for (int qItr = 0; qItr < q; qItr++) {
	            int n = Integer.parseInt(scanner.nextLine().trim());

	            int[][] edges = new int[n-1][2];

	            for (int edgesRowItr = 0; edgesRowItr < n-1; edgesRowItr++) {
	                String[] edgesRowItems = scanner.nextLine().split(" ");

	                for (int edgesColumnItr = 0; edgesColumnItr < 2; edgesColumnItr++) {
	                    int edgesItem = Integer.parseInt(edgesRowItems[edgesColumnItr].trim());
	                    edges[edgesRowItr][edgesColumnItr] = edgesItem;
	                }
	            }

	            String[] gk = scanner.nextLine().split(" ");

	            int g = Integer.parseInt(gk[0].trim());

	            int k = Integer.parseInt(gk[1].trim());

	            int[][] guesses = new int[q][2];

	            for (int guessesRowItr = 0; guessesRowItr < q; guessesRowItr++) {
	                String[] guessesRowItems = scanner.nextLine().split(" ");

	                for (int guessesColumnItr = 0; guessesColumnItr < 2; guessesColumnItr++) {
	                    int guessesItem = Integer.parseInt(guessesRowItems[guessesColumnItr].trim());
	                    guesses[guessesRowItr][guessesColumnItr] = guessesItem;
	                }
	            }

	            String result = storyOfATree(n, edges, k, guesses);

	        }
	    }
	    


}

class Gnode{
	int i ;
	boolean visited;
	List<Gnode> nei;
	Gnode(int i){
		this.i = i;
		this.nei = new ArrayList<Gnode>();
	}
}
