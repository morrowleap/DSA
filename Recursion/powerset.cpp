/*
https://leetcode.com/problems/subsets/description/
78. Subsets

Given an integer array nums of unique elements, return all possible
subsets
 (the power set).

The solution set must not contain duplicate subsets. Return the solution in any
order.

Example 1:

Input: nums = [1,2,3]
Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
Example 2:

Input: nums = [0]
Output: [[],[0]]

Constraints:

1 <= nums.length <= 10
-10 <= nums[i] <= 10
All the numbers of nums are unique.
*/

#include <iostream>
#include <vector>

using namespace std;

class Solution
{
private:
  void dfs(const vector<int>& nums, int index, vector<int>& temp,
           vector<vector<int>>& result)
  {
    if (index == nums.size())
    {
      result.push_back(temp);
      return;
    }

    temp.push_back(nums[index]);
    dfs(nums, index + 1, temp, result);
    temp.pop_back();

    dfs(nums, index + 1, temp, result);
  }

public:
  vector<vector<int>> subsets(vector<int> nums)
  {
    vector<vector<int>> result;
    vector<int> temp;
    int index = 0;
    dfs(nums, index, temp, result);
    return result;
  }
};

int main()
{
  cout << "Problem: Generate all possible subsets (the power set) of a given "
          "array of unique elements.\n";
  cout << "Input: An integer 'n' representing the length of the array and the "
          "array itself.\n";
  cout << "Output: All possible subsets of the array.\n";

  int n;
  cout << "\nEnter the length of the array: ";
  cin >> n;

  vector<int> nums(n);
  cout << "Enter the array elements: ";
  for (int i = 0; i < n; i++)
  {
    cin >> nums[i];
  }

  Solution sol;
  vector<vector<int>> result = sol.subsets(nums);

  cout << "\nGenerated Subsets (Power Set):\n[";
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
