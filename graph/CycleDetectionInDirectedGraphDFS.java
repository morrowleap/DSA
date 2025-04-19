/*
 * https://takeuforward.org/data-structure/detect-cycle-in-a-directed-graph-using-dfs-g-19/
 * https://youtu.be/9twcmtQj4DU
 * 
 * https://www.geeksforgeeks.org/problems/detect-cycle-in-a-directed-graph/1
 * https://www.geeksforgeeks.org/detect-cycle-in-a-graph/
*/

package graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CycleDetectionInDirectedGraphDFS {

    public boolean isCyclic(int V, int[][] edges) {
        List<List<Integer>> adjList = new ArrayList<>();
        for (int u = 0; u < V; u++) {
            adjList.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            adjList.get(edge[0]).add(edge[1]);
        }

        boolean[] visited = new boolean[V];
        boolean[] pathVisited = new boolean[V];

        for (int source = 0; source < V; source++) {
            if (!visited[source] && dfs(source, adjList, visited, pathVisited)) {
                return true;
            }
        }
        return false;
    }

    private boolean dfs(int source, List<List<Integer>> adjList, boolean[] visited, boolean[] pathVisited) {
        visited[source] = true;
        pathVisited[source] = true;

        for (int nbr : adjList.get(source)) {
            if (!visited[nbr] && dfs(nbr, adjList, visited, pathVisited)) {
                return true;
            } else if (pathVisited[nbr]) {
                return true;
            }
        }

        pathVisited[source] = false;
        return false;
    }

    public static void main(String[] args) {
        int V1 = 4, edges1[][] = { { 0, 1 }, { 0, 2 }, { 1, 2 }, { 2, 0 }, { 2, 3 }
        };
        int V2 = 4, edges2[][] = { { 0, 1 }, { 0, 2 }, { 1, 2 }, { 2, 3 } };

        CycleDetectionInDirectedGraphDFS sol = new CycleDetectionInDirectedGraphDFS();
        System.out.println(sol.isCyclic(V1, edges1));
        System.out.println(sol.isCyclic(V2, edges2));

        Scanner sc = new Scanner(System.in);
        int V = sc.nextInt(), E = sc.nextInt();
        int[][] edges = new int[E][2];
        for (int i = 0; i < E; i++) {
            edges[i][0] = sc.nextInt();
            edges[i][1] = sc.nextInt();
        }
        System.out.println(sol.isCyclic(V, edges));
        sc.close();
    }
}
