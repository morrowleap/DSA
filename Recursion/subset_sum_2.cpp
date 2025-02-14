/*
https://leetcode.com/problems/subsets-ii/description/
90. Subsets II

Subset Sum : Sum of all Subsets

Given an integer array nums that may contain duplicates, return all possible
subsets
 (the power set).

The solution set must not contain duplicate subsets. Return the solution in any
order.



Example 1:

Input: nums = [1,2,2]
Output: [[],[1],[1,2],[1,2,2],[2],[2,2]]
Example 2:

Input: nums = [0]
Output: [[],[0]]


Constraints:

1 <= nums.length <= 10
-10 <= nums[i] <= 10
*/

#include <iostream>
#include <vector>

using namespace std;

class Solution
{
private:
  // Pick and Non-Pick Solution
  void dfs(const vector<int>& nums, int index, vector<int>& curr,
           vector<vector<int>>& result)
  {
    if (index == nums.size())
    {
      result.push_back(curr);
      return;
    }

    curr.push_back(nums[index]);
    dfs(nums, index + 1, curr, result);
    curr.pop_back();

    while (index < nums.size() - 1 && nums[index] == nums[index + 1])
    {
      index++;
    }
    dfs(nums, index + 1, curr, result);
  }

  // Generating Subsequences
  void dfs2(const vector<int>& nums, int index, vector<int>& curr,
            vector<vector<int>>& result)
  {
    result.push_back(curr);
    if (index == nums.size())
    {
      return;
    }

    for (int i = index; i < nums.size(); i++)
    {
      curr.push_back(nums[i]);
      dfs(nums, i + 1, curr, result);
      curr.pop_back();

      while (i < nums.size() - 1 && nums[i] == nums[i + 1])
      {
        i++;
      }
    }
  }

public:
  vector<vector<int>> subsetsWithDup(vector<int>& nums)
  {
    sort(nums.begin(), nums.end());
    vector<vector<int>> result;
    vector<int> curr;
    dfs2(nums, 0, curr, result);
    return result;
  }
};

int main()
{
  cout << "Enter the number of elements in the array: ";
  int n;
  cin >> n;

  cout << "Enter the elements of the array: ";
  vector<int> nums(n, 0);
  for (int i = 0; i < n; i++)
  {
    cin >> nums[i];
  }

  Solution sol;
  vector<vector<int>> result = sol.subsetsWithDup(nums);

  cout << "\nOutput combinations:\n[";
  for (size_t i = 0; i < result.size(); ++i)
  {
    cout << "[";
    for (size_t j = 0; j < result[i].size(); ++j)
    {
      cout << result[i][j];
      if (j < result[i].size() - 1)
        cout << ",";
    }
    cout << "]";
    if (i < result.size() - 1)
      cout << ",";
  }
  cout << "]" << endl;

  return 0;
}
