/*
Striver Recursion Series
L7. All Kind of Patterns in Recursion | Print All | Print one | Count

Count the subsequences with sum K

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
  int dfs(const vector<int> &nums, int index, int currentSum, int k)
  {
    if (index == nums.size())
    {
      return currentSum == k ? 1 : 0;
    }

    int include = dfs(nums, index + 1, currentSum + nums[index], k);

    int exclude = dfs(nums, index + 1, currentSum, k);

    return include + exclude;
  }

public:
  int countSubsequencesWithSumK(const vector<int> &nums, int k)
  {
    return dfs(nums, 0, 0, k);
  }
};

int main()
{
  int n, k;
  cout << "Enter the number of elements in the array: ";
  cin >> n;

  if (n <= 0)
  {
    cout << "Array size must be greater than zero.";
    return 0;
  }

  vector<int> nums(n);
  cout << "Enter the elements of the array: ";
  for (int i = 0; i < n; i++)
  {
    cin >> nums[i];
  }

  cout << "Enter the target sum K: ";
  cin >> k;

  Solution sol;
  cout << "\nSubsequence count: " << sol.countSubsequencesWithSumK(nums, k)
       << endl;

  return 0;
}
