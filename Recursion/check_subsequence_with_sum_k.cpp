/*
Striver Recursion Series
L7. All Kind of Patterns in Recursion | Print All | Print one | Count

Print any one subsequence whoose sum is k

OR

Check if there exists a subsequence with sum k.

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
  bool dfs(const vector<int> &nums, int index, vector<int> &curr,
           int currentSum, int k)
  {
    if (index == nums.size())
    {
      if (currentSum == k)
      {
        for (int x : curr)
        {
          cout << x << " ";
        }
        cout << endl;
        return true;
      }
      return false;
    }

    if (currentSum > k)
    {
      return false;
    }

    curr.push_back(nums[index]);
    if (dfs(nums, index + 1, curr, currentSum + nums[index], k))
    {
      return true;
    }
    curr.pop_back();

    if (dfs(nums, index + 1, curr, currentSum, k))
    {
      return true;
    }

    return false;
  }

public:
  bool isSubsequenceWithSumK(const vector<int> &nums, int k)
  {
    vector<int> curr;
    return dfs(nums, 0, curr, 0, k);
  }
};

int main()
{
  int n, k;
  cout << "Enter the number of elements in the array: ";
  cin >> n;

  vector<int> nums(n);
  cout << "Enter the array: ";
  for (int i = 0; i < n; i++)
  {
    cin >> nums[i];
  }

  cout << "Enter the target sum K: ";
  cin >> k;

  Solution sol;
  if (!sol.isSubsequenceWithSumK(nums, k))
  {
    cout << "No subsequences with sum K\n";
  }

  return 0;
}
