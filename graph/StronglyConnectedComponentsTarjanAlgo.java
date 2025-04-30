/*
 * https://takeuforward.org/graph/bridges-in-graph-using-tarjans-algorithm-of-time-in-and-low-time-g-55/
 * https://youtu.be/qrAub5z8FeA
 * 
 * https://leetcode.com/problems/critical-connections-in-a-network/description/
*/

package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StronglyConnectedComponentsTarjanAlgo {

    private int timer = 1;

    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }
        for (List<Integer> edge : connections) {
            int u = edge.get(0), v = edge.get(1);
            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }

        boolean[] visited = new boolean[n];
        int[] timeOfInsertion = new int[n];
        int[] lowestTimeOfInsertion = new int[n]; // minimum lowest time of insertion of all adjacent nodes apart from
                                                  // parent

        List<List<Integer>> bridges = new ArrayList<>();

        for (int u = 0; u < n; u++)
            if (!visited[u])
                dfs(u, -1, visited, adjList, timeOfInsertion, lowestTimeOfInsertion, bridges);
        return bridges;
    }

    private void dfs(int node, int parent, boolean[] visited, List<List<Integer>> adjList,
            int[] timeOfInsertion,
            int[] lowestTimeOfInsertion, List<List<Integer>> bridges) {
        visited[node] = true;
        // Maintains the series in which graph is bieng searched
        timeOfInsertion[node] = lowestTimeOfInsertion[node] = timer++;

        for (int nbr : adjList.get(node)) {
            if (nbr == parent) {
                continue;
            }

            if (!visited[nbr]) {
                dfs(nbr, node, visited, adjList, timeOfInsertion, lowestTimeOfInsertion, bridges);

                // after nbr came back from dfs, check if its lowest time is lower than my
                // lowest time
                // If yes that means the nbr can touch someone that is traversed earlier, so i
                // can also touch that
                lowestTimeOfInsertion[node] = Math.min(lowestTimeOfInsertion[node], lowestTimeOfInsertion[nbr]);

                // Now check if the edge between node and nbr can be a bridge
                // We will hypothetically remove this edge, and will try to find current node
                // from nbr
                // If the lowest time of insertion of nbr is less our time of insertion, that
                // means we can reach to a node from nbr which was traversed before our current
                // node and from thier we can reach our current node from another path
                if (timeOfInsertion[node] < lowestTimeOfInsertion[nbr]) {
                    bridges.add(Arrays.asList(node, nbr));
                }
            } else {
                // Just update the lowest time because this shows our current node can touch a
                // nbr which was already traversed earlier
                lowestTimeOfInsertion[node] = Math.min(lowestTimeOfInsertion[node], lowestTimeOfInsertion[nbr]);
            }
        }
    }

    public static void main(String[] args) {
        int n = 4, connections[][] = { { 0, 1 }, { 1, 2 }, { 2, 0 }, { 1, 3 } };
        List<List<Integer>> c = new ArrayList<>();
        for (int[] edge : connections) {
            c.add(Arrays.asList(edge[0], edge[1]));
        }

        StronglyConnectedComponentsTarjanAlgo sol = new StronglyConnectedComponentsTarjanAlgo();
        System.out.println(sol.criticalConnections(n, c));
    }
}
