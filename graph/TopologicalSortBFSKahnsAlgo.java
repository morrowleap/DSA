/*
 * https://takeuforward.org/data-structure/kahns-algorithm-topological-sort-algorithm-bfs-g-22/
 * https://youtu.be/73sneFXuTEg
 * 
 * https://www.geeksforgeeks.org/problems/topological-sort/1
 * 
 * https://www.geeksforgeeks.org/kahns-algorithm-vs-dfs-approach-a-comparative-analysis/
*/

package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TopologicalSortBFSKahnsAlgo {

    public static ArrayList<Integer> topoSort(int V, int[][] edges) {
        List<List<Integer>> adjList = new ArrayList<>();
        for (int u = 0; u < V; u++) {
            adjList.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            adjList.get(edge[0]).add(edge[1]);
        }

        int[] indegree = new int[V];
        for (int u = 0; u < V; u++) {
            for (int nbr : adjList.get(u)) {
                indegree[nbr]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        // Insert the node with indegree 0, that means we can complete these nodes first
        // they don't have any dependency
        for (int u = 0; u < V; u++) {
            if (indegree[u] == 0) {
                queue.add(u);
            }
        }

        ArrayList<Integer> topoSort = new ArrayList<>();

        while (!queue.isEmpty()) {
            int node = queue.remove();

            // We have completed this task and pushed into topo sort
            topoSort.add(node);

            // We can remove the dependency of this task from adjacent nodes
            for (int nbr : adjList.get(node)) {
                indegree[nbr]--;

                // If the adjacent task do not have any other dependency we can push it to the
                // queue, for removiing its dependency from nbrs of this task
                if (indegree[nbr] == 0) {
                    queue.add(nbr);
                }
            }
        }

        return topoSort;
    }

    public static void main(String[] args) {
        int V1 = 4, edges1[][] = { { 3, 0 }, { 1, 0 }, { 2, 0 } };
        int V2 = 6, edges2[][] = { { 1, 3 }, { 2, 3 }, { 4, 1 }, { 4, 0 }, { 5, 0 }, { 5, 2 } };

        System.out.println(TopologicalSortBFSKahnsAlgo.topoSort(V1, edges1));
        System.out.println(TopologicalSortBFSKahnsAlgo.topoSort(V2, edges2));
    }
}
