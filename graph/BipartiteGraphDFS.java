/*
 * https://takeuforward.org/graph/bipartite-graph-dfs-implementation/
 * https://youtu.be/KG5YFfR0j8A
 * https://leetcode.com/problems/is-graph-bipartite/description/
 * 
 * https://www.geeksforgeeks.org/problems/bipartite-graph/1
 * https://www.geeksforgeeks.org/check-if-a-given-graph-is-bipartite-using-dfs/
*/

package graph;

import java.util.Arrays;

public class BipartiteGraphDFS {

    public boolean isBipartite(int[][] adjList) {
        int V = adjList.length;
        int[] color = new int[V];
        Arrays.fill(color, -1);

        for (int source = 0; source < V; source++) {
            if (color[source] == -1 && !dfs(source, adjList, color)) {
                return false;
            }
        }

        return true;
    }

    private boolean dfs(int source, int[][] adjList, int[] color) {
        for (int nbr : adjList[source]) {
            if (color[nbr] == -1) {
                color[nbr] = 1 - color[source];
                if (!dfs(nbr, adjList, color)) {
                    return false;
                }
            } else if (color[nbr] == color[source]) {
                return false;
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
