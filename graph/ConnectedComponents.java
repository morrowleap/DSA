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

import java.util.ArrayList;
import java.util.List;

class Graph {
    public int vertexCount;
    public List<List<Integer>> adjList;

    Graph(int vertexCount) {
        this.vertexCount = vertexCount;
        adjList = new ArrayList<>();
        for (int i = 0; i <= vertexCount; i++) {
            adjList.add(new ArrayList<>());
        }
    }

    public void addEdge(int u, int v) {
        adjList.get(u).add(v);
        adjList.get(v).add(u);
    }
}

public class ConnectedComponents {

}
