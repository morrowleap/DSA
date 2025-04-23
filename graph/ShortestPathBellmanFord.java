/*
 * https://takeuforward.org/data-structure/bellman-ford-algorithm-g-41/
 * https://youtu.be/0vVofAhAYjc
 * 
 * Dijakstra algorithm will fail when the graph have negative edges, if the graph have negative cycle it will go for a TLE
 * 
 * Bellman Ford helps us to detect negative cycle as well
 * 
 * It is applicable only in directed graph
 * 
 * https://www.geeksforgeeks.org/bellman-ford-algorithm-dp-23/
 * https://www.geeksforgeeks.org/problems/distance-from-the-source-bellman-ford-algorithm/1
 * 
 * https://youtu.be/lyw4FaxrwHg
 * 
*/

package graph;

import java.util.Arrays;

public class ShortestPathBellmanFord {

    private static final int INF = (int) 1e8;

    public int[] bellmanFord(int V, int[][] edges, int src) {

        int[] dist = new int[V];
        Arrays.fill(dist, INF);
        dist[src] = 0;

        for (int i = 0; i < V; i++) { // Relaxation V - 1 times
            for (int[] edge : edges) {
                int u = edge[0], v = edge[1], w = edge[2];

                if (dist[u] != INF && dist[u] + w < dist[v]) { // Relaxation of edges

                    // If this is the Vth relaxation, then there is
                    // a negative cycle
                    if (i == V - 1) {
                        return new int[] { -1 };
                    }

                    dist[v] = dist[u] + w;
                }
            }
        }

        return dist;
    }

    public static void main(String[] args) {
        int V = 5, edges[][] = { { 1, 3, 2 }, { 4, 3, -1 }, { 2, 4, 1 }, { 1, 2, 1 }, { 0, 1, 5 } }, src = 0;

        ShortestPathBellmanFord sol = new ShortestPathBellmanFord();
        System.out.println(sol.bellmanFord(V, edges, src));
    }

}
