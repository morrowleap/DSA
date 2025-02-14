#include <iostream>
#include <vector>

using namespace std;

class Solution
{
private:
  void dfs(const vector<int> &candidates, int index, vector<int> &curr,
           int target, vector<vector<int>> &result)
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

    // for (int i = index; i < candidates.size(); i++) {
    //     curr.push_back(candidates[i]);
    //     dfs(candidates, i + 1, curr, target - candidates[i], result);
    //     curr.pop_back();
    //     while(i < candidates.size() - 1 && candidates[i] == candidates[i+1])
    //     {
    //         i++;
    //     }
    // }

    curr.push_back(candidates[index]);
    dfs(candidates, index + 1, curr, target - candidates[index], result);
    curr.pop_back();

    while (index < candidates.size() - 1 &&
           candidates[index] == candidates[index + 1])
    {
      index++;
    }
    dfs(candidates, index + 1, curr, target, result);
  }

public:
  vector<vector<int>> combinationSum2(vector<int> &candidates, int target)
  {
    sort(candidates.begin(), candidates.end());
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
  vector<vector<int>> result = sol.combinationSum2(candidates, target);

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