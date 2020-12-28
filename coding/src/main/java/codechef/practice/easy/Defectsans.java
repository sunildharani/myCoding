package codechef.practice.easy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Defectsans {

	 public static void main(String[] args) {
	        InputStream inputStream = System.in;
	        OutputStream outputStream = System.out;
	        FastScanner in = new FastScanner(inputStream);
	        PrintWriter out = new PrintWriter(outputStream);
	        Shield solver = new Shield();
	        solver.solve(1, in, out);
	        out.close();
	    }

	    static class Shield {
	        private int[][] color;
	        private int[] yMove = new int[]{-1, 0, 0, 1};
	        private int[] xMove = new int[]{0, -1, 1, 0};

	        public void solve(int testNumber, FastScanner in, PrintWriter out) {
	            int T = in.nextInt();
	            while ((T = T - 1) >= 0) {
	                int N = in.nextInt();
	                int M = in.nextInt();

	                int[][] grid = new int[N][M];

	                for (int i = 0; i < N; i++) {
	                    for (int j = 0; j < M; j++) {
	                        grid[i][j] = in.nextInt();
	                    }
	                }

	                int count = colorGraph(N, M, grid);
	                ArrayList[] G = new ArrayList[count];
	                for (int i = 0; i < count; i++) {
	                    G[i] = new ArrayList<Integer>();
	                }

	                boolean[][] isDone = new boolean[count][count];
	                for (int i = 0; i < N; i++) {
	                    for (int j = 0; j < M; j++) {
	                        if (i - 1 >= 0 && color[i - 1][j] != color[i][j] && !isDone[color[i - 1][j]][color[i][j]]) {
	                            G[color[i - 1][j]].add(color[i][j]);
	                            G[color[i][j]].add(color[i - 1][j]);
	                            isDone[color[i - 1][j]][color[i][j]] = true;
	                            isDone[color[i][j]][color[i - 1][j]] = true;
	                        }

	                        if (j - 1 >= 0 && color[i][j - 1] != color[i][j] && !isDone[color[i][j - 1]][color[i][j]]) {
	                            G[color[i][j - 1]].add(color[i][j]);
	                            G[color[i][j]].add(color[i][j - 1]);
	                            isDone[color[i][j - 1]][color[i][j]] = true;
	                            isDone[color[i][j]][color[i][j - 1]] = true;
	                        }
	                    }
	                }

	                int mn = N * M + 2;
	                for (int i = 0; i < count; i++) {
//	                out.println(i + " " + G[i]);
	                    boolean[] visited = new boolean[count];
	                    Queue<Integer> queue = new LinkedList<>();
	                    queue.add(i);
	                    queue.add(-1);
	                    visited[i] = true;
	                    int dist = 0;
	                    while (!queue.isEmpty()) {
	                        int v = queue.poll();
	                        if (v == -1) {
	                            if (!queue.isEmpty()) {
	                                queue.add(-1);
	                                dist++;
	                            } else break;
	                        } else {
	                            for (int j = 0; j < G[v].size(); j++) {
	                                if (!visited[(Integer) G[v].get(j)]) {
	                                    visited[(Integer) G[v].get(j)] = true;
	                                    queue.add((Integer) G[v].get(j));
	                                }
	                            }
	                        }
	                    }
	                    mn = Math.min(dist, mn);
	                }
	                out.println(mn);
	            }
	        }

	        private int colorGraph(int N, int M, int grid[][]) {
	            color = new int[N][M];
	            for (int i = 0; i < N; i++) Arrays.fill(color[i], -1);
	            int count = 0;
	            for (int i = 0; i < N; i++) {
	                for (int j = 0; j < M; j++) {
	                    if (color[i][j] == -1) {
	                        bfs(N, M, grid, new Vertex(i, j), count++);
	                    }
	                }
	            }
	            return count;
	        }

	        private void bfs(int N, int M, int grid[][], Vertex u, int col) {
	            Queue<Vertex> queue = new LinkedList<>();
	            queue.add(u);
	            color[u.x][u.y] = col;
	            while (!queue.isEmpty()) {
	                Vertex front = queue.poll();
	                int val = grid[front.x][front.y];
	                for (int i = 0; i < 4; i++) {
	                    int nx = front.x - xMove[i];
	                    int ny = front.y - yMove[i];

	                    if (nx >= 0 && nx < N && ny >= 0 && ny < M && grid[nx][ny] == val && color[nx][ny] == -1) {
	                        color[nx][ny] = col;
	                        queue.add(new Vertex(nx, ny));
	                    }
	                }
	            }
	        }

	        private class Vertex {
	            int x;
	            int y;

	            Vertex(int x, int y) {
	                this.x = x;
	                this.y = y;
	            }

	        }

	    }

	    static class FastScanner {
	        private BufferedReader bufferedReader;
	        private StringTokenizer stringTokenizer;

	        public FastScanner(InputStream inputStream) {
	            bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
	        }

	        public String next() {
	            while (stringTokenizer == null || !stringTokenizer.hasMoreElements()) {
	                try {
	                    stringTokenizer = new StringTokenizer(bufferedReader.readLine());
	                } catch (IOException e) {
	                    e.printStackTrace();
	                }
	            }
	            return stringTokenizer.nextToken();
	        }

	        public int nextInt() {
	            return Integer.parseInt(next());
	        }

	    }
	
	
}
