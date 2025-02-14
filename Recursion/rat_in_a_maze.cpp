/*
https://www.geeksforgeeks.org/problems/rat-in-a-maze-problem/1
Rat in a Maze Problem - I

Consider a rat placed at position (0, 0) in an n x n square matrix mat. The
rat's goal is to reach the destination at position (n-1, n-1). The rat can move
in four possible directions: 'U'(up), 'D'(down), 'L' (left), 'R' (right).

The matrix contains only two possible values:

0: A blocked cell through which the rat cannot travel.
1: A free cell that the rat can pass through.
Note: In a path, no cell can be visited more than one time. If the source cell
is 0, the rat cannot move to any other cell. In case of no path, return an empty
list.+

The task is to find all possible paths the rat can take to reach the
destination, starting from (0, 0) and ending at (n-1, n-1), under the condition
that the rat cannot revisit any cell along the same path. Furthermore, the rat
can only move to adjacent cells that are within the bounds of the matrix and not
blocked.

Examples:

Input: mat[][] = [[1, 0, 0, 0], [1, 1, 0, 1], [1, 1, 0, 0], [0, 1, 1, 1]]
Output: ["DDRDRR", "DRDDRR"]
Explanation: The rat can reach the destination at (3, 3) from (0, 0) by two
paths - DRDDRR and DDRDRR, when printed in sorted order we get DDRDRR DRDDRR.
Input: mat[][] = [[1, 0], [1, 0]]
Output: []
Explanation: No path exists and the destination cell is blocked.
Input: mat = [[1, 1, 1], [1, 0, 1], [1, 1, 1]]
Output: ["DDRR", "RRDD"]
Explanation: The rat has two possible paths to reach the destination: 1.
"DDRR" 2. "RRDD", These are returned in lexicographically sorted order.
Constraints:
2 ≤ mat.size() ≤ 5
0 ≤ mat[i][j] ≤ 1
*/

#include <algorithm>
#include <iostream>
#include <string>
#include <vector>

using namespace std;

class Solution
{
private:
  vector<pair<char, pair<int, int>>> directions = {
      {'R', {0, +1}}, {'D', {+1, 0}}, {'L', {0, -1}}, {'U', {-1, 0}}};

  void dfs(vector<vector<int>>& matrix, int x, int y, string& curr,
           vector<vector<bool>>& visited, vector<string>& result)
  {
    int n = matrix.size();
    if (x == n - 1 && y == n - 1)
    {
      result.push_back(curr);
      return;
    }

    for (const auto& dir : directions)
    {
      char move = dir.first;
      int newX = x + dir.second.first;
      int newY = y + dir.second.second;

      if (newX >= 0 && newX < n && newY >= 0 && newY < n &&
          matrix[newX][newY] == 1 && !visited[newX][newY])
      {
        curr += move;
        visited[x][y] = true;
        dfs(matrix, newX, newY, curr, visited, result);
        visited[x][y] = false;
        curr.pop_back();
      }
    }
  }

public:
  vector<string> findPath(vector<vector<int>>& matrix)
  {
    int n = matrix.size();
    vector<string> result;
    string curr;
    vector<vector<bool>> visited(n, vector<bool>(n, false));
    if (matrix[0][0] == 0 || matrix[n - 1][n - 1] == 0)
    {
      return result;
    }
    dfs(matrix, 0, 0, curr, visited, result);
    return result;
  }
};

int main()
{
  cout << "============================================\n";
  cout << "        Rat in a Maze Problem Solver         \n";
  cout << "============================================\n\n";
  cout << "This program finds all possible paths for a rat starting\n";
  cout << "from the top-left corner (0, 0) to the bottom-right corner (n-1, "
          "n-1)\n";
  cout << "of a square matrix with blocked and free cells.\n\n";

  int n;
  cout << "Enter the size of the square matrix (n): ";
  cin >> n;

  vector<vector<int>> matrix(n, vector<int>(n));
  cout << "\nEnter the elements of the matrix row by row. Use '1' for free "
          "cells and '0' for "
          "blocked cells. Separate each element with a space:\n";
  for (int i = 0; i < n; ++i)
  {
    for (int j = 0; j < n; ++j)
    {
      cin >> matrix[i][j];
    }
  }

  Solution sol;
  vector<string> paths = sol.findPath(matrix);

  cout << "\nOutput:\n";
  if (paths.empty())
  {
    cout << "No paths found.\n";
  }
  else
  {
    cout << "Possible paths:\n";
    for (const string& path : paths)
    {
      cout << path << "\n";
    }
  }

  return 0;
}