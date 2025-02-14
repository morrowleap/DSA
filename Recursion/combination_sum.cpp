/*
https://leetcode.com/problems/combination-sum/description/
39. Combination Sum

Given an array of distinct integers candidates and a target integer target,
return a list of all unique combinations of candidates where the chosen numbers
sum to target. You may return the combinations in any order.

The same number may be chosen from candidates an unlimited number of times.
Two combinations are unique if the
frequency of at least one of the chosen numbers is different.

The test cases are generated such that the number of unique combinations
that sum up to target is less than 150 combinations for the given input.



Example 1:

Input: candidates = [2,3,6,7], target = 7
Output: [[2,2,3],[7]]
Explanation:
2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple
times. 7 is a candidate, and 7 = 7. These are the only two combinations. Example
2:

Input: candidates = [2,3,5], target = 8
Output: [[2,2,2,2],[2,3,3],[3,5]]
Example 3:

Input: candidates = [2], target = 1
Output: []


Constraints:

1 <= candidates.length <= 30
2 <= candidates[i] <= 40
All elements of candidates are distinct.
1 <= target <= 40
*/

#include <iostream>
#include <vector>

using namespace std;

class Solution
{
private:
  void dfs(const vector<int>& candidates, int index, vector<int>& curr,
           int target, vector<vector<int>>& result)
  {
    if (target == 0)
    {
      result.push_back(curr);
      return;
    }

    if (target < 0 || index == candidates.size())
    {
      return;
    }

    // Include the current candidate
    // curr.push_back(candidates[index]);
    // dfs(candidates, index, curr, target - candidates[index], result);
    // curr.pop_back();

    // Exclude the current candidate
    // dfs(candidates, index + 1, curr, target, result);

    // Iterate through candidates starting from the current index
    for (int i = index; i < candidates.size(); i++)
    {
      curr.push_back(candidates[i]);
      dfs(candidates, i, curr, target - candidates[i], result);
      curr.pop_back();
    }
  }

public:
  vector<vector<int>> combinationSum(vector<int>& candidates, int target)
  {
    vector<vector<int>> result;
    vector<int> curr;
    dfs(candidates, 0, curr, target, result);
    return result;
  }
};

int main()
{
  cout << "Enter the number of elements in the candidates array: ";
  int n;
  cin >> n;

  cout << "Enter the elements of the candidates array: ";
  vector<int> candidates(n, 0);
  for (int i = 0; i < n; i++)
  {
    cin >> candidates[i];
  }

  cout << "Enter the target sum: ";
  int target;
  cin >> target;

  Solution sol;
  vector<vector<int>> result = sol.combinationSum(candidates, target);

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
