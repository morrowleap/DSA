#include <iostream>
#include <queue>
#include <vector>

using namespace std;

class MSTEdge {
   public:
    int weight;
    int curVertex;
    int parent;

    MSTEdge(int weight, int curVertex, int parent)
        : weight(weight), curVertex(curVertex), parent(parent) {}
};

struct MSTEdgeComparator {
    bool operator()(const MSTEdge& e1, const MSTEdge& e2) {
        // Min-heap if we return true when first edge's weight is greater
        return e1.weight > e2.weight;
    }
};

class Graph {
   private:
    int vertexCount;
    vector<vector<pair<int, int>>> adjList;  // u: [{v, w}]
    vector<bool> visited;

   public:
    vector<MSTEdge> mstPath;
    int weightSum;

    Graph(int vertexCount)
        : vertexCount(vertexCount),
          adjList(vertexCount),
          visited(vertexCount, false) {
        weightSum = 0;
    }

    void addEdge(int u, int v, int w) {
        adjList[u].push_back({v, w});
        adjList[v].push_back({u, w});
    }

    void primsAlgo(int source) {
        priority_queue<MSTEdge, vector<MSTEdge>, MSTEdgeComparator> pq;
        pq.push(MSTEdge(0, source, -1));

        while (!pq.empty()) {
            MSTEdge edge = pq.top();
            pq.pop();

            int p = edge.parent;
            int u = edge.curVertex;
            int w = edge.weight;

            if (visited[u]) continue;
            visited[u] = true;

            if (p != -1) {
                mstPath.push_back(edge);
                weightSum += w;
            }

            for (pair<int, int> vw : adjList[u]) {
                if (!visited[vw.first])
                    pq.push(MSTEdge(vw.second, vw.first, u));
            }
        }
    }
};

int main() {
    Graph g(7);
    g.addEdge(0, 1, 2);
    g.addEdge(0, 2, 1);
    g.addEdge(1, 2, 1);
    g.addEdge(2, 4, 2);
    g.addEdge(2, 3, 2);
    g.addEdge(3, 4, 1);

    g.primsAlgo(0);

    for (MSTEdge edge : g.mstPath) {
        cout << edge.parent << "," << edge.curVertex << " ";
    }
    cout << "\n";
    cout << "weighted sum: " << g.weightSum << "\n";

    return 0;
}