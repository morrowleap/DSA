#include <iostream>
#include <vector>
using namespace std;

class Graph {
   private:
    int vertexCount;
    vector<vector<int>> adjList;
    vector<vector<int>> adjMatrix;

   public:
    Graph(int vertexCount) : vertexCount(vertexCount) {
        adjList.resize(vertexCount);
        adjMatrix.resize(vertexCount, vector<int>(vertexCount, 0));
    }

    void addEdge(int u, int v) {
        adjList[u].push_back(v);
        adjList[v].push_back(u);

        adjMatrix[u][v] = 1;
        adjMatrix[u][v] = 1;
    }

    void printAdjList() {
        for (int u = 0; u < vertexCount; u++) {
            cout << u << "-> ";
            for (int v : adjList[u]) {
                cout << v << " ";
            }
            cout << '\n';
        }
    }

    void printMatrix() {
        for (int i = 0; i < vertexCount; ++i) {
            for (int j = 0; j < vertexCount; ++j) {
                cout << adjMatrix[i][j] << " ";
            }
            cout << '\n';
        }
    }
};

int main() {
    Graph g(4);
    g.addEdge(0, 1);
    g.addEdge(0, 2);
    g.addEdge(1, 2);
    g.addEdge(2, 3);

    g.printAdjList();
    g.printMatrix();
    return 0;
}