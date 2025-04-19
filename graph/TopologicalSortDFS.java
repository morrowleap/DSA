/*
 * Topological Sort
 * https://takeuforward.org/data-structure/topological-sort-algorithm-dfs-g-21/
 * https://youtu.be/5lZ0iJMrUMk
 * 
 * Linear ordering of vertices, such that there is an edge between u -> v, u appears before v in that ordering.
 * This linear ordering is only possible in Directed Acyclic Graph (DAG)
 * Why directed: Because u -> v and v <- u, u cannot be before v and vice versa in topo sort.
 * Why acyclic: Becuase in cyclic grapth there is a circular dependency, so no topo ordering.
 * 
 * https://www.geeksforgeeks.org/problems/topological-sort/1
*/

/*
 * https://youtu.be/7J3GadLzydI
 * In u -> v means, v depends on u, In order to v we first must do u
 * Topological sort allows you to create a sequence of nodes where all the dependencies are going to be first.
*/

package graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class TopologicalSortDFS {
    public static ArrayList<Integer> topoSort(int V, int[][] edges) {
        List<List<Integer>> adjList = new ArrayList<>();
        for (int u = 0; u < V; u++) {
            adjList.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            adjList.get(edge[0]).add(edge[1]);
        }

        boolean[] visited = new boolean[V];
        Deque<Integer> stack = new ArrayDeque<>();

        for (int source = 0; source < V; source++) {
            if (!visited[source]) {
                dfs(source, adjList, visited, stack);
            }
        }

        return new ArrayList<>(stack);
    }

    private static void dfs(int source, List<List<Integer>> adjList, boolean[] visited, Deque<Integer> stack) {
        visited[source] = true;

        for (int nbr : adjList.get(source)) {
            if (!visited[nbr]) {
                dfs(nbr, adjList, visited, stack);
            }
        }

        stack.push(source);
    }

    public static void main(String[] args) {
        int V1 = 4, edges1[][] = { { 3, 0 }, { 1, 0 }, { 2, 0 } };
        int V2 = 6, edges2[][] = { { 1, 3 }, { 2, 3 }, { 4, 1 }, { 4, 0 }, { 5, 0 }, { 5, 2 } };

        System.out.println(TopologicalSortDFS.topoSort(V1, edges1));
        System.out.println(TopologicalSortDFS.topoSort(V2, edges2));
    }
}
