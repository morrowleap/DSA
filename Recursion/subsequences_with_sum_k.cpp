/*
Striver Recursion Series
L7. All Kind of Patterns in Recursion | Print All | Print one | Count

Printing Subsequences Whose Sum Equals K.

subsequences_with_sum_k.cpp
check_subsequence_with_sum_k.cpp
count_subsequence_sum_k.cpp

*/

#include <iostream>
#include <vector>

using namespace std;

class Solution
{
private:
  void dfs(const vector<int>& nums, int index, vector<int>& curr,
           vector<vector<int>>& res, int k, int currentSum)
  {
    if (index == nums.size())
    {
      if (currentSum == k)
      {
        res.push_back(curr);
      }
      return;
    }

    curr.push_back(nums[index]);
    dfs(nums, index + 1, curr, res, k, currentSum + nums[index]);
    curr.pop_back();

    dfs(nums, index + 1, curr, res, k, currentSum);
  }

public:
  vector<vector<int>> subsequencesWithSumK(vector<int> nums, int k)
  {
    vector<vector<int>> res;
    vector<int> curr;
    dfs(nums, 0, curr, res, k, 0);
    return res;
  }
};

int main()
{
  cout << "Problem: Find all subsequences of an array whose sum equals a given "
          "target K.\n";
  cout << "Input: An integer 'n' representing the number of elements in the "
          "array, the array itself, and an integer 'k' representing the target "
          "sum.\n";
  cout << "Output: All subsequences whose sum equals the target K.\n";

  int n;
  cout << "\nEnter the number of elements in the array: ";
  cin >> n;

  vector<int> nums(n);
  cout << "Enter the array elements: ";
  for (int i = 0; i < n; i++)
  {
    cin >> nums[i];
  }

  int k;
  cout << "Enter the target sum K: ";
  cin >> k;

  Solution sol;
  vector<vector<int>> result = sol.subsequencesWithSumK(nums, k);

  cout << "\nSubsequences Whose Sum Equals " << k << ":\n[";
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
