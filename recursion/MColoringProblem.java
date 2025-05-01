/*
 * https://takeuforward.org/data-structure/m-coloring-problem/
 * https://youtu.be/wuVwUK25Rfc
 * 
 * https://www.geeksforgeeks.org/problems/m-coloring-problem-1587115620/1
*/

package recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MColoringProblem {
    boolean graphColoring(int V, int[][] edges, int m) {
        List<List<Integer>> adjList = new ArrayList<>();
        for (int u = 0; u < V; u++) {
            adjList.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }

        int[] color = new int[V];
        Arrays.fill(color, -1);

        return solve(0, V, adjList, color, m);
    }

    private boolean solve(int node, int V, List<List<Integer>> adjList, int[] color, int m) {
        if (node == V) {
            return true;
        }

        for (int c = 0; c < m; c++) {
            if (isSafe(node, adjList, c, color)) {
                color[node] = c;
                if (solve(node + 1, V, adjList, color, m) == true) {
                    return true;
                }
                color[node] = -1;
            }
        }

        return false;
    }

    private boolean isSafe(int node, List<List<Integer>> adjList, int c, int[] color) {
        for (int nbr : adjList.get(node)) {
            if (color[nbr] == c) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int V = 4, edges[][] = { { 0, 1 }, { 1, 2 }, { 2, 3 }, { 3, 0 }, { 0, 2 } }, m = 3;

        MColoringProblem sol = new MColoringProblem();
        boolean result = sol.graphColoring(V, edges, m);

        if (result)
            System.out.println("The graph can be colored using " + m + " colors.");
        else
            System.out.println("The graph cannot be colored using " + m + " colors.");
    }
}
