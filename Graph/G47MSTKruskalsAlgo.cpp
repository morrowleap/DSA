#include <iostream>
#include <numeric>
#include <vector>

using namespace std;

class DisjointSet {
   private:
    int vertexCount;
    vector<int> parent, size;

   public:
    DisjointSet(int vertexCount)
        : vertexCount(vertexCount), parent(vertexCount), size(vertexCount, 1) {
        iota(parent.begin(), parent.end(), 0);
    }

    int findULP(int vertex) {
        if (vertex < 0 || vertex >= vertexCount) {
            throw std::out_of_range("Node index out of range");
        }
        if (vertex == parent[vertex]) {
            return vertex;
        }
        return parent[vertex] = findULP(parent[vertex]);
    }

    void unionBySize(int u, int v) {
        if (u < 0 || u >= vertexCount || v < 0 || v >= vertexCount) {
            throw std::out_of_range("Node index out of range");
        }
        int ulp_u = findULP(u);
        int ulp_v = findULP(v);
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
};

class Graph {
   private:
    int vertexCount;
    vector<vector<pair<int, int>>> adjList;  // [u: [{v, w}]] adjNodes

   public:
    int weightSum;
    vector<pair<int, pair<int, int>>> mstPath;  // {w, {u, v}} edge

    Graph(int vertexCount) : vertexCount(vertexCount), adjList(vertexCount) {
        weightSum = 0;
    }

    void addEdge(int u, int v, int w) {
        adjList[u].push_back({v, w});
        adjList[v].push_back({u, w});
    }

    void kruskalsAlgo() {
        vector<pair<int, pair<int, int>>> edges;  // {w, {u, v}} edge

        for (int u = 0; u < vertexCount; u++) {
            vector<pair<int, int>> adjNodes = adjList[u];
            for (pair<int, int> x : adjNodes) {
                int v = x.first;
                int w = x.second;

                edges.push_back({w, {u, v}});
            }
        }

        sort(edges.begin(), edges.end());

        DisjointSet ds(vertexCount);

        for (pair<int, pair<int, int>> edge : edges) {
            int u = edge.second.first;
            int v = edge.second.second;
            int w = edge.first;

            if (ds.findULP(u) != ds.findULP(v)) {
                ds.unionBySize(u, v);

                weightSum += w;
                mstPath.push_back(edge);
            }
        }
    }
};

int main() {
    Graph g(3);
    g.addEdge(0, 1, 5);
    g.addEdge(1, 2, 3);
    g.addEdge(0, 2, 1);

    g.kruskalsAlgo();

    for (pair<int, pair<int, int>> edge : g.mstPath) {
        cout << edge.second.first << "," << edge.second.second << " ";
    }
    cout << "\n";
    cout << "weighted sum: " << g.weightSum << "\n";

    return 0;
}