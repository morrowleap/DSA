#include <iostream>
#include <numeric>
#include <vector>

using namespace std;

class DisjointSet {
   private:
    int vertexCount;
    vector<int> rank, parent, size;

   public:
    DisjointSet(int vertexCount)
        : vertexCount(vertexCount),  // Set the number of vertices
          rank(vertexCount, 0),      // Initialize ranks of vertices to 0
          parent(vertexCount),       // Reserve space for parent pointers
          size(vertexCount, 1)       // Initialize size of vertices to 1
    {
        // Fill parent vector where each vertex is its own parent
        iota(parent.begin(), parent.end(), 0);
        // Initially, every vertex is a parent of itself with rank 0
        // Initially, every vertex is a parent of itself with size 1
    }

    int findULP(int node) {  // find Ultimate Parent
        if (node < 0 || node >= vertexCount) {
            throw std::out_of_range("Node index out of range");
        }
        if (parent[node] != node) {
            // If the current node is not the root, find the root of its parent
            // and apply path compression by setting the parent of the current
            // node directly to the root.
            parent[node] = findULP(parent[node]);
            return parent[node];  // Return the updated parent.
        } else {
            // If the current node is the root (i.e., its parent is itself),
            // simply return the node.
            return node;
        }
    }

    void unionByRank(int u, int v) {
        if (u < 0 || u >= vertexCount || v < 0 || v >= vertexCount) {
            throw std::out_of_range("Node index out of range");
        }
        int ulp_u = findULP(u);
        int ulp_v = findULP(v);

        if (ulp_u != ulp_v) {  // Only unite if they are in different sets
            if (rank[ulp_u] < rank[ulp_v]) {
                // If root1 has smaller rank, make root2 the parent
                parent[ulp_u] = ulp_v;
            } else if (rank[ulp_u] > rank[ulp_v]) {
                // If root1 has greater rank, make root1 the parent of root2
                parent[ulp_v] = ulp_u;
            } else {
                // If both have the same rank, choose one as the new root and
                // increment its rank
                parent[ulp_v] = ulp_u;
                rank[ulp_u]++;
            }
        }
    }

    void unionBySize(int u, int v) {
        if (u < 0 || u >= vertexCount || v < 0 || v >= vertexCount) {
            throw std::out_of_range("Node index out of range");
        }
        int ulp_u = findULP(u);
        int ulp_v = findULP(v);

        if (ulp_u != ulp_v) {
            if (size[ulp_u] <= size[ulp_v]) {
                parent[ulp_u] = ulp_v;
                size[ulp_v] += size[ulp_u];
            } else {
                parent[ulp_v] = ulp_u;
                size[ulp_u] += size[ulp_v];
            }
        }
    }
};

int main() {
    DisjointSet ds(8);
    // ds.unionByRank(1, 2);
    // ds.unionByRank(2, 3);
    // ds.unionByRank(4, 5);
    // ds.unionByRank(6, 7);
    // ds.unionByRank(5, 6);
    // // if 3 and 7 belongs to same component or not ?
    // if (ds.findULP(3) == ds.findULP(7)) {
    //     cout << "Same\n";
    // } else {
    //     cout << "Not Same\n";
    // }

    // ds.unionByRank(3, 7);

    // if (ds.findULP(3) == ds.findULP(7)) {
    //     cout << "Same\n";
    // } else {
    //     cout << "Not Same\n";
    // }

    ds.unionBySize(1, 2);
    ds.unionBySize(2, 3);
    ds.unionBySize(4, 5);
    ds.unionBySize(6, 7);
    ds.unionBySize(5, 6);
    // if 3 and 7 belongs to same component or not ?
    if (ds.findULP(3) == ds.findULP(7)) {
        cout << "Same\n";
    } else {
        cout << "Not Same\n";
    }

    ds.unionBySize(3, 7);

    if (ds.findULP(3) == ds.findULP(7)) {
        cout << "Same\n";
    } else {
        cout << "Not Same\n";
    }

    return 0;
}

// 128. Longest Consecutive Sequence
// https://leetcode.com/problems/longest-consecutive-sequence/solutions/166544/union-find-thinking-process/