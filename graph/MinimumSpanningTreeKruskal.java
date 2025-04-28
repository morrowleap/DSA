/*
 * https://takeuforward.org/data-structure/kruskals-algorithm-minimum-spanning-tree-g-47/
 * https://youtu.be/DMnDM_sxVig
 * 
 * https://www.geeksforgeeks.org/kruskals-minimum-spanning-tree-algorithm-greedy-algo-2/
 * https://www.geeksforgeeks.org/problems/minimum-spanning-tree-kruskals-algorithm/1
*/

package graph;

import java.util.Arrays;

class DSU {
    int[] parent, size;

    DSU(int V) {
        parent = new int[V];
        size = new int[V];
        for (int u = 0; u < V; u++) {
            size[u] = 1;
            parent[u] = u;
        }
    }

    int find(int node) {
        if (node == parent[node]) {
            return node;
        }
        int ulp = find(parent[node]);
        parent[node] = ulp;
        return ulp;
    }

    void union(int u, int v) {
        int ulp_u = find(u);
        int ulp_v = find(v);

        if (ulp_u != ulp_v) {
            if (size[ulp_u] < size[ulp_v]) {
                parent[ulp_u] = ulp_v;
                size[ulp_v] += size[ulp_u];
            } else {
                parent[ulp_v] = ulp_u;
                size[ulp_u] += size[ulp_v];
            }
        }
    }
}

class Edge implements Comparable<Edge> {
    int u, v, w;

    Edge(int u, int v, int w) {
        this.u = u;
        this.v = v;
        this.w = w;
    }

    @Override
    public int compareTo(Edge o) {
        return Integer.compare(w, o.w);
    }
}

public class MinimumSpanningTreeKruskal {

    private static int kruskalsMST(int V, int[][] edges) {
        int sum = 0;

        Edge[] customeEdges = new Edge[edges.length];
        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0], v = edges[i][1], w = edges[i][2];
            customeEdges[i] = new Edge(u, v, w);
        }

        Arrays.sort(customeEdges);

        DSU ds = new DSU(V);

        for (Edge edge : customeEdges) {
            if (ds.find(edge.u) != ds.find(edge.v)) {
                ds.union(edge.u, edge.v);
                sum += edge.w;
            }
        }

        return sum;
    }

    public static void main(String[] args) {
        int[][] edges = {
                { 0, 1, 10 }, { 1, 3, 15 }, { 2, 3, 4 }, { 2, 0, 6 }, { 0, 3, 5 }
        };

        System.out.println(kruskalsMST(4, edges));
    }
}
