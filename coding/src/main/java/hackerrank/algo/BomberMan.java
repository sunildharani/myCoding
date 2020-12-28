package hackerrank.algo;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class BomberMan {

	static String[] bomberMan(int n, String[] grid) {
		if((n-1) % 4 == 0) {
			return grid;
		}
		String[] gridAllfilled = new String[grid.length];
		String[] inMiddle = new String[grid.length];
		StringBuilder sb = new StringBuilder();
		int origi = grid.length-1;
		int origj = grid[0].length()-1;
		for(int i = 0; i<grid[0].length();i++) {
			sb.append("O");
		}
		for(int i = 0; i < grid.length;i++) {
			gridAllfilled[i] = sb.toString();
		}
		if(n % 2 == 0) {
			return gridAllfilled;
		}
		
		ArrayList<Point> al = new ArrayList<Point>();
		Point[][] allpoints = new Point[origi+1][origj+1];
		for(int i = 0; i< grid.length;i++) {
			char[] ar = grid[i].toCharArray();
			for(int j = 0; j< ar.length;j++) {
				allpoints[i][j] = new Point(i,j);
				if(ar[j] == 'O') {
					al.add(allpoints[i][j]);
				}
			}
		}
		al = getneighbours(al,origi,origj,allpoints);
		for(int i = 0; i< grid.length;i++) {
			char[] a = grid[i].toCharArray();
			for(int j = 0; j< grid[0].length();j++) {
				if(allpoints[i][j].visited) {
					a[j] = '.';			
				}else {
					a[j] = 'O';
				}
			}
			inMiddle[i] = new String(a);
		}
		return inMiddle;
    }

    private static ArrayList<Point> getneighbours(ArrayList<Point> al,int origi ,int origj, Point[][] allpoints) {
		ArrayList<Point> all = new ArrayList<Point>();
    	for(Point p : al) {
			if(p.visited) {
				continue;
			}
			all.add(p);
			p.visited = true;
			Stack<Point> st = new Stack<Point>();
			if(p.i+1 <= origi) {
				all.add(allpoints[p.i+1][p.j]);
				allpoints[p.i+1][p.j].visited = true;
			}
			if(p.i-1 >= 0) {
				all.add(allpoints[p.i-1][p.j]);
				allpoints[p.i-1][p.j].visited = true;
			}
			if(p.j+1 <= origj) {
				all.add(allpoints[p.i][p.j+1]);
				allpoints[p.i][p.j+1].visited = true;
			}
			if(p.j-1 >= 0) {
				all.add(allpoints[p.i][p.j-1]);
				allpoints[p.i][p.j-1].visited = true;
			}
		}
    	return all;
		
	}

	private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        
        String[] rcn = scanner.nextLine().split(" ");

        int r = Integer.parseInt(rcn[0]);

        int c = Integer.parseInt(rcn[1]);

        int n = Integer.parseInt(rcn[2]);

        String[] grid = new String[r];

        for (int i = 0; i < r; i++) {
            String gridItem = scanner.nextLine();
            grid[i] = gridItem;
        }

        String[] result = bomberMan(n, grid);

        scanner.close();
    }
    

}

class Point{
	int i = 0; 
	int j = 0;
	boolean visited = false;
	Point(int i,int j){
		this.i = i;
		this.j = j;
	}
}
