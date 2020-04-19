package hackerrank.graphs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.stream.IntStream;

public class Eventree {

	 // Complete the evenForest function below.
    static int evenForest(int t_nodes, int t_edges, List<Integer> t_from, List<Integer> t_to) {
    	Event[] events = new Event[t_nodes+1];
    	for(int i = 1; i<t_nodes+1;i++) {
    		events[i] = new Event(i);
    	}
    	for(int i = 0; i< t_edges;i++) {
    		int a = t_from.get(i);
    		int b = t_to.get(i);
    		events[a].nei.add(events[b]);
    		events[b].nei.add(events[a]);
    	}
    	Event start = events[1];
    	Stack<Event> st = new Stack<Event>();
    	st.add(start);
    	while(!st.isEmpty()) {
    		Event temp = st.peek();
    		temp.visted = true;
    		List<Event> nei = temp.nei;
    		boolean added = false;
    		for(Event ne : nei) {
    			if(!ne.visted) {
    				st.add(ne);
    				added = true;
    			}
    		}
    		if(!added) {
    			st.pop();
    			for(Event ne : nei) {
        			temp.depth += ne.depth;
    			}
    			temp.depth--;
    		}
    	}
    	int count = 0;
    	for(int i = 1; i<events.length;i++) {
    		System.out.println(i +" -->"+events[i].depth);
    		if(events[i].depth % 2 == 0) {
    			count++;
    		}
    	}
    	return count;
    }

  

	public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] tNodesEdges = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int tNodes = Integer.parseInt(tNodesEdges[0]);
        int tEdges = Integer.parseInt(tNodesEdges[1]);

        List<Integer> tFrom = new ArrayList<>();
        List<Integer> tTo = new ArrayList<>();

        IntStream.range(0, tEdges).forEach(i -> {
            try {
                String[] tFromTo = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

                tFrom.add(Integer.parseInt(tFromTo[0]));
                tTo.add(Integer.parseInt(tFromTo[1]));
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int res = evenForest(tNodes, tEdges, tFrom, tTo);
        System.out.println(res);
    }
	
}


class Event{
	int i =0;
	List<Event> nei;
	boolean visted;
	int depth = 1;
	Event(int i){
		this.i = i;
		this.nei = new ArrayList<Event>();
	}
}