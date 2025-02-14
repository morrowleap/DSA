#include <iostream>
#include <numeric>
#include <queue>
#include <vector>

using namespace std;

class Graph {
   private:
    int vertexCount;
    vector<vector<pair<int, int>>> adjList;  // u: {v, w}

   public:
    vector<int> dist;

    Graph(int vertexCount)
        : vertexCount(vertexCount), adjList(vertexCount), dist(vertexCount) {
        fill(dist.begin(), dist.end(), INT_MAX);
    }

    void addEdge(int u, int v, int w) {
        adjList[u].push_back({v, w});
        adjList[v].push_back({u, w});
    }

    void dijkstrasAlgo(int source) {
        priority_queue<pair<int, int>, vector<pair<int, int>>,
                       greater<pair<int, int>>>
            pq;  // {w, u}

        pq.push({0, source});
        dist[source] = 0;
        while (!pq.empty()) {
            pair<int, int> x = pq.top();
            pq.pop();

            int u = x.first;
            int w = x.second;

            for (int i = 0; i < adjList[u].size(); i++) {
                int v = adjList[u][i].first;
                int ww = adjList[u][i].second;

                if (dist[v] > ww + w) {
                    pq.push({ww + w, v});
                    dist[v] = ww + w;
                }
            }
        }
    }
};

int main() {
    Graph g(6);
    g.addEdge(0, 1, 4);
    g.addEdge(0, 2, 4);
    g.addEdge(1, 2, 2);
    g.addEdge(2, 3, 3);
    g.addEdge(2, 4, 1);
    g.addEdge(4, 5, 3);
    g.addEdge(5, 3, 2);
    g.addEdge(2, 5, 6);

    g.dijkstrasAlgo(0);
    cout << "Dist: ";
    for (int d : g.dist) {
        cout << d << " ";
    }
    cout << "\n";

    return 0;
}