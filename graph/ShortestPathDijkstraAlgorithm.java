/*
 * https://takeuforward.org/data-structure/dijkstras-algorithm-using-priority-queue-g-32/
 * https://youtu.be/V6H1qAeB-l4?list=PLgUwDviBIf0oE3gA41TKO2H5bHpPd7fzn
 * 
 * https://takeuforward.org/data-structure/dijkstras-algorithm-using-set-g-33/
 * https://youtu.be/PATgNiuTP20?list=PLgUwDviBIf0oE3gA41TKO2H5bHpPd7fzn
 * 
 * https://takeuforward.org/data-structure/g-34-dijkstras-algorithm-intuition-and-time-complexity-derivation/
 * https://youtu.be/3dINsjyfooY?list=PLgUwDviBIf0oE3gA41TKO2H5bHpPd7fzn
 * 
 * https://takeuforward.org/data-structure/g-35-print-shortest-path-dijkstras-algorithm/
 * https://youtu.be/rp1SMw7HSO8?list=PLgUwDviBIf0oE3gA41TKO2H5bHpPd7fzn
 * 
 * 
 * https://www.geeksforgeeks.org/introduction-to-dijkstras-shortest-path-algorithm/
 * Dijkstra’s algorithm is a popular algorithm for solving single-source shortest path problems having non-negative edge weight in the graphs
 * 
 * https://www.geeksforgeeks.org/dijkstras-shortest-path-algorithm-greedy-algo-7/
 * 
 * https://www.geeksforgeeks.org/problems/implementing-dijkstra-set-1-adjacency-matrix/1
 * 
*/

package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class ShortestPathDijkstraAlgorithm {

    public int[] dijkstra(int V, int[][] edges, int src) {
        List<List<int[]>> adjList = new ArrayList<>();
        for (int u = 0; u < V; u++) {
            adjList.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1], w = edge[2];
            adjList.get(u).add(new int[] { v, w });
            adjList.get(v).add(new int[] { u, w });
        }

        int[] dist = new int[V];
        for (int u = 0; u < V; u++) {
            dist[u] = (int) 1e9;
        }
        dist[src] = 0;

        Queue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        minHeap.add(new int[] { 0, src }); // {dist, node}

        while (!minHeap.isEmpty()) {
            int[] x = minHeap.poll();
            int u = x[1];

            for (int[] nbr : adjList.get(u)) {
                int v = nbr[0], w = nbr[1];

                if (dist[v] > dist[u] + w) {
                    dist[v] = dist[u] + w;

                    minHeap.add(new int[] { dist[v], v });
                }
            }
        }

        return dist;
    }

    public static void main(String[] args) {
        int V = 5, edges[][] = {
                { 0, 1, 4 }, { 0, 2, 8 }, { 1, 4, 6 },
                { 2, 3, 2 }, { 3, 4, 10 }
        }, src = 0;

        ShortestPathDijkstraAlgorithm sol = new ShortestPathDijkstraAlgorithm();
        int[] dist = sol.dijkstra(V, edges, src);

        System.out.println(Arrays.toString(dist));
    }
}
