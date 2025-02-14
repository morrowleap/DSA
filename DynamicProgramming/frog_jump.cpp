/*
https://www.geeksforgeeks.org/problems/geek-jump/1
Frog Jump

Given an integer array height[] where height[i] represents the height of the
i-th stair, a frog starts from the first stair and wants to reach the top. From
any stair i, the frog has two options: it can either jump to the (i+1)th stair
or the (i+2)th stair. The cost of a jump is the absolute difference in height
between the two stairs. Determine the minimum total cost required for the frog
to reach the top.

Example:

Input: heights[] = [20, 30, 40, 20]
Output: 20
Explanation:  Minimum cost is incurred when the frog jumps from stair 0 to 1
then 1 to 3: jump from stair 0 to 1: cost = |30 - 20| = 10 jump from stair 1 to
3: cost = |20-30|  = 10
Total Cost = 10 + 10 = 20

Input: heights[] = [30, 20, 50, 10, 40]
Output: 30
Explanation: Minimum cost will be incurred when frog
jumps from stair 0 to 2 then 2 to 4: jump from stair 0 to 2: cost = |50 - 30| =
20 jump from stair 2 to 4: cost = |40-50|  = 10
Total Cost = 20 + 10 = 30

Constraints:

1 <= height.size() <= 105
0 <= height[i]<=104
*/

#include <climits>
#include <cmath>
#include <iostream>
#include <vector>
using namespace std;

class Solution
{
private:
  int topDownHelper(const vector<int>& height, int n, vector<int>& dp)
  {
    if (n == 0)
    {
      return 0;
    }
    if (dp[n] != -1)
    {
      return dp[n];
    }
    int oneStep =
        topDownHelper(height, n - 1, dp) + abs(height[n] - height[n - 1]);
    int twoStep = INT_MAX;
    if (n - 2 >= 0)
    {
      twoStep =
          topDownHelper(height, n - 2, dp) + abs(height[n] - height[n - 2]);
    }
    return dp[n] = min(oneStep, twoStep);
  }

public:
  int forwardRecursion(const vector<int>& height, int i)
  {
    int n = height.size();
    if (i == n - 1)
    {
      return 0;
    }
    int oneStep =
        forwardRecursion(height, i + 1) + abs(height[i] - height[i + 1]);
    int twoStep = INT_MAX;
    if (i + 2 < n)
    {
      twoStep =
          forwardRecursion(height, i + 2) + abs(height[i] - height[i + 2]);
    }
    return min(oneStep, twoStep);
  }

  int topDown(const vector<int>& height)
  {
    int n = height.size();
    vector<int> dp(n, -1);
    return topDownHelper(height, n - 1, dp);
  }

  int bottomUp(const vector<int>& height)
  {
    int n = height.size();
    vector<int> dp(n, -1);

    dp[0] = 0;
    for (int i = 1; i < n; i++)
    {
      int oneStep = dp[i - 1] + abs(height[i] - height[i - 1]);
      int twoStep = INT_MAX;

      if (i - 2 >= 0)
      {
        twoStep = dp[i - 2] + abs(height[i] - height[i - 2]);
      }

      dp[i] = min(oneStep, twoStep);
    }

    return dp[n - 1];
  }

  int bottomUpSpaceOptimized(const vector<int>& height)
  {
    int n = height.size();
    int prev2 = 0, prev = 0, curr = 0;
    for (int i = 1; i < n; i++)
    {
      int oneStep = prev + abs(height[i] - height[i - 1]);
      int twoStep = INT_MAX;
      if (i - 2 >= 0)
      {
        twoStep = prev2 + abs(height[i] - height[i - 2]);
      }

      curr = min(oneStep, twoStep);
      prev2 = prev;
      prev = curr;
    }

    return prev;
  }
};

int main()
{
  cout << "Problem Statement:\n";
  cout << "Given an integer array height[] where height[i] represents the "
          "height of the i-th stair, "
          "a frog starts from the first stair and wants to reach the top. From "
          "any stair i, the frog has two options: "
          "it can either jump to the (i+1)th stair or the (i+2)th stair. The "
          "cost of a jump is the absolute difference "
          "in height between the two stairs. Determine the minimum total cost "
          "required for the frog to reach the top.\n\n";

  cout << "Example 1:\n";
  cout << "Input: heights[] = [20, 30, 40, 20]\n";
  cout << "Output: 20\n";
  cout << "Explanation: Minimum cost is incurred when the frog jumps from "
          "stair 0 to 1 then 1 to 3:\n";
  cout << "jump from stair 0 to 1: cost = |30 - 20| = 10\n";
  cout << "jump from stair 1 to 3: cost = |20-30| = 10\n";
  cout << "Total Cost = 10 + 10 = 20\n\n";

  cout << "Example 2:\n";
  cout << "Input: heights[] = [30, 20, 50, 10, 40]\n";
  cout << "Output: 30\n";
  cout << "Explanation: Minimum cost will be incurred when frog jumps from "
          "stair 0 to 2 then 2 to 4:\n";
  cout << "jump from stair 0 to 2: cost = |50 - 30| = 20\n";
  cout << "jump from stair 2 to 4: cost = |40-50| = 10\n";
  cout << "Total Cost = 20 + 10 = 30\n\n";

  int n;
  cout << "Enter the number of stairs: ";
  cin >> n;

  vector<int> heights(n);
  cout << "Enter the heights of the stairs (space-separated): ";
  for (int i = 0; i < n; ++i)
  {
    cin >> heights[i];
  }

  Solution sol;

  cout << "\nMinimum total cost for the frog to reach the top:\n\n";
  cout << "Forward Recursion Result: " << sol.forwardRecursion(heights, 0)
       << endl;
  cout << "Top-Down (Memoization) Result: " << sol.topDown(heights) << endl;
  cout << "Bottom-Up (Tabulation) Result: " << sol.bottomUp(heights) << endl;
  cout << "Bottom-Up (Space Optimized) Result: "
       << sol.bottomUpSpaceOptimized(heights) << endl;

  return 0;
}