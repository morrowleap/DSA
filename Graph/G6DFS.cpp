#include <iostream>
#include <vector>
using namespace std;

class Graph {
   private:
    int vertexCount;
    vector<vector<int>> adjList;
    vector<int> visited;

   public:
    Graph(int vertexCount) : vertexCount(vertexCount) {
        adjList.resize(vertexCount);
        visited.resize(vertexCount, false);
    }

    void addEdge(int u, int v) {
        adjList[u].push_back(v);
        adjList[v].push_back(u);
    }

    void dfs(int vertex) {
        visited[vertex] = true;

        cout << vertex << " ";

        for (int adjI = 0; adjI < adjList[vertex].size(); adjI++) {
            int nbr = adjList[vertex][adjI];
            if (!visited[nbr]) {
                dfs(nbr);
            }
        }
    }

    void dfsAll() {
        for (int i = 0; i < vertexCount; i++) {
            if (!visited[i]) {
                cout << "Starting new DFS from vertex " << i << ":\n";
                dfs(i);
                cout << "\n";
            }
        }
    }
};

int main() {
    Graph g(7);
    g.addEdge(0, 1);
    g.addEdge(0, 2);
    g.addEdge(1, 3);
    g.addEdge(1, 4);
    g.addEdge(1, 5);
    g.addEdge(1, 6);
    g.addEdge(6, 2);

    g.dfsAll();

    return 0;
}