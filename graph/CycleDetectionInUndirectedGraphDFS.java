/*
 * https://takeuforward.org/data-structure/detect-cycle-in-an-undirected-graph-using-dfs/
 * https://youtu.be/zQ3zgFypzX4
 * https://practice.geeksforgeeks.org/problems/detect-cycle-in-an-undirected-graph/1
*/

package graph;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CycleDetectionInUndirectedGraphDFS {

    public boolean isCycle(int V, int[][] edges) {
        List<List<Integer>> adjList = new ArrayList<>();
        for (int u = 0; u < V; u++) {
            adjList.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }
        boolean[] visited = new boolean[V];

        for (int u = 0; u < V; u++) {
            if (!visited[u]) {
                if (dfs(u, -1, adjList, visited)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean dfs(int source, int parent, List<List<Integer>> adjList, boolean[] visited) {
        visited[source] = true;

        for (int nbr : adjList.get(source)) {
            if (!visited[nbr]) {
                if (dfs(nbr, source, adjList, visited)) {
                    return true;
                }
            } else {
                if (nbr != parent) {
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
            CycleDetectionInUndirectedGraphDFS sol = new CycleDetectionInUndirectedGraphDFS();
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
