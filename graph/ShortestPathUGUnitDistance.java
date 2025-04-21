/*
 * https://takeuforward.org/data-structure/shortest-path-in-undirected-graph-with-unit-distance-g-28/
 * https://youtu.be/C4gxoTaI71U
 * 
 * https://www.geeksforgeeks.org/problems/shortest-path-in-undirected-graph-having-unit-distance/0
*/

package graph;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathUGUnitDistance {

    public int[] shortestPath(ArrayList<ArrayList<Integer>> adjList, int src) {
        int V = adjList.size();

        int[] dist = new int[V];
        for (int u = 0; u < V; u++) {
            dist[u] = (int) 1e9;
        }
        dist[src] = 0;

        Queue<Integer> queue = new LinkedList<>();

        queue.add(src);

        while (!queue.isEmpty()) {
            int u = queue.remove();

            for (int v : adjList.get(u)) {
                if (dist[v] > dist[u] + 1) {
                    dist[v] = dist[u] + 1;

                    queue.add(v);
                }
            }
        }

        for (int i = 0; i < V; i++) {
            if (dist[i] == (int) 1e9) {
                dist[i] = -1;
            }
        }
        return dist;
    }

    public static void main(String[] args) {
        int adj[][] = { { 1, 3 }, { 0, 2 }, { 1, 6 }, { 0, 4 }, { 3, 5 }, { 4, 6 }, { 2, 5, 7, 8 }, { 6, 8 },
                { 7, 6 } }, src = 0;

        ShortestPathUG sol = new ShortestPathUG();

        int V = adj.length;

        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        for (int u = 0; u < V; u++) {
            adjList.add(new ArrayList<>());
            for (int v : adj[u]) {
                adjList.get(u).add(v);
            }
        }

        System.out.println(sol.shortestPath(adjList, src));

    }
}
