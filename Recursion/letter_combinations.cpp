/*
https://leetcode.com/problems/letter-combinations-of-a-phone-number/description/
17. Letter Combinations of a Phone Number

Given a string containing digits from 2-9 inclusive, return all possible letter
combinations that the number could represent. Return the answer in any order.

A mapping of digits to letters (just like on the telephone buttons) is given
below. Note that 1 does not map to any letters.

Example 1:

Input: digits = "23"
Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
Example 2:

Input: digits = ""
Output: []
Example 3:

Input: digits = "2"
Output: ["a","b","c"]


Constraints:

0 <= digits.length <= 4
digits[i] is a digit in the range ['2', '9'].
*/

#include <iostream>
#include <string>
#include <vector>

using namespace std;

class Solution
{
private:
  void dfs(const string &digits,
           const unordered_map<char, vector<char>> &mapping, int index,
           string &curr, vector<string> &result)
  {
    if (index == digits.size())
    {
      result.push_back(curr);
      return;
    }

    for (char x : mapping.at(digits[index]))
    { // Use at() to handle out-of-bound access
      curr.push_back(x);
      dfs(digits, mapping, index + 1, curr, result);
      curr.pop_back();
    }
  }

public:
  vector<string> letterCombinations(const string &digits)
  {
    if (digits.empty())
      return {}; // Early return for empty input

    unordered_map<char, vector<char>> mapping = {
        {'2', {'a', 'b', 'c'}}, {'3', {'d', 'e', 'f'}},
        {'4', {'g', 'h', 'i'}}, {'5', {'j', 'k', 'l'}},
        {'6', {'m', 'n', 'o'}}, {'7', {'p', 'q', 'r', 's'}},
        {'8', {'t', 'u', 'v'}}, {'9', {'w', 'x', 'y', 'z'}}};

    vector<string> result;
    string curr;
    dfs(digits, mapping, 0, curr, result);
    return result;
  }
};

int main()
{
  cout << "Enter a string containing digits from 2-9 inclusive to find all "
          "possible letter combinations the number could represent: ";
  string digits;
  cin >> digits;

  Solution sol;
  vector<string> result = sol.letterCombinations(digits);

  cout << "\nOutput combinations:\n[";
  for (size_t i = 0; i < result.size(); ++i)
  {
    cout << "\"" << result[i] << "\"";
    if (i < result.size() - 1)
      cout << ",";
  }
  cout << "]" << endl;

  return 0;
}