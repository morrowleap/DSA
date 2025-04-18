/*
 * https://takeuforward.org/data-structure/detect-cycle-in-an-undirected-graph-using-bfs/
 * https://youtu.be/BPlrALf1LDU
 * https://practice.geeksforgeeks.org/problems/detect-cycle-in-an-undirected-graph/1
*/

package graph;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CycleDetectionInUnirectedGraphBFS {

    public boolean isCycle(int V, int[][] edges) {
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }
        boolean[] visited = new boolean[V];

        for (int u = 0; u < V; u++) {
            if (!visited[u]) {
                if (bfs(adjList, visited, u)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean bfs(List<List<Integer>> adjList, boolean[] visited, int source) {
        Queue<int[]> queue = new LinkedList<>();

        int parent = -1;
        queue.add(new int[] { source, parent });
        visited[source] = true;

        while (!queue.isEmpty()) {
            int[] x = queue.remove();
            int u = x[0], p = x[1];

            for (int v : adjList.get(u)) {
                if (!visited[v]) {
                    queue.add(new int[] { v, u });
                    visited[v] = true;
                } else if (visited[v] && v != p) {
                    return true;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        try {

            // File path of the input file (in Downloads folder)
            String filePath = System.getProperty("user.home") + "/Downloads/fileInput.txt";

            // Reading the file
            BufferedReader br;

            br = new BufferedReader(new FileReader(filePath));
            // Read number of vertices
            int V = Integer.parseInt(br.readLine().trim());

            // Read number of edges (not needed, but can be used for validation)
            int E = Integer.parseInt(br.readLine().trim());

            // Prepare the edges array
            int[][] edges = new int[E][2];

            // Read edges
            for (int i = 0; i < E; i++) {
                String[] edge = br.readLine().trim().split(" ");
                edges[i][0] = Integer.parseInt(edge[0]);
                edges[i][1] = Integer.parseInt(edge[1]);
            }

            // Close the file reader
            br.close();

            // Now call the cycle detection function
            CycleDetectionInUnirectedGraphBFS sol = new CycleDetectionInUnirectedGraphBFS();
            System.out.println(sol.isCycle(V, edges));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (NumberFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
