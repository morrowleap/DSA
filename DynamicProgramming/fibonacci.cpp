/*
https://www.geeksforgeeks.org/problems/introduction-to-dp/1
Introduction to DP

Geek is learning data structures, and he recently learned about the top-down and
bottom-up dynamic programming approaches. Geek is having trouble telling them
apart from one another.

When given an integer n, where n is based on a 0-based index, find the nth
Fibonacci number.

Every ith number in the series equals the sum of the (i-1)th and (i-2)th
numbers, where the first and second numbers are specified as 0 and 1,
respectively.

For the given issue, code both top-down and bottom-up approaches.

Note : As the answer might be large, return the final answer modulo 109 + 7

Example 1:

Input:
n = 5
Output: 5
Explanation: 0,1,1,2,3,5 as we can see 5th number is 5.
Example 2:

Input:
n = 6
Output: 8
Explanation: 0,1,1,2,3,5,8 as we can see 6th number is 8.
Constraints:
1 <= n <= 104

Your Task:
You don't need to read input or print anything. Your task is to complete two
functions topDown() and bottomUp() which take n as input parameters and return
the nth Fibonacci number.

Expected Time Complexity: O(n)
Expected Auxiliary Space: O(n)
*/

#include <iostream>
#include <vector>
using namespace std;

class Solution
{
private:
  const long long int MOD = 1e9 + 7;

  int topDownHelper(int n, vector<int>& dp)
  {
    if (n == 0 || n == 1)
    {
      return n;
    }
    if (dp[n] != -1)
    {
      return dp[n];
    }
    return dp[n] = (topDownHelper(n - 1, dp) + topDownHelper(n - 2, dp)) % MOD;
  }

  int forwardRecHelper(int n, int index, int prevprev, int prev)
  {
    if (index == n)
    {
      return prevprev;
    }
    return forwardRecHelper(n, index + 1, prev, (prev + prevprev) % MOD);
  }

public:
  long long int topDown(int n)
  {
    vector<int> dp(n + 1, -1);
    return topDownHelper(n, dp);
  }

  long long int forwardRecursion(int n)
  {
    int index = 0;
    int prevprev = 0;
    int prev = 1;
    return forwardRecHelper(n, index, prevprev, prev);
  }

  long long int bottomUp(int n)
  {
    vector<int> dp(n + 1, -1);
    dp[0] = 0;
    dp[1] = 1;
    for (int i = 2; i <= n; i++)
    {
      dp[i] = (dp[i - 1] + dp[i - 2]) % MOD;
    }
    return dp[n];
  }

  long long int bottomUpSpaceOptimized(int n)
  {
    int prevprev = 0;
    int prev = 1;
    for (int i = 2; i <= n; i++)
    {
      int curr = (prev + prevprev) % MOD;
      prevprev = prev;
      prev = curr;
    }
    return prev;
  }
};

int main()
{
  cout << "Problem Statement:\n";
  cout << "Geek is learning data structures, and he recently learned about the "
          "top-down and bottom-up dynamic programming approaches. "
          "Geek is having trouble telling them apart from one another.\n\n";

  cout << "When given an integer n, where n is based on a 0-based index, find "
          "the nth Fibonacci number.\n";
  cout << "Every ith number in the series equals the sum of the (i-1)th and "
          "(i-2)th numbers, where the first and second numbers are specified "
          "as 0 and 1, respectively.\n";
  cout << "For the given issue, code both top-down and bottom-up approaches.\n";
  cout << "Note: As the answer might be large, return the final answer modulo "
          "10^9 + 7.\n\n";

  cout << "Example 1:\n";
  cout << "Input: n = 5\n";
  cout << "Output: 5\n";
  cout << "Explanation: 0, 1, 1, 2, 3, 5 as we can see 5th number is 5.\n\n";

  cout << "Example 2:\n";
  cout << "Input: n = 6\n";
  cout << "Output: 8\n";
  cout << "Explanation: 0, 1, 1, 2, 3, 5, 8 as we can see 6th number is 8.\n\n";

  int n;
  cout << "Enter the value of n (Fibonacci index): ";
  cin >> n;

  Solution sol;

  cout << "\nFibonacci number at position " << n << "\n\n";
  cout << "Top-Down (Memoization) Result: " << sol.topDown(n) << endl;
  cout << "Forward Recursion Result: " << sol.forwardRecursion(n) << endl;
  cout << "Bottom-Up (Tabulation) Result: " << sol.bottomUp(n) << endl;
  cout << "Bottom-Up (Space Optimized) Result: "
       << sol.bottomUpSpaceOptimized(n) << endl;
  return 0;
}
