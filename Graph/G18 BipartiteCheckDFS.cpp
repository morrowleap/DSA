/*
Intuition:.
A bipartite graph is a graph which can be coloured using 2 colours such that no
adjacent nodes have the same colour. Any linear graph with no cycle is always a
bipartite graph. With a cycle, any graph with an even cycle length can also be a
bipartite graph. So, any graph with an odd cycle length can never be a bipartite
graph.

The intuition is the brute force of filling colours using any traversal
technique, just make sure no two adjacent nodes have the same colour. If at any
moment of traversal, we find the adjacent nodes to have the same colour, it
means that there is an odd cycle, or it cannot be a bipartite graph.


Approach:
We can follow either of the traversal techniques. In this article, we will be
solving it using DFS traversal.

DFS is a traversal technique which involves the idea of recursion and
backtracking. DFS goes in-depth, i.e., traverses all nodes by going ahead, and
when there are no further nodes to traverse in the current path, then it
backtracks on the same path and traverses other unvisited nodes.

We will be defining the DFS traversal below, but this check has to be done for
every component, for that we can use the simple for loop concept that we have
learnt, to call the traversals for unvisited nodes.


The algorithm steps are as follows:

For DFS traversal, we need a start node and a visited array but in this case,
instead of a visited array, we will take a colour array where all the nodes are
initialised to -1 indicating they are not coloured yet.

In the DFS function call, make sure to pass the value of the assigned colour,
and assign the same in the colour array. We will try to colour with 0 and 1, but
you can choose other colours as well. We will start with the colour 0, you can
start with 1 as well, just make sure for the adjacent node, it should be
opposite of what the current node has.

In DFS traversal, we travel in-depth to all its uncoloured neighbours using the
adjacency list. For every uncoloured node, initialise it with the opposite
colour to that of the current node.

If at any moment, we get an adjacent node from the adjacency list which is
already coloured and has the same colour as the current node, we can say it is
not possible to colour it, hence it cannot be bipartite. Thereby return a false
indicating the given graph is not bipartite; otherwise, keep on returning true.
*/

#include <iostream>
#include <vector>

using namespace std;

class Graph {
   private:
    int vertexCount;
    vector<vector<int>> adjList;
    vector<int> colors;

   public:
    Graph(int vertexCount) : vertexCount(vertexCount) {
        adjList.resize(vertexCount);
        colors.resize(vertexCount, -1);
    }

    void addEdge(int u, int v) {
        adjList[u].push_back(v);
        adjList[v].push_back(u);
    }

    bool dfs(int vertex, int color) {
        colors[vertex] = color;

        for (int adjI = 0; adjI < adjList[vertex].size(); adjI++) {
            int nbr = adjList[vertex][adjI];

            if (colors[nbr] == -1) {
                if (dfs(nbr, color xor 1)) {
                    continue;  // check for other neighbours
                } else {
                    return false;
                }
            } else {
                if (colors[nbr] == color) {
                    return false;
                } else {
                    continue;
                }
            }
        }
        // is bipartite
        return true;
    }

    bool bipartiteCheck() {
        for (int vertex = 0; vertex < vertexCount; vertex++) {
            if (colors[vertex] == -1) {
                if (!dfs(vertex, 0)) {
                    return false;
                }
            }
        }
        return true;
    }
};

int main() {
    Graph g(9);
    g.addEdge(1, 2);
    g.addEdge(2, 3);
    g.addEdge(3, 4);
    g.addEdge(4, 7);
    g.addEdge(7, 8);
    g.addEdge(4, 5);
    // g.addEdge(5, 6);
    // g.addEdge(6, 2);
    g.addEdge(5, 2);

    cout << (g.bipartiteCheck() ? "Graph is bipartite"
                                : "Graph is not bipartite")
         << "\n";

    return 0;
}
