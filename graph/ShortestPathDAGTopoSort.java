/*
 * https://takeuforward.org/data-structure/shortest-path-in-directed-acyclic-graph-topological-sort-g-27/
 * https://youtu.be/ZUFQfFaU-8U
 * 
 * https://www.geeksforgeeks.org/shortest-path-for-directed-acyclic-graphs/
 * https://www.geeksforgeeks.org/problems/shortest-path-in-undirected-graph/1
 * 
 * https://youtu.be/TXkDpqjDMHA
*/

package graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class ShortestPathDAGTopoSort {
    private void dfs(int source, List<List<int[]>> adjList, boolean[] visited, Deque<Integer> topoSortStack) {
        visited[source] = true;

        for (int[] nbr : adjList.get(source)) {
            int v = nbr[0];
            if (!visited[v]) {
                dfs(v, adjList, visited, topoSortStack);
            }
        }

        topoSortStack.push(source);
    }

    private Deque<Integer> topoSort(int V, List<List<int[]>> adjList) {
        boolean[] visited = new boolean[V];

        Deque<Integer> topoSortStack = new ArrayDeque<>();

        for (int u = 0; u < V; u++) {
            if (!visited[u]) {
                dfs(u, adjList, visited, topoSortStack);
            }
        }

        return topoSortStack;
    }

    public int[] shortestPath(int V, int E, int[][] edges) {
        List<List<int[]>> adjList = new ArrayList<>();
        for (int u = 0; u < V; u++) {
            adjList.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1], w = edge[2];
            adjList.get(u).add(new int[] { v, w });
        }

        Deque<Integer> topoSortStack = topoSort(V, adjList);

        int[] dist = new int[V];
        for (int u = 0; u < V; u++) {
            dist[u] = (int) 1e9;
        }

        dist[0] = 0;

        while (!topoSortStack.isEmpty()) {
            int u = topoSortStack.pop();

            for (int[] nbr : adjList.get(u)) {
                int v = nbr[0], w = nbr[1];
                if (dist[v] > dist[u] + w) { // Relaxation of edges
                    dist[v] = dist[u] + w;
                }
            }
        }

        for (int i = 0; i < V; i++) {
            if (dist[i] == (int) 1e9)
                dist[i] = -1;
        }
        return dist;
    }

    public static void main(String[] args) {
        int V1 = 4, E1 = 2, edges1[][] = { { 0, 1, 2 }, { 0, 2, 1 } };
        int V2 = 6, E2 = 7, edges2[][] = { { 0, 1, 2 }, { 0, 4, 1 }, { 4, 5, 4 }, { 4, 2, 2 }, { 1, 2, 3 }, { 2, 3, 6 },
                { 5, 3, 1 } };

        ShortestPathDAGTopoSort sol = new ShortestPathDAGTopoSort();
        System.out.println(sol.shortestPath(V1, E1, edges1));
        System.out.println(sol.shortestPath(V2, E2, edges2));
    }
}
