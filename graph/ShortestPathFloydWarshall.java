/*
 * https://takeuforward.org/data-structure/floyd-warshall-algorithm-g-42/
 * https://youtu.be/YbY8cVwWAvw
 * 
 * https://youtu.be/4OQeCuLYj-4
 * 
 * William Fiset; https://youtu.be/4NQ3HnhyNfQ
 * https://youtu.be/0dTrKG5UK9k
 * 
 * https://www.geeksforgeeks.org/floyd-warshall-algorithm-dp-16/
 * https://www.geeksforgeeks.org/problems/implementing-floyd-warshall2042/1
 * 
*/

package graph;

public class ShortestPathFloydWarshall {

    private static final int INF = (int) 1e8;

    public void floydWarshall(int[][] dist) {
        int V = dist.length;

        for (int k = 0; k < V; k++) {
            for (int i = 0; i < V; i++) {
                for (int j = 0; j < V; j++) {
                    if (dist[i][k] < INF && dist[k][j] < INF && dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }

    }

    public static void main(String[] args) {
        int dist[][] = { { 0, 4, INF, 5, INF }, { INF, 0, 1, INF, 6 }, { 2, INF, 0, 3, INF }, { INF, INF, 1, 0, 2 },
                { 1, INF, INF, 4, 0 } };

        ShortestPathFloydWarshall sol = new ShortestPathFloydWarshall();
        sol.floydWarshall(dist);
    }
}
