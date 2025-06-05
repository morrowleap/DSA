/*
 * https://takeuforward.org/data-structure/disjoint-set-union-by-rank-union-by-size-path-compression-g-46/
 * https://youtu.be/aBxjDBC4M1U
 * 
 * Dynamic Graphs
*/

// https://leetcode.com/problems/lexicographically-smallest-equivalent-string/submissions/1655069401/?envType=daily-question&envId=2025-06-05

package graph;

public class DisjointSet {
    int[] parent, rank, size;

    public DisjointSet(int V) {
        parent = new int[V + 1];
        rank = new int[V + 1];
        size = new int[V + 1];
        for (int u = 0; u <= V; u++) {
            parent[u] = u;
            rank[u] = 0;
            size[u] = 1;
        }
    }

    private int findUltimateParent(int node) {
        if (node == parent[node]) {
            return node;
        }

        int ulp = findUltimateParent(parent[node]); // Recursion to at most parent node
        parent[node] = ulp; // path compression technique, we are breaking the bond of node and its parent
                            // and making a bond of node and ultimate parent while backtracking
        return ulp;
    }

    private void unionByRank(int u, int v) {
        int ulp_u = findUltimateParent(u);
        int ulp_v = findUltimateParent(v);

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
        int ulp_u = findUltimateParent(u);
        int ulp_v = findUltimateParent(v);

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
        System.out.println((char) ('a' + 1));
        // DisjointSet ds = new DisjointSet(7);
        // ds.unionByRank(1, 2);
        // ds.unionByRank(2, 3);
        // ds.unionByRank(4, 5);
        // ds.unionByRank(6, 7);
        // ds.unionByRank(5, 6);

        // // if 3 and 7 same or not
        // if (ds.findUltimateParent(3) == ds.findUltimateParent(7)) {
        // System.out.println("Same");
        // } else
        // System.out.println("Not Same");

        // ds.unionByRank(3, 7);
        // if (ds.findUltimateParent(3) == ds.findUltimateParent(7)) {
        // System.out.println("Same");
        // } else
        // System.out.println("Not Same");

        // DisjointSet ds2 = new DisjointSet(7);
        // ds2.unionBySize(1, 2);
        // ds2.unionBySize(2, 3);
        // ds2.unionBySize(4, 5);
        // ds2.unionBySize(6, 7);
        // ds2.unionBySize(5, 6);

        // // if 3 and 7 same or not
        // if (ds2.findUltimateParent(3) == ds2.findUltimateParent(7)) {
        // System.out.println("Same");
        // } else
        // System.out.println("Not Same");

        // ds2.unionBySize(3, 7);
        // if (ds2.findUltimateParent(3) == ds2.findUltimateParent(7)) {
        // System.out.println("Same");
        // } else
        // System.out.println("Not Same");
    }
}
