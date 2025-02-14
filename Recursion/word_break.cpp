/*
https://leetcode.com/problems/word-break/description/
139. Word Break

Given a string s and a dictionary of strings wordDict, return true if s can be
segmented into a space-separated sequence of one or more dictionary words.

Note that the same word in the dictionary may be reused multiple times in the
segmentation.



Example 1:

Input: s = "leetcode", wordDict = ["leet","code"]
Output: true
Explanation: Return true because "leetcode" can be segmented as "leet code".
Example 2:

Input: s = "applepenapple", wordDict = ["apple","pen"]
Output: true
Explanation: Return true because "applepenapple" can be segmented as "apple pen
apple". Note that you are allowed to reuse a dictionary word. Example 3:

Input: s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
Output: false


Constraints:

1 <= s.length <= 300
1 <= wordDict.length <= 1000
1 <= wordDict[i].length <= 20
s and wordDict[i] consist of only lowercase English letters.
All the strings of wordDict are unique.
 */

#include <iostream>
#include <string>
#include <unordered_set>
#include <vector>

using namespace std;

class Solution
{
private:
  bool memoizedDFS(const string& s, int index,
                   const unordered_set<string>& wordSet,
                   unordered_map<int, bool>& memo)
  {
    int n = s.length();
    if (memo.find(index) != memo.end())
    {
      return memo[index];
    }

    cout << "f(" << index << ") " << "\"" << s.substr(index, n - index + 1)
         << "\"" << endl;

    if (index == n)
    {
      return memo[index] = true;
    }

    for (int i = index; i < n; i++)
    {
      string x = s.substr(index, i - index + 1);
      if (wordSet.find(x) != wordSet.end() &&
          memoizedDFS(s, i + 1, wordSet, memo))
      {
        return memo[index] = true;
      }
    }

    return memo[index] = false;
  }

public:
  bool wordBreak(string s, vector<string>& wordDict)
  {
    int index = 0;
    unordered_set<string> wordSet(wordDict.begin(), wordDict.end());
    unordered_map<int, bool> memo;
    return memoizedDFS(s, index, wordSet, memo);
  }
};

int main()
{
  cout << "============================================\n";
  cout << "              Word Break Problem             \n";
  cout << "============================================\n\n";
  cout << "Given a string `s` and a dictionary of words `wordDict`, this "
          "program\n";
  cout << "checks if `s` can be segmented into a sequence of one or more "
          "dictionary words.\n\n";

  string s;
  cout << "Enter the string `s`: ";
  cin >> s;

  int n;
  cout << "Enter the number of words in the dictionary: ";
  cin >> n;

  vector<string> wordDict(n);
  cout << "Enter the words in the dictionary (space-separated):\n";
  for (int i = 0; i < n; ++i)
  {
    cin >> wordDict[i];
  }

  Solution sol;
  bool result = sol.wordBreak(s, wordDict);

  cout << "\nOutput:\n";
  if (result)
  {
    cout << "The string \"" << s
         << "\" can be segmented into a sequence of dictionary words.\n";
  }
  else
  {
    cout << "The string \"" << s
         << "\" cannot be segmented into a sequence of dictionary words.\n";
  }

  return 0;
}
