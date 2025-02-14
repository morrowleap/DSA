/*
198. House Robber

You are a professional robber planning to rob houses along a street. Each house
has a certain amount of money stashed, the only constraint stopping you from
robbing each of them is that adjacent houses have security systems connected and
it will automatically contact the police if two adjacent houses were broken into
on the same night.

Given an integer array nums representing the amount of money of each house,
return the maximum amount of money you can rob tonight without alerting the
police.



Example 1:

Input: nums = [1,2,3,1]
Output: 4
Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
Total amount you can rob = 1 + 3 = 4.
Example 2:

Input: nums = [2,7,9,3,1]
Output: 12
Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5
(money = 1). Total amount you can rob = 2 + 9 + 1 = 12.

Constraints:

1 <= nums.length <= 100
0 <= nums[i] <= 400
 */

#include <algorithm>
#include <iostream>
#include <vector>

using namespace std;

class Solution
{
private:
  int forwardRecHelper(const vector<int>& nums, int index, vector<int>& dp)
  {
    int n = nums.size();
    if (index >= n)
    {
      return 0;
    }

    if (dp[index] != -1)
    {
      return dp[index];
    }

    // Pick or Not pick Solution
    int pick = nums[index] + forwardRecHelper(nums, index + 2, dp);

    int notpick = forwardRecHelper(nums, index + 1, dp);

    return dp[index] = max(pick, notpick);
  }

  int topDownHelper(const vector<int>& nums, int n, vector<int>& dp)
  {
    if (n < 0)
    {
      return 0;
    }

    if (dp[n] != -1)
    {
      return dp[n];
    }

    // Pick or Not pick Solution
    int pick = nums[n] + topDownHelper(nums, n - 2, dp);

    int notpick = topDownHelper(nums, n - 1, dp);

    return dp[n] = max(pick, notpick);
  }

public:
  int forwardRecursion(const vector<int>& nums)
  {
    vector<int> dp(nums.size(), -1);
    return forwardRecHelper(nums, 0, dp);
  }

  int topDown(const vector<int>& nums)
  {
    int n = nums.size();
    vector<int> dp(n, -1);
    return topDownHelper(nums, n - 1, dp);
  }

  int bottomUp(const vector<int>& nums)
  {
    int n = nums.size();
    vector<int> dp(n, -1);

    for (int i = 0; i < n; i++)
    {
      int pick = nums[i];
      if (i - 2 >= 0)
      {
        pick += dp[i - 2];
      }
      int notpick = 0;
      if (i - 1 >= 0)
      {
        notpick += dp[i - 1];
      }

      dp[i] = max(pick, notpick);
    }

    return dp[n - 1];
  }

  int bottomUpSpaceOptimized(const vector<int>& nums)
  {
    int n = nums.size();
    int prev2 = 0, prev = 0, curr = 0;

    for (int i = 0; i < n; i++)
    {
      int pick = nums[i];
      if (i - 2 >= 0)
      {
        pick += prev2;
      }
      int notpick = 0;
      if (i - 1 >= 0)
      {
        notpick += prev;
      }

      curr = max(pick, notpick);
      prev2 = prev;
      prev = curr;
    }

    return prev;
  }
};

int main()
{
  cout << "Problem Statement:\n";
  cout
      << "You are a professional robber planning to rob houses along a street. "
         "Each house has a certain amount of money stashed, the only "
         "constraint stopping you from robbing each of them is "
         "that adjacent houses have security systems connected and it will "
         "automatically contact the police if two adjacent houses "
         "were broken into on the same night.\n\n";

  cout << "Given an integer array nums representing the amount of money of "
          "each house, return the maximum amount of money you can rob tonight "
          "without alerting the police.\n\n";

  cout << "Example 1:\n";
  cout << "Input: nums = [1,2,3,1]\n";
  cout << "Output: 4\n";
  cout << "Explanation: Rob house 1 (money = 1) and then rob house 3 (money = "
          "3).\n";
  cout << "Total amount you can rob = 1 + 3 = 4.\n\n";

  cout << "Example 2:\n";
  cout << "Input: nums = [2,7,9,3,1]\n";
  cout << "Output: 12\n";
  cout << "Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and "
          "rob house 5 (money = 1).\n";
  cout << "Total amount you can rob = 2 + 9 + 1 = 12.\n\n";

  cout << "Example 3:\n";
  cout << "Input: 48 nums = "
          "[114 117 207 117 235 82 90 67 143 146 53 108 200 91 80 223 58 170 "
          "110 236 81 90 222 160 165 195 187 199 114 235 197 187 69 129 64 214 "
          "228 78 188 67 205 94 205 169 241 202 144 240]\n\n";

  int n;
  cout << "Enter the number of houses: ";
  cin >> n;

  vector<int> nums(n);
  cout << "Enter the amounts of money in each house (space-separated): ";
  for (int i = 0; i < n; ++i)
  {
    cin >> nums[i];
  }

  Solution sol;
  cout << "\nMaximum amount of money you can rob:\n\n";
  cout << "Forward Recursion Result: " << sol.forwardRecursion(nums) << endl;
  cout << "Top-Down (Memoization) Result: " << sol.topDown(nums) << endl;
  cout << "Bottom-Up (Tabulation) Result: " << sol.bottomUp(nums) << endl;
  cout << "Bottom-Up (Space Optimized) Result: "
       << sol.bottomUpSpaceOptimized(nums) << endl;

  return 0;
}
