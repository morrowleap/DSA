/*
 * https://takeuforward.org/data-structure/disjoint-set-union-by-rank-union-by-size-path-compression-g-46/
 * https://youtu.be/aBxjDBC4M1U
 * 
 * Dynamic Graphs
*/

package graph;

public class DisjointSet {
    int[] parent, rank, size;

    public DisjointSet(int V) {
        parent = new int[V];
        rank = new int[V];
        size = new int[V];
        for (int u = 0; u <= V; u++) {
            parent[u] = u;
            rank[u] = 0;
            size[u] = 1;
        }
    }

    private int findUPar(int node) {
        if (node == parent[node]) {
            return node;
        }

        int ulp = findUPar(parent[node]); // Recursion to at most parent node
        parent[node] = ulp; // path compression technique, we are breaking the bond of node and its parent
                            // and making a bond of node and ultimate parent while backtracking
        return ulp;
    }

    private void unionByRank(int u, int v) {
        int ulp_u = findUPar(u);
        int ulp_v = findUPar(v);

        if (ulp_u != ulp_v) {
            if (rank[ulp_u] < rank[ulp_v]) {
                parent[ulp_u] = ulp_v;
            } else if (rank[ulp_u] > rank[ulp_v]) {
                parent[ulp_v] = ulp_u;
            } else {
                parent[ulp_v] = ulp_u;
                rank[ulp_u] = rank[ulp_u] + 1;
            }
        }
    }

    private void unionBySize(int u, int v) {
        int ulp_u = findUPar(u);
        int ulp_v = findUPar(v);

        if (ulp_u != ulp_v) {
            if (size[ulp_u] < size[ulp_v]) {
                parent[ulp_u] = ulp_v;
                size[ulp_v] = size[ulp_v] + size[ulp_u];
            } else if (size[ulp_u] > size[ulp_v]) {
                parent[ulp_v] = ulp_u;
                size[ulp_u] = size[ulp_u] + size[ulp_v];
            } else {
                parent[ulp_v] = ulp_u;
                size[ulp_u] = size[ulp_u] + size[ulp_v];
            }
        }
    }

    public static void main(String[] args) {
        DisjointSet ds = new DisjointSet(7);
        ds.unionByRank(1, 2);
        ds.unionByRank(2, 3);
        ds.unionByRank(4, 5);
        ds.unionByRank(6, 7);
        ds.unionByRank(5, 6);

        // if 3 and 7 same or not
        if (ds.findUPar(3) == ds.findUPar(7)) {
            System.out.println("Same");
        } else
            System.out.println("Not Same");

        ds.unionByRank(3, 7);
        if (ds.findUPar(3) == ds.findUPar(7)) {
            System.out.println("Same");
        } else
            System.out.println("Not Same");

        DisjointSet ds2 = new DisjointSet(7);
        ds2.unionBySize(1, 2);
        ds2.unionBySize(2, 3);
        ds2.unionBySize(4, 5);
        ds2.unionBySize(6, 7);
        ds2.unionBySize(5, 6);

        // if 3 and 7 same or not
        if (ds2.findUPar(3) == ds2.findUPar(7)) {
            System.out.println("Same");
        } else
            System.out.println("Not Same");

        ds2.unionBySize(3, 7);
        if (ds2.findUPar(3) == ds2.findUPar(7)) {
            System.out.println("Same");
        } else
            System.out.println("Not Same");
    }
}
