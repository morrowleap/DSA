/*
https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
3. Longest Substring Without Repeating Characters

Given a string s, find the length of the longest
substring
 without repeating characters.

Example 1:

Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.
Example 2:

Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:

Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a
substring.


Constraints:

0 <= s.length <= 5 * 104
s consists of English letters, digits, symbols and spaces.
 */

#include <iostream>
#include <set>
#include <vector>

using namespace std;

int main()
{
  string str;
  cout << "Enter the string (s): ";
  cin >> str;

  int n = str.length();
  set<char> seen;
  int start = 0, end = 0, maxl = 0;

  for (int end = 0; end < n; end++)
  {
    char x = str[end];
    while (seen.find(x) != seen.end())
    {
      seen.erase(str[start]);
      start++;
    }

    seen.insert(x);
    maxl = max(maxl, end - start + 1);
  }

  cout << "\nMax length :: " << maxl << endl;

  return 0;
}
