/*
 * https://takeuforward.org/graph/bipartite-graph-bfs-implementation/
 * https://youtu.be/-vu34sct1g8
 * https://leetcode.com/problems/is-graph-bipartite/description/
 * https://www.geeksforgeeks.org/problems/bipartite-graph/1
*/

package graph;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class BipartiteGraphBFS {

    public boolean isBipartite(int[][] adjList) {
        int V = adjList.length;
        int[] color = new int[V];
        Arrays.fill(color, -1);

        for (int source = 0; source < V; source++) {
            if (color[source] == -1) {
                Queue<Integer> queue = new ArrayDeque<>();
                queue.add(source);
                color[source] = 1;

                while (!queue.isEmpty()) {
                    int node = queue.remove();

                    for (int nbr : adjList[node]) {
                        if (color[nbr] == -1) {
                            queue.add(nbr);
                            color[nbr] = 1 - color[node];
                        } else if (color[nbr] == color[node]) {
                            return false;
                        }
                    }
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {

        int[][] adj1 = { { 1, 2, 3 }, { 0, 2 }, { 0, 1, 3 }, { 0, 2 } };
        int[][] adj2 = { { 1, 3 }, { 0, 2 }, { 1, 3 }, { 0, 2 } };
        int[][] adj3 = { {}, { 2, 4, 6 }, { 1, 4, 8, 9 }, { 7, 8 }, { 1, 2, 8, 9 }, { 6, 9 }, { 1, 5, 7, 8, 9 },
                { 3, 6, 9 }, { 2, 3, 4, 6, 9 }, { 2, 4, 5, 6, 7, 8 } };

        BipartiteGraphBFS sol = new BipartiteGraphBFS();
        System.out.println(sol.isBipartite(adj1));
        System.out.println(sol.isBipartite(adj2));
        System.out.println(sol.isBipartite(adj3));
    }
}
