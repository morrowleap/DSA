/*
https://leetcode.com/problems/n-queens/description/
51. N-Queens

The n-queens puzzle is the problem of placing n queens on an n x n chessboard
such that no two queens attack each other.

Given an integer n, return all distinct solutions to the n-queens puzzle. You
may return the answer in any order.

Each solution contains a distinct board configuration of the n-queens'
placement, where 'Q' and '.' both indicate a queen and an empty space,
respectively.



Example 1:


Input: n = 4
Output: [[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
Explanation: There exist two distinct solutions to the 4-queens puzzle as shown
above Example 2:

Input: n = 1
Output: [["Q"]]


Constraints:

1 <= n <= 9
*/

#include <iostream>
#include <string>
#include <vector>

using namespace std;

class Solution
{
private:
  void fillQueenLookupGrid(vector<vector<int>> &queenLookupGrid, int x, int y,
                           int delta)
  {
    int rows = queenLookupGrid.size();
    int cols = queenLookupGrid[0].size();

    // Update the row and column
    for (int i = 0; i < rows; i++)
    {
      queenLookupGrid[i][y] += delta;
    }
    for (int i = 0; i < cols; i++)
    {
      queenLookupGrid[x][i] += delta;
    }

    // Directions for diagonals: (dx, dy)
    vector<pair<int, int>> directions = {
        {-1, +1}, {+1, +1}, {+1, -1}, {-1, -1}};

    // Iterate in each diagonal direction
    for (const auto &dir : directions)
    {
      int newX = x + dir.first;
      int newY = y + dir.second;

      // Move in the current direction until boundary is reached
      while (newX >= 0 && newX < rows && newY >= 0 && newY < cols)
      {
        queenLookupGrid[newX][newY] += delta;
        newX += dir.first;
        newY += dir.second;
      }
    }

    // Undo self-overlap since the placed queen is incremented
    queenLookupGrid[x][y] -= delta;
  }

  void dfs(int index, vector<string> &currBoard,
           vector<vector<int>> &queenLookupGrid, vector<vector<string>> &result)
  {
    int n = currBoard.size();
    if (index == n)
    {
      result.push_back(currBoard);
      return;
    }

    for (int i = 0; i < n; i++)
    {
      if (queenLookupGrid[index][i] == 0)
      {
        // Place the queen
        currBoard[index][i] = 'Q';
        fillQueenLookupGrid(queenLookupGrid, index, i, 1);

        // Recurse to the next row
        dfs(index + 1, currBoard, queenLookupGrid, result);

        // Backtrack: remove the queen and reset the grid
        fillQueenLookupGrid(queenLookupGrid, index, i, -1);
        currBoard[index][i] = '.';
      }
    }
  }

public:
  vector<vector<string>> solveNQueens(int n)
  {
    vector<vector<string>> result;
    vector<string> currBoard(n, string(n, '.'));
    vector<vector<int>> queenLookupGrid(n, vector<int>(n, 0));
    dfs(0, currBoard, queenLookupGrid, result);
    return result;
  }
};

int main()
{
  cout << "============================================\n";
  cout << "            N-Queens Solver                 \n";
  cout << "============================================\n\n";
  cout << "This program solves the N-Queens puzzle for a given chessboard size "
          "(N x N).\n";
  cout << "The solution ensures no two queens attack each other horizontally, "
          "vertically, or diagonally.\n\n";

  int n;
  cout << "Enter the value of N (size of the chessboard): ";
  cin >> n;

  Solution sol;
  vector<vector<string>> solutions = sol.solveNQueens(n);

  cout << "\nNumber of solutions: " << solutions.size() << "\n\n";
  cout << "Solutions:\n";
  cout << "--------------------------------------------\n";

  for (int i = 0; i < solutions.size(); ++i)
  {
    cout << "Solution " << i + 1 << ":\n";
    for (const string &row : solutions[i])
    {
      cout << row << "\n";
    }
    cout << "--------------------------------------------\n";
  }

  return 0;
}
