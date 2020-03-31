package hackerrank.graphs;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Roadsandlibraries {

	 private static final Scanner scanner = new Scanner(System.in);

	    public static void main(String[] args) throws IOException {
	        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

	        int q = scanner.nextInt();
	        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

	        for (int qItr = 0; qItr < q; qItr++) {
	            String[] nmC_libC_road = scanner.nextLine().split(" ");

	            int n = Integer.parseInt(nmC_libC_road[0]);

	            int m = Integer.parseInt(nmC_libC_road[1]);

	            int c_lib = Integer.parseInt(nmC_libC_road[2]);

	            int c_road = Integer.parseInt(nmC_libC_road[3]);

	            int[][] cities = new int[m][2];

	            for (int i = 0; i < m; i++) {
	                String[] citiesRowItems = scanner.nextLine().split(" ");
	                scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

	                for (int j = 0; j < 2; j++) {
	                    int citiesItem = Integer.parseInt(citiesRowItems[j]);
	                    cities[i][j] = citiesItem;
	                }
	            }

	            long result = roadsAndLibraries(n, c_lib, c_road, cities);

	            bufferedWriter.write(String.valueOf(result));
	            bufferedWriter.newLine();
	        }

	        bufferedWriter.close();

	        scanner.close();
	    }
	
	    static long roadsAndLibraries(int n, int c_lib, int c_road, int[][] cities) {
	    	City[] cit = new City[n+1];
	    	for(int i = 1; i<n+1;i++) {
	    		cit[i] = new City(i);
	    	}
	    	long cost = 0L;
	    	if(c_lib <= c_road) {
	    		return c_lib*(long)n;
	    	}
	    	for(int i = 0; i < cities.length;i++) {
	    		int a = cities[i][0];
	    		int b = cities[i][1];
	    		cit[a].neighbours.add(cit[b]);
	    		cit[b].neighbours.add(cit[a]);
	    	}
	    	long n_lib = 0L;
	    	long n_road = 0L;
	    	for(int i = 1; i< cit.length;i++) {
	    		if(!cit[i].visited) {
	    			cit[i].visited = true;
	    			n_lib++;
	    			Stack<City> st = new Stack<City>();
	    			st.add(cit[i]);
	    			while(!st.isEmpty()) {
	    				City temp = st.pop();
	    				for(City c: temp.neighbours) {
	    					if(!c.visited) {
	    						c.visited = true;
	    						st.add(c);
	    					}
	    				}
	    				n_road++;
	    			}
	    			n_road--;
	    		}
	    	}
	    	return (n_road*c_road+c_lib*n_lib);
	    }
	
}


class City{
	int i ;
	List<City> neighbours;
	boolean visited;
	City(int i) {
		this.i = i;
		this.neighbours= new ArrayList<City>();
	}
}