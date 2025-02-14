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

import java.util.Scanner;
import java.util.Stack;

class Solution
{
  private void insertAtBottom(Stack<Integer> st, int x)
  {
    if (st.isEmpty())
    {
      st.push(x);
      return;
    }
    int temp = st.pop();
    insertAtBottom(st, x);
    st.push(temp);
  }

  public void reverseStack(Stack<Integer> st)
  {
    if (st.isEmpty())
    {
      return;
    }
    int x = st.pop();
    reverseStack(st);
    insertAtBottom(st, x);
  }

  public void printStack(Stack<Integer> st)
  {
    System.out.print("Stack from top to bottom: ");
    Stack<Integer> temp = new Stack<>();
    temp.addAll(st);
    while (!temp.isEmpty())
    {
      System.out.print(temp.pop() + " ");
    }
    System.out.println();
  }
}

public class reverse_a_stack
{
  public static void main(String[] args)
  {
    System.out.println("=== Reverse a Stack using Recursion ===\n");
    System.out.println(
        "You are given a stack. Enter the number of elements in the stack,\n"
        + "followed by the elements (from top to bottom). The program will\n"
        + "reverse the stack and display the result.\n");

    Scanner scanner = new Scanner(System.in);

    System.out.print("Enter the number of elements in the stack: ");
    int n = scanner.nextInt();

    int[] arr = new int[n]; // Input array to hold the elements
    System.out.print("Enter the elements (from top to bottom): ");
    for (int i = 0; i < n; i++)
    {
      arr[i] = scanner.nextInt();
    }

    Stack<Integer> st = new Stack<>();
    for (int i = n - 1; i >= 0; i--)
    {
      st.push(arr[i]);
    }

    Solution sol = new Solution();

    System.out.println("\nOriginal Stack:");
    sol.printStack(st);

    sol.reverseStack(st);

    System.out.println("\nReversed Stack:");
    sol.printStack(st);

    scanner.close();
  }
}

/*
Time Complexity:
The time complexity is O(N^2) because for each of the N elements, we perform an
O(N) operation (inserting at the bottom).

Space Complexity: The space complexity
is O(N) due to the recursion stack used while reversing the stack.
*/
