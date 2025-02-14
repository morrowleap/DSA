/*
https://www.geeksforgeeks.org/problems/subset-sums2234/1
Subset Sums

Subset Sum : Sum of all Subsets

Subset Sum-I

Given a array arr of integers, return the sums of all subsets in the list.
Return the sums in any order.

Examples:

Input: arr[] = [2, 3]
Output: [0, 2, 3, 5]
Explanation: When no elements are taken then Sum = 0. When only 2 is taken then
Sum = 2. When only 3 is taken then Sum = 3. When elements 2 and 3 are taken then
Sum = 2+3 = 5.

Input: arr[] = [1, 2, 1]
Output: [0, 1, 1, 2, 2, 3, 3, 4]
Explanation: The possible subset sums are 0 (no elements), 1 (either of the
1's), 2 (the element 2), and their combinations.

Input: arr[] = [5, 6, 7]
Output: [0, 5, 6, 7, 11, 12, 13, 18]
Explanation: The possible subset sums are 0 (no elements), 5, 6, 7, and their
combinations.

Constraints:
1 ≤ arr.size() ≤ 15
0 ≤ arr[i] ≤ 10^4
*/

#include <iostream>
#include <vector>

using namespace std;

class Solution
{
private:
  // Pick and Non-Pick Solution
  void dfs(const vector<int> &arr, int index, int currSum, vector<int> &res)
  {
    if (index == arr.size())
    {
      res.push_back(currSum);
      return;
    }

    // Include the current element in the subset
    dfs(arr, index + 1, currSum + arr[index], res);

    // Exclude the current element from the subset
    dfs(arr, index + 1, currSum, res);
  }

  // Generating Subsequences
  void dfs2(const vector<int> &arr, int index, int currSum, vector<int> &res)
  {

    res.push_back(currSum);

    for (int i = index; i < arr.size(); i++)
    {
      dfs(arr, i + 1, currSum + arr[i], res);
    }
  }

public:
  vector<int> subsetSums(vector<int> &arr)
  {
    vector<int> res;
    int currSum = 0; // Initialize current sum to 0
    dfs2(arr, 0, currSum, res);
    return res;
  }
};

int main()
{
  cout << "Enter the number of elements in the array: ";
  int n;
  cin >> n;

  cout << "Enter the elements of the array: ";
  vector<int> arr(n, 0);
  for (int i = 0; i < n; i++)
  {
    cin >> arr[i];
  }

  Solution sol;
  vector<int> result = sol.subsetSums(arr);

  cout << "\nOutput sums:\n[";
  for (size_t i = 0; i < result.size(); ++i)
  {
    cout << result[i];
    if (i < result.size() - 1)
      cout << ",";
  }
  cout << "]" << endl;

  return 0;
}
