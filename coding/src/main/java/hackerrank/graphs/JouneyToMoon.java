package hackerrank.graphs;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class JouneyToMoon {

	static int journeyToMoon(int n, int[][] astronaut) {
		List<Integer> groups = new ArrayList<Integer>();
    	City[] cit = new City[n];
    	for(int i = 0; i<n;i++) {
    		cit[i] = new City(i);
    	}
    	for(int i = 0; i < astronaut.length;i++) {
    		int a = astronaut[i][0];
    		int b = astronaut[i][1];
    		cit[a].neighbours.add(cit[b]);
    		cit[b].neighbours.add(cit[a]);
    	}
    	int n_road = 0;
    	for(int i = 0; i< cit.length;i++) {
    		if(!cit[i].visited) {
    			cit[i].visited = true;
    			Stack<City> st = new Stack<City>();
    			st.add(cit[i]);
    			n_road = 0;
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
    			groups.add(n_road);
    		}
    	}
    	int possib = 0;
    	int sum = 0;
    	for(int i = 0; i<groups.size();i++) {
    		sum += groups.get(i);
    	}
    	int sub = 0;
    	for(int j = 0;j < groups.size();j++) {
    		sub += groups.get(j);
			possib += groups.get(j)*(sum-sub); 
		}
    	return possib;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] np = scanner.nextLine().split(" ");

        int n = Integer.parseInt(np[0]);

        int p = Integer.parseInt(np[1]);

        int[][] astronaut = new int[p][2];

        for (int i = 0; i < p; i++) {
            String[] astronautRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 2; j++) {
                int astronautItem = Integer.parseInt(astronautRowItems[j]);
                astronaut[i][j] = astronautItem;
            }
        }

        int result = journeyToMoon(n, astronaut);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    } 
	
}

