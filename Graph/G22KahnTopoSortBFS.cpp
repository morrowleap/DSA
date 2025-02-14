/*
A Topological Ordering is an ordering of the nodes in a directed graph where
for each directed edge from node A to node B, node A appears before node B in
the ordering.

Note: Topological orderings are NOT unique.

"Not Every Graph has a Topological Sort!"

A simple directed graph with four nodes labeled A, B, C, and
D, arranged in a cycle: A → B → C → D → A. This cycle indicates why a
topological sort is not possible, as topological sorting requires the graph to
be a Directed Acyclic Graph (DAG) and this graph clearly contains a cycle.

Not Every Graph has a Topological Sort!
Directed Cyclic Graph cannot have a Topological Sort.
Only Directed Acyclic Graph (DAG) have a valid Topological Sort.



Sample Test Case and intuition

The image depicts a directed graph with the following structure:

Node A at the top, with directed edges to nodes B, C, and D.
Node B has directed edges to nodes E and F.
Node C has a directed edge to node G.
Nodes D, E, F, and G do not have outgoing edges.


Algorithm
While(All the nodes are not visited)
Nodes with zero indegree can be added to the output array.
All the nodes which are adjacent to terminal nodes, gets their indegree
subtracted

*/
#include <iostream>
#include <queue>
#include <vector>

using namespace std;

class Graph {
   private:
    int vertexCount;
    vector<vector<int>> adjList;
    vector<int> indeg;

   public:
    Graph(int vertexCount) : vertexCount(vertexCount) {
        adjList.resize(vertexCount);
        indeg.resize(vertexCount, 0);
    }

    void addEdge(int u, int v) {
        adjList[u].push_back(v);
        indeg[v]++;
    }

    vector<int> topoSort() {
        vector<int> topo;
        queue<int> q;

        for (int vertex = 0; vertex < vertexCount; vertex++) {
            if (indeg[vertex] == 0) q.push(vertex);
        }

        while (!q.empty()) {
            int node = q.front();
            q.pop();

            topo.push_back(node);

            for (int adjI = 0; adjI < adjList[node].size(); adjI++) {
                int nbr = adjList[node][adjI];
                indeg[nbr]--;

                if (indeg[nbr] == 0) {
                    q.push(nbr);
                }
            }
        }

        return topo;
    }
};

int main() {
    Graph g(6);

    g.addEdge(5, 0);
    g.addEdge(5, 2);
    g.addEdge(2, 3);
    g.addEdge(3, 1);
    g.addEdge(4, 1);
    g.addEdge(4, 0);

    vector<int> topo = g.topoSort();
    for (int i : topo) {
        cout << i << " ";
    }
    cout << "\n";

    return 0;
}