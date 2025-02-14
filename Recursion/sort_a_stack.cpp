/*
https://www.geeksforgeeks.org/problems/sort-a-stack/1
Sort a stack

Given a stack, the task is to sort it such that the top of the stack has the
greatest element.

Example 1:

Input:
Stack: 3 2 1
Output: 3 2 1
Example 2:

Input:
Stack: 11 2 32 3 41
Output: 41 32 11 3 2
Your Task:
You don't have to read input or print anything. Your task is to complete the
function sort() which sorts the elements present in the given stack. (The sorted
stack is printed by the driver's code by popping the elements of the stack.)

Expected Time Complexity: O(N*N)
Expected Auxilliary Space: O(N) recursive.

Constraints:
1<=N<=100
 */

#include <iostream>
#include <stack>
#include <vector>
using namespace std;

class Solution
{
private:
  void insertAtSorted(stack<int>& st, int x)
  {
    if (st.empty() || st.top() > x)
    {
      st.push(x);
      return;
    }
    int temp = st.top();
    st.pop();
    insertAtSorted(st, x);
    st.push(temp);
  }

public:
  void sortStack(stack<int>& st)
  {
    if (st.empty())
    {
      return;
    }
    int x = st.top();
    st.pop();
    sortStack(st);
    insertAtSorted(st, x);
  }

  void printStack(stack<int> st)
  {
    cout << "Stack elements (from top to bottom): ";
    while (!st.empty())
    {
      cout << st.top() << " ";
      st.pop();
    }
    cout << endl;
  }
};

int main()
{
  cout << "Sort a Stack using Recursion" << endl;
  cout << "You are given a stack. Enter the number of elements in the stack,"
       << endl;
  cout << "followed by the elements (from top to bottom). The program will "
          "sort the stack in descending order."
       << endl;

  int n;
  cout << "Enter the number of elements in the stack: ";
  cin >> n;

  vector<int> arr(n);
  cout << "Enter the elements (top to bottom): ";
  for (int i = 0; i < n; i++)
  {
    cin >> arr[i];
  }

  stack<int> stk;
  for (int i = n - 1; i >= 0; i--) // Push elements in reverse order
  {
    stk.push(arr[i]);
  }

  Solution sol;

  cout << "Original ";
  sol.printStack(stk);

  sol.sortStack(stk);

  cout << "Sorted ";
  sol.printStack(stk);

  return 0;
}

/*
Time Complexity:
The time complexity is O(N^2) because for each of the N elements, we perform an
O(N) operation (inserting in sorted order).

Space Complexity: The space
complexity is O(N) due to the recursion stack used during sorting.
*/
