/*
 * https://takeuforward.org/graph/connected-components-in-graphs/
 * https://youtu.be/lea-Wl_uWXY
 * https://neetcode.io/problems/count-connected-components
*/

/*Number of Connected Components in an Undirected Graph
There is an undirected graph with n nodes. There is also an edges array, where edges[i] = [a, b] means that there is an edge between node a and node b in the graph.

The nodes are numbered from 0 to n - 1.

Return the total number of connected components in that graph.

Example 1:

Input:
n=3
edges=[[0,1], [0,2]]

Output:
1
Example 2:

Input:
n=6
edges=[[0,1], [1,2], [2,3], [4,5]]

Output:
2
Constraints:

1 <= n <= 100
0 <= edges.length <= n * (n - 1) / 2
*/

package graph;

import java.util.LinkedList;
import java.util.Queue;

public class ConnectedComponents {

    public int countComponents(int n, int[][] edges) {
        Graph g = new Graph(n);
        for (int[] edge : edges) {
            g.addEdge(edge[0], edge[1]);
        }

        int count = 0;
        boolean[] visited = new boolean[n];
        for (int u = 0; u < n; u++) {
            if (!visited[u]) {
                count++;

                Queue<Integer> q = new LinkedList<>();
                q.add(u);
                while (!q.isEmpty()) {
                    int x = q.remove();
                    visited[x] = true;

                    for (int v : g.adjList.get(x)) {
                        if (!visited[v]) {
                            q.add(v);
                        }
                    }
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        ConnectedComponents sol = new ConnectedComponents();

        int n = 3;
        int[][] edges = new int[][] { { 0, 1 }, { 0, 2 } };
        System.out.println(sol.countComponents(n, edges));
    }
}
