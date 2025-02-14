/*
https://leetcode.com/problems/permutations-ii/description/

47. Permutations II

Given a collection of numbers, nums, that might contain duplicates, return all
possible unique permutations in any order.

Example 1:

Input: nums = [1,1,2]
Output:
[[1,1,2],
 [1,2,1],
 [2,1,1]]
Example 2:

Input: nums = [1,2,3]
Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]


Constraints:

1 <= nums.length <= 8
-10 <= nums[i] <= 10
 */

#include <iostream>
#include <unordered_map>
#include <vector>

using namespace std;

class Solution
{
private:
  void dfs(const vector<int>& nums, vector<int>& temp,
           unordered_map<int, int>& hash, vector<vector<int>>& result)
  {
    if (temp.size() == nums.size())
    {
      result.push_back(temp);
      return;
    }

    for (const auto& pair : hash)
    {
      int num = pair.first;
      int count = pair.second;

      if (count > 0)
      {
        temp.push_back(num);
        hash[num]--;
        dfs(nums, temp, hash, result);
        hash[num]++;
        temp.pop_back();
      }
    }
  }

public:
  vector<vector<int>> permuteUnique(vector<int>& nums)
  {
    vector<vector<int>> result;
    vector<int> temp;
    unordered_map<int, int> hash;
    for (int num : nums)
    {
      hash[num]++;
    }
    dfs(nums, temp, hash, result);
    return result;
  }

  // Better Approach
  // void helper(vector<vector<int>>& res, vector<int> nums, const int& n, int
  // index) {
  //     if(index == n-1) {
  //         res.push_back(nums);
  //         return;
  //     }
  //     for(int i=index;i<n;++i) {
  //         if(i != index && nums[i] == nums[index]) {
  //             continue;
  //         }
  //         swap(nums[index], nums[i]);
  //         helper(res, nums, n, index+1);
  //         // swap(nums[index], nums[i]);
  //     }
  // }
  // vector<vector<int>> permuteUnique(vector<int>& nums) {
  //     sort(nums.begin(), nums.end());
  //     int n = nums.size();
  //     vector<vector<int>> res;
  //     int index = 0;
  //     helper(res, nums, n, index);
  //     return res;
  // }
};

int main()
{
  cout << "This program generates all unique permutations of a given array "
          "of integers that may contain duplicates.\n";
  cout << "Enter the size of the array (1 <= size <= 8): ";

  int n;
  cin >> n;

  vector<int> nums(n);
  cout << "Enter " << n << " integers (-10 <= value <= 10): ";
  for (int i = 0; i < n; ++i)
  {
    cin >> nums[i];
  }

  Solution sol;
  vector<vector<int>> result = sol.permuteUnique(nums);
  cout << "\nAll unique permutations of the array are:\n";
  for (const auto& perm : result)
  {
    for (int num : perm)
    {
      cout << num << " ";
    }
    cout << endl;
  }

  return 0;
}
