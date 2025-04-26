/*
 * https://takeuforward.org/data-structure/prims-algorithm-minimum-spanning-tree-c-and-java-g-45/
 * https://youtu.be/mJcZjjKzeqk
 * 
 * https://www.geeksforgeeks.org/prims-minimum-spanning-tree-mst-greedy-algo-5/
 * https://www.geeksforgeeks.org/problems/minimum-spanning-tree/1
*/

package graph;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class MSPPrims {
    static int spanningTree(int V, int E, List<List<int[]>> adjList) {
        boolean[] visited = new boolean[V];
        int source = 0, sum = 0;
        Queue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));

        minHeap.add(new int[] { 0, source });

        while (!minHeap.isEmpty()) {
            int[] x = minHeap.poll();
            int w = x[0], u = x[1];

            if (visited[u]) {
                continue;
            }

            sum += w;
            visited[u] = true;

            for (int[] nbr : adjList.get(u)) {
                int v = nbr[0], vw = nbr[1];

                if (!visited[v]) {
                    minHeap.add(new int[] { vw, v });
                }
            }
        }

        return sum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int V = sc.nextInt();
        int E = sc.nextInt();

        List<List<int[]>> adjList = new ArrayList<>();
        for (int u = 0; u < V; u++) {
            adjList.add(new ArrayList<>());
        }

        for (int i = 0; i < E; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();

            adjList.get(u).add(new int[] { v, w });
            adjList.get(v).add(new int[] { u, w });
        }

        System.out.println(MSPPrims.spanningTree(V, E, adjList));

        sc.close();
    }
}
