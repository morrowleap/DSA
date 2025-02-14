/*
https://leetcode.com/problems/powx-n/description/
50. Pow(x, n)
Pow(x, n)

Implement pow(x, n), which calculates x raised to the power n (i.e., xn).

-100.0 < x < 100.0
-231 <= n <= 231-1
n is an integer.
Either x is not zero or n > 0.
-104 <= x^n <= 104

*/

#include <iomanip>
#include <iostream>

using namespace std;

class Solution
{
public:
  double myPow(double x, int n)
  {
    if (n == 0)
    {
      return 1;
    }

    long p = n;
    if (p < 0)
    {
      p = -p;
      x = 1 / x;
    }

    if (p % 2 == 0)
    {
      return myPow(x * x, (int)(p / 2));
    }
    else
    {
      return x * myPow(x, (int)(p - 1));
    }
  }
};

int main()
{
  double x;
  int n;

  cout << "Enter base (x) and exponent (n) separated by a space: ";
  cin >> x >> n;

  Solution sol;
  double result = sol.myPow(x, n);

  cout << fixed << setprecision(5); // Format result to 5 decimal places
  cout << "Result: " << result << endl;

  return 0;
}

/*
Time and Space Complexity Analysis:

Time Complexity: O(log(N)), where N is the exponent. This is due to dividing the
problem into halves at each recursive step.

Space Complexity: O(log(N)), due to
the recursive call stack.
*/
