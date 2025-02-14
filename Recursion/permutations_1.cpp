/*
https://leetcode.com/problems/permutations/description/

46. Permutations

Given an array nums of distinct integers, return all the possible
permutations. You can return the answer in any order.

Example 1:

Input: nums = [1,2,3]
Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]

Example 2:

Input: nums = [0,1]
Output: [[0,1],[1,0]]

Example 3:

Input: nums = [1]
Output: [[1]]

Constraints:

1 <= nums.length <= 6
-10 <= nums[i] <= 10
All the integers of nums are unique.
*/

#include <iostream>
#include <unordered_set>
#include <vector>

using namespace std;

class Solution
{
private:
  void dfs(const vector<int>& nums, vector<int>& temp, vector<bool>& visited,
           vector<vector<int>>& result)
  {
    if (temp.size() == nums.size())
    {
      result.push_back(temp);
      return;
    }
    for (int i = 0; i < nums.size(); i++)
    {
      if (!visited[i])
      {
        visited[i] = true;
        temp.push_back(nums[i]);
        dfs(nums, temp, visited, result);
        temp.pop_back();
        visited[i] = false;
      }
    }
  }

  void dfs(vector<int>& nums, int index, vector<vector<int>>& result)
  {
    if (index == nums.size())
    {
      result.push_back(nums);
      return;
    }
    for (int i = index; i < nums.size(); i++)
    {
      swap(nums[index], nums[i]);
      dfs(nums, index + 1, result);
      swap(nums[index], nums[i]);
    }
  }

public:
  vector<vector<int>> permute1(vector<int>& nums)
  {
    vector<vector<int>> result;
    vector<bool> visited(nums.size(), false);
    vector<int> temp;
    dfs(nums, temp, visited, result);
    return result;
  }

  vector<vector<int>> permute2(vector<int>& nums)
  {
    vector<vector<int>> result;
    dfs(nums, 0, result);
    return result;
  }
};

int main()
{
  cout << "This program generates all possible permutations of a given array "
          "of distinct integers.\n";
  cout << "Enter the size of the array (1 <= size <= 6): ";

  int n;
  cin >> n;

  vector<int> nums(n);
  cout << "Enter " << n << " distinct integers (-10 <= value <= 10): ";
  for (int i = 0; i < n; ++i)
  {
    cin >> nums[i];
  }

  Solution sol;
  vector<vector<int>> result = sol.permute1(nums);
  cout << "\nPermutations using visited tracking:\n";
  for (const auto& perm : result)
  {
    for (int num : perm)
    {
      cout << num << " ";
    }
    cout << endl;
  }

  vector<vector<int>> result2 = sol.permute2(nums);
  cout << "\nPermutations using in-place swapping:\n";
  for (const auto& perm : result2)
  {
    for (int num : perm)
    {
      cout << num << " ";
    }
    cout << endl;
  }

  return 0;
}
