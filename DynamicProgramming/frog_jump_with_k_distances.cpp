/*
https://takeuforward.org/data-structure/dynamic-programming-frog-jump-with-k-distances-dp-4/
https://www.geeksforgeeks.org/problems/minimal-cost/1

Given an array arr[] of size n, where arr[i] denotes the height of ith stone.
Geek starts from stone 0 and from stone i, he can jump to stones i + 1, i + 2, …
i + k. The cost for jumping from stone i to stone j is abs(arr[i] – arr[j]).
Find the minimum cost for Geek to reach the last stone.

Example:

Input: k = 3, arr[]= [10, 30, 40, 50, 20]
Output: 30
Explanation: Geek will follow the path 1->2->5, the total cost would be |10-30|
+ |30-20| = 30, which is minimum. Input: k = 1, arr[]= [10, 20, 10] Output: 20
Explanation: Geek will follow the path 1->2->3, the total cost would be |10 -
20| + |20 - 10| = 20. Constraints:

1 <= arr.size() <=104
1 <= k <= 100
1 <= arr[i] <= 104
 */

#include <climits>
#include <cmath>
#include <iostream>
#include <vector>

using namespace std;

class Solution
{
private:
  int topDownHelper(const vector<int>& height, int n, int k, vector<int>& dp)
  {
    if (n == 0)
    {
      return 0;
    }

    if (dp[n] != -1)
    {
      return dp[n];
    }

    int minStepCost = INT_MAX;
    for (int step = 1; step <= k; step++)
    {
      if (n - step >= 0)
      {
        minStepCost = min(minStepCost, topDownHelper(height, n - step, k, dp) +
                                           abs(height[n] - height[n - step]));
      }
    }

    return dp[n] = minStepCost;
  }

public:
  int topDown(const vector<int>& height, int k)
  {
    int n = height.size();
    vector<int> dp(n, -1);
    return topDownHelper(height, n - 1, k, dp);
  }

  int bottomUp(const vector<int>& height, int k)
  {
    int n = height.size();
    vector<int> dp(n, -1);

    dp[0] = 0;

    for (int i = 1; i < n; i++)
    {
      int minStepCost = INT_MAX;
      for (int step = 1; step <= k; step++)
      {
        if (i - step >= 0)
        {
          minStepCost = min(minStepCost,
                            dp[i - step] + abs(height[i] - height[i - step]));
        }
        else
        {
          break;
        }
      }
      dp[i] = minStepCost;
    }

    return dp[n - 1];
  }

  int bottomUpSpaceOptimized(vector<int>& height, int k)
  {
    int n = height.size();
    if (k <= 0)
      return 0;
    vector<int> dp(k, -1);

    dp[0] = 0;

    for (int i = 1; i < n; i++)
    {
      int minStepCost = INT_MAX;
      for (int step = 1; step <= k; step++)
      {
        if (i - step >= 0)
        {
          minStepCost = min(minStepCost, dp[(i - step) % k] +
                                             abs(height[i] - height[i - step]));
        }
        else
        {
          break;
        }
      }

      dp[i % k] = minStepCost;
    }

    return dp[(n - 1) % k];
  }
};

int main()
{
  cout << "Problem Statement:\n";
  cout << "Given an array arr[] of size n, where arr[i] denotes the height of "
          "the ith stone. "
          "Geek starts from stone 0 and from stone i, he can jump to stones i "
          "+ 1, i + 2, … i + k. "
          "The cost for jumping from stone i to stone j is abs(arr[i] - "
          "arr[j]). "
          "Find the minimum cost for Geek to reach the last stone.\n\n";

  cout << "Example 1:\n";
  cout << "Input: k = 3, arr[] = [10, 30, 40, 50, 20]\n";
  cout << "Output: 30\n";
  cout << "Explanation: Geek will follow the path 1->2->5, the total cost "
          "would be |10-30| + |30-20| = 30, which is minimum.\n\n";

  cout << "Example 2:\n";
  cout << "Input: k = 1, arr[] = [10, 20, 10]\n";
  cout << "Output: 20\n";
  cout << "Explanation: Geek will follow the path 1->2->3, the total cost "
          "would be |10 - 20| + |20 - 10| = 20.\n\n";

  cout << "Example 3:\n";
  cout << "Input: k = 8, arr[] = [92 5 3 54 93 83 22]\n";
  cout << "Output: 70\n\n";

  int n, k;
  cout << "Enter the number of stones (n) and maximum jump distance (k) "
          "(space-separated): ";
  cin >> n >> k;

  vector<int> arr(n);
  cout << "Enter the heights of the stones (space-separated): ";
  for (int i = 0; i < n; ++i)
  {
    cin >> arr[i];
  }

  Solution sol;
  cout << "\nMinimum cost to reach the last stone:\n\n";
  cout << "Top-Down (Memoization) Result: " << sol.topDown(arr, k) << endl;
  cout << "Bottom-Up (Tabulation) Result: " << sol.bottomUp(arr, k) << endl;
  cout << "Bottom-Up (Space Optimized) Result: "
       << sol.bottomUpSpaceOptimized(arr, k) << endl;

  return 0;
}
