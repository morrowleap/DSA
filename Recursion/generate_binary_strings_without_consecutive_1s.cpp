/*
https://www.geeksforgeeks.org/generate-binary-strings-without-consecutive-1s/
Generate all binary strings without consecutive 1’s
Generate all binary strings
*/

#include <iostream>
#include <vector>
using namespace std;

class Solution
{
private:
  void dfs(int n, string& temp, vector<string>& result)
  {
    if (temp.size() == n)
    {
      result.push_back(temp);
      return;
    }

    temp += '0';
    dfs(n, temp, result);
    temp.pop_back();

    if (temp.empty() || temp.back() == '0')
    {
      temp += '1';
      dfs(n, temp, result);
      temp.pop_back();
    }
  }

public:
  vector<string> generateBinaryStrings(int n)
  {
    vector<string> result;
    string temp = "";
    dfs(n, temp, result);
    return result;
  }
};

int main()
{
  cout << "Problem: Generate all binary strings of a given length 'n' such "
          "that there are no consecutive 1's.\n";
  cout << "Input: An integer 'n' representing the length of the binary "
          "strings.\n";
  cout << "Output: All binary strings of length 'n' with no consecutive 1's.\n";

  int n;
  cout << "\nEnter the size of the binary strings (n): ";
  cin >> n;

  Solution sol;
  vector<string> result = sol.generateBinaryStrings(n);

  cout << "\nGenerated Binary Strings (without consecutive 1's):\n";
  for (const auto& str : result)
  {
    cout << str << "\n";
  }

  return 0;
}