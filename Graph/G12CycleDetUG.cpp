/*
Intuition:
The cycle in a graph starts from a node and ends at the same node. DFS is a
traversal technique that involves the idea of recursion and backtracking. DFS
goes in-depth, i.e., traverses all nodes by going ahead, and when there are no
further nodes to traverse in the current path, then it backtracks on the same
path and traverses other unvisited nodes. The intuition is that we start from a
source and go in-depth, and reach any node that has been previously visited in
the past; it means there's a cycle.

Approach:
The algorithm steps are as follows:

In the DFS function call make sure to store the parent data along with the
source node, create a visited array, and initialize to 0. The parent is stored
so that while checking for re-visited nodes, we don’t check for parents. We run
through all the unvisited adjacent nodes using an adjacency list and call the
recursive dfs function. Also, mark the node as visited. If we come across a node
that is already marked as visited and is not a parent node, then keep on
returning true indicating the presence of a cycle; otherwise return false after
all the adjacent nodes have been checked and we did not find a cycle. NOTE: We
can call it a cycle only if the already visited node is a non-parent node
because we cannot say we came to a node that was previously the parent node.
*/

#include <iostream>
#include <vector>

using namespace std;
class Graph {
   private:
    int vertexCount;
    vector<vector<int>> adjList;
    vector<bool> visited;

   public:
    Graph(int vertexCount) : vertexCount(vertexCount) {
        adjList.resize(vertexCount);
        visited.resize(vertexCount, false);
    }

    void addEdge(int u, int v) {
        adjList[u].push_back(v);
        adjList[v].push_back(u);
    }

    bool dfsCycleDetection(int vertex, int parent) {
        visited[vertex] = true;
        for (int adjI = 0; adjI < adjList[vertex].size(); adjI++) {
            int nbr = adjList[vertex][adjI];
            if (visited[nbr]) {
                cout << nbr;
                return true;
            } else {
                if (dfsCycleDetection(nbr, vertex))
                    return true;
                else
                    continue;
            }
        }
        // no cycle
        return false;
    }

    bool isCycle() {
        fill(visited.begin(), visited.end(), false);
        for (int vertex = 0; vertex < vertexCount; vertex++) {
            if (!visited[vertex] && dfsCycleDetection(vertex, -1)) return true;
        }
        return false;
    }
};
int main() {
    Graph g(4);
    g.addEdge(0, 1);
    g.addEdge(1, 2);
    g.addEdge(2, 0);

    cout << (g.isCycle() ? "th vertex contains a cycle" : "No cycle present")
         << "\n";

    return 0;
}