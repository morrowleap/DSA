/*
Approach:
Consider the following graph:


We will be solving it using DFS traversal. DFS goes in-depth, i.e., traverses
all nodes by going ahead, and when there are no further nodes to traverse in the
current path, then it backtracks on the same path and traverses other unvisited
nodes.

The algorithm steps are as follows:

We will traverse the graph component-wise using the DFS technique.
Make sure to carry two visited arrays in the DFS call. One is a visited
array(vis) and the other is a path-visited(pathVis) array. The visited array
keeps a track of visited nodes, and the path-visited keeps a track of visited
nodes in the current traversal only. While making a DFS call, at first we will
mark the node as visited in both the arrays and then will traverse through its
adjacent nodes. Now, there may be either of the three cases: Case 1: If the
adjacent node is not visited, we will make a new DFS call recursively with that
particular node. Case 2: If the adjacent node is visited and also on the same
path(i.e marked visited in the pathVis array), we will return true, because it
means it has a cycle, thereby the pathVis was true. Returning true will mean the
end of the function call, as once we have got a cycle, there is no need to check
for further adjacent nodes. Case 3: If the adjacent node is visited but not on
the same path(i.e not marked in the pathVis array), we will continue to the next
adjacent node, as it would have been marked as visited in some other path, and
not on the current one. Finally, if there are no further nodes to visit, we will
unmark the current node in the pathVis array and just return false. Then we will
backtrack to the previous node with the returned value. The point to remember
is, while we enter we mark both the pathVis and vis as true, but at the end of
traversal to all adjacent nodes, we just make sure we unmark the pathVis and
still keep the vis marked as true, as it will avoid future extra traversal
calls.

*/
#include <iostream>
#include <vector>

using namespace std;

class Graph {
   private:
    int vertexCount;
    vector<vector<int>> adjList;
    vector<bool> visited;
    vector<bool> pathVisited;

   public:
    Graph(int vertexCount) : vertexCount(vertexCount) {
        adjList.resize(vertexCount);
        visited.resize(vertexCount, false);
        pathVisited.resize(vertexCount, false);
    }

    void addEdge(int u, int v) { adjList[u].push_back(v); }

    bool dfsCycleDetection(int vertex) {
        visited[vertex] = true;
        pathVisited[vertex] = true;

        for (int adjI = 0; adjI < adjList[vertex].size(); adjI++) {
            int nbr = adjList[vertex][adjI];
            if (visited[nbr]) {
                if (pathVisited[nbr]) {
                    cout << nbr;
                    return true;
                } else
                    continue;
            } else {
                if (dfsCycleDetection(nbr))
                    return true;
                else
                    continue;
            }
        }
        pathVisited[vertex] = false;
        // no cycle
        return false;
    }

    bool isCycle() {
        fill(visited.begin(), visited.end(), false);
        fill(pathVisited.begin(), pathVisited.end(), false);

        for (int vertex = 0; vertex < vertexCount; vertex++) {
            if (!visited[vertex] && dfsCycleDetection(vertex)) return true;
        }
        return false;
    }
};

int main() {
    Graph g(11);
    g.addEdge(1, 2);
    g.addEdge(2, 3);
    g.addEdge(3, 4);
    g.addEdge(3, 7);
    g.addEdge(4, 5);
    g.addEdge(7, 5);
    g.addEdge(5, 6);
    g.addEdge(8, 2);
    g.addEdge(8, 9);
    g.addEdge(9, 10);
    g.addEdge(10, 8);

    cout << (g.isCycle() ? "th vertex contains a cycle" : "No cycle present")
         << "\n";

    return 0;
}
