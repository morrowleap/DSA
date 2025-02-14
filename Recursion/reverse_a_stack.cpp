/*
https://www.geeksforgeeks.org/problems/reverse-a-stack/1
Reverse a Stack

You are given a stack St. You have to reverse the stack using recursion.

Example 1:

Input:
St = {3,2,1,7,6}
Output:
{6,7,1,2,3}
Explanation:
Input stack after reversing will look like the stack in the output.
Example 2:

Input:
St = {4,3,9,6}
Output:
{6,9,3,4}
Explanation:
Input stack after reversing will look like the stack in the output.
Your Task:

You don't need to read input or print anything. Your task is to complete the
function Reverse() which takes the stack St as input and reverses the given
stack.

Expected Time Complexity: O(N2)
Expected Auxiliary Space: O(1)

Constraints:
1 <= size of the stack <= 104
-109 <= Each element of the stack <= 109
Sum of N over all test cases doesn't exceeds 106
Array may contain duplicate elements.
*/

#include <iostream>
#include <stack>
#include <vector>

using namespace std;

class Solution
{
private:
  void insertAtBottom(stack<int>& st, int x)
  {
    if (st.empty())
    {
      st.push(x);
      return;
    }
    int temp = st.top();
    st.pop();
    insertAtBottom(st, x);
    st.push(temp);
  }

public:
  void reverseStack(stack<int>& st)
  {
    if (st.empty())
    {
      return;
    }
    int x = st.top();
    st.pop();
    reverseStack(st);
    insertAtBottom(st, x);
  }

  void printStack(stack<int> st)
  {
    cout << "Stack from top to bottom: ";
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
  cout << "Reverse a Stack using Recursion" << endl;
  cout << "You are given a stack. Enter the number of elements in the stack,"
       << endl;
  cout << "followed by the elements (from top to bottom). The program will "
          "reverse the stack."
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

  stack<int> st;
  for (int i = n - 1; i >= 0; i--) // Push elements in reverse order
  {
    st.push(arr[i]);
  }

  Solution sol;

  cout << "Original ";
  sol.printStack(st);

  sol.reverseStack(st);

  cout << "Reversed ";
  sol.printStack(st);

  return 0;
}

/*
Time Complexity:
The time complexity is O(N^2) because for each of the N elements, we perform an
O(N) operation (inserting at the bottom).

Space Complexity: The space complexity
is O(N) due to the recursion stack used while reversing the stack.
*/
