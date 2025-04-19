/*
 * https://youtu.be/iTBaI90lpDQ
 * https://takeuforward.org/data-structure/detect-a-cycle-in-directed-graph-topological-sort-kahns-algorithm-g-23/
 * 
 * https://www.geeksforgeeks.org/detect-cycle-in-a-directed-graph-using-bfs/
 * 
 * https://www.geeksforgeeks.org/problems/detect-cycle-in-a-directed-graph/1
*/

package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class CycleDetectionInDirectedGraphBFS {

    public boolean isCyclic(int V, int[][] edges) {
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
        // Tasks with no dependency, added to queue
        for (int u = 0; u < V; u++) {
            if (indegree[u] == 0) {
                queue.add(u);
            }
        }

        int count = 0;
        while (!queue.isEmpty()) {
            int node = queue.remove();
            count++;

            for (int nbr : adjList.get(node)) {
                indegree[nbr]--;

                if (indegree[nbr] == 0) {
                    queue.add(nbr);
                }
            }
        }

        return count != V;
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
