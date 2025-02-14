/*
https://leetcode.com/problems/palindrome-partitioning/
131. Palindrome Partitioning
Given a string s, partition s such that every
substring
 of the partition is a
palindrome
. Return all possible palindrome partitioning of s.



Example 1:

Input: s = "aab"
Output: [["a","a","b"],["aa","b"]]
Example 2:

Input: s = "a"
Output: [["a"]]


Constraints:

1 <= s.length <= 16
s contains only lowercase English letters.
*/

#include <iostream>
#include <string>
#include <vector>

using namespace std;

class Solution
{
private:
  void dfs(const string &s, int index, vector<string> &curr,
           vector<vector<string>> &result)
  {
    if (index == s.length())
    {
      result.push_back(curr);
      return;
    }

    for (int i = index; i < s.length(); i++)
    {
      string x = s.substr(index, i - index + 1);
      if (isPalindrome(x))
      {
        curr.push_back(x);
        dfs(s, i + 1, curr, result);
        curr.pop_back();
      }
    }
  }

  bool isPalindrome(string s)
  {
    int l = 0, r = s.length() - 1;
    while (l < r)
    {
      if (s[l] != s[r])
      {
        return false;
      }
      l++;
      r--;
    }
    return true;
  }

public:
  vector<vector<string>> partition(string s)
  {
    vector<vector<string>> result;
    vector<string> curr;
    int index = 0;
    dfs(s, index, curr, result);
    return result;
  }
};

int main()
{
  cout << "Enter a string to find all possible palindrome partitionings, where "
          "each substring of the partition is a palindrome: ";
  string s;
  cin >> s;

  Solution sol;
  vector<vector<string>> result = sol.partition(s);

  cout << "\nPalindrome partitions for \"" << s << "\":" << "\n[";
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
