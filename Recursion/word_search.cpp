/*
https://leetcode.com/problems/word-search/description/
79. Word Search

Given an m x n grid of characters board and a string word, return true if word
exists in the grid.

The word can be constructed from letters of sequentially adjacent cells, where
adjacent cells are horizontally or vertically neighboring. The same letter cell
may not be used more than once.



Example 1:


Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word =
"ABCCED" Output: true Example 2:


Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word =
"SEE" Output: true Example 3:


Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word =
"ABCB" Output: false


Constraints:

m == board.length
n = board[i].length
1 <= m, n <= 6
1 <= word.length <= 15
board and word consists of only lowercase and uppercase English letters.


Follow up: Could you use search pruning to make your solution faster with a
larger board?
*/

#include <iostream>
#include <string>
#include <vector>

using namespace std;

class Solution
{
private:
  vector<int> roww = {1, -1, 0, 0}; // Row offsets
  vector<int> coll = {0, 0, -1, 1}; // Column offsets

  bool searchString(vector<vector<char>> &board, int rows, int cols, int x,
                    int y, const string &word, int index)
  {
    if (index == word.size())
    {
      return true;
    }

    if (x < 0 || x >= rows || y < 0 || y >= cols)
    {
      return false;
    }

    if (word[index] == board[x][y])
    {
      board[x][y] = '#';
      for (int i = 0; i < 4; i++)
      {
        int newX = x + roww[i];
        int newY = y + coll[i];
        if (searchString(board, rows, cols, newX, newY, word, index + 1))
        {
          return true;
        }
      }

      board[x][y] = word[index];
    }

    return false;
  }

public:
  bool exist(vector<vector<char>> &board, string word)
  {
    int rows = board.size();
    int cols = board[0].size();

    int index = 0;
    for (int i = 0; i < rows; i++)
    {
      for (int j = 0; j < cols; j++)
      {
        if (board[i][j] == word[index] &&
            searchString(board, rows, cols, i, j, word, index))
        {
          return true;
        }
      }
    }

    return false;
  }
};

int main()
{
  cout << "============================================\n";
  cout << "        Word Search in a Character Grid      \n";
  cout << "============================================\n\n";
  cout << "This program checks whether a given word exists within a grid of "
          "characters.\n";
  cout << "The word must be constructed from letters of sequentially adjacent "
          "cells,\n";
  cout << "where adjacent cells are horizontally or vertically neighboring.\n";
  cout << "Each letter cell may be used only once in the construction of the "
          "word.\n\n";
  cout << "Please follow the instructions below to input the grid and the "
          "word.\n\n";

  int rows, cols;
  cout << "Enter the number of rows in the grid: ";
  cin >> rows;

  cout << "Enter the number of columns in the grid: ";
  cin >> cols;

  vector<vector<char>> board(rows, vector<char>(cols));

  cout << "\nEnter the grid row by row. For each row, enter " << cols
       << " characters separated by spaces.\n";
  for (int i = 0; i < rows; ++i)
  {
    cout << "Row " << i + 1 << ": ";
    for (int j = 0; j < cols; ++j)
    {
      cin >> board[i][j];
    }
  }

  string word;
  cout << "\nEnter the word to search for in the grid: ";
  cin >> word;

  Solution sol;
  bool exists = sol.exist(board, word);

  cout << "\nResult:\n";
  cout << "--------------------------------------------\n";
  cout << "The word \"" << word << "\" "
       << (exists ? "exists" : "does not exist") << " in the grid.\n";
  cout << "--------------------------------------------\n";

  return 0;
}
