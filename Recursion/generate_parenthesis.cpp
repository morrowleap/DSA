/*
https://leetcode.com/problems/generate-parentheses/description/
22. Generate Parentheses

Given n pairs of parentheses, write a function to generate all combinations of
well-formed parentheses.

Example 1:

Input: n = 3
Output: ["((()))","(()())","(())()","()(())","()()()"]
Example 2:

Input: n = 1
Output: ["()"]


Constraints:

1 <= n <= 8
*/

#include <iostream>
#include <string>
#include <vector>
using namespace std;

class Solution
{
private:
  void dfs(int n, int openP, int closeP, string& temp, vector<string>& result)
  {
    if (2 * n == openP + closeP)
    {
      result.push_back(temp);
      return;
    }

    if (openP < n)
    {
      temp += '(';
      dfs(n, openP + 1, closeP, temp, result);
      temp.pop_back();
    }

    if (openP > closeP)
    {
      temp += ')';
      dfs(n, openP, closeP + 1, temp, result);
      temp.pop_back();
    }
  }

public:
  vector<string> generateParenthesis(int n)
  {
    vector<string> result;
    string temp = "";
    int openP = 0;
    int closeP = 0;
    dfs(n, openP, closeP, temp, result);
    return result;
  }
};

int main()
{
  cout << "Problem: Generate all combinations of well-formed parentheses for a "
          "given number of pairs.\n";
  cout << "Input: An integer 'n' representing the number of pairs of "
          "parentheses.\n";
  cout << "Output: All possible combinations of well-formed parentheses.\n";

  int n;
  cout << "\nEnter the number of pairs of parentheses (n): ";
  cin >> n;

  Solution sol;
  vector<string> result = sol.generateParenthesis(n);

  cout << "\nGenerated Combinations of Well-Formed Parentheses:\n";
  for (const string& str : result)
  {
    cout << str << "\n";
  }

  return 0;
}
