#include <iostream>
#include <queue>
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

    void bfs(int source) {
        queue<int> q;
        q.push(source);
        visited[source] = true;
        while (!q.empty()) {
            int n = q.size();
            for (int lvlIdx = 0; lvlIdx < n; lvlIdx++) {
                int cur = q.front();
                q.pop();

                cout << cur << " ";

                for (int adjI = 0; adjI < adjList[cur].size(); adjI++) {
                    int nbr = adjList[cur][adjI];
                    if (!visited[nbr]) {
                        q.push(nbr);
                        visited[nbr] = true;
                    }
                }
            }
            cout << '\n';
        }
    }

    void bfsAll() {
        for (int i = 0; i < vertexCount; i++) {
            if (!visited[i]) {
                cout << "Starting new BFS from vertex " << i << ":\n";
                bfs(i);
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

    g.bfsAll();
    return 0;
}
