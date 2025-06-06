/*
 * https://takeuforward.org/graph/breadth-first-search-bfs-level-order-traversal/
 * https://youtu.be/-tgVpUgsQ5k
*/

// https://leetcode.com/problems/lexicographically-smallest-equivalent-string/submissions/1655021963/?envType=daily-question&envId=2025-06-05

package graph;

import java.util.LinkedList;
import java.util.Queue;

public class BFS {

    private void bfsAll(int n, int[][] edges) {
        Graph g = new Graph(n);
        for (int[] edge : edges) {
            g.addEdge(edge[0], edge[1]);
        }

        boolean[] visited = new boolean[n];
        for (int u = 0; u < g.vertexCount; u++) {
            if (!visited[u]) {
                System.out.println("Starting new BFS from vertex " + u + ":");
                bfs(g, u, visited);
                System.out.println();
            }
        }

    }

    private void bfs(Graph g, int source, boolean[] visited) {
        Queue<Integer> q = new LinkedList<>();

        q.add(source);
        visited[source] = true;

        int level = -1;

        while (!q.isEmpty()) {
            int q_count = q.size();
            level++;

            for (int i = 0; i < q_count; i++) {
                int u = q.remove();

                System.out.println(u + " at level: " + level);

                for (int v : g.adjList.get(u)) {
                    if (!visited[v]) {
                        q.add(v);
                        visited[v] = true;
                    }
                }
            }
            System.out.println();
        }

    }

    public static void main(String[] args) {

        int n = 7;
        int[][] edges = new int[][] { { 0, 1 }, { 0, 2 }, { 1, 3 }, { 1, 4 }, { 1, 5 }, { 1, 6 }, { 6, 2 } };

        BFS sol = new BFS();
        sol.bfsAll(n, edges);
    }
}
