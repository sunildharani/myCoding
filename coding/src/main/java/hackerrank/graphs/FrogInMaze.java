package hackerrank.graphs;

import java.util.*;

public class FrogInMaze {

    private static final Scanner scanner = new Scanner(System.in);
    static int N;static int M;
    static Double sum = 0d;
    static int count = 0;

    public static void main(String[] args) {
        String[] nmk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nmk[0]);
        N = n;

        int m = Integer.parseInt(nmk[1]);
        M = m;
        int k = Integer.parseInt(nmk[2]);
        Cell[][] cells = new Cell[n][m];
        boolean foundexit = false;
        Cell start = null;

        for (int nItr = 0; nItr < n; nItr++) {
            String row = scanner.nextLine();
            char[] arr = row.toCharArray();
            for(int j = 0; j < arr.length;j++) {
            	Cell cell = new Cell(nItr,j);
            	if(arr[j] == '#') {
            		cell.block = true;
            	}
            	if(arr[j] == '%') {
            		cell.exit = true;
            		foundexit = true;
            	}
            	if(arr[j] == '*') {
            		cell.bomb = true;
            	}
            	if(arr[j] == 'A'){
            		start = cell;
            	}
            	cells[nItr][j] = cell;
            }
            
        }
        for (int kItr = 0; kItr < k; kItr++) {
            String[] i1J1I2J2 = scanner.nextLine().split(" ");

            int i1 = Integer.parseInt(i1J1I2J2[0]);

            int j1 = Integer.parseInt(i1J1I2J2[1]);

            int i2 = Integer.parseInt(i1J1I2J2[2]);

            int j2 = Integer.parseInt(i1J1I2J2[3]);
            cells[i1-1][j1-1].tunnel = cells[i2-1][j2-1];
            cells[i2-1][j2-1].tunnel = cells[i1-1][j1-1];

        }
        if(!foundexit) {
        	System.out.println(0);
        }

        Double prod = (double) 1;
        getWays(cells,start,prod);
        System.out.println(sum);
        System.out.println(count);
        scanner.close();
    }

    private static void getWays(Cell[][] cells, Cell cell,Double prod) {
        List<Cell> nei = getNeighbours(cell,cells);
        cell.visited = true;
        Double temp = new Double(prod);
        prod *= cell.stepsprob;
        for(Cell ncell :nei) {
            if(ncell.exit) {
            //    System.out.println(ncell.i+" "+ncell.j);
                sum += prod;
                count +=1;
            }else {
                getWays(cells,ncell,prod);
            }
        }
        prod = temp;
        cell.visited = false;
    }

	

	private static List<Cell> getNeighbours(Cell cell,Cell[][] cells) {
		List<Cell> cellList = new ArrayList<Cell>();
		if(cell.exit) {
			return cellList;
		}
		int i = cell.i;
		int j = cell.j;
		Cell nei = null;
		if(j+1 < cells[0].length) {
			nei = cells[i][j+1];
			if(!nei.block && !nei.bomb && !nei.visited) {
				if(nei.tunnel != null) {
					cellList.add(nei.tunnel);
				}else {
					cellList.add(nei);
				}
			}
		}
		if(j-1 >= 0) {
			nei = cells[i][j-1];
			if(!nei.block && !nei.bomb && !nei.visited) {
				if(nei.tunnel != null) {
					cellList.add(nei.tunnel);
				}else {
					cellList.add(nei);
				}
			}
		}
		if(i+1 < cells.length) {
			nei = cells[i+1][j];
			if(!nei.block && !nei.bomb && !nei.visited) {
				if(nei.tunnel != null) {
					cellList.add(nei.tunnel);
				}else {
					cellList.add(nei);
				}
			}
		}
		if(i-1 >= 0) {
			nei = cells[i-1][j];
			if(!nei.block && !nei.bomb && !nei.visited) {
				if(nei.tunnel != null) {
					cellList.add(nei.tunnel);
				}else {
					cellList.add(nei);
				}
			}
		}
		return cellList;
		
	}
}

class Cell{
	int i ;
	int j ;
	Cell(int i, int j){
		this.i = i;
		this.j = j;
			if(i==0 && (j==0 || j ==FrogInMaze.M-1)) {
				stepsprob = 0.5d;
			}
			if(i==FrogInMaze.N-1 && (j==0 || j ==FrogInMaze.M-1)) {
				stepsprob = 0.5d;
			}
			if(i>0 && i < FrogInMaze.N-1 && (j == 0||j ==FrogInMaze.M-1)) {
				stepsprob = new Double(1/3d);
			}
			if(j > 0 && j <FrogInMaze.M-1 &&(i==0 || i == FrogInMaze.N-1)) {
				stepsprob = new Double(1/3d);
			}
	}
	Cell tunnel;
	Double stepsprob = 0.25d;
	boolean block;
	boolean exit;
	boolean bomb;
	boolean visited;
}

