/*
 * https://takeuforward.org/graph/strongly-connected-components-kosarajus-algorithm-g-54/
 * https://youtu.be/R6uoSjZ2imo
 * 
 * https://www.geeksforgeeks.org/strongly-connected-components/
 * https://www.geeksforgeeks.org/problems/strongly-connected-components-kosarajus-algo/1
*/

package graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;

public class StronglyConnectedComponentsKosarajuAlgo {

    private void dfs(int source, ArrayList<ArrayList<Integer>> adjList, boolean[] visited, Deque<Integer> stack) {
        visited[source] = true;

        for (int nbr : adjList.get(source)) {
            if (!visited[nbr]) {
                dfs(nbr, adjList, visited, stack);
            }
        }

        stack.push(source);
    }

    private void dfs2(int source, ArrayList<ArrayList<Integer>> adjList, boolean[] visited) {
        visited[source] = true;

        for (int nbr : adjList.get(source)) {
            if (!visited[nbr]) {
                dfs2(nbr, adjList, visited);
            }
        }
    }

    public int kosaraju(ArrayList<ArrayList<Integer>> adjList) {
        int V = adjList.size();

        boolean[] visited = new boolean[V];
        Deque<Integer> stack = new ArrayDeque<>();

        // Stack nodes by finish time, reverse postorder of the DFS
        for (int u = 0; u < V; u++) {
            if (!visited[u]) {
                dfs(u, adjList, visited, stack);
            }
        }

        // Inverse Graph
        ArrayList<ArrayList<Integer>> adjListInverted = new ArrayList<>();
        for (int u = 0; u < V; u++) {
            adjListInverted.add(new ArrayList<>());
        }
        for (int u = 0; u < V; u++) {
            for (int nbr : adjList.get(u)) {
                adjListInverted.get(nbr).add(u);
            }
        }

        Arrays.fill(visited, false);
        int components = 0;

        // Start visiting ndes in reverse postoder
        while (!stack.isEmpty()) {
            int node = stack.pop();

            // We will be able to visit only the cycles or the individual strongly connected
            // in one go.
            if (!visited[node]) {
                dfs2(node, adjListInverted, visited);
                components++;
            }
        }

        return components;
    }

    public static void main(String[] args) {
        int[][] adj = { { 2, 3 }, { 0 }, { 1 }, { 4 }, {} };

        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for (int i = 0; i < adj.length; i++) {
            list.add(new ArrayList<>());
            for (int x : adj[i]) {
                list.get(i).add(x);
            }
        }
        StronglyConnectedComponentsKosarajuAlgo sol = new StronglyConnectedComponentsKosarajuAlgo();
        System.out.println(sol.kosaraju(list));
    }
}
