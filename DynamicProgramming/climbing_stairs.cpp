/*
https://leetcode.com/problems/climbing-stairs/description/
70. Climbing Stairs

You are climbing a staircase. It takes n steps to reach the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you
climb to the top?

Example 1:

Input: n = 2
Output: 2
Explanation: There are two ways to climb to the top.
1. 1 step + 1 step
2. 2 steps
Example 2:

Input: n = 3
Output: 3
Explanation: There are three ways to climb to the top.
1. 1 step + 1 step + 1 step
2. 1 step + 2 steps
3. 2 steps + 1 step


Constraints:

1 <= n <= 45
*/
#include <iostream>
#include <vector>
using namespace std;

class Solution
{
private:
  int topDownHelper(int n, vector<int>& dp)
  {
    if (n == 0)
    {
      return 1;
    }

    if (dp[n] != -1)
    {
      return dp[n];
    }

    int oneStep = 0, twoStep = 0;
    oneStep = topDownHelper(n - 1, dp);
    if (n - 2 >= 0)
    {
      twoStep = topDownHelper(n - 2, dp);
    }
    return dp[n] = oneStep + twoStep;
  }

public:
  int topDown(int n)
  {
    vector<int> dp(n + 1, -1);
    return topDownHelper(n, dp);
  }

  int bottomUp(int n)
  {
    vector<int> dp(n + 1, -1);
    dp[0] = 1;
    for (int i = 1; i <= n; i++)
    {
      int oneStep = 0, twoStep = 0;
      oneStep = dp[i - 1];
      if (i - 2 >= 0)
      {
        twoStep = dp[i - 2];
      }
      dp[i] = oneStep + twoStep;
    }
    return dp[n];
  }

  int forwardRecursion(int n, int index)
  {
    if (index == n)
    {
      return 1;
    }
    int oneStep = 0, twoStep = 0;
    oneStep = forwardRecursion(n, index + 1);
    if (index + 2 <= n)
    {
      twoStep = forwardRecursion(n, index + 2);
    }
    return oneStep + twoStep;
  }
};

int main()
{
  cout << "Problem Statement:\n";
  cout << "You are climbing a staircase. It takes n steps to reach the top.\n";
  cout << "Each time you can either climb 1 or 2 steps. In how many distinct "
          "ways can you climb to the top?\n\n";

  cout << "Example 1:\n";
  cout << "Input: n = 2\n";
  cout << "Output: 2\n";
  cout << "Explanation: There are two ways to climb to the top:\n";
  cout << "1. 1 step + 1 step\n";
  cout << "2. 2 steps\n\n";

  cout << "Example 2:\n";
  cout << "Input: n = 3\n";
  cout << "Output: 3\n";
  cout << "Explanation: There are three ways to climb to the top:\n";
  cout << "1. 1 step + 1 step + 1 step\n";
  cout << "2. 1 step + 2 steps\n";
  cout << "3. 2 steps + 1 step\n\n";

  int n;
  cout << "Enter the number of steps (n): ";
  cin >> n;

  Solution sol;

  cout << "\nNumber of ways to climb " << n << " steps:\n\n"
       << "Top-Down (Memoization) Result: " << sol.topDown(n) << "\n"
       << "Bottom-Up (Tabulation) Result: " << sol.bottomUp(n) << "\n"
       << "Forward Recursion Result: " << sol.forwardRecursion(n, 0) << "\n";

  return 0;
}
