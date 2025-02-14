/*
https://leetcode.com/problems/expression-add-operators/
282. Expression Add Operators

Given a string num that contains only digits and an integer target, return all
possibilities to insert the binary operators '+', '-', and/or '*' between the
digits of num so that the resultant expression evaluates to the target value.

Note that operands in the returned expressions should not contain leading zeros.

Example 1:

Input: num = "123", target = 6
Output: ["1*2*3","1+2+3"]
Explanation: Both "1*2*3" and "1+2+3" evaluate to 6.
Example 2:

Input: num = "232", target = 8
Output: ["2*3+2","2+3*2"]
Explanation: Both "2*3+2" and "2+3*2" evaluate to 8.
Example 3:

Input: num = "3456237490", target = 9191
Output: []
Explanation: There are no expressions that can be created from "3456237490" to
evaluate to 9191.

Constraints:

1 <= num.length <= 10
num consists of only digits.
-231 <= target <= 231 - 1
*/

#include <iostream>
#include <string>
#include <vector>

using namespace std;

class Solution
{
private:
  void dfs(const string& num, int index, long long prevOperand,
           long long currTotal, const int& target, string curr,
           vector<string>& result)
  {
    if (index == num.length())
    {
      if (target == currTotal)
      {
        result.push_back(curr);
      }
    }

    // https://algo.monster/liteproblems/282

    for (int i = index; i < num.length(); i++)
    {
      string sstr = num.substr(index, i - index + 1);
      if (sstr.length() > 1 && sstr[0] == '0')
      {
        break;
      }
      long long nextOperand = stoll(sstr);

      if (index == 0)
      {
        dfs(num, i + 1, nextOperand, nextOperand, target,
            curr + to_string(nextOperand), result);
      }
      else
      {
        dfs(num, i + 1, nextOperand, currTotal + nextOperand, target,
            curr + "+" + to_string(nextOperand), result);

        dfs(num, i + 1, -nextOperand, currTotal - nextOperand, target,
            curr + "-" + to_string(nextOperand), result);

        dfs(num, i + 1, prevOperand * nextOperand,
            currTotal - prevOperand + prevOperand * nextOperand, target,
            curr + "*" + to_string(nextOperand), result);
      }
    }
  }

public:
  vector<string> addOperators(string num, int target)
  {
    int index = 0;
    long long prevOperand = 0;
    long long currTotal = 0;
    string curr = "";
    vector<string> result;
    dfs(num, index, prevOperand, currTotal, target, curr, result);
    return result;
  }
};

int main()
{
  string num;
  int target;

  cout << "Enter the number string: ";
  cin >> num;

  cout << "Enter the target value: ";
  cin >> target;

  Solution sol;
  vector<string> results = sol.addOperators(num, target);

  cout << "Possible expressions: " << endl;
  for (const auto& expr : results)
  {
    cout << expr << endl;
  }

  return 0;
}
