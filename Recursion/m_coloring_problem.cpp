/*
https://www.geeksforgeeks.org/problems/m-coloring-problem-1587115620/1
M-Coloring Problem

You are given an undirected graph consisting of v vertices and a list of edges,
along with an integer m. Your task is to determine whether it is possible to
color the graph using at most m different colors such that no two adjacent
vertices share the same color. Return true if the graph can be colored with at
most m colors, otherwise return false.

Note: The graph is indexed with 0-based indexing.

Examples:

Input: v = 4, edges[] = [(0,1),(1,2),(2,3),(3,0),(0,2)], m = 3
Output: true
Explanation: It is possible to color the given graph using 3 colors, for
example, one of the possible ways vertices can be colored as follows: Vertex 0:
Color 3 Vertex 1: Color 2 Vertex 2: Color 1 Vertex 3: Color 2 Input: v = 3,
edges[] = [(0,1),(1,2),(0,2)], m = 2 Output: false Explanation: It is not
possible to color the given graph using only 2 colors because vertices 0, 1, and
2 form a triangle. Expected Time Complexity: O(mV) Expected Auxiliary Space:
O(v2)

Constraints:
1 ≤ v ≤ 20
1 ≤ edges.size() ≤ (v*(v-1))/2
0 ≤ edges[i][j] ≤ n-1
1 ≤ m ≤ v
*/
#include <iostream>
#include <vector>
using namespace std;

class Solution
{
private:
  bool isColorable(int vertex, int color, vector<vector<int>>& adjList,
                   vector<int>& vertexColors)
  {
    for (int v : adjList[vertex])
    {
      if (color == vertexColors[v])
      {
        return false;
      }
    }
    return true;
  }

  bool dfs(int index, vector<vector<int>>& adjList, vector<int>& vertexColors,
           int colors)
  {
    if (index == adjList.size())
    {
      return true;
    }

    for (int color = 1; color <= colors; color++)
    {
      if (isColorable(index, color, adjList, vertexColors))
      {
        vertexColors[index] = color;
        if (dfs(index + 1, adjList, vertexColors, colors))
        {
          return true;
        }
        vertexColors[index] = -1;
      }
    }

    return false;
  }

public:
  bool graphColoring(int vertices, vector<pair<int, int>>& edges, int colors)
  {
    vector<vector<int>> adjList(vertices);
    for (const auto& edge : edges)
    {
      int u = edge.first;
      int v = edge.second;

      adjList[u].push_back(v);
      adjList[v].push_back(u);
    }
    int index = 0;
    vector<int> vertexColors(vertices, -1);
    return dfs(index, adjList, vertexColors, colors);
  }
};

int main()
{
  cout << "============================================\n";
  cout << "           M-Coloring Problem Solver         \n";
  cout << "============================================\n\n";
  cout << "This program determines if a graph can be colored using at most m "
          "colors,\n";
  cout << "such that no two adjacent vertices share the same color.\n";
  cout << "Note: We are using 0-based indexing for the vertices.\n\n";

  int v, e, m;
  cout << "Enter the number of vertices (v): ";
  cin >> v;

  cout << "Enter the number of edges (e): ";
  cin >> e;

  vector<pair<int, int>> edges(e);
  cout << "Enter the edges in the format 'start_vertex end_vertex' (e.g., 0 1 "
          "for an edge between vertex 0 and vertex 1).\n";
  cout << "Use a space between the two vertices. Enter each edge on a new "
          "line:\n";
  for (int i = 0; i < e; ++i)
  {
    int u, v;
    cin >> u >> v;
    edges[i] = {u, v};
  }

  cout << "Enter the maximum number of colors (m): ";
  cin >> m;

  Solution sol;
  bool result = sol.graphColoring(v, edges, m);

  cout << "\nOutput:\n";
  if (result)
  {
    cout << "The graph can be colored using " << m << " colors.\n";
  }
  else
  {
    cout << "The graph cannot be colored using " << m << " colors.\n";
  }

  return 0;
}
