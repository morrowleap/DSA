/*
https://leetcode.com/problems/combination-sum-iii/
216. Combination Sum III
Find all valid combinations of k numbers that sum up to n such that the
following conditions are true:

Only numbers 1 through 9 are used.
Each number is used at most once.
Return a list of all possible valid combinations. The list must not contain the
same combination twice, and the combinations may be returned in any order.



Example 1:

Input: k = 3, n = 7
Output: [[1,2,4]]
Explanation:
1 + 2 + 4 = 7
There are no other valid combinations.
Example 2:

Input: k = 3, n = 9
Output: [[1,2,6],[1,3,5],[2,3,4]]
Explanation:
1 + 2 + 6 = 9
1 + 3 + 5 = 9
2 + 3 + 4 = 9
There are no other valid combinations.
Example 3:

Input: k = 4, n = 1
Output: []
Explanation: There are no valid combinations.
Using 4 different numbers in the range [1,9], the smallest sum we can get is
1+2+3+4 = 10 and since 10 > 1, there are no valid combination.


Constraints:

2 <= k <= 9
1 <= n <= 60
*/

#include <iostream>
#include <vector>

using namespace std;

class Solution
{
private:
  void dfs(int n, int k, int index, int currSum, vector<int> &curr,
           vector<vector<int>> &result)
  {
    if (k == 0)
    {
      if (currSum == n)
      {
        result.push_back(curr);
      }
      return;
    }

    if (currSum >= n)
    {
      return;
    }

    for (int i = index; i <= 9; ++i)
    {
      curr.push_back(i);
      dfs(n, k - 1, i + 1, currSum + i, curr, result);
      curr.pop_back();
    }
  }

  void dfs2(int n, int k, int index, int currSum, vector<int> &curr,
            vector<vector<int>> &result)
  {
    if (k == 0)
    {
      if (currSum == n)
      {
        result.push_back(curr);
      }
      return;
    }

    if (index > 9 || currSum >= n)
    {
      return;
    }

    // Include the current index
    curr.push_back(index);
    dfs(n, k - 1, index + 1, currSum + index, curr, result);
    curr.pop_back();

    // Exclude the current index
    dfs(n, k, index + 1, currSum, curr, result);
  }

public:
  vector<vector<int>> combinationSum3(int k, int n)
  {
    vector<vector<int>> result;
    vector<int> curr;
    dfs(n, k, 1, 0, curr, result);
    return result;
  }
};

int main()
{
  cout << "Enter the number of elements (k): ";
  int k;
  cin >> k;

  cout << "Enter the target sum (n): ";
  int n;
  cin >> n;

  Solution sol;
  vector<vector<int>> result = sol.combinationSum3(k, n);

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
