/*
 * https://takeuforward.org/data-structure/depth-first-search-dfs/
 * https://youtu.be/Qzf1a--rhp8
*/

package graph;

public class DFS {

    private void dfsAll(int n, int[][] edges) {
        Graph g = new Graph(n);
        for (int[] edge : edges) {
            g.addEdge(edge[0], edge[1]);
        }

        boolean[] visited = new boolean[n];

        for (int u = 0; u < g.vertexCount; u++) {
            if (!visited[u]) {
                System.out.println("Starting new BFS from vertex " + u + ":");
                dfs(g, u, visited);
                System.out.println();
            }
        }
    }

    private void dfs(Graph g, int vertex, boolean[] visited) {
        visited[vertex] = true;

        System.out.print(vertex + " ");

        for (int nbr : g.adjList.get(vertex)) {
            if (!visited[nbr]) {
                dfs(g, nbr, visited);
            }
        }
    }

    public static void main(String[] args) {

        int n = 7;
        int[][] edges = new int[][] { { 0, 1 }, { 0, 2 }, { 1, 3 }, { 1, 4 }, { 1, 5 }, { 1, 6 }, { 6, 2 } };

        DFS sol = new DFS();
        sol.dfsAll(n, edges);
    }
}
